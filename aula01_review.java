/*
 ___  ___  _   _  ___  
  |_  |/ _ \| | | |/ _ \ 
    | / /_\ \ | | / /_\ \
    | |  _  | | | |  _  |
/\__/ / | | \ \_/ / | | |
\____/\_| |_/\___/\_| |_/

*/

// Java é uma linguagem que tem linguagem estática. Ela verifica os tipos de váriaveis no momento de compilação (Previne erros de tipagem). Exemplos: C,C++, C#, Java.
// Javascritp e Python tem tipagem dinâmica. Se quer uma tipagem mais estática deve-se utilizar Typescript.
// Java também tem tipagem forte. Isso quer dizer que NÃO se pode mudar o tipo de uma variável ao longo do código.
// Java foi bem inspirada no C++. Sendo utilizada como alternativa à esta linguagem.


// Toda vez que for escrever um código em java é necessário inicialmente escrever uma classe. Se a classe foi criada, o arquivo DEVE ter o mesmo nome da classe.
// Quando compilar deve-se criar um arquivo ".class". Este será o "executavel".
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
---App.java---

public class App{
  public static void main(String[] args) throws exception{
    System.out.println("Hello World");
  }
}

*/

// Temos os tipos primitivos e os tipos de referência.
// Primitivos: Char, Bool, Int, Double, Long ... (Possuem tamanho fixo)
// Referência: Tudo que não é primitivo. (Objetos)

// Temos 2 tipos de memória na execução de um código (Stack e Heap)
// A stack é limitada, curta e eficiente (referência e "ponteiros"), a Heap é ilimitada (primitivos).
// Não são ponteiros porque nao tem acesso total à memória, já que no java a memória é protegida. Porém os tipos de referência funcionam semelhante à ponteiros.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--- TiposPrimitivos.java ---

public class TiposPrimitivos{
  public static void main(String[] args){
    byte b = 10; //  8 bits
    short s = 20; // 16 bits
    int i = 30; // 32 bits
    long l = 40; // 64 bits

    float f = 1.0; // 4 bytes ou 32 bits
    double d = 2.0; // 8 bytes ou 64 bits

    char c = 'a'; // 2 bytes ou 16 bits // Aspas simples em um caractere
    boolean bool = true; // 1 byte ou 8 bits (memória é endereçada por byte, no minimo)
    }
}

// podemos representar float, longs, octais, hexa ou binário. Porém tipos maiores não cabem em menores. (f no final, L no final, 0 no começo, 0x no começo, 0b no começo)
// 10.0f , 10L, 010, 0x10, 0b10
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- ArraysExemplo.java ---

public class ArraysExemplo{
  public static void main(String[] args){
    int[] numeros = {3,2,1,0}; // inicialização
    double[] decimais = {1.0,2.0,3.0}
    char[] caracteres = {'a','b','c'} // NÃO é uma string. É uma string APENAS em C e deve ter um '\0' no final para ser considerado uma string.

    System.out.println(numeros[2]);
    System.out.println(decimais[1]);
    System.out.println(caracteres[0]);
    
    int size = numeros.length; // Aqui é uma variável !!
    
    System.out.println(size);

    for(int i = 0; i < numeros.length; i++){
      System.out.print(numeros[i] + " "); // sem o "ln" do print não quebra a linha, imprimindo tudo na mesma linha.
    }  
  }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- StringsExemplo.java ---

public class StringsExemplo{
  public static void main(String[] args){
    String s1 = "Hello World!";
    
    // como String é uma classe podemos usar diversos métodos (funções embutidas) para manipular a string.
    // Pode-se ver todos os métodos na documentação do Java (Oracle).

    System.out.println(s1.charAt(2));
    System.out.println(s1.length()); // não tem \0, apenas no C. Aqui é um método !!


    System.out.printf("O valor de pi é %.3f\n", Math.PI); // Muito semelhante ao printf do C. (Print formatted)
  }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// No Java a saida padrão é o System.out.
// Análogo ao scanf temos o scanner no Java. Que por si possui a entrada padrão.

// DEPOIS DE UTILIZAR O SCANNER ELE DEVE SER FECHADO, É ANALOGO AO VAZAMENTO DE MEMÓRIA !!!

--- EntradaDados.java ---

import java.util.Scanner;

public class EntradaDados{
  public static void main(String[] args){
    Scanner scan = new Scanner(Systen.in);

    System.out.print("Digite um inteiro, um boolean e um double respectivamente");
    
    int n = scan.nextInt();
    boolean b = scan.nexBoolean();
    double d = scan.nextDouble();

    System.out.printf("Inteiro lido %d\n", n);
    System.out.printf("Boolean lido %b\n", b);
    System.out.printf("Double lido %.4f\n",d);

    // para ler UMA string deve-se usar o método scan.next(), NÃO lê espaço.
    // para o método scan.nextLine() deve-se tomar cuidado porque o \n de um println fica em buffer, cancelando a operação de receber uma linha. Não é recomendado limpar o buffer, é recomendado pular uma linha ao escrever scan.nextLine().

    String s = scanner.next();
    System.out.printf("String lida %s", s);

    /*
    --- exemplo do scan.nextLine() ---
      
      int n = scan.nextInt();
      boolean b = scan.nexBoolean();
      double d = scan.nextDouble();

      scan.nexLine();
      String s = scan.nextLine();
    
    *\

    // DEPOIS DE UTILIZAR O SCANNER ELE DEVE SER FECHADO, É ANALOGO AO VAZAMENTO DE MEMÓRIA !!!
    scan.close();
    
  }
}

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


--- AritmeticaLogica.java ---

public class AritmeticaLogica{
  public static void main(String[] args){
    int a = 1 + 1 ;
    int b = 1 - 2 ;
    int c = 1/2 ;
    int d = 11 % 2 ;
    float e = 1/2.0 ; // Ocorre a promoção para float.
    float f = (float)(1/2.0); // Ocorre o cast do número, sendo ele sujeito à truncamentos/arredondamentos.

    // operadores de decremento e incremento i++, ++i, i--,--i.

    boolean a = true;
    boolean b = false;
    boolean c = a && b;
    boolean d = a || b;
    boolean e = !a;

    int n = 10;
    int m = 20;

    boolean z = (n == m);
    boolean y = (n != m);
    boolean x = (n <= m);

    // tomar cuidado com comparação de floats, exemplo "0.1 + 0.2 == 0.3 --> false" !!!!. Já que a comparação bit a bit é incorreta neste caso. Deve-se incorporar variáveis neste caso.

    float g = 0.3;
    float g2 = 0.1 + 0.2;

    double erro = 1e-10
    boolean g3 = Math.abs(g4 - g3) < erro;
    System.out.println(g3); // true !!!
    
    
  }
}
    
















