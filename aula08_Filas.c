/*
 .____    .                
 /     °  |     ___    ____
 |__.  |  |    /   `  (    
 |     |  |   |    |  `--. 
 /     / /\__ `.__/| \___.'
                           

*/

// estrutura de dados linear que usa o principio FIFO, diferente de LIFO da pilha
// FIFO é first in first out (elementos inserido no final e removido no começo)
// utilizado para um pré carregamento de dados (buffering de streaming, escalonamento de tarefas de SO (varios aplicativos/processos abertos ao mesmo tempo),controle de impressão, busca de grafos em largura, simulação computacional, processamento de pacotes de rede em roteadores)
// pode ser implementado com array e com lista encadedada, assim como a pilha
// """+ facil com lista encadeada !!!"""

// operações:
// enfileirar (enqueue ou insert)
// desenfileirar (unqueue ou remove)
// frente (front)
// fim (back)




////////////////////////////////////////////////////////////////////////////////////////

// TAD Fila (queue.h)

 #ifndef QUEUE_H
 #define QUEUE_H

 #include "element.h"

 #include <stdbool.h>

 typedef struct Queue Queue;

 Queue* queue_create();
 void queue_destroy(Queue* queue);
 void queue_insert(Queue* queue, Element element);
 Element queue_remove(Queue* queue);
 Element queue_front(Queue* queue);
 Element queue_back(Queue* queue);
 int queue_size(Queue* queue);
 bool queue_isEmpty(Queue* queue);
 bool queue_isFull(Queue* queue);
 void queue_print(Queue* queue);

 #endif


////////////////////////////////////////////////////////////////////////////////////////

// Implementacao com Lista Encadeada (queue.c)

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


Element queue_front(Queue* queue){
  if (queue_isEmpty(queue){
    return ELEMENT_NULL;
  }
  return queue->front->element;
}

 Element queue_back(Queue* queue){
 if (queue_isEmpty(queue){
    return ELEMENT_NULL;
  }
  return queue->back->element;
 }

 }

int queue_size(Queue* queue){
  return queue->size;
}

bool queue_isEmpty(Queue* queue){
  return queue->front == NULL;
}

void queue_print(Queue* queue){
   Node* cur = queue->front;
  while(cur != NULL){
  element_print(cur->element);
  cur = cur->next;
}
}

////////////////////////////////////////////////////////////////////////////////////////

// Implementação com array (queue2.c)













