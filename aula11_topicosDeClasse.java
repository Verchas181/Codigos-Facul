/*

 _____           _                     _        _____ _                         
|_   _|         (_)                   | |      /  __ \ |                        
  | | ___  _ __  _  ___ ___  ___    __| | ___  | /  \/ | __ _ ___ ___  ___  ___ 
  | |/ _ \| '_ \| |/ __/ _ \/ __|  / _` |/ _ \ | |   | |/ _` / __/ __|/ _ \/ __|
  | | (_) | |_) | | (_| (_) \__ \ | (_| |  __/ | \__/\ | (_| \__ \__ \  __/\__ \
  \_/\___/| .__/|_|\___\___/|___/  \__,_|\___|  \____/_|\__,_|___/___/\___||___/
          | |                                                                   
          |_|                                                                   

*/

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Sobrecarga de métodos

  // A sobrecarga de métodos é uma técnica que cria funções com o mesmo nome, sendo que estas são diferenciadas através de seus parâmetros no momento da declaração.
  // A sobrecarga de métodos é uma forma de polimorfismo

  // A sobrecarga ocorre quando as funções tem mesmo nome porém as seguintes características diferentes:
  
  // • Número de parâmetros.
  // • Tipo dos parâmetros.
  // • Ordem dos parâmetros

  // A SOBRECARGA NÃO É AFETADA PELO TIPO DE RETORNO DO MÉTODO.

      public int sum(int a, int b) {
        return a + b;
    }
    
    public double sum(double a, double b) {
        return a + b;
    }

  // Outro exemplo

    public void print() {
        System.out.println("Printing...");
    }
    
    public void print(String text) {
        System.out.println("Printing: " + text);
    }
    
    public void print(String text, int copies) {
        for (int i = 0; i < copies; i++) {
            System.out.println("Printing: " + text);
        }
    }

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Sobrecarga de construtores

  // A sobrecarga de construtores é um recurso útil para definir diferentes formas de inicialização de um objeto

    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    public Person(int age) {
        this.name = "Unknown";
        this.age = age;
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

  // Instanciando

    Person person1 = new Person();
    Person person2 = new Person("Alice", 30);
    Person person3 = new Person(25);

  
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Propriedades de estaticidade


  // Os membros de uma classe podem ser de instancia ou estáticos. Estáticos podem ser acessados por todas as instancias, já os membros instanciados só podem ser acessados discretamente.
  // Em resumo, os membros estáticos são compartilhados por todas as instâncias da classe

    public class Math {
     public static final double PI = 3.14159265358979323846;
    
     public static int max(int a, int b) {
     return a > b ? a : b;
     }
    
     public static int min(int a, int b) {
     return a < b ? a : b;
     }
  }

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Compartilhamento de propriedades

  // Quando uma classe possui uma propriedade estática, essa propriedade é compartilhada por todas as instâncias da classe. 
  // Ou seja, a propriedade estática atua como uma “variável global” para todas as instâncias da classe.

    public class Counter {
        private static int count;
    
        static {
            count = 0;
        }
    
        public Counter() {
            count++;
        }
    
        public static int getCount() {
            return count;
        }
    }

    // Classe que demonstra a contagem de instâncias da classe Counter
    public class Main {
        public static void main(String[] args) {
          
            // Criando três instâncias da classe Counter (cada instancia incrementa a propriedade count.
          
            new Counter();
            new Counter();
            new Counter();
    
            // Imprimindo o valor da propriedade estática count
            System.out.println(Counter.getCount());
        }
    }

  // Propriedades estáticas não devem ser inicializadas no construtor da classe, pois o construtor é chamado a cada vez que uma instância da classeé criada 
  // Se fizéssemos dessa forma, cada instância criada sobrescreveria o valor setado pela instância anterior

    public class Poupanca {
        private static double taxaDeJuros; // Propriedade estática para a taxa de juros
    
        private double saldo; // Propriedade de instância para o saldo
    
        static {
            taxaDeJuros = 0.05; // Inicialização da taxa de juros
        }
    
        public Poupanca(double saldo) {
            this.saldo = saldo; 
        }
    
        public void atualizarSaldo() {
            saldo += saldo * taxaDeJuros; 
        }
    
        public double getSaldo() {
            return saldo; 
        }
    
        public static void setTaxaDeJuros(double novaTaxa) {
            taxaDeJuros = novaTaxa; 
        }
    
        public static double getTaxaDeJuros() {
            return taxaDeJuros; 
        }
    }

  // Neste exemplo, a propriedade taxaDeJuros é comum a todas as contas poupança. Portanto, podemos definí-la como uma propriedade estática.
  // A propriedade saldo, por outro lado, é um valor que varia para cada instância















