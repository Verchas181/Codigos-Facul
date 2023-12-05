#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void procedimento(int *p , int n){
    for(int c = 0; c< n; c += 2 ){
        *(p + c)++;
    }
}

void procedimento2(int *px , int nx){
    for(int c = 0; c< nx; c += 2 ){
        px[c] += 1;
    }
}

int main(int argc[], char * argv[]){
    int meuVetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
     int tamanhoDoVetor = sizeof(meuVetor) / sizeof(meuVetor[0]);
     procedimento(meuVetor,tamanhoDoVetor);
     
      printf("Vetor com índices pares incrementados: ");
    for (int i = 0; i < tamanhoDoVetor; i++) {
        printf("%d ", meuVetor[i]);
    }
    printf("\n");

    return 0;
}