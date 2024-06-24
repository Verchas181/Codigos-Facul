/*
______           _                     ___                  
| ___ \         (_)                   |_  |                 
| |_/ /_____   ___ ___  __ _  ___       | | __ ___   ____ _ 
|    // _ \ \ / / / __|/ _` |/ _ \      | |/ _` \ \ / / _` |
| |\ \  __/\ V /| \__ \ (_| | (_) | /\__/ / (_| |\ V / (_| |
\_| \_\___| \_/ |_|___/\__,_|\___/  \____/ \__,_| \_/ \__,_|

*/

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


// Um dos erros mais comuns envolvendo conceitos numéricos é a coerção de tipos. No caso temos:

// byte -> short, int, long, float, double
// short -> int, long, float, double
// int -> long, float, double
// long -> float, double
// float -> double

// exemplo

public class CoercaoTipos {
   public static void main(String[] args) {
      byte b = 10;
      short s = b;
      int i = s;
      long l = i;
      float f = l;
      double d = f;
   }
}

OU podemos fazer um cast de dados


public class Casting {
   public static void main(String[] args) {
      double d = 10.5;
      int i = (int) d;
      long l = (long) d;
      float f = (float) d;
   }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---Tipos de Referência ---

// É qualquer tipo que não seja primitivo
// A representação é feita através de uma referência (através da memória)
// É ANALOGO AO PONTEIRO EM C
// Tipos primitivos são aramazenados em memória estática
// Tipos de referência são armazenados em memória dinâmica
// 90% dos problemas de segurança em C e C++ é vazamento de memória, o java não dá acesso à memória. Estouro de Pilha, Spray de Heap ....

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- Array ---


public class Arrays1 {
   public static void main(String[] args) {
      int[] numeros = {1, 2, 3, 4, 5};
      double[] decimais = {1.0, 2.0, 3.0, 4.0, 5.0};
   }
}

O ARRAY JÁ VEM COM TAMANHO, DIFERENTE DO C, MAS PODE SER DECLARADO EXPLICITAMENTE 

public class Arrays2 {
   public static void main(String[] args) {
      int[] numeros = {1, 2, 3, 4, 5};
      double[] decimais = {1.0, 2.0, 3.0, 4.0, 5.0};

      numeros[0] = 10;
      decimais[1] = 4.5;

      System.out.println(numeros.length);
      System.out.println(decimais.length);
   }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- Strings ---

// São similares à arrays.  

/* Diferentemente da linguagem C, onde as strings são meramente arrays de carac-
teres terminados por um caractere nulo, em Java as strings são objetos de uma
classe String, portanto são um tipo de dados completamente diferente. Em Java,
as strings são imutáveis */

public class FormattedOutput {
   public static void main(String[] args) {
      String nome = "Maria";
      String sobrenome = "Silva";
      int idade = 18;
      double aplic = 123.453;

      System.out.printf("Olá %s\n", nome);
      System.out.printf("Olá %s %s\n", nome, sobrenome);
      System.out.printf("Olá %s %s. Você tem %d anos\n", nome, sobrenome, idade);
      System.out.printf("Você tem R$ %.2f aplicados na conta\n", aplic);
      System.out.printf(Locale.US, "You have $ %.2f in your savings account\n", aplic);
   }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
// Temos diversos comandos de manipulação: 

--- Modulos ---
charAt() | //Retorna o caractere na posição especificada
substring() | //Retorna uma substring da string
length() | //Retorna o tamanho da string
equals() | //Compara duas strings
compareTo() | //Compara duas strings lexicograficamente
toUpperCase() | //Converte a string para maiúsculas
toLowerCase() | //Converte a string para minúsculas
trim() | //Remove espaços em branco do início e do fim da string


--- OUT ---
print() | //Imprime um texto no console
println() | //Imprime um texto no console e pula para a próxima linha
printf() | //Imprime um texto formatado no console

--- IN ---
Scanner scan = new Scanner(Systen.in);
int n = scan.nextInt();
boolean b = scan.nexBoolean();
double d = scan.nextDouble();

--- Especificadores ---
%d | //Número inteiro
%f | //Número de ponto flutuante
%s | //String
%c | //Caractere
%b | //Booleano
%x | //Número hexadecimal
%o | //Número octal
%e | //Notação científica
  
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Exemplo de entrada de dados
  ---Entrada de Dados ---

import java.util.Scanner;

public class EntradaDados {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Digite um número inteiro: ");
      int numero = scanner.nextInt();
      System.out.printf("Você digitou o número %d\n", numero);

      System.out.print("Digite um número real: ");
      double decimal = scanner.nextDouble();
      System.out.printf("Você digitou o número %.2f\n", decimal);

      System.out.print("Digite uma string: ");
      String texto = scanner.nextLine();
      System.out.printf("Você digitou a string \"%s\"\n", texto);

      scanner.close();
   }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- Erros ---

public class ErroPadrao {
   public static void main(String[] args) {
      System.err.println("Erro: divisão por zero");

      try {
            int resultado = 10 / 0; Exemplo de divisão por zero
      } catch (ArithmeticException e) {
              System.err.println("Erro ao calcular: " + e.getMessage());
              e.printStackTrace(System.err); // Imprime o stack trace da exceção
          }
   }
}




// É possivel disparar diversos erros ao utilizar o módulo System.err.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  --- Promoção de Tipos ---

// A coerção de tipos só ocorre na atribuição de tipos, já a promoção de tipos coerge o tipo sempre para o maior tipo.
// byte -> short -> int -> long -> float -> double

public class PromocaoTipos {
  public static void main(String[] args) {
      int a = 10;
      double b = 20.0;
      double c = a + b;
      int d = a + (int) b;

      System.out.printf("a + b = %.1f\n", c);
      System.out.printf("a + (int) b = %d\n", d);
   }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- Operadores ---

+ Adição
- Subtração
* Multiplicação
/ Divisão
% Resto da divisão
++n/--n pré incremento/decremento
n++/n-- incremento/decremento
&& E lógico
|| OU lógico
! Negação lógica
== Igual a
!= Diferente de
> Maior que
< Menor que
>= Maior ou igual a
<= Menor ou igual a
= Atribuição simples
+= Adição e atribuição
-= Subtração e atribuição
*= Multiplicação e atribuição
/= Divisão e atribuição
%= Resto da divisão e atribuição

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- Comparação de pontos flutuantes ---

// Há uma precisão associada à um numero flutuante. Logo devemos tirar o módulo de cada número e utilizar uma tolerância.
// 0.1 + 0.2 == 0.3 é false (!!!)

public class ComparacaoPontoFlutuante {
  public static void main(String[] args) {
      double a = 0.1;
      double b = 0.2;
      double c = 0.3;
      double erro = 1e-10;
      boolean d = (a + b == c);
      boolean e = Math.abs(a + b - c) < erro;

      System.out.printf("a + b == c : %b\n", d);
      System.out.printf("Math.abs(a + b - c) < erro : %b\n", e);
   }
}




  








