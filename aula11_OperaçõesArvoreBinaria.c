/*      o__ __o                                                                                                                                                    o                                                                                      o__ __o      o                                         o                           
     /v     v\                                                                                                                                                  <|>                                                                                    <|     v\   _<|>_                                     _<|>_                         
    />       <\                                                                                                                                                 / \                                                                                    / \     <\                                                                          
  o/           \o   \o_ __o      o__  __o   \o__ __o     o__ __o/      __o__    o__ __o      o__  __o       __o__        o__  __o   \o__ __o__ __o            o/   \o       \o__ __o    o      o     o__ __o    \o__ __o     o__  __o       __o__      \o/     o/    o    \o__ __o      o__ __o/  \o__ __o     o       o__ __o/      __o__ 
 <|             |>   |    v\    /v      |>   |     |>   /v     |      />  \    /v     v\    /v      |>     />  \        /v      |>   |     |     |>          <|__ __|>       |     |>  <|>    <|>   /v     v\    |     |>   /v      |>     />  \        |__  _<|    <|>    |     |>    /v     |    |     |>   <|>     /v     |      />  \  
  \\           //   / \    <\  />      //   / \   < >  />     / \   o/        />       <\  />      //      \o          />      //   / \   / \   / \          /       \      / \   < >  < >    < >  />       <\  / \   < >  />      //      \o           |       \   / \   / \   / \   />     / \  / \   < >   / \    />     / \     \o     
    \         /     \o/     /  \o    o/     \o/        \      \o/  <|         \         /  \o    o/         v\         \o    o/     \o/   \o/   \o/        o/         \o    \o/         \o    o/   \         /  \o/        \o    o/         v\         <o>      /   \o/   \o/   \o/   \      \o/  \o/         \o/    \      \o/      v\    
     o       o       |     o    v\  /v __o   |          o      |    \\         o       o    v\  /v __o       <\         v\  /v __o   |     |     |        /v           v\    |           v\  /v     o       o    |          v\  /v __o       <\         |      o     |     |     |     o      |    |           |      o      |        <\   
     <\__ __/>      / \ __/>     <\/> __/>  / \         <\__  / \    _\o__</   <\__ __/>     <\/> __/>  _\o__</          <\/> __/>  / \   / \   / \      />             <\  / \           <\/>      <\__ __/>   / \          <\/> __/>  _\o__</        / \  __/>    / \   / \   / \    <\__  / \  / \         / \     <\__  / \  _\o__</   
                    \o/                                                                                                                                                                                                                                                                                                                    
                     |                                                                                                                                                                                                                                                                                                                     
                    / \      
                                                                                                                                                                                                                                                                                                                                  */


// Um novo nó é sempre inserido como um nó folha
// O nó pai do novo nó é sempre o último nó visitado durante a busca do local de inserção.

// Todas as operações a seguir são O(h) no tempo e no espaço recursivo
// O(1) no espaço iterativo (!!!)

/* Com base nessas propriedades, podemos perceber que o algoritmo de inserção
envolve:
1. encontrar o nó que será o pai do novo nó;
2. inserir o novo nó como filho (esquerdo ou direito) do nó pai.
 */

Node* createNode(Element key) {
    Node* node = (Node*) malloc(sizeof(Node));
    node->key = key;
    node->left = NULL;
    node->right = NULL;

        return node;
}

// implementação recursiva da inserção

Node* bst_insertRecursive(Node* node, Element key) {
    if (node == NULL) {
        return createNode(key);
    }
    if (key < node->key) {
    node->left = bst_insertRecursive(node->left, key);
} else if (key > node->key) {
    node->right = bst_insertRecursive(node->right, key);
}
    return node;
}
void bst_insert(BST* bst, Element key) {
    bst_insertRecursive(bst->root, key);
}

// implementação iterativa da inserção

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


// sucessor de um nó

Node* bst_successor(Node* node) {
    Node* cur = node->right;

    while (cur->left != NULL) {
        cur = cur->left;
}

        return cur;
}

// implementação recursiva da remoção 

Node* bst_removeRecur(Node* node, Element key) {
    if (node == NULL) {
        return node;
}
    if (key < node->key) {
        node->left = bst_removeRecur(node->left, key);
} else if (key > node->key) {
    node->right = bst_removeRecur(node->right, key);
} else {
    if (node->left == NULL) {
        Node* trash = node;
        node = node->right;
        free(trash);
} else if (node->right == NULL) {
    Node* trash = node;
    node = node->left;
    free(trash);
} else {
    Node* temp = bst_successor(node);
    node->key = temp->key;
    node->right = bst_removeRecur(node->right, temp->key);
}
}
    return node;
}

// implementação iterativa

void bst_removeIter(BST* bst, Element key) {
    Node* parent = NULL;
    Node* cur = bst->root;
    while (cur != NULL) {
        if (cur->key == key) {
            break;
} else if (key < cur->key) {
    parent = cur;
    cur = cur->left;
} else {
    parent = cur;
    cur = cur->right;
}
}

    if (cur == NULL) {
        return;
}
    if (cur->left == NULL) {
    if (parent == NULL) {
        bst->root = cur->right;
} else if (parent->left == cur) {
    parent->left = cur->right;
} else {
    parent->right = cur->right;
}
    free(cur);
} else if (cur->right == NULL) {
    if (parent == NULL) {
        bst->root = cur->left;
} else if (parent->left == cur) {
    parent->left = cur->left;
} else {
    parent->right = cur->left;
}
    free(cur);
} else {
    Node* successor = cur->right;
    parent = cur;
    while (successor->left != NULL) {
        parent = successor;
        successor = successor->left;
}

 cur->key = successor->key;

    if (parent->left == successor) {
        parent->left = successor->right;
} else {
    parent->right = successor->right;
}
    free(successor);
}
}

















