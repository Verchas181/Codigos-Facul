/*___                            ______ _                  _       
 / _ \                           | ___ (_)                (_)      
/ /_\ \_ ____   _____  _ __ ___  | |_/ /_ _ __   __ _ _ __ _  __ _ 
|  _  | '__\ \ / / _ \| '__/ _ \ | ___ \ | '_ \ / _` | '__| |/ _` |
| | | | |   \ V / (_) | | |  __/ | |_/ / | | | | (_| | |  | | (_| |
\_| |_/_|    \_/ \___/|_|  \___| \____/|_|_| |_|\__,_|_|  |_|\__,_|
                                                                   
                                                                   */



// Propriedades de árvore binária:

 // Cada nó possui uma chave e no máximo dois filhos, chamados de filho esquerdo e filho direito
 // Cada filho de um nó é uma subárvore 
 // Há um nó especial, chamado de raiz, que é o nó a partir do qual a árvore é acessada
 // Cada nó, exceto a raiz, possui um nó pai
 // Um nó que não possui filhos é chamado de folha
 // Um nó que possui ao menos um filho é chamado de nó interno
 // As arestas (setas) são unidirecionais, ou seja, elas partem de um nó e terminam em outro nó (e não vice-versa)
 // A altura (h) é o tamanho do caminho mais longo da árvore (raiz->....->folha) (contar o numero de arestas)

// Propriedades de árvore binária de busca (ABB):
 // Para cada nó x, todos os nós da subárvore à esquerda de x possuem chaves menores que a chave de x;
 // Para cada nó x, todos os nós da subárvore à direita de x possuem chaves maiores que a chave de x.
 // Não há dois nós com a mesma chave
 // Uma arvore degenerada ("não-simétrica") é menos eficiente que uma arvore balanceada ("simetrica")

 // *** O pior caso é se o elemento não está na árvore O(h)

 /////////////////////////////////////////////////////////////////////////////////////////////////////////

 // arvore_binaria.h
 #ifndef BST_H
 #define BST_H

typedef struct Node {
    Element key;
    struct Node* left;
    struct Node* right;
}Node;

struct BST {
    Node* root;
};



#include <stdbool.h>

#include "element.h"


BST* bst_create();
void bst_destroy(BST* bst);
bool bst_search(BST* bst, Element key);
void bst_insert(BST* bst, Element key);
void bst_remove(BST* bst, Element key);
void bst_printInOrder(BST* bst);
void bst_printPreOrder(BST* bst);
void bst_printPostOrder(BST* bst);
int bst_height(BST* bst);
int bst_count(BST* bst);

#endif

/////////////////////////////////////////////////////////////////////////////////////////////////////////

// busca 
bool bst_search(BST* bst, Element key) {
    Node* cur = bst->root;

    while (cur != NULL) {
        if (key == cur->key) {
            return true;
 } else if (key < cur->key) {
    cur = cur->left;
 } else {
    cur = cur->right;
 }
    return false;
}

// percurso em ordem (esquerda, meio, direita)
void bst_printNodeInOrder(Node* node) {
    if (node == NULL) {
    return;
}
    bst_printNodeInOrder(node->left);
    element_print(node->key);
    printf(" ");
    bst_printNodeInOrder(node->right);
}

void bst_printInOrder(BST* bst) {
    bst_printNodeInOrder(bst->root);
    printf("\n");
}

// percurso pré-ordem (meio, esquerda, direita)

void bst_printNodePreOrder(Node* node) {
    if (node == NULL) {
        return;
}
    element_print(node->key);
    printf(" ");
    bst_printNodePreOrder(node->left);
    bst_printNodePreOrder(node->right);
}

// percurso pós-ordem (esquerda, direita, meio)

void bst_printNodePostOrder(Node* node) {
    if (node == NULL) {
        return;
}
    bst_printNodePostOrder(node->left);
    bst_printNodePostOrder(node->right);
    element_print(node->key);
    printf(" ");
}

// impressão em forma de diagrama

void bst_printDiagram(Node* node, int level) {
    if (node == NULL) {
        return;
}
    for (int i = 0; i < level; i++) {
        printf(" ");
}
    element_print(node->key);
    printf("\n");
    bst_printDiagram(node->left, level + 1);
    bst_printDiagram(node->right, level + 1);
}

// criador e destruidor

BST* bst_create() {
    BST* bst = malloc(sizeof(BST));
    bst->root = NULL;
    return bst;
}

void bst_destroyNode(Node* node) {
    if (node == NULL) {
    return;
}
    bst_destroyNode(node->left);
    bst_destroyNode(node->right);
    free(node);
}
void bst_destroy(BST* bst) {
    bst_destroyNode(bst->root);
    free(bst);
}

// inserção Recursiva

Node* bst_insertRecursive(Node* node, Element key) {
    if (node == NULL) {
        return createNode(key);
}
    if (key < node->key) {
    node->left = bst_insertRecursive(node->left, key);
} else if (key > node->key) { // recursive case 2
    node->right = bst_insertRecursive(node->right, key);
}

        return node;
}

void bst_insert(BST* bst, Element key) {
    bst_insertRecursive(bst->root, key);
}

// inserção Iterativa

void bst_insertIterative(BST* bst, Element key) {
    if (bst->root == NULL) { // empty tree
        bst->root = createNode(key);
            return;
 }
    Node* parent = NULL;
    Node* cur = bst->root;

    while (cur != NULL) { // non-empty tree, find the parent leaf
        if (cur->key == key) {
            return;
 } else if (key < cur->key) {
    parent = cur;
    cur = cur->left;
 } else {
    parent = cur;
    cur = cur->right;
 }
 }

    if (key < parent->key) { // insert in the leaf node
        parent->left = createNode(key);
} else {
    parent->right = createNode(key);
}
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////

// implementação recursiva

bool searchRecur(Node* cur, Element key) {
if (cur == NULL) {
    return false;
 }
if (key == cur->key) {
    return true;
}
 if (key < cur->key) {
    return searchRecur(cur->left, key);
}
    return searchRecur(cur->right, key);
}


 bool bst_search(BST* bst, Element key) {
    return searchRecur(bst->root, key);
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
// teste

#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>

#include "element.h"

(...)

Node* createTree() {
Node* root = createNode(50);
root->left = createNode(43);
root->left->left = createNode(3);
root->left->right = createNode(48);
root->left->right->left = createNode(45);
root->right = createNode(61);
root->right->left = createNode(58);
root->right->right = createNode(70);

    return root;
}

int main() {
    Node* root = createTree();
    Element contains[] = {50, 43, 3, 48, 45, 61, 58, 70};
    Element notContains[] = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 90,
};

for (int i = 0; i < 8; i++) {
    printf("%d: %sfound\n", contains[i], bst_searchRecur(root,contains[i]) ? "" : "not ");
}
for (int i = 0; i < 12; i++) {
printf("%d: %sfound\n", notContains[i], bst_searchRecur(root, notContains[i]) ? "" : "not ");
}
    return 0;
}
*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////