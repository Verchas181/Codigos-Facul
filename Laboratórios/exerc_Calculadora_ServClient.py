#//////////////////////////////////////#

# servidor #


from socket import *

Porta = 1337
s = socket(AF_INET,SOCK_STREAM)

s.bind(("124.157.13.1",Porta))
s.listen(1)
print("Servidor ligado")

while 1:
    conexao , ender = s.accept()
    dados = conexao.recv(1024)
    lista = dados.split(' ', 3)
    res = 0
    if lista[0] == "SUM":
        res = int(lista[1]) + int(lista[2])
    elif lista[0] == "MIN":
        res = int(lista[1]) - int(lista[2])
    elif lista[0] == "MUL":
        res = int(lista[1]) * int(lista[2])
    elif lista[0] == "DIV":
        res = int(lista[1]) / int(lista[2])
        conexao.send(res)
        conexao.close()


# /////////////////////////////////////#

# cliente #

from socket import *

NomeDoServidor = "124.157.13.1"
PortaDoServidor = 1337
s_cliente = socket(AF_INET,SOCK_STREAM)
s_cliente.connect((NomeDoServidor,PortaDoServidor))
operacao = input("Escreva uma operação e em seguida dois números, separando por espaços. As possibilidades de operação são SUM, MIN, MUL, DIV")
listaa = operacao.split(' ', 3)
op = operacao.encode()
s_cliente.send(op)
resposta = s_cliente.recv(1024)
print(f"O servidor enviou o resultado {resposta} para a operação {listaa[0]} e os números {listaa[1]} e {listaa[2]}")
s_cliente.close()


