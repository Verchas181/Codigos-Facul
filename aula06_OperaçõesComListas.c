/*
 _____                                                                       _      _       _
|  _  |                                                                     | |    (_)     | |
| | | | _ __    ___  _ __   __ _   ___   ___    ___  ___    ___  _ __ ___   | |     _  ___ | |_   __ _  ___
| | | || '_ \  / _ \| '__| / _` | / __| / _ \  / _ \/ __|  / _ \| '_ ` _ \  | |    | |/ __|| __| / _` |/ __|
\ \_/ /| |_) ||  __/| |   | (_| || (__ | (_) ||  __/\__ \ |  __/| | | | | | | |____| |\__ \| |_ | (_| |\__ \
 \___/ | .__/  \___||_|    \__,_| \___| \___/  \___||___/  \___||_| |_| |_| \_____/|_||___/ \__| \__,_||___/
       | |
       |_|


  */


// vamos criar a remoção de itens de uma Lista encadeada

// devemos criar um ponteiro "trash"
/*
if (head != NULL){
Node* trash = list->head;
list->head = list->head->next;
free(trash);
}
*/


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  #include "element.h" 
  
  LL* list_create();
void list_destroy(LL* list);
void list_insertFirst(LL* list, Element element);
void list_insertAfter(LL* list, int posicao, Element element);
void list_removeFirst()
vid list_print(LL* list);

#endif


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


bool list_removeFirst(LL* list){
  // lista vazia
  if(list->head == NULL){
    return false;
  }
  // lista n vazia
  Node* trash = list->head;
  list->head = list->head->next;
  free(trash);
  return true;
}

// para verificar a validade da funcao acima!!

void test_removeFirst(){
  LL* list = list_create();

  bool res =list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false");

  list_insertFirst(list,30);
  list_insertFirst(list,20);
  list_insertFirst(list,40);

  list_print(list);

  res = list_removeFirst(list); // true
  printf("%s \n",(res) ? "true" : "false");  
 res = list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false");// true
 res = list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false"); // true
 res = list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false"); // false

  list_destroy(list);

}


  bool list_removeAt(LL* list, int posicao){
    // caso de posicao invalida
    if (posicao < 0 || posicao >= list->size){
      return false;
    }
    if (posicao == 0){
     return list_removeFirst(list);
    }else{
      Node* prev = list->head;
      int i = 0;
      while(i < posicao - 1){
        prev= prev->next;
        i++;
    }
    Node* trash = prev->next;
    prev->next = trash-next; // ou  prev->next = prev->next->next;
    free(trash);
      list->size--;
    }

  return true;
  }

  void test_removeAt(){
  LL* list = list_create();
  bool res =list_removeAt(list);
  printf("%s \n",(res) ? "true" : "false");

  list_insertFirst(list,30);
  list_insertFirst(list,20);
  list_insertFirst(list,40);

  list_print(list);

  res = list_removeAt(list,-1); // fase
  printf("%s \n",(res) ? "true" : "false");  
  res = list_removeAt(list,10);
  printf("%s \n",(res) ? "true" : "false"); //false
  res = list_removeAt(list,1);
  printf("%s \n",(res) ? "true" : "false"); // true
  res = list_removeAt(list,0);
  printf("%s \n",(res) ? "true" : "false"); // true
  res = list_removeAt(list,0);
  printf("%s \n",(res) ? "true" : "false"); // true
  res = list_removeAt(list,0);
  printf("%s \n",(res) ? "true" : "false"); // false
  list_destroy(list);

  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  // LISTA BIDIRECIONAL
  
  // neste caso, podemos tanto "ir para frente", como "ir para trás" da lista
  // temos de definir o element.h, o element.c, o linked_list.h, linked_list.c e por fim a main

  // linked_list.h

#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include "element.h"

#include <stdbool.h>

typedef struct LinkedList LinkedList;

LinkedList *list_create();
void list_destroy(LinkedList *list);
void list_insertFirst(LinkedList *list, Element element);
void list_insertLast(LinkedList *list, Element element);
bool list_insertAfter(LinkedList *list, int position, Element element);
bool list_removeFirst(LinkedList *list);
bool list_removeLast(LinkedList *list);
bool list_removeAt(LinkedList *list, int position);
Element list_get(LinkedList *list, int position);
int list_size(LinkedList *list);
bool list_isEmpty(LinkedList *list);
void list_print(LinkedList *list);

#endif

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  

#include "linked_list.h"

#include <stdlib.h>
#include <stdio.h>

typedef struct Node {
    Element element;
    struct Node* next;
} Node;

struct LinkedList {
    Node* first;
    Node* last;
    int size;
};

LinkedList* list_create() {
    LinkedList* list = malloc(sizeof(LinkedList));

    list->first = NULL;
    list->last = NULL;
    list->size = 0;

    return list;

}

void list_destroy(LinkedList *list) {
    Node* cur = list->first;

    while (cur != NULL) {
        Node* trash = cur;

        cur = cur->next;
        free(trash);
    }

    free(list);
}

void list_insertFirst(LinkedList *list, Element element) {
    Node* newNode = malloc(sizeof(Node));

    newNode->element = element;
    newNode->next = list->first;
    list->first = newNode;
    if (list->last == NULL) {
        list->last = newNode;
    }
    list->size++;
}

void list_insertLast(LinkedList *list, Element element) {
    Node* newNode = malloc(sizeof(Node));

    newNode->element = element;
    newNode->next = NULL;

    if (list->last != NULL) {
        list->last->next = newNode;
    }

    list->last = newNode;

    if (list->first == NULL) {
        list->first = newNode;
    }
    list->size++;
}

bool list_insertAfter(LinkedList *list, int position, Element element) {
    if (position < 0 || position >= list->size) {
        return false;
    }

    Node* cur = list->first;
    int i = 0;

    while (i < position) {
        cur = cur->next;
        i++;
    }

    Node* newNode = malloc(sizeof(Node));

    newNode->element = element;
    newNode->next = cur->next;
    cur->next = newNode;

    if (cur == list->last) {
        list->last = newNode;
    }
    list->size++;

    return true;
}

bool list_removeFirst(LinkedList *list) {
    if (list->first == NULL) {
        return false;
    }
    
    Node* trash = list->first;

    list->first = list->first->next;
    if (list->first == NULL) {
        list->last = NULL;
    }
    free(trash);
    list->size--;

    return true;
}

bool list_removeLast(LinkedList *list) {
    if (list->first = NULL) {
        return false;    
    }

    if (list->first == list->last) {
        free(list->first);
        list->first = NULL;
        list->last = NULL;
    } else {
        Node* cur = list->first;

        while (cur->next != list->last) {
            cur = cur->next;
        }

        Node* trash = list->last;

        list->last = cur;
        list->last->next = NULL;

        free(trash);
    }

    return true;
}

bool list_removeAt(LinkedList *list, int position) {
    if (position < 0 || position >= list->size) {
        return false;
    }   
    if (position == 0) {
        return list_removeFirst(list);
    } else {
        Node* prev = list->first;
        int i = 0;

        while (i < position - 1) {
            prev = prev->next;
            i++;
        }

        Node* trash = prev->next;

        prev->next = trash->next;
        if (trash == list->last) {
            list->last = prev;
        }
        free(trash);

        return true;
    }
}

Element list_get(LinkedList *list, int position) {
    Node* cur = list->first;
    int i = 0;

    while (cur != NULL && i < position) {
        cur = cur->next;
        i++;
    }

    if (cur != NULL) {
        return cur->element;
    } else {
        return ELEMENT_NULL;
    }
}

int list_size(LinkedList *list) {
    return list->size;
}

bool list_isEmpty(LinkedList *list) {
    return list->first == NULL;
}

void list_print(LinkedList *list) {
    Node* cur = list->first;

    while (cur != NULL) {
        element_print(cur->element);
        if (cur->next != NULL)
            printf(" -> ");
        cur = cur->next;
    }

    printf("\n");
}
  




















