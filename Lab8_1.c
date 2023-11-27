#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    FILE *parquivo;
    char ajudante;
    int n;
    printf("Digite a quantidade de números:\n");
    scanf("%d",&n);
    printf("Digite o valor da seed:\n ");
    int seed;
    scanf("%d",&seed);
    srand(seed);
    
    
    
    parquivo = fopen("exemplo.txt","w");
    
    for(int i=1;i<n+1;i++){
    int x = rand()%11;
    fprintf(parquivo,"%d ",x);
    }
    
    fclose(parquivo);
    
    float m = 0;
    int c = 0;
    char aux;
    int y;
    
    parquivo = fopen("exemplo.txt", "r");
    for(int j = 0;j<n;j++){

        fscanf(parquivo,"%d",&y);
        m += y;
        c++;
         printf("%d",y);
         printf(" ");
    }
    printf("\n Média = %.2f",m/c);
    
    fclose(parquivo);
    return 0;
}