/*
 _____ _                                    _____ _     _      _            
/  __ \ |                           ___    |  _  | |   (_)    | |           
| /  \/ | __ _ ___ ___  ___  ___   ( _ )   | | | | |__  _  ___| |_ ___  ___ 
| |   | |/ _` / __/ __|/ _ \/ __|  / _ \/\ | | | | '_ \| |/ _ \ __/ _ \/ __|
| \__/\ | (_| \__ \__ \  __/\__ \ | (_>  < \ \_/ / |_) | |  __/ || (_) \__ \
 \____/_|\__,_|___/___/\___||___/  \___/\/  \___/|_.__/| |\___|\__\___/|___/
                                                      _/ |                  
                                                     |__/                   
*/

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Praticamente tudo em java se utiliza um objeto primeiramente.
// Uma classe é um moldador de objeto (a classe é como se fosse a "struct"). A classe é uma maneira de criar um novo tipo de dados dentro do compilador.
// Já um objeto é uma classe que foi nomeado e que teve propriedades atribuidas.
// Um exemplo de classe é o carro.
// Um exemplo de objeto é o Uno, o Gol, o Fusca, o Corolla ......
  
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Temos o definidor de acesso (private, public e default).
// Para uma abstração de código será utilizado o TAD (Tipo Abstrato de Dados) onde temos o domínio (onde as funções e estruturas/classes são declaradas) e a inteface (onde ocorrem as interações).

// Objeto: Um objeto é uma representação auto-contida que representa um conceito por meio do encapsulamento de dados (propriedades) e comportamentos associados a esses dados (métodos).
// Classe: Uma classe define um tipo de dados com base em um conjunto de propriedades e um conjunto de métodos (funções/interações). Uma classe pode permitir a criação de múltiplos objetos que terão as mesmas propriedades e métodos da classe.

// Toda classe necessáriamente tem um construtor, este construtor pode ter parâmetros padrão ou atribuídos.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Definindo uma classe
--- ContaCorrente.java ---

class ContaCorrente {
    String numeroDaConta;
    String titular;
    float saldo;

    // Construtor
    ContaCorrente(String numeroDaConta, String titular) {

    // O operador "this." sempre se refere ao atributo da classe.  É um operador de "Autoreferência"
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        saldo = 0.0f;
    }

    float sacar(float amount) {
        if (amount <= this.saldo) {
            this.saldo -= amount;
        }        

        return this.saldo;
    }

    float depositar(float amount) {
        this.saldo += amount;

        return this.saldo;
    }   
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Definindo objetos: 

  --- Main.java ---

  public class Main {
    public static void printContaCorrente(ContaCorrente c) {
        System.out.printf("Numero: %s\n", c.numeroDaConta);
        System.out.printf("Titular: %s\n", c.titular);
        System.out.printf("Saldo: R$ %.2f\n", c.saldo);
    }

    public static void main(String[] args) {

      // Ao declarar um novo tipo de dado (ContaCorrente) podemos utilizar o operador "new" para associar um objeto com o construtor desta classe. 
        ContaCorrente c1 = new ContaCorrente("123-x", "Maria");
        ContaCorrente c2 = new ContaCorrente("456-x", "Joao");

      // Quando utilizamos esta atribuição abaixo é como se pegassemos dois ponteiros e apontassemos eles para o MESMO endereço de memória.
      // Dessa forma ao alterar o valor de um alteramos o valor de outro.
        ContaCorrente c3 = c1;

        printContaCorrente(c1);        
        System.out.println();
        printContaCorrente(c2);
        System.out.println();
        printContaCorrente(c3);


        c1.depositar(100);
        c2.depositar(50);

        System.out.println();
        printContaCorrente(c1);
        System.out.println();
        printContaCorrente(c2);

        c1.sacar(100);
        c2.sacar(15);

        System.out.println();
        printContaCorrente(c1);
        System.out.println();
        printContaCorrente(c2);

    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--- Identidade de um objeto ---

// Em Java, a identidade de um objeto é representada pelo endereço do início de segmento de memória alocado na memória dinâmica. 
// Esse valor é retornado pelo método hashCode() da classe Object

public class IdentidadeObjeto {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente("123-x", "Fulano");
        ContaCorrente conta2 = new ContaCorrente("456-x", "Ciclano");

        System.out.println();

        System.out.println(conta1 + " " + "--->" + "" + conta1.hashCode());
        System.out.println(conta2 + " " + "--->" + "" + conta2.hashCode());
    }
}


// [*] ContaCorrente@1b6d3586 ---> 460141958
// [*] ContaCorrente@4554617c ---> 1163157884



































 


  
