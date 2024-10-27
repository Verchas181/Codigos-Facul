import re



string = 'Este é um teste de expressões teste regulares.'
print(re.search(r'teste', string)) # busca a primeira aparicao do texto inserido
print(re.findall(r'teste', string)) #busca todos os padrões do texto inserido
print(re.sub(r'teste', 'ABCD', string)) #substitui o padrao pelo texto todas as vezes

regexp = re.compile(r'teste') # a função compile atribui esta expressao à uma "Variavel", exige menos do compilador que escrever toda vez o mesmo texto
print(regexp.search(string))
print(regexp.findall(string))
print(regexp.sub('DEF', string))
