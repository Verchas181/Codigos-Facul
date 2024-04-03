#implementação de um servidor base para interpratação de métodos HTTP
import socket

#definindo o endereço IP do host
SERVER_HOST = ""
#definindo o número da porta em que o servidor irá escutar pelas requisições HTTP
SERVER_PORT = 80

#vamos criar o socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

#vamos setar a opção de reutilizar sockets já abertos
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

#atrela o socket ao endereço da máquina e ao número de porta definido
server_socket.bind((SERVER_HOST, SERVER_PORT))

#coloca o socket para escutar por conexões
server_socket.listen(6)

#mensagem inicial do servidor
print("Servidor em execução...")
print("Escutando por conexões na porta %s" % SERVER_PORT)


while True:
   
    #client_connection: o socket que será criado para trocar dados com o cliente de forma dedicada
    #client_address: tupla (IP do cliente, Porta do cliente)

    client_connection, client_address = server_socket.accept()

    #pega a solicitação do cliente
    
    request = client_connection.recv(8192).decode()
    

    if request:

        #imprime a solicitação do cliente

        headers = request.split("\r\n") 
        filename = headers[0].split()[1]  # nome do arquivo
        solicitacao = headers[0].split()[0] #tipo de solicitacao GET, PUT ....

        response = "HTTP/1.1 404 NOT FOUND\n\n<h1>ERRO</h1>"

        

        if solicitacao == "PUT": #put corrigido
            try:
                if filename == "/":
                    with open("htdocs/padrao.txt", "w") as f:
                        while True:
                            conteudo = client_connection.recv(8192)
                            if not conteudo:
                                break
                            f.write(conteudo.decode())
                else:
                    with open("htdocs" + filename, "w") as f:
                        while True:
                            conteudo = client_connection.recv(8192)
                            if not conteudo:
                                break
                            f.write(conteudo.decode())

                f.close()

                response = "HTTP/1.1 200 OK \n\n"
                client_connection.sendall(response.encode())
            except:
                print("Erro ao escrever/criar o arquivo")
                response = "HTTP/1.1 500 Internal Server Error\n\n"
                client_connection.sendall(response.encode())




        if solicitacao == "GET":
            if filename == "/": #verifica qual arquivo está sendo solicitado
                filename = "/index.html" 

          
            try:
                if filename.split(".")[-1] in ["jpg", "jpeg", "png", "gif"]:
                    fin = open("htdocs" + filename, "rb") # Abrir o arquivo binário para imagem
                    content = fin.read()
                    fin.close() 

        
                    response = "HTTP/1.1 200 OK\n"
                    response += "Content-Type: image/" + filename.split(".")[-1] + "\n\n"
                    response = response.encode() + content 
                    client_connection.sendall(response)
                else:
                    fin = open("htdocs" + filename, "r") # Abrir o arquivo texto
                    content = fin.read() 
                    fin.close() 

        
                    response = "HTTP/1.1 200 OK\n\n" + content
                    client_connection.sendall(response.encode())
            except FileNotFoundError:
    
                response = "HTTP/1.1 404 NOT FOUND\n\n<h1>ERROR 404!<br>File Not Found!</h1>"


            #envia a resposta HTTP
        

        client_connection.close()


server_socket.close()