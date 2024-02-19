/*
  _                       ___  _                 _        
   /_\  _ _ _ _ __ _ _  _  |   \(_)_ _  __ _ _ __ (_)__ ___ 
  / _ \| '_| '_/ _` | || | | |) | | ' \/ _` | '  \| / _/ _ \
 /_/ \_\_| |_| \__,_|\_, | |___/|_|_||_\__,_|_|_|_|_\__\___/
                     |__/                                   
*/


// se quisermos alterar a estrutura de dados de uma TAD podemos realizar um typedef de um dado e adicionar funções em outro dominio, exemplo:


/*

Array* array_create(int);
void array_destroy(Array*);
void array_print(Array*);
bool array_set(Array*, int posicao, int valor);
int array_get(Array*, int);
int array_size(Array*);

//podemos mudar as funcoes acima, aproveitando a estrutura da seguinte maneira

typedef int Element; //por exemplo:

void print_element(Element e){
printf("%c",e);
}

Array* array_create(Element);
void array_destroy(Array*);
void array_print(Array*);
bool array_set(Array*, int posicao, Element valor);
Element array_get(Array*, int);
int array_size(Array*);

//podemos também mudar element como typedef double Element, entao todos os elementos Element serão double agora

*/


// array estatico precisa alocar toda a memoria na inicializaçao, a quantidade de memoria se mantem fixa durante o tempo
// o array dinamico pode ter sua memoria realocada, possuindo quantidade de memoria variavel

///////////////////////////////////////////////////
// elemento.h
#ifndef ELEMENTO_H
#define ELEMENTO_H
typedef struct double Elemento;
#endif

///////////////////////////////////////////////////
// array_dinamico.h
// definindo a API e Dominio

#ifndef ARRAY_DINAMICO_H
#define ARRAY_DINAMICO_H
#include "elemento.h"

typedef struct ArrayDinamico AD;

AD* AD_create();
void AD_destroy(AD*);
void AD_add(AD*, Elemento);
void AD_print(AD*);
int AD_size(AD*);
void AD_set(AD*, int posicao, Elemento);
Elemento AD_get(AD*, int posicao);

///////////////////////////////////////////////////////
// interface
//array_dinamico.c
#include "array_dinamico.h"
#define CAPACIDADE_INICIAL 10;
#include <stdio.h>
#include <stdlib.h>

struct ArrayDinamico {
  Elemento* dados;
  int tam;
  int capacidade;
};

AD* AD_create(){
AD* array = malloc(sizeof(AD));
array->capacidade = CAPACIDADE_INICIAL;
array->dados = malloc(sizeof(Elemento) * array->capacidade);
array->tam = 0;
return array;
}

void AD_destroy(AD* array){
free(array->dados);
free(array);
}

void AD_print(AD* array){
for(int i =0; i<size;i++){
printf("%d", array[i]);
}
print("\n");
}

int AD_size(AD* array){
return array->tam;
}

void AD_resize(AD* array, int novo_tam){
Elemento* new_array = realloc(array->dados,sizeof(Elemento) * novo_tam);
if(new_array != NULL){
  array->dados = new_array;
  array->capacidade = novo_tam;

}

void AD_add(AD* array, Elemento element){
//para saber se o array ta cheio? array->size == array->capacidade
if(array->tam == array->capacidade){
  AD_resize(array,array->capacidade*2);
}
  array->dados[array->tam] = element;
  array->tam++;

}

Elemento AD_get(AD* array, int posicao){
if (posicao < 0  || posicao <= array->tam){
abort();
}
return array-dados[posicao];
}

void AD_set(AD*, int posicao, Elemento element){

// FAZER EM CASA

}
/////////////////////////////////////////////////////////
//implementação
//main.c
#include <stdio.h>
#include "array_dinamico.c"

int main(){
AD* array = AD_create();

for(int i = 0; i<100; i++){
  AD_add(array,i);
}
AD_print(array);
AD_destroy(array);

return 0;

}
///////////////////////////////////////////////////////////////////////////////

//criar pasta/diretorio de inclusao  ./inc
//copiar os arquivos array_dinamico.h , array_dinamico.c e elemento.h na pasta

//////////////////////////////////////////////////////////////////////////////
//interface
//string_buffer.h
#ifndef STRING_BUFFER_H
#define STRING_BUFFER_H

typedef struct StringBuffer SB;

SB* SB_create();
void SB_destroy(SB* strb);
void SB_append(SB* strb, char* c);
char* SB_to_string(SB* strb);
////////////////////////////////////////////////////////////////////////////////

// no arquivo elemento.h -> mudar o struct de double para char 


////////////////////////////////////////////////////////////////////////////////
//string_buffer.c

#include "string_buffer.h"
#include "inc/array_dinamico.h"
#include <string.h>
#include <stdlib.h>

struct StringBuffer{
AD* dados
};

SB* SB_create(){
  SB* strb = malloc(sizeof(SB))
return strb;
}

void SB_destroy(SB* strb){
free(sb->dados);
free(sb);
}

void SB_append(SB* strb, char* c){
  for (int i= 0 ; i<strlen(c);i++){
    AD_add(sb->dados,s[i]);
  }
  char SB_to_string(SB* sb){
  int tam = AD_size(sb->dados) + 1;
    char* s = malloc(sizeof(char)*tam);
  for (int j = 0; j< size-1;j++){
    s[j] = AD_get(sb->data,i);
  }
  s[size-1] = '\0'
    return s;
}
////////////////////////////////////////////////////////////////////
//implementacao
//main2.c
#include "string_buffer.h"
#include <stdio.h>
#include <stdlib.h>

int main(){
SB* strb = SB_create();
SB_append(strb,"Hello");
SB_append(strb," ");
SB_append(strb,"World!");

char* s = SB_to_string(strb);
printf("%s\n",s);
free(s);
SB_destroy(strb);

return 0;
}
























