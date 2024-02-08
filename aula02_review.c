/* 
______       # ______      # __   __     # ________     # ______      # ________      # ______      #
/_____/\      #/_____/\     #/_/\ /_/\    #/_______/\    #/_____/\     #/_______/\     #/_____/\     #
\:::_ \ \     #\::::_\/_    #\:\ \\ \ \   #\__.::._\/    #\::::_\/_    #\::: _  \ \    #\:::_ \ \    #
 \:(_) ) )_   # \:\/___/\   # \:\ \\ \ \  #   \::\ \     # \:\/___/\   # \::(_)  \ \   # \:\ \ \ \   #
  \: __ `\ \  #  \::___\/_  #  \:\_/.:\ \ #   _\::\ \__  #  \_::._\:\  #  \:: __  \ \  #  \:\ \ \ \  #
   \ \ `\ \ \ #   \:\____/\ #   \ ..::/ / #  /__\::\__/\ #    /____\:\ #   \:.\ \  \ \ #   \:\_\ \ \ #
    \_\/ \_\/ #    \_____\/ #    \___/_(  #  \________\/ #    \_____\/ #    \__\/\__\/ #    \_____\/ #
              ##             ##             ##              ##             ##               ##             

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


int main(){

//PONTEIROS
// ponteiro armazena endereço de memoria
// aloca dinamicamente também

int x = 10;
float y = 20.0;
int z = 30;
//%p é operador de endereço

//printf("%p",&x);

int* point = NULL; //so pode armazenar endereços int
float* pin = NULL; //so pode armazenar endereco float

//printf("%p",point); printa o conteudo do ponteiro

// se quiser o endereco do ponteiro printf("%p",&point); "endereco do endereco"

point = &x;
pin = &y;

//agora os ponteiros possuem conteudo com o endereco das variaveis

// o operador de desreferenciamento é * antes do ponteiro, no caso * """corta""" o &

*point = 20; // troca o valor de x por 20

// o array equivale NA LINGUAGEM C porque ele pode ser convertido em ponteiro no primeiro elemento, mas formalmente eles não são a mesma coisa

char* ponteiro;
char s[] = "abc";
ponteiro = s;

// *(ponteiro + 1) == b; por exemplo

// podemos somar 1 no endereco de um ponteiro porque ele busca o proximo endereco de memoria do mesmo tipo que o endereco anterior


struct p { 
float x;
float y;
};

struct p abcd ={ .x = 10.0, .y=20.0};
struct p* q = &abcd;


//para scruct devemos usar seta ->

//printf("%f",q->x);
//printf("%f",q->y);


//FUNCOES E ARGUMENTOS

int add(a,b){
return a+b;
}

// parametros sao as variaveis locais que recebem os argumentos acima os parametros sao a,b. abaixo os argumentos sao w,t.

//int h = add(w,t);

//passando por referencia o argumento deve ser um ponteiro/endereço e mexer o conteudo externo à funcao!

int add2(int* c, int* d){
return *c + *d
}

//int* a = malloc(sizeof(int*5)); LEMBRAR DE DESALOCAR free(a);

//calloc aloca a memória de maneira limpa

return 0;

}