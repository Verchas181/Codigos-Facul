# | OU
# . Qualquer caractere (com exceção da quebra de linha)
# [] conjunto de caracteres ou intervalo se [-]

import re

texto = '''
João trouxe    flores para sua amada namorada em 10 de janeiro de 1970,
Maria era o nome dela.


Foi um ano excelente na vida de joão. Teve 5 filhos, todos adultos atualmente.
maria, hoje sua esposa, ainda faz aquele café com pão de queijo nas tardes de
domingo. Também né! Sendo a boa mineira que é, nunca esquece seu famoso
pão de queijo.
Não canso de ouvir a Maria:
"Joooooooooãooooooo, o café tá prontinho aqui. Veeemm"!
'''

print(re.findall(r'João|Maria|ad....s', texto)) #Joao ou Maria ou ad...s
print(re.findall(r'João|joão|Maria', texto)) # Joao, joao, Maria
print(re.findall(r'[Jj]oão|[Mm]aria', texto)) #Joao, joao, maria, Maria
print(re.findall(r'[a-z]aria', texto)) # Qualquer letra minuscula + aria
print(re.findall(r'[a-zA-Z0-9_.]aria|[a-zA-Z0-9]oão', texto)) # Qualquer caractere padrão + (aria ou oao)
print(re.findall(r'jOãO|mAriA', texto, flags=re.I)) #Ignorecase
