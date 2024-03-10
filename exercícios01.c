

//////////////////////////////////////////////////////////////////////////////////////

/* (1) Adicione no TAD LinkedList uma função que recebe duas listas encadeadas (LinkedList)
como argumento e imprima os elementos da primeira lista cujas posições estão armazenadas na segunda lista. A função deve ter a seguinte assinatura:
void list_printElements(LinkedList* l1, LinkedList* l2). Por exemplo, se a
primeira lista contém os elementos 30, 40, 10, 80, 5 e a segunda lista contém os
elementos 1, 3, 4, a função deve imprimir os elementos 40, 80, 5.*/

void list_printElements(LinkedList* l1, LinkedList* l2) {
    Node* cur2 = l2->head;
    
    while (cur2 != NULL) {
        int position = cur2->element;
        Node* cur1 = l1->head;
        for (int k = 0; k < position; k++) {
            cur1 = cur1->next;
        }
        if (cur1 != NULL) {
            printf("%d ", cur1->element);
        }
        cur2 = cur2->next;
    }

    printf("\n");
}
//////////////////////////////////////////////////////////////////////////////////////

/*. (2) Adicione no TAD LinkedList uma função que recebe como argumento duas listas encadeadas e retorna true se as listas são iguais e false caso contrário. A função deve ter
a seguinte assinatura: bool list_equals(LinkedList* l1, LinkedList* l2). Por
exemplo, se a primeira lista contém os elementos 1, 2, 3, 4, 5 e a segunda lista contém
os elementos 1, 2, 3, 4, 5, a função deve retornar true. Se a primeira lista contém
os elementos 1, 2, 3, 4, 5 e a segunda lista contém os elementos 1, 2, 3, 4, 6, a
função deve retornar false.*/

bool list_equals(LinkedList* l1, LinkedList* l2){
    if(list_size(l1) != list_size(l2)){
        return false;
    }
    Node* cur1 = l1->head;
    Node* cur2 = l2->head;

    while(cur1 != NULL || cur2 != NULL){
        if(cur1->element != cur2->element){
            return false;
        }
        cur1 = cur1->next;
        cur2 = cur2->next;
    }
    return true;
}

//////////////////////////////////////////////////////////////////////////////////////

/* (3) Adicione no TAD LinkedList uma função que recebe como argumento uma lista encadeada e
retorne como resultado o código 1 caso a lista esteja ordenada em ordem crescente, 2
caso esteja ordenada em ordem descrescente e 0 caso não esteja ordenada. A função deve
ter a seguinte assinatura: int list_isSorted(LinkedList* l). Por exemplo, se a lista
encadeada contém os elementos na ordem 1, 2, 3, 4, 5, a função deve retornar 1. Se a
lista contém os elementos na ordem 5, 4, 3, 2, 1, a função deve retornar 2. Se a lista
contém os elementos na ordem 1, 3, 2, 4, 5, a função deve retornar 0.*/

int list_isSorted(LinkedList* l){
    Node* cur = l->head;
    // exemplo crescente
    if (cur->element < cur->next->element){
        while(cur->next != NULL){
            if(cur->element > cur->next->element){
                return 0;
            }
            cur = cur->next;
        }
        return 1;
    }
    //exemplo decrescente
     if (cur->element >  cur->next->element){
        while(cur->next != NULL){
            if(cur->element < cur->next->element){
                return 0;
            }
            cur = cur->next;
        }
        return 2;
    }
    return 0;
}

//////////////////////////////////////////////////////////////////////////////////////

/* (4) Adicione ao TAD LinkedList uma função que remova todos os elementos duplicados de
uma lista encadeada. A função deve ter a seguinte assinatura:
void list_removeDuplicates(LinkedList* l). Por exemplo, se a lista encadeada
contém os elementos 1, 2, 3, 2, 4, 5, 3, a lista resultante deve conter os elementos
1, 2, 3, 4, 5.*/

void list_removeDuplicates(LinkedList* l){
    Node* cur = l->head;
    while(cur->next != NULL){
        Node* proximos = cur;
        while(proximos->next != NULL){
            if(proximos->next->element == cur->element){
                Node* trash = proximos->next;
                proximos->next = proximos->next->next;
                free(trash);
                l->size--;
            }
            proximos = proximos->next;
        }
        cur = cur->next
    }

}

//////////////////////////////////////////////////////////////////////////////////////

/* (5) Adicione no TAD LinkedList uma função que recebe uma lista encadeada como argumento e imprima os elementos da lista na ordem inversa.
 A função deve ter a seguinte assinatura: void list_printReverse(LinkedList* l). 
 Por exemplo, se a lista encadeada contém os elementos 1, 2, 3, 4, 5, a função deve imprimir os elementos na ordem
5, 4, 3, 2, 1. Não é permitido permitido alocar dinamicamente memória adicional
para resolver o problema.*/


void list_printReverse(LinkedList* l){

    for(int i = list_size(l); i >=0 ; i--){
        Node* cur = l->head;
        for(int j = 0;j<i;j++){
            cur = cur->next;
        }
        element_print(cur->element);
    }
    printf("\n");
}

//////////////////////////////////////////////////////////////////////////////////////

/* (6) Escreva um código-cliente que contenha uma função que recebe como argumento uma lista
encadeada (LinkedList) e retorne como resultado outra lista encadeada contendo os mesmos elementos na ordem reversa. 
A função deve ter a seguinte assinatura: LinkedList*
reverse(LinkedList* l). Por exemplo, se a lista encadeada contém os elementos na
ordem 1, 2, 3, 4, 5, a lista retornada deve conter os elementos na ordem 5, 4,
3, 2, 1. Não é permitido violar o encapsulamento da lista recebida como argumento,
todas as manipulações devem ocorrer via operações da interface da lista. Além disso,
terminada a função, a lista recebida como argumento deve ter os mesmos elementos que
tinha inicialmente, na mesma ordem.*/


// JEITO NÃO TÃO CERTO O(n²)

LinkedList* reverse(LinkedList* l){
    if (l->head == NULL){
        return NULL;
    }
    LinkedList* cria = list_create(......);
    for(int i = list_size(l);i > 0; i--){
       Node* cur = l->head;
        for(int j = 0; j< i; j++){
            cur = cur->next;
        }
        list_append(cria,cur);
    }
    return cria;
}

// OUTRO JEITO O(n) (!!!)

LinkedList* reverse(const LinkedList* l) {
    if (l == NULL || l->head == NULL) {
        return NULL;  
    }

    LinkedList* reversedList = list_create(.......)

    Node* cur = l->head;

    while (cur != NULL) {
        Node* newNode = malloc(sizeof(Node));
        newNode->data = current->data;
        newNode->next = reversedList->head;
        reversedList->head = newNode;
        current = current->next;
    }

    return reversedList;  
}

//////////////////////////////////////////////////////////////////////////////////////

/* (7) Escreva uma função que recebe uma pilha (Stack) como argumento e retorne uma cópia
da pilha. A função deve ter a seguinte assinatura: Stack* stack_copy(Stack* s). Por exemplo,
se a pilha contém os elementos top -> 1, 2, 3, 4, 5, a pilha retornada deve conter
os mesmos elementos. A função deve estar em um código-cliente da pilha. Obviamente,
não é permitido violar o encapsulamento da pilha recebida como argumento, todas as
manipulações devem ocorrer via operações da interface da pilha. Além disso, terminada
a função, a pilha recebida como argumento deve ter os mesmos elementos que tinha
inicialmente, na mesma ordem.*/


// MALANDRAGEM
Stack* stack_copy(Stack* s){
    Stack* copia = stack_create(s->capacity);
    Stack* copia_final = stack_create(s->capacity);
    int top = s->top;
    int top2 = copia->top;
    for(int i = 0;i< s->capacity;i++){
        stack_push(copia,s->element[top++])
    }
    for(int j = 0; j< s->capacity; j++){
        stack_push(copia_final,copia->element[top2++])
    }
    stack_destroy(copia);
    
    return copia_final;

}

// IMPLEMENTAÇÃO CORRETA (SEM MALANDRAGEM)

Stack* stack_copy(Stack* s) {
    Stack* copia_inversa = stack_create(s->capacity);
    Stack* copia_final = stack_create(s->capacity);

    while (!stack_isEmpty(s)) {
        stack_push(copia_inversa, stack_pop(s));
    }

   
    while (!stack_isEmpty(copia_inversa)) {
        int valor = stack_pop(copia_inversa);
        stack_push(s, valor);  
        stack_push(copia_final, valor);
    }

    
    free(copia_inversa->element);
    free(copia_inversa);

    return copia_final;
}


/* (8) Construa uma função que receba como argumento uma pilha (Stack) e retorne como
resultado uma fila (Queue) com os elementos da pilha na ordem inversa. A função deve
ter a seguinte assinatura: Queue* StackToQueue(Stack* s). Por exemplo, se na pilha os
elementos estão na ordem top-> 1, 2, 3, 4, 5, na fila os elementos devem estar na
ordem front -> 5, 4, 3, 2, 1. A função deve estar em um código-cliente. Não
é permitido violar o encapsulamento nem da pilha nem da fila. Todas as manipulações
devem ocorrer via operações das respectivas interfaces. Além disso, terminada a função, a
pilha recebida como argumento deve ter os mesmos elementos que tinha inicialmente, na
mesma ordem.*/


Queue* StackToQueue(Stack* s) {
    Stack* pilha_inversa = stack_create();

    while (!stack_isEmpty(s)) {
        int valor = stack_pop(s);
        stack_push(pilha_inversa, valor);
    }
    while(!stack_isEmpty(fila_inversa)){
        int valor2 = stack_pop(pilha_inversa)
        Queue* fila_inversa = queue_create();
        queue_enqueue(fila_inversa,valor2);
    }
    return fila_inversa;
}

/* (9) Escreva uma função que receba como argumento duas filas (Queue) e retorne como
resultado true, caso as filas sejam iguais, e false caso contrário, com a seguinte assinatura bool queue_equal(Stack* s, Stack* s2). As filas são iguais se
contém os mesmos elementos, na mesma ordem. Não é permitido violar o encapsulamento
das filas recebidas como argumento, todas as manipulações devem ocorrer via operações
da interface da fila. Além disso, terminada a função, as filas recebidas como argumento
devem ter os mesmos elementos que tinham inicialmente.*/

bool queue_equals(Stack* q1, Stack* q2){
    if(queue_size(q1) != queue_size(q2)){
        return false;
    }
 while(!queue_isEmpty(q1) || !queue_isEmpty(q2)){
    if(queue_dequeue(q1) != queue_dequeue(q2)){
        return false;
    }
 }
    return true;
}

/* (10) Escreva um programa que recebe como argumento uma string contendo uma expressão
aritmética, contendo parênteses, colchetes e chaves, e verifica se a expressão está corretamente balanceada. 
A função deve ter a seguinte assinatura: bool isBalanced(char* expr). 
Por exemplo, a expressão [2 * (3 + 4)] está corretamente balanceada, enquanto a expressão [2 * (3 + 4) não está.*/



















