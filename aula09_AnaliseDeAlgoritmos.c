/*  ___              _ _                _         ___  _                  _ _                       
 / _ \            | (_)              | |       / _ \| |                (_) |                      
/ /_\ \_ __   __ _| |_ ___  ___    __| | ___  / /_\ \ | __ _  ___  _ __ _| |_ _ __ ___   ___  ___ 
|  _  | '_ \ / _` | | / __|/ _ \  / _` |/ _ \ |  _  | |/ _` |/ _ \| '__| | __| '_ ` _ \ / _ \/ __|
| | | | | | | (_| | | \__ \  __/ | (_| |  __/ | | | | | (_| | (_) | |  | | |_| | | | | | (_) \__ \
\_| |_/_| |_|\__,_|_|_|___/\___|  \__,_|\___| \_| |_/_|\__, |\___/|_|  |_|\__|_| |_| |_|\___/|___/
                                                        __/ |                                     
                                                       |___/                                      */

///////////////////////////////////////////////////////////////////////////////////////////////////////////

// Notação BIG: 

// Big-Omega(Ω) representa o melhor caso de um algorítmo
// Big-O(O) representa o pior dos casos (notação mais importante por ser o destaque do algorítmo)
// Big-Theta(Θ) representa o caso m´dio (todos menos o melhor e o pior caso)
// (A análise de algoritmo é uma ciencia "pessimista", onde sempre tomamos o pior caso como ponto de partida)

// para o estudo de algorítmos devemos levar em conta o tempo de execução e o espaço de memória alocado

// Existem duas metodologias principais para medir o desempenho de um algoritmo. 
// A metodologia empírica, baseia-se em experimentos e medições. 
// E a metodologia analítica, também conhecida como análise de complexidade, baseia-se em provas e fórmulas matemáticas.

// A análise empírica de eficiência é uma metodologia eficaz para medir o desempenho de um algoritmo. 
// No entanto, apresenta algumas limitações importantes, que devemos ter em mente ao interpretar os resultados do experimento.
// Influência do ambiente de execução, utilizado para Validação de resultados, Dificuldade de isolar variáveis, Dificuldade de comparar diferentes algoritmos.

// A análise de complexidade é a metodologia mais utilizada para medir o desempenho de algoritmos. 
// Baseada em provas e fórmulas matemáticas, é mais generalizável que a análise empírica.
// Casos de desempenho, Modelo de custo, Notação assintótica (notação-BIG), Análise de complexidade.

// temos dois tipos de operações que entram para o custo do algorítmo, as constantes e variáveis
// Operações constantes: atribuição, comparação, aritmetica.
// Operações variáveis: loops, chamada de funções ...

// Exemplo:

/*#include <stdio.h>
void generate_pairs(int *v, int n) {
    for (int i = 0; i < n; i++) {                            T_1 = a1*n + b1
        for (int j = 0; j < n; j++) {                        T_2 = a2*n + b2
            printf("(%d, %d)\n", v[i], v[j]);                T = 1
        }
    }
}*/

// Neste caso temos que o T_t = (a1*n + b1)*n + b2 + 1; logo temos que O(n²)

// podemos ter os seguintes tipos de complexidade (em ordem crescente):
// constante << logarítmico << linear << nlog(n) <<  polinomial << exponencial << fatorial