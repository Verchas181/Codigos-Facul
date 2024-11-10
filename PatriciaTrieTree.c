// Arvore Patricia

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


typedef struct PatriciaNode {
    char *prefix;
    bool isEndOfWord;
    struct PatriciaNode *left;
    struct PatriciaNode *right;
} PatriciaNode;


PatriciaNode *createPatriciaNode(const char *prefix, bool isEndOfWord) {
    PatriciaNode *node = (PatriciaNode *)malloc(sizeof(PatriciaNode));
    node->prefix = strdup(prefix);
    node->isEndOfWord = isEndOfWord;
    node->left = NULL;
    node->right = NULL;
    return node;
}


int comparePrefix(const char *a, const char *b) {
    int i;
    for (i = 0; a[i] && b[i] && a[i] == b[i]; i++);
    return i;
}


PatriciaNode *insertPatricia(PatriciaNode *root, const char *key) {
    if (!root) {
        return createPatriciaNode(key, true);
    }

    int prefixLen = comparePrefix(root->prefix, key);


    if (prefixLen == strlen(root->prefix)) {
        if (prefixLen == strlen(key)) {
            root->isEndOfWord = true;
        } else {
            if (!root->left) {
                root->left = createPatriciaNode(key + prefixLen, true);
            } else {
                root->left = insertPatricia(root->left, key + prefixLen);
            }
        }
    } else {

        PatriciaNode *newNode = createPatriciaNode(root->prefix + prefixLen, root->isEndOfWord);
        newNode->left = root->left;
        newNode->right = root->right;

        root->prefix[prefixLen] = '\0'; 
        root->left = newNode;
        root->isEndOfWord = (prefixLen == strlen(key));
        if (!root->isEndOfWord) {
            root->right = createPatriciaNode(key + prefixLen, true);
        }
    }
    return root;
}

bool searchPatricia(PatriciaNode *root, const char *key) {
    if (!root) return false;

    int prefixLen = comparePrefix(root->prefix, key);

    if (prefixLen == strlen(root->prefix)) {
        if (prefixLen == strlen(key)) {
            return root->isEndOfWord;
        }
        return searchPatricia(root->left, key + prefixLen);
    }
    return false;
}

---------------------------------------------------------------------------------------------------

  // Arvore Trie

  #include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define ALPHABET_SIZE 26 // Para letras de A a Z

typedef struct TrieNode {
    struct TrieNode *children[ALPHABET_SIZE];
    bool isEndOfWord;
} TrieNode;

TrieNode *createNode() {
    TrieNode *node = (TrieNode *)malloc(sizeof(TrieNode));
    node->isEndOfWord = false;
    for (int i = 0; i < ALPHABET_SIZE; i++) {
        node->children[i] = NULL;
    }
    return node;
}

void insert(TrieNode *root, const char *key) {
    TrieNode *current = root;
    for (int level = 0; level < strlen(key); level++) {
        int index = key[level] - 'a';
        if (current->children[index] == NULL) {
            current->children[index] = createNode();
        }
        current = current->children[index];
    }
    current->isEndOfWord = true;
}

bool search(TrieNode *root, const char *key) {
    TrieNode *current = root;
    for (int level = 0; level < strlen(key); level++) {
        int index = key[level] - 'a';
        if (current->children[index] == NULL) {
            return false;
        }
        current = current->children[index];
    }
    return (current != NULL && current->isEndOfWord);
}



