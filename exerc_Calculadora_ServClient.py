#//////////////////////////////////////#

# servidor #


from socket import *

Porta = 1337
s = socket(AF_INET,SOCK_STREAM)

s.bind(('',Porta))
s.listen(1)
print("Servidor ligado")

while 1:
    conexao , ender = s.accept()
    dados = conexao.recv(1024)
    lista = dados.split(' ', 3)
    res = 0
    if lista[0] == "SUM":
        res = lista[1] + lista[2]
    if


# /////////////////////////////////////#

# cliente #


