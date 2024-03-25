 
/*
  __    ____  ____      ____    __    __      __    _  _  ___  ____    __    ____    __   
  /__\  (  _ \(  _ \    (  _ \  /__\  (  )    /__\  ( \( )/ __)( ___)  /__\  (  _ \  /__\  
 /(__)\  ) _ < ) _ <     ) _ < /(__)\  )(__  /(__)\  )  (( (__  )__)  /(__)\  )(_) )/(__)\ 
(__)(__)(____/(____/    (____/(__)(__)(____)(__)(__)(_)\_)\___)(____)(__)(__)(____/(__)(__)

  */

// Arvore AVL (Adelson Velsky e Landis - União Soviética 1962)

// O fator de balanceamento determina se a arvore não esta balanceada
// FB(n) = | altura(esq(n)) − altura(dir(n)) |                 

/*

> 1 Desbalanceamento à esquerda
1 Desbalanceamento à esquerda (tolerável)
0 Árvore balanceada
−1 Desbalanceamento à direita (tolerável)
< −1 Desbalanceamento à direita

*/

// para o nó folha o FB é sempre 0, ja que nao tem subarvores...
// ao inserir um nó temos de recalcular o FB   (feito de baixo para cima)

///////////////////////////////////////////////////////////////////////////////

// temos 4 tipos de desbalanceamento


// LL (rotacao à direita)
// RR (rotacao à esquerda)
// LR (rotacao esquerda-direita)
// RL (rotacao direita-esquerda)


///////////////////////////////////////////////////////////////////////////////
typedef struct Node {
  Element key;
  struct Node* left;
  struct Node* right;
  int height;
} Node;

Node* createNode(Element key) {
  Node* newNode = malloc(sizeof(Node));
  newNode->key = key;
  newNode->left = NULL;
  newNode->right = NULL;
  newNode->height = 1;
  
    return newNode;
}

int maximum(int a, int b) {
   if (a > b){
       return a;
}else if (a < b){
       return b;
}

int height(Node* node) {
  if (node == NULL) {
      return 0;
}
    return node->height;
}

void updateHeight(Node* node) {
  if (node != NULL) {
    node->height = 1 + maximum(height(node->left), height(node->right));
}
}

void uptadeALLHeights(Node* root){
  if(root != NULL){
    updateALLHeights(root->left);
    updateALLHeights(root->left);
    updateHeight(root);
}

int balanceFactor(Node* node) {
  if (node == NULL) {
      return 0;
}

    return height(node->left) - height(node->right);
}

///////////////////////////////////////////////////////////////////////////////

// Rotacoes

Node* rotateRight(Node* node){
  Node* pivot = node->left;
  node->left = pivot->right;
  pivot->right = node;
  updateHeight(node);
  updateHeight(pivot);

    return pivot;
}

Node* rotateLeft(Node* node) {
  Node* pivot = node->right;
  node->right = pivot->left;
  pivot->left = node;
  updateHeight(node);
  updateHeight(pivot);

    return pivot;
}

Node* rotateLeftRight(Node* node) {
  node->left = rotateLeft(node->left);
    return rotateRight(node);
}

Node* rotateRightLeft(Node* node) {
  node->right = rotateRight(node->right);
    return rotateLeft(node);
}

///////////////////////////////////////////////////////////////////////////////
/*
|----------|-----------------|-----------------|------------------|
| bf(root) | bf(root->right) | bf(root->left)  | Desbalanceamento |
|----------|-----------------|-----------------|------------------|
| < -1     | <= 0            | X               | RR               |
| < -1     | > 0             | X               | RL               |
| > 1      | X               | >= 0            | LL               |
| > 1      | X               | < 0             | LR               |
|----------|-----------------|-----------------|------------------|
*/

///////////////////////////////////////////////////////////////////////////////


