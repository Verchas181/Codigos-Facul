/*

  ____                                           
  / __ \                                          
 | |  | |_ __   ___ _ __ __ _  ___ ___   ___  ___ 
 | |  | | '_ \ / _ \ '__/ _` |/ __/ _ \ / _ \/ __|
 | |__| | |_) |  __/ | | (_| | (_| (_) |  __/\__ \
  \____/| .__/ \___|_|  \__,_|\___\___/ \___||___/
        | |                                       
        |_|                            

*/


--------------------------------------------------------------------------------------------------------------------------------------------------

--- Conhecendo java e a memória ---

// Em uma classe, ela deve possuir o mesmo nome que o arquivo dela. Deve ter uma "main" associada.
// para compilar em C devemos pegar o arquivo, passar com parâmetro -o e o compilador (gcc arquivo.c -o programa ou g++ arquivo.c -o programa)
// no caso do java temos (javac arquivo)
// Um objeto é tudo menos um tipo primitivo.
// O java NÃO da acesso à memória diretamente. Temos um acesso indireto à memoria através do java.
// O "new" é análogo ao "malloc" do C. Toda vez que o "new" aparece há alocação de memória na heap. 

--------------------------------------------------------------------------------------------------------------------------------------------------

--- Comparação e Cópia de Referencias ---

// NÃO se pode comparar strings ou arrays utilizando o "==".
  
// Deve-se utilizar o método "<str1>.equals(<str2>);" ou o "Array.equals(<arr1>,<arr2>);"

// Para copiar arrays "int[] c = Arrays.copyOf(a, a.length);"  , para copiar strings "String copia = new String(original);" , ""
  
  public class CompRef{
    public static void main(String [] args){
      int [] a = {1,2,3};
      int [] c = a; // "cópia rasa" , ao alterar um, também altera o outro.
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------
--- Switch Case ---

// Quase arcaico. Se não colocar "break" em cada caso então todos os casos seriam executados ou pulando entre casos.

int dia = 3;
String nomeDia = "";

switch (dia) {
    case 1:
        nomeDia = "Domingo";
        break;
    case 2:
        nomeDia = "Segunda";
        break;
    case 3:
        nomeDia = "Terça";
        break;
    case 4:
        nomeDia = "Quarta";
        break;
    case 5:
        nomeDia = "Quinta";
        break;
    case 6:
        nomeDia = "Sexta";
        break;
    case 7:
        nomeDia = "Sábado";
        break;
    default:
        nomeDia = "Dia inválido";
        break;
}

--------------------------------------------------------------------------------------------------------------------------------------------------

  --- Repetições ---

  // A operação "do while" executa pelo menos 1 vez. Já a "while" e "for" não.
  // O "break" cancela as repetições que estão sendo executáveis.
  // O "return" serve para retornar algo em função. Como a main é "void" ela não deve retornar nada, sendo desnecessário colocar o "return".
  // O "continue" serve para pular uma iteração ou um if.

  public class Repeticoes{
    public static void main (String[] args){
      for (int i = 1; i <= 5; i++) {
      }
      int contador = 1;
      while (contador <= 3) {
          System.out.println("Contagem: " + contador);
          contador++;
      }

      int num = 1;
      do {
          System.out.println("Número: " + num);
          num++;
      } while (num <= 5);
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------

--- Métodos ---

  public class Metodos{
  
    public static int soma(int a, int b){
      return a + b;
    }
  
    public static void main(Strings[] args){ 
      //static é um metodo que pode ser chamado sem a criação de um objeto. Métodos estáticos só podem chamar métodos estáticos.
      int a = 1;
      int b = 2;
      int c = soma(a,b);
      System.out.printf("Soma deu %d",c);
      }
}
      


  

    












  

      
