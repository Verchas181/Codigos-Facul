/*
 ____  _____ _     _____ ____  _____  _  ____  _        ____  ____  ____  _____ 
/ ___\/  __// \   /  __//   _\/__ __\/ \/  _ \/ \  /|  / ___\/  _ \/  __\/__ __\
|    \|  \  | |   |  \  |  /    / \  | || / \|| |\ ||  |    \| / \||  \/|  / \  
\___ ||  /_ | |_/\|  /_ |  \_   | |  | || \_/|| | \||  \___ || \_/||    /  | |  
\____/\____\\____/\____\\____/  \_/  \_/\____/\_/  \|  \____/\____/\_/\_\  \_/  
                                                                                */



void selectionSort(Element* arr, int n) {
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            Element temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

// Tempo: O(n²)
// Espaço: O(1)

/*
 _     _____ ____  ____    ____  ____  ____  _____ 
/ \ /|/  __//  _ \/  __\  / ___\/  _ \/  __\/__ __\
| |_|||  \  | / \||  \/|  |    \| / \||  \/|  / \  
| | |||  /_ | |-|||  __/  \___ || \_/||    /  | |  
\_/ \|\____\\_/ \|\_/     \____/\____/\_/\_\  \_/  
                                                   
                                                   */


// Versão com memória adicional (out-of-place)

void heapSort(Element *array, int n) {
    BinaryHeap* heap = bheap_create(n);

    for (int i = 0; i < n; i++) {
        bheap_insert(heap, array[i]);
    }

    for (int i = n - 1; i >= 0; i--) {
        array[i] = bheap_extract(heap);
    }

    bheap_destroy(heap);
}

//  Versão sem memória adicional (in-place)

/* O programa acima apresenta a implementação da operação heapify. Basicamente,
a operação percorre todos os nós internos, do mais profundo para o mais raso, e faz
o nó “descer” na árvore, garantindo que a propriedade de heap seja satisfeita. A
condição parent(size - 1), obtém o pai do último nó da heap, que é o nó mais
a direita do penúltimo nível. A partir desse nó, fazemos a operação siftDownAt
para todos os nós internos, até a raiz. A operação siftDownAt é praticamente a
mesma que a operação siftDown, mas recebe um índice como parâmetro, ao invés
de operar sempre sobre a raiz */

/*
 _      _____ ____  _____ _____   ____  ____  ____  _____ 
/ \__/|/  __//  __\/  __//  __/  / ___\/  _ \/  __\/__ __\
| |\/|||  \  |  \/|| |  _|  \    |    \| / \||  \/|  / \  
| |  |||  /_ |    /| |_//|  /_   \___ || \_/||    /  | |  
\_/  \|\____\\_/\_\\____\\____\  \____/\____/\_/\_\  \_/  
                                                          */

// Paradigma de Divisão e Conquista

/*o processo consiste em dividir o conjunto de dados sucessivamente ao meio, até que cada subconjunto contenha apenas um elemento. Em
seguida, os subconjuntos são mesclados dois a dois, de forma que a mesclagem
garanta a ordem dos elementos. O processo de mesclagem é repetido até que todos os subconjuntos sejam mesclados em um único conjunto ordenado.*/

void merge(Element *array, Element* aux, int l, int m, int r) {
    for (int k = l; k <= r; k++) {
        aux[k] = array[k];
    }

    int i = l;
    int j = m + 1;

    for (int k = l; k <= r; k++) {
        if (i > m) {
            array[k] = aux[j++];
        } else if (j > r) {
            array[k] = aux[i++];
        } else if (aux[j] < aux[i]) {
            array[k] = aux[j++];
        } else {
            array[k] = aux[i++];
        }
    }
}

// mergesort Recursivo
void mergeSortRecur(Element *arr, Element *aux, int l, int r) {
    if (l >= r) {
        return;
    }

    int m = l + (r - l) / 2;

    mergeSortRecur(arr, aux, l, m);
    mergeSortRecur(arr, aux, m + 1, r);
    merge(arr, aux, l, m, r);
}

void mergeSort(Element *arr, int size) {
    Element aux[size];

    mergeSortRecur(arr, aux, 0, size - 1);
}

// mergesort Iterativo

void mergeSortIter(Element *arr, Element *aux, int size) {
    for (int i = 1; i < size; i *= 2) {
        for (int j = 0; j < size - i; j += 2 * i) {
            int l = j;
            int m = j + i - 1;
            int r = j + 2 * i - 1;

            if (r >= size) {
                r = size - 1;
            }

            merge(arr, aux, l, m, r);
        }
    }
}

// Tempo: O(nlog(n))
// Espaço: O(n)


/*
 ____  _     _  ____  _  __   ____  ____  ____  _____ 
/  _ \/ \ /\/ \/   _\/ |/ /  / ___\/  _ \/  __\/__ __\
| / \|| | ||| ||  /  |   /   |    \| / \||  \/|  / \  
| \_\|| \_/|| ||  \_ |   \   \___ || \_/||    /  | |  
\____\\____/\_/\____/\_|\_\  \____/\____/\_/\_\  \_/  
                                                      */

// Utiliza um pivô, acha a posição do pivô, coloca os menores na esquerda, os maiores na direita, escolhe um pivô entre os menores, um pivô entre os maiores

void swap(Element *arr, int i, int j) {
    if (i != j) {
        Element temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

int partition(Element *arr, int low, int high) {
    Element pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr, i, j);
        }
    }

    swap(arr, i + 1, high);

    return i + 1;
}

void quickSortRecur(Element *arr, int low, int high) {
    if (low < high) {
        int pivot = partition(arr, low, high);

        quickSortRecur(arr, low, pivot - 1);
        quickSortRecur(arr, pivot + 1, high);
    }
}

void quickSort(Element *arr, int size) {
    quickSortRecur(arr, 0, size - 1);
}

// fazemos o quicksort aleatorio para não pegarmos os elementos das pontas, que caso o array ja esteja ordenado se torna os piores casos

void shuffle(Element *arr, int size) {
    srand(time(NULL));
    for (int i = size - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        swap(arr, i, j);
    }
}

void quickSort(Element *arr, int size) {
    shuffle(arr, size);  // Embaralha o array antes de iniciar o Quicksort
    quickSortRecur(arr, 0, size - 1);  // Chama a função recursiva de Quicksort
}


// Tempo: O(nlog(n))












