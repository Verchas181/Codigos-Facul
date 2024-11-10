// Arvore RubroNegra

#include <stdio.h>
#include <stdlib.h>

typedef enum { RED, BLACK } Color;

typedef struct RBNode {
    int data;
    Color color;
    struct RBNode *left, *right, *parent;
} RBNode;

// Função para criar um novo nó da árvore Rubro-Negra
RBNode *createNode(int data) {
    RBNode *node = (RBNode *)malloc(sizeof(RBNode));
    node->data = data;
    node->color = RED;
    node->left = NULL;
    node->right = NULL;
    node->parent = NULL;
    return node;
}

// Função para fazer uma rotação à esquerda
void leftRotate(RBNode **root, RBNode *x) {
    RBNode *y = x->right;
    x->right = y->left;

    if (y->left != NULL) {
        y->left->parent = x;
    }
    y->parent = x->parent;

    if (x->parent == NULL) {
        *root = y;
    } else if (x == x->parent->left) {
        x->parent->left = y;
    } else {
        x->parent->right = y;
    }
    y->left = x;
    x->parent = y;
}

// Função para fazer uma rotação à direita
void rightRotate(RBNode **root, RBNode *y) {
    RBNode *x = y->left;
    y->left = x->right;

    if (x->right != NULL) {
        x->right->parent = y;
    }
    x->parent = y->parent;

    if (y->parent == NULL) {
        *root = x;
    } else if (y == y->parent->left) {
        y->parent->left = x;
    } else {
        y->parent->right = x;
    }
    x->right = y;
    y->parent = x;
}

// Função para ajustar a árvore após a inserção de um nó
void fixInsert(RBNode **root, RBNode *node) {
    while (node != *root && node->parent->color == RED) {
        if (node->parent == node->parent->parent->left) {
            RBNode *uncle = node->parent->parent->right;
            if (uncle != NULL && uncle->color == RED) {
                node->parent->color = BLACK;
                uncle->color = BLACK;
                node->parent->parent->color = RED;
                node = node->parent->parent;
            } else {
                if (node == node->parent->right) {
                    node = node->parent;
                    leftRotate(root, node);
                }
                node->parent->color = BLACK;
                node->parent->parent->color = RED;
                rightRotate(root, node->parent->parent);
            }
        } else {
            RBNode *uncle = node->parent->parent->left;
            if (uncle != NULL && uncle->color == RED) {
                node->parent->color = BLACK;
                uncle->color = BLACK;
                node->parent->parent->color = RED;
                node = node->parent->parent;
            } else {
                if (node == node->parent->left) {
                    node = node->parent;
                    rightRotate(root, node);
                }
                node->parent->color = BLACK;
                node->parent->parent->color = RED;
                leftRotate(root, node->parent->parent);
            }
        }
    }
    (*root)->color = BLACK;
}

// Função para inserir um novo nó na árvore Rubro-Negra
void insert(RBNode **root, int data) {
    RBNode *node = createNode(data);
    RBNode *y = NULL;
    RBNode *x = *root;

    while (x != NULL) {
        y = x;
        if (node->data < x->data) {
            x = x->left;
        } else {
            x = x->right;
        }
    }

    node->parent = y;
    if (y == NULL) {
        *root = node;
    } else if (node->data < y->data) {
        y->left = node;
    } else {
        y->right = node;
    }

    fixInsert(root, node);
}

// Função para imprimir a árvore em ordem (para teste)
void inorder(RBNode *root) {
    if (root == NULL) return;
    inorder(root->left);
    printf("%d (%s) ", root->data, root->color == RED ? "R" : "B");
    inorder(root->right);
}

// Exemplo de uso
int main() {
    RBNode *root = NULL;

    insert(&root, 10);
    insert(&root, 20);
    insert(&root, 30);
    insert(&root, 15);
    insert(&root, 25);

    printf("Árvore Rubro-Negra em ordem:\n");
    inorder(root);
    printf("\n");

    return 0;
}
