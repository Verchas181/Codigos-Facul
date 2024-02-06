
/*
.______       _______ ____    ____  __       _______.     ___        ______              ______ 
|   _  \     |   ____|\   \  /   / |  |     /       |    /   \      /  __  \            /      |
|  |_)  |    |  |__    \   \/   /  |  |    |   (----`   /  ^  \    |  |  |  |          |  ,----'
|      /     |   __|    \      /   |  |     \   \      /  /_\  \   |  |  |  |          |  |     
|  |\  \----.|  |____    \    /    |  | .----)   |    /  _____  \  |  `--'  |          |  `----.
| _| `._____||_______|    \__/     |__| |_______/    /__/     \__\  \______/            \______|

*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int main(){

    
    char c = 10; // 8 bits  %c ou %s para 
    short a = 2; //16 bits
    float e = 1.0; // 32 bits %f
    const int pi = 3.1415; //32 bits  %d
    long d = 40; //64 bits %ld
    double f = 2.0; // 64 bits

    //printf("char %ld bits \n",sizeof(char)*8);
    //printf("short %ld bits \n",sizeof(short)*8);
    //printf("float %ld bits \n",sizeof(float)*8);
    //printf("const int %ld bits \n",sizeof(const int)*8);
    //printf("long %ld bits \n",sizeof(long)*8);
    //printf("double %ld bits \n",sizeof(double)*8);

    typedef int inteiros; //cria um tipo customizado utilizando um tipo que ja existe 'ALIAS'

    char alfabeto[26];
    alfabeto[0] = 'A';
    alfabeto[1] = 'B';
    alfabeto[2] = 'C';
    alfabeto[3] = 'D';
    alfabeto[4] = 'E';
    alfabeto[5] = 'F';
    //    .
    //    .   
    //    .

    /*
    for (int i=0;i<4;i++){
        printf("letras em ordem alfabetica %c", alfabeto[i]);
    }
    */

    //char alfanum[] = {'A', 'B', 'C' . . . . . . . .} para inicializar sem tamanho pré-definido

    char nome[] = "jhonny"; //array de tamanho 7 por conta do caractere /0 no final
    char nome2[100];
    strcpy(nome2 , nome);

 
  
    //printf("%s tem %d anos e tirou %c . \n", a1.nome, a1.idade , a1.conceito);

    unsigned short abcd; // o unsigned serve para deixar em modulo o valor, ou seja, toda a memória é utilizada para o número positivo

    struct date{
    unsigned short dia;
    unsigned short mes;
    unsigned short ano;
    };

  
    typedef date data;

    // podemos fazer tambem typedef struct{..........} data; ,  uma struct anonima que é renomeada para 'data' depois

       struct a{
      char nome[100];
      int idade;
      char conceito;
      data quando;
    };
  
    typedef struct a aluno;
    aluno a1.nome = "jhonny";
    aluno a1.idade = 20;
    aluno a1.conceito = 'B';
    aluno a1.quando.dia = 02;
    aluno a1.quando.mes = 04;
    aluno a1.quando.ano = 03;


    // if, while, for, else if (), else
    // true = qualquer coisa, false = 0  <bool.h>
    // || ou ; && e
    // switch (xxxx){ case 1: \n ..... ; case 2: \n ......; default: \n ......;}
    // do { .....} while(x) ; ENTRA PELO MENOS UMA VEZ, DIFERENTE DO OPERADOR 'WHILE' QUE CASO FALSO NAO ENTRA NENHUMA VEZ


    return 0;
}
