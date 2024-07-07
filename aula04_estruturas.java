/*
 _____    _              _                       
|  ___|  | |            | |                      
| |__ ___| |_ _ __ _   _| |_ _   _ _ __ __ _ ___ 
|  __/ __| __| '__| | | | __| | | | '__/ _` / __|
| |__\__ \ |_| |  | |_| | |_| |_| | | | (_| \__ \
\____/___/\__|_|   \__,_|\__|\__,_|_|  \__,_|___/
                                              

*/
----------------------------------------------------------------------------------------------------------------------------------------
// Para comparações feitas entre números flutuantes SEMPRE temos de utilizar um erro arbitrário, por exemplo:

double a = 0.1;
double b = 0.2;
double c = 0.3;
double erro = 1e-10;
boolean d = (a + b == c);
boolean e = Math.abs(a + b - c) < erro;

System.out.printf("ERRADO a + b == c : %b\n", d);
System.out.printf("CORRETO a + b - c < erro :  %b\n", e);

----------------------------------------------------------------------------------------------------------------------------------------
// No caso de estruturas de desvio podemos utilizar o "break" para finalizar um loop ou o "continue" para pular uma iteração.

  public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                break;
            }
            if (i % 2 == 0) {
                continue;
            }
            if (i % 8 == 0) {
                return;
            }
            System.out.print(i + " ");
        }        
    }
----------------------------------------------------------------------------------------------------------------------------------------

// Já para estruturas de seleção segue o seguinte exemplo:

  if (a > b) {
            System.out.println("a é maior que b");
        } else if (a < b) {
            System.out.println("a é menor que b");
        } else {
            System.out.println("a é igual a b");
        }

----------------------------------------------------------------------------------------------------------------------------------------

  // Relembrando o garbage collector:

  /*
O Garbage Collector (GC) do Java é um componente crucial da Java Virtual Machine (JVM) responsável pela gestão automática de memória. 
Ele visa automatizar a tarefa de alocação e desalocação de memória, liberando os programadores dessa responsabilidade e reduzindo a incidência de erros como vazamentos de memória e acessos a áreas de memória inválidas. 
Para entender o funcionamento do GC, é essencial compreender alguns conceitos fundamentais e as técnicas que ele utiliza.

Memória Gerenciada pela JVM
A JVM gerencia a memória em duas áreas principais: a heap e a stack. A heap é usada para armazenar objetos, enquanto a stack é usada para armazenar variáveis locais e chamadas de métodos. 
O Garbage Collector atua principalmente na heap, onde ele identifica e libera a memória ocupada por objetos que não são mais acessíveis pelo programa.

Ciclo de Vida dos Objetos
No Java, um objeto é criado e alocado na heap quando o operador new é usado. Esse objeto permanece na memória até que não haja mais referências a ele, tornando-o inacessível pelo programa. 
Nesse ponto, o Garbage Collector considera o objeto como "lixo" e pode liberá-lo para reutilização.
  */


















