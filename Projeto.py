#implementação de um servidor base para interpratação de métodos HTTP

import socket

#definindo o endereço IP do host
SERVER_HOST = ""
#definindo o número da porta em que o servidor irá escutar pelas requisições HTTP
SERVER_PORT = 8080

#vamos criar o socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

#vamos setar a opção de reutilizar sockets já abertos
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

#atrela o socket ao endereço da máquina e ao número de porta definido
server_socket.bind((SERVER_HOST, SERVER_PORT))

#coloca o socket para escutar por conexões
server_socket.listen(1)

#mensagem inicial do servidor
print("Servidor em execução...")
print("Escutando por conexões na porta %s" % SERVER_PORT)


while True:
   
    #client_connection: o socket que será criado para trocar dados com o cliente de forma dedicada
    #client_address: tupla (IP do cliente, Porta do cliente)
    client_connection, client_address = server_socket.accept()

    #pega a solicitação do cliente
    request = client_connection.recv(8192).decode('latin-1')
    

    if request:

        #imprime a solicitação do cliente
        print(request)
        
       
        headers = request.split("\n")  #analisa a solicitação HTTP
        print(headers)
        filename = headers[0].split()[1]  # nome do arquivo
        
        solicitacao = headers[0].split()[0] #tipo de solicitacao GET, PUT ....

        if solicitacao == "PUT":
            conteudo = headers[5]
            try:

                f = open("htdocs" + caminho, "w")

                f.write(conteudo)

                f.close()

                response = "HTTP/1.1 200 OK \n\n"
            except:
                print("Erro ao escrever/criar o arquivo")
                response = "HTTP/1.1 500 Internal Server Error\n\n"




        if solicitacao == "GET":
            if filename == "/": #verifica qual arquivo está sendo solicitado
                filename = "/index.html" 

            #try e except para tratamento de erro quando um arquivo solicitado não existir
            try:
            
                fin = open("htdocs" + filename) #abrir o arquivo e
            
                content = fin.read() #leio o conteúdo do arquivo 
                
            
                fin.close() #fecho o arquivo
            
                response = "HTTP/1.1 200 OK\n\n" + content #envia a resposta + arquivo


            except FileNotFoundError:
                #caso o arquivo solicitado não exista no servidor, gera uma resposta de erro
                response = "HTTP/1.1 404 NOT FOUND\n\n<h1>ERROR 404!<br>File Not Found!</h1>"


            #envia a resposta HTTP
client_connection.sendall(response.encode())

client_connection.close()


server_socket.close()


