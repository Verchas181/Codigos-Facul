//////////////////////////////////////////////////////////////////////////

// AARRAY DINAMICO

typedef struct ArrayDinamico {
  Elemento* dados;
  int tam;
  int capacidade;
}AD;

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

void AD_resize(AD* array, int novo_tam){
Elemento* new_array = realloc(array->dados,sizeof(Elemento) * novo_tam);
if(new_array != NULL){
  array->dados = new_array;
  array->capacidade = novo_tam;

}


//////////////////////////////////////////////////////////////////////////

// LISTA ENCADEADA


typedef struct Node {
    Element element;
    struct Node* next;
} Node;

typedef struct LinkedList {
    Node* head;
    int size;
}LL;

LL* list_create(){
    LL* list = malloc(sizeof(LL));
    list->head = NULL;
    list->size = 0;

    return list;
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

void list_insertPos(LL* list, int posicao, Element element){

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
  list->size++;
     
}

//////////////////////////////////////////////////////////////////////////

// LISTA BIENCADEADA

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

//////////////////////////////////////////////////////////////////////////

// PILHA BASEADA EM ARRAY

struct Stack{
   Element* element;
   int top;
   int capacity;
};



Stack* stack_create(int capacity){

  Stack* stack = malloc(sizeof(Stack));
  stack->element = malloc(sizeof(element)*capacity);
  stack->capacity = capacity;
  stack->top = -1;

    return stack;
}


void stack_destroy(Stack* stack){

    free(stack->element);
    free(stack);
}


bool stack_push(Stack* stack, Element e){
  if(stack_full(stack)){
    return false;
    }
  stack->top++;
  stack->element[stack->top] = e;
    return true;
}

Element stack_pop(Stack* stack){
  if (stack_empty(stack)){
    return ELEMENT_NULL;
    }
    return stack->element[stack->top--];
}


//////////////////////////////////////////////////////////////////////////

// PILHA BASEADA EM LISTA ENCADEADA

struct Stack{
   Element* element;
   Node* top;
   int size;
   // int capacity;  se eu quiser que ela seja limitada
};


Stack* stack_create(){
  Stack* stack = malloc(sizeof(Stack));
  stack->top = NULL;
  stack->size = 0;
}


void stack_destroy(Stack* stack) {
    Node* cur = stack->top; 

    while (cur != NULL) { 
        free(cur->element);      
        free(cur);               
        cur = cur->next;             
    }

    free(stack); 
}

bool stack_push(Stack* stack, Element e) {
  Node* new_node = malloc(sizeof(Node));
  if (new_node == NULL) {
    return false; // Falha na alocação de memória
  }
  new_node->element = e;
  new_node->next = stack->top;
  stack->top = new_node;
  stack->size++;
  return true;
}

Element stack_pop(Stack* stack) {
  if (stack_empty(stack)) {
    return ELEMENT_NULL;
  }
  Node* popped_node = stack->top;
  Element popped_element = popped_node->element;
  stack->top = popped_node->next;
  free(popped_node);
  stack->size--;
  return popped_element;
}

//////////////////////////////////////////////////////////////////////////

// FILA

#include "queue.h"

typedef struct Node {
  Element element;
  struct Node* next;
 } Node;

struct Queue {
  Node* front;
  Node* back;
  int size;
 };

Queue* queue_create() {
 Queue* queue = malloc(sizeof(Queue));

 queue->front = NULL;
 queue->back = NULL;
 queue->size = 0;

return queue;
}

void queue_destroy(Queue* queue) {
 while (!queue_isEmpty(queue)) {
 queue_remove(queue);
}
 free(queue);
}

void queue_insert(Queue* queue, Element element){
   Node* newNode = malloc(sizeof(Node));
   newNode->element = element
   newNode->next = NULL;
   
   if (queue_isEmpty(queue){
     queue->front = newNode;
     }else{
    queue->back->next = newNode;  
 }
   queue->back = newNode;
   queue->size++;
 }

Element queue_remove(Queue* queue){
  if (queue_isEmpty(queue){
    return ELEMENT_NULL; 
 }else{
    Node* trash = queue->front;
    Element eTrash = trash->element;
    queue->front = queue->front->next;
    free(trash);
    queue->size--;
  return eTrash;
 }
}



























//////////////////////////////////////////////////////////////////////////

