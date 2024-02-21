
# cliente servidor funciona na base da requisição e resposta #
# temos também peer 2 peer, o computador faz requisicoes e ele mesmo faz as respostas (funciona como cliente e servidor ao mesmo tempo) #
# pipe serve para comunicoes intra (entre a mesma) maquinas #
# sockets para comunicacoes inter (entre diferentes) maquinas #
#///////////////////////////////////////////////////////////////////// #

# o ip não é o suficiente para o redirecionamento de dados com o Sockets, e sim o IP + número de Porta (entregue para a maquina, e entregue para a aplicacao dentro da maquina) #
# isso é necessário para o computador diferenciar os diferentes processos dentro da maquina (distinguir uma aplicação de outra) #
# exemplos de porta: #
# todo servidor web usa a porta 80 #
# todo servidor telnet usa 23 (não trabalha com criptografia) #
# email é 53 #
# /////////////////////////////////////////////////////////////////// #

import socket
import sys

# s = socket.socket(socket.AF_INET,socket.SOCK_STREAM) #
# AF_INET é o IPv4 #
# SOCK_STREAM é para o TCP , para usar UDP (Não faz controle da transmissão) o parametro deve ser SOCK_DGRAM (TCP cria fluxo de pacotes na camada de transporte, UDP simplesmente envia + rapido) #
# TCP para cada segmento do fluxo enviado, ele espera um de resposta
# aplicacao web e email NUNCA pode ser UDP por conta da confiabilidade, já o DNS usa UDP #

try:
    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
except socket.error as erro:
    print(f"Socket creation failed with error {erro}")

porta = 80 # porta de servidor web
site = "www.google.com"
try:
    host_ip = socket.gethostbyname(site) #DNS consulta uma tabela com esta entrada de domínios e IPs "traduz o dominio para IP"
except socket.gainerror :
    print(f"There was an error resolving the host")
    sys.exit()

s.connect((host_ip,porta))
print("The socket has been successfully connected to " + site)

# temos o metodo send() para enviar mensagens entre maquinas conectadas #

# /////////////////////////////////////////////////////////////////// #
# ***novo arquivo***#
# agora a parte do servidor #
# o servidor deve ser executado antes que o cliente "server deve estar ON"
from socket import *

serverPort = 12000 #define qual porta será executada
serverSocket = socket(AF_INET,SOCK_STREAM)
serverSocket.bind(('',serverPort)) # atrela ao localhost
serverSocket.listen(1) # comeca a esperar por conexoes (escutando) #

print("The server is ready o receive")

while 1:
    connectionSocket , addr = serverSocket.accept() # addr é a variavel que armazena o endereco do socket do cliente #
    sentence = connectionSocket.recv(1024) # estabelece um buffer para limitar a quantidade de dados recebido (trabalha com Bytes) #
    capitalizedSentence = sentence.upper()
    connectionSocket.send(capitalizedSentence)
    connectionSocket.close()

# /////////////////////////////////////////////////////////////////// #
# ***novo arquivo***#
# agora a parte do cliente #

from socket import *

#ip do socket
serverName = "127.0.0.1" # localhost do servidor

serverPort = 12000 #cria socket TCP, porta 12000

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName,serverPort))
sentence = input("Digite algo em letra minuscula")

sen = sentence.encode() # formata a mensagem em bytes
clientSocket.send(sen)
modifiedSentence = clientSocket.recv(1024) #recebe a resposta
print("From Server: ", modifiedSentence.decode())
clientSocket.close()

# /////////////////////////////////////////////////////////////////// #
