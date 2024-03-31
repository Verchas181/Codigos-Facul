/*
 __ __    ___   ____  ____       ____   ____  ____    ____  ____   ____   ____ 
|  |  |  /  _] /    ||    \     |    \ |    ||    \  /    ||    \ |    | /    |
|  |  | /  [_ |  o  ||  o  )    |  o  ) |  | |  _  ||  o  ||  D  ) |  | |  o  |
|  _  ||    _]|     ||   _/     |     | |  | |  |  ||     ||    /  |  | |     |
|  |  ||   [_ |  _  ||  |       |  O  | |  | |  |  ||  _  ||    \  |  | |  _  |
|  |  ||     ||  |  ||  |       |     | |  | |  |  ||  |  ||  .  \ |  | |  |  |
|__|__||_____||__|__||__|       |_____||____||__|__||__|__||__|\_||____||__|__|
                                                                               
*/

// Trata-se de uma estrutura que está na interface entre os problemas de busca e os problemas de ordenação
// Em particular, a heap binária é a estrutura de dados preferida para implementar filas de prioridade, que são usadas em muitos algoritmos de otimização e busca

/*

Propriedade de heap binária:

• Em uma heap binária, para cada nó x, o valor armazenado em x é
maior ou igual ao valor armazenado em seus filhos.

• O nó raiz da heap é armazenado no índice 0 do array.

• O filho esquerdo do nó i é armazenado no índice 2i + 1 do array.

• O filho direito do nó i é armazenado no índice 2i + 2 do array.

• O pai do nó i é armazenado no índice (i − 1)/2 do array.


*/
////////////////////////////////////////////////////////////////////////

// Definindo o TAD:


#ifndef BINARY_HEAP_H
#define BINARY_HEAP_H

#include <stdbool.h>

#include "element.h"

typedef struct BinaryHeap BinaryHeap;

BinaryHeap* bheap_create(int capacity);
void bheap_destroy(BinaryHeap* heap);
void bheap_insert(BinaryHeap *heap, Element element);
Element bheap_extract(BinaryHeap *heap);
Element bheap_peek(BinaryHeap *heap);
int bheap_size(BinaryHeap* heap);
bool bheap_isEmpty(BinaryHeap* heap);
bool bheap_isFull(BinaryHeap* heap);
void bheap_print(BinaryHeap* heap);

#endif
//////////////////////////////////////////////////////////////////////

struct BinaryHeap {
    Element* data;
    int capacity;
    int size;
};

int left(int index) {
    return index * 2 + 1;
}

int right(int index) {
    return index * 2 + 2;
}

int parent(int index) {
    return (index - 1) / 2;
}

bool hasLeft(BinaryHeap* bheap, int index) {
    return left(index) < bheap->size;
}

bool hasRight(BinaryHeap* bheap, int index) {
    return right(index) < bheap->size;
}

bool hasParent(BinaryHeap* bheap, int index) {
    return index > 0;
}

Element getLeft(BinaryHeap* bheap, int index) {
    if (!hasLeft(bheap, index)) {
        return ELEMENT_NULL;
    }

    return bheap->data[left(index)];
}

Element getRight(BinaryHeap* bheap, int index) {
    if (!hasRight(bheap, index)) {
        return ELEMENT_NULL;
    }

    return bheap->data[right(index)];
}

Element getParent(BinaryHeap* bheap, int index) {
    if (!hasParent(bheap, index)) {
        return ELEMENT_NULL;
    }

    return bheap->data[parent(index)];
}

Element get(BinaryHeap* bheap, int index) {
    if (index >= bheap->size) {
        return ELEMENT_NULL;
    }

    return bheap->data[index];
}


///////////////////////////////////////////////////////////////////

// inserção


void bheap_insert(BinaryHeap* bheap, Element element) {
    if (bheap_isFull(bheap)) {
        return;
    }

    bheap->data[bheap->size] = element;
    bheap->size++;
    siftUp(bheap);
}

void swapAt(BinaryHeap* bheap, int i, int j) {
    Element temp = bheap->data[i];
    bheap->data[i] = bheap->data[j];
    bheap->data[j] = temp;
}

void siftUp(BinaryHeap* bheap) {
    int cur = bheap->size - 1;

    while (hasParent(bheap, cur) && get(bheap, cur) > getParent(bheap, cur)) {
        swapAt(bheap, cur, parent(cur));
        cur = parent(cur);
    }
}


// remoção

Element removeMax(BinaryHeap* bheap) {
    Element result = bheap->data[0];

    bheap->data[0] = bheap->data[bheap->size - 1];
    bheap->size--;
    siftDown(bheap);

    return result;
}


void siftDown(BinaryHeap* bheap) {
    int cur = 0;

    while (hasLeft(bheap, cur)) {
        int maxChild = maximumAt(bheap, left(cur), right(cur));

        if (get(bheap, cur) > get(bheap, maxChild)) {
            break;
        }

        swapAt(bheap, cur, maxChild);
        cur = maxChild;
    }
}


// consulta

Element bheap_peek(BinaryHeap *heap) {
    if (heap->size == 0) {
        return ELEMENT_NULL;
    }

    return heap->data[0];
}

//












