
/*
  _____      _          _           ________                               __                     __         
 |_   _|    (_)        / |_        |_   __  |                             |  ]                   |  ]        
   | |      __   .--. `| |-',--.     | |_ \_| _ .--.   .---.  ,--.    .--.| | .---.  ,--.    .--.| |  ,--.   
   | |   _ [  | ( (`\] | | `'_\ :    |  _| _ [ `.-. | / /'`\]`'_\ : / /'`\' |/ /__\\`'_\ : / /'`\' | `'_\ :  
  _| |__/ | | |  `'.'. | |,// | |,  _| |__/ | | | | | | \__. // | |,| \__/  || \__.,// | |,| \__/  | // | |, 
 |________|[___][\__) )\__/\'-;__/ |________|[___||__]'.___.'\'-;__/ '.__.;__]'.__.'\'-;__/ '.__.;__]\'-;__/ 
                                                                                                             
*/



// A lista encadeada fundamentalmente é um ponteiro que aponta para uma sequencia de nós

/////////////////////

//representacao

//nó

typedef struct no{
Element elemento;
struct no* proximo;
}Node;

//exemplo de construcao

Node* head = malloc(sizeof(Node));
head->element = 30;
head->next = malloc(sizeof(Node));
head->next->element = 10;
head->next->next = malloc(sizeof(Node));
head->next->next->element = 15;
head->next->next->next = NULL;

/*
resultado

head->30->10->15->NULL 
*/
////////////////
// interface de um TAD Lista Encadeada

#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include "element.h"

typedef struct LinkedList LL;

LL* list_create();
void list_destroy(LL* list);
void list_insertBegin(LL* list, Element e);
void list_insertEnd(LL* list, Element e);
void list_insertPos(LL*list, Element e, int pos);
void list_removeFirst(LL* list);
void list_remove(LL* list, int posicao);
int list_get(LL* list, int posicao);
int list_size(LL* list);
int list_isEmpty(LL* list);
void list_print(LL* list);

#endif


// não expor o nó dentro do arquivo.h !!! por conta da segurança

///////////////

// definindo a estrutura


struct LinkedList{
Node* head;
};

// a cabeça é apenas um referencial, um ponteiro

////////////

#ifndef LL_H
#define LL_H

#include "element.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct LinkedList LL;

LL* list_create(){
LL* list = malloc(sizeof(LL));
list->head = NULL;
return list;
}

void list_print(){
Node* cur = list->head;

while(cur != NULL){
element_print(cur->element)
printf(" ");
cur = cur->next;
if(cur != NULL){
printf("->");
}
printf("\n");
}

void list_destroy(LL* list){

Node* trash = list->head;
while(trash != NULL){

list->head = trash->next;
free(trash);
trash= trash->head;
}
free(list);
}


void list_insertBegin(LL* list, Element e){
Node* newNode = malloc(sizeof(Node));
newNode->element = e;
newNode->next = list->head;
list->head = newNode;
}



void list_insertEnd(){
}

void list_insertPos(){

if(list->head == NULL || pos<0){
list_insertFirst(list,element)
}   else{
    Node* cur = list->head;
    int i=0;

    while (i<pos && cur->next != NULL){
      cur = cur->next;
      i++;
     }
    Node* newNode = malloc(sizeof(Node));
    newNode->next = cur->next;
    cur->next = newNode;
    }
     
}


///////////////////// 
//main.c

#include "linked_list.h"

int main(){
LL* list = list_create();

list_insertBegin(list,10);
list_insertBegin(list,20);
list_insertBegin(list,30);

list_print(list);
list_destroy(list);

return 0;
}




