○○○ Tipos de Dados ○○○




//Encapsulamento

// lista.h ou lista.c
//.h para os tipos necessarios da API (comandos)
//.c é a implementação concreta (corpo das funcoes)



//Dominio (valores)

typedef struct{
char nome[50];
int quantidade;
float preco;
}ItemCompra;

typedef struct{
ItemCompra intens[100];
}ListaDeCompras;


//Interface/API (comandos)

void adicionarItem(ListaDeCompras* Lista, ItemCompra item);
void removerItem(ListaDeCompras* ItemCompra, int indice);
.
.
.



// TAD Array (sempre passar o array e o tamanho)

void print_array(int* array,int size){
for(int i =0; i<size;i++){
printf("%d", array[i]);
}
print("\n");
}

// Exemplo de TAD Array

//array.h (api)
//array.c (implementacao)

/////////////////////////////////////////////

// API

#ifndef ARRAY_H // evitar inclusão dupla e conflitos
#define ARRAY_H

typedef struct{
int* dados;
int size;
}Array;

Array* array_create(int);
void array_destroy(Array*);
void array_print(Array*);
bool array_set(Array*, int posicao, int valor);
int array_get(Array*, int);
int array_size(Array*);


#endif
///////////////////////////////////////////////

// implementação

#include "array.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


Array* array_create(int){

Array* array = malloc(sizeof(Array));
array->dados = malloc(sizeof(int)*size);
return array;

}

void array_destroy(Array*){

free(array->dados);
free(array);

}


void array_print(Array* array){
for (int i=0; i<array->size;i++){
printf("%d", array->dados[i]);
}
printf("\n"):
}

bool array_set(Array* array, int posicao, int valor){
if(posicao < 0 || posicao >= array->size){
return false;
}
array->dados[posicao] = value
}

int array_get(Array* array, int posicao){
return array->dados[posicao]
}

int array_size(Array* array){
return array->size;
}

//////////////////////////////////////////////

//main.c

#include "array.h" 


int main(){
Array* a = array_create(10);

array_print(a);

for(int i=0; i< array_size(a); i++){
array_set(a,i,i+1);
}

a->size = 20; ///// violando o encapsulamento, nao se deve mexer no struct

// em linguagem orientada a objeto há o encapsulamento forte (privada, nao da pra acessar)

// uma solução é o Tipo Opaco (C), onde que definimos a struct na interface e na implementação, onde ela deve ser complementada na implementação


array_destroy(a);

return 0;
}





// Tipo Opaco

// no .h  typedef struct Array array;

//no .c   struct Array{ int ........};




