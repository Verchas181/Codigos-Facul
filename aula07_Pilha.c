/*

-__ /\\     ,, ,,          
  ||  \\  ' || ||      _   
 /||__|| \\ || ||/\\  < \, 
 \||__|| || || || ||  /-|| 
  ||  |, || || || || (( || 
_-||-_/  \\ \\ \\ |/  \/\\ 
  ||             _/        

*/

// "Last in First Out"
// operações push e pop (a operacao pop "remove" e retorna o elemento do topo da pilha)
// baseado em array estatico, array dinamico e lista encadeada

//////////////////////////////////////////////////////

// TAD

#ifndef STACK_H
#define STACK_H

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "element.h"

typedef struct Stack Stack;


Stack* stack_create(int capacidade);
void stack_destroy(Stack* stack);
bool stack_push(Stack* stack, Element e);
Element stack_pop(Stack* stack);
Element stack_peek(Stack* stack);
bool stack_size(Stack* stack);
bool stack_empty(Stack* stack);
bool stack_full(Stack* stack); // pilha é limitada, senão a pilha iria crescer indefinidamente, inclusive a pilha de execucao
void stack_print(Stack* stack);


//////////////////////////////////////////////////////

// implementacao baseada em array


#include "stack.h"

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define ELEMENT_NULL INT_MIN


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


Element stack_peek(Stack* stack){
// mostra o topo sem decrementar

 if (stack_empty(stack)){
  return ELEMENT_NULL;
}
  return stack->element[top];

}

bool stack_size(Stack* stack){

 return stack->top + 1;
}

bool stack_empty(Stack* stack){
  return stack->top == -1;
}

bool stack_full(Stack* stack){
  return stack->top == stack->capacity - 1;
}


void stack_print(Stack* stack){

 for(int i = 0; i < stack_size(stack); i++){

 element_print(stack->element[i]);
 printf(" ");
}
 printf("<-top \n");
}


//////////////////////////////////////////////////////

// implementacao baseada em lista encadeada

#include "stack.h"

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define ELEMENT_NULL INT_MIN

typedef struct Node{
  Element* element;
  Node* next;
}


struct Stack{
   Element* element;
   Node* top;
   int size;
   // int capacity;  se eu quiser que ela seja limitada
};

// push <-> insertFirst/insertBegin
// pop <-> removeFirst/removeBegin


Stack* stack_create(){
  Stack* stack = malloc(sizeof(Stack));
  stack->top = NULL;
  stack->size = 0;
}


void stack_destroy(Stack* stack);
  Node* cur = stack->top;
  while( cur != NULL){


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

Element stack_peek(Stack* stack) {
  if (stack_empty(stack)) {
    return ELEMENT_NULL;
  }
  return stack->top->element;
}

int stack_size(Stack* stack) {
  return stack->size;
}

bool stack_empty(Stack* stack) {
  return stack->top == NULL;
}

bool stack_full(Stack* stack) {
  // Lista encadeada não tem um limite de capacidade, então não precisa verificar se está cheia
  return false;
}

void stack_print(Stack* stack) {
  Node* current = stack->top;
  while (current != NULL) {
    element_print(current->element);
    printf(" ");
    current = current->next;
  }
  printf("<-top \n");
}

