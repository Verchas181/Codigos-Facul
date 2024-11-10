
// Arvore B

#define MIN_DEGREE 2

typedef struct BTreeNode {
    int *keys;
    int degree;
    struct BTreeNode **children;
    int n;
    int isLeaf;
} BTreeNode;

BTreeNode *createNode(int degree, int isLeaf) {
    BTreeNode *node = malloc(sizeof(BTreeNode));
    node->degree = degree;
    node->isLeaf = isLeaf;
    node->keys = malloc(sizeof(int) * (2 * degree - 1));
    node->children = malloc(sizeof(BTreeNode *) * (2 * degree));
    node->n = 0;
    return node;
}

----------------------------------------------------------------------------------------------
// Arvore B+

  #include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define DEGREE 2 // Grau mínimo da árvore

typedef struct BPlusNode {
    int keys[2 * DEGREE - 1];
    struct BPlusNode *children[2 * DEGREE];
    struct BPlusNode *next;
    bool isLeaf;
    int n; 
} BPlusNode;

BPlusNode *createNode(bool isLeaf) {
    BPlusNode *node = malloc(sizeof(BPlusNode));
    node->isLeaf = isLeaf;
    node->n = 0;
    node->next = NULL;
    for (int i = 0; i < 2 * DEGREE; i++) {
        node->children[i] = NULL;
    }
    return node;
}

void splitChild(BPlusNode *parent, int i, BPlusNode *child) {
    BPlusNode *newNode = createNode(child->isLeaf);
    newNode->n = DEGREE - 1;

    for (int j = 0; j < DEGREE - 1; j++) {
        newNode->keys[j] = child->keys[j + DEGREE];
    }

    if (!child->isLeaf) {
        for (int j = 0; j < DEGREE; j++) {
            newNode->children[j] = child->children[j + DEGREE];
        }
    }

    child->n = DEGREE - 1;

    for (int j = parent->n; j >= i + 1; j--) {
        parent->children[j + 1] = parent->children[j];
    }

    parent->children[i + 1] = newNode;

    for (int j = parent->n - 1; j >= i; j--) {
        parent->keys[j + 1] = parent->keys[j];
    }

    parent->keys[i] = child->keys[DEGREE - 1];
    parent->n++;
}

void insertNonFull(BPlusNode *node, int key) {
    int i = node->n - 1;

    if (node->isLeaf) {
        while (i >= 0 && key < node->keys[i]) {
            node->keys[i + 1] = node->keys[i];
            i--;
        }
        node->keys[i + 1] = key;
        node->n++;
    } else {
        while (i >= 0 && key < node->keys[i]) {
            i--;
        }
        i++;
        if (node->children[i]->n == 2 * DEGREE - 1) {
            splitChild(node, i, node->children[i]);
            if (key > node->keys[i]) {
                i++;
            }
        }
        insertNonFull(node->children[i], key);
    }
}

void insert(BPlusNode **root, int key) {
    BPlusNode *r = *root;
    if (r->n == 2 * DEGREE - 1) {
        BPlusNode *s = createNode(false);
        *root = s;
        s->children[0] = r;
        splitChild(s, 0, r);
        insertNonFull(s, key);
    } else {
        insertNonFull(r, key);
    }
}

----------------------------------------------------------------------------------------------

  // Arvore B*

  #include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MIN_DEGREE 2 // Grau mínimo da árvore B*

typedef struct BStarNode {
    int keys[2 * MIN_DEGREE - 1];
    struct BStarNode *children[2 * MIN_DEGREE];
    bool isLeaf;
    int n; 
} BStarNode;

BStarNode *createBStarNode(bool isLeaf) {
    BStarNode *node = malloc(sizeof(BStarNode));
    node->isLeaf = isLeaf;
    node->n = 0;
    for (int i = 0; i < 2 * MIN_DEGREE; i++) {
        node->children[i] = NULL;
    }
    return node;
}


void splitAndRedistribute(BStarNode *parent, int i, BStarNode *node) {
    BStarNode *newNode = createBStarNode(node->isLeaf);
    int splitIdx = (2 * MIN_DEGREE) / 3; 

    for (int j = splitIdx; j < 2 * MIN_DEGREE - 1; j++) {
        newNode->keys[j - splitIdx] = node->keys[j];
        newNode->children[j - splitIdx] = node->children[j];
        node->keys[j] = 0;
        node->children[j] = NULL;
    }

    if (!node->isLeaf) {
        newNode->children[splitIdx] = node->children[2 * MIN_DEGREE - 1];
    }

    node->n = splitIdx;
    newNode->n = 2 * MIN_DEGREE - 1 - splitIdx;

    for (int j = parent->n; j >= i + 1; j--) {
        parent->children[j + 1] = parent->children[j];
    }

    parent->children[i + 1] = newNode;

    for (int j = parent->n - 1; j >= i; j--) {
        parent->keys[j + 1] = parent->keys[j];
    }

    parent->keys[i] = node->keys[splitIdx - 1];
    parent->n++;
}

void insertBStarNonFull(BStarNode *node, int key) {
    int i = node->n - 1;

    if (node->isLeaf) {
        while (i >= 0 && key < node->keys[i]) {
            node->keys[i + 1] = node->keys[i];
            i--;
        }
        node->keys[i + 1] = key;
        node->n++;
    } else {
        while (i >= 0 && key < node->keys[i]) {
            i--;
        }
        i++;
        if (node->children[i]->n == 2 * MIN_DEGREE - 1) {
            splitAndRedistribute(node, i, node->children[i]);
            if (key > node->keys[i]) {
                i++;
            }
        }
        insertBStarNonFull(node->children[i], key);
    }
}

void insertBStar(BStarNode **root, int key) {
    BStarNode *r = *root;
    if (r->n == 2 * MIN_DEGREE - 1) {
        BStarNode *s = createBStarNode(false);
        *root = s;
        s->children[0] = r;
        splitAndRedistribute(s, 0, r);
        insertBStarNonFull(s, key);
    } else {
        insertBStarNonFull(r, key);
    }
}


















