/*

______     _ _                       __ _                     
| ___ \   | (_)                     / _(_)                    
| |_/ /__ | |_ _ __ ___   ___  _ __| |_ _ ___ _ __ ___   ___  
|  __/ _ \| | | '_ ` _ \ / _ \| '__|  _| / __| '_ ` _ \ / _ \ 
| | | (_) | | | | | | | | (_) | |  | | | \__ \ | | | | | (_) |
\_|  \___/|_|_|_| |_| |_|\___/|_|  |_| |_|___/_| |_| |_|\___/ 
                                                              


*/

---------------------------------------------------------------------------
  // Subtipagem
  
  // A herança permite que uma classe seja tratada como um subtipo de outra classe, o que efetivamente nos permite a criação de hierarquias de classes.
  // Uma implicação desse conceito é que podemos, de modo abstrato, entender uma hierarquia de tipos como relações entre conjuntos.

class A {}
class B extends A {}
class C extends A {}

 // B ⊆ A
 // C ⊆ A
 // B ∩ C = ∅

  // O relacionamento de subtipagem é denominado formalmente como subsunção

---------------------------------------------------------------------------
  // Polimorfismo:

  // Polimorfismo ad-hoc: ocorre quando um método tem diferentes implementações para diferentes tipos de parâmetros. (Também conhecido como sobrecarga de métodos)
  // Polimorfismo paramétrico: ocorre quando um método é parametrizado por um tipo genérico. (Também conhecido como programação genérica)
  // Polimorfismo de inclusão (ou de subtipos): ocorre quando um método é implementado de maneira diferente por diferentes subtipos de uma classe. (Combina subtipagem com sobrescrita de métodos.)

---------------------------------------------------------------------------
  // Princípio da substituição (Liskov Substitution Principle, ou LSP)

  // *** Se B é um subtipo de A, então objetos do tipo B podem ser usados onde objetos do tipo A são esperados. ***


  // Permite a criação de sistemas de software flexíveis, extensíveis, e mais fáceis de manter. Em essência, o princípio da substituição é a essência do polimorfismo de subtipos

---------------------------------------------------------------------------

  // Polimorfismo de Subtipos:

    // Def: Polimorfismo é a capacidade de objetos de diferentes tipos, que estabelecem entre si relações de subtipagem, responderem de maneira
        // uniforme a um mesmo tipo de mensagem, por meio do princípio de substituição.


//  • Em variáveis. Variáveis de um supertipo podem armazenar referências a objetos de um subtipo.
//  • Em parâmetros. Métodos cujo parâmetro é um supertipo podem receber objetos de um subtipo como argumento.
//  • Em tipos de retorno. Métodos que retornam um supertipo podem retornar objetos de um subtipo.
//  • Em tipos genéricos. Tipos genéricos podem ser parametrizados com supertipos, mas receber objetos de subtipos.


  public abstract class Veiculo {
    protected String placa;

    public Veiculo(String placa) {
        this.placa = placa;
    }
}

public class Carro extends Veiculo {
    public Carro(String placa) {
        super(placa);
    }
}

public class Moto extends Veiculo {
    public Moto(String placa) {
        super(placa);
    }
}

// Pelo princípio da substituição, podemos usar objetos de Carro e Moto onde objetos de Veiculo são esperados.

---------------------------------------------------------------------------
  //  Polimorfismo em variáveis

  // Aplicado a variáveis, o polimorfismo nos permite armazenar referências a objetos de subtipos em variáveis de supertipos.

  Veiculo carro = new Carro("ABC-1234");
  Veiculo moto = new Moto("XYZ-9876");

  System.out.println(carro.placa);
  System.out.println(moto.placa);

  // Arrays Polimorficos: Outra variação de polimorfismo em variáveis consiste na criação de arrays polimórficos

---------------------------------------------------------------------------

  // Polimorfismo em parâmetros

  // Outro uso do princípio da substituição é a passagem de objetos de subtipos como argumentos de métodos que esperam objetos de supertipos
  // Neste caso, o método imprimePlaca() espera um objeto de Veiculo como argumento. No corpo do método imprimimos o tipo do objeto e a placa do veículo.
  
  class Main {
    static void imprimePlaca(Veiculo veiculo) {
        System.out.printf("%s: %s\n",
            veiculo.getClass().getSimpleName(),
            veiculo.placa);
    }

    public static void main(String[] args) {
        Carro carro = new Carro("ABC-1234");
        Moto moto = new Moto("XYZ-9876");

        imprimePlaca(carro);
        imprimePlaca(moto);
    }
}

    // Polimorfismo VS Sobrecarga. A alternativa para esse problema, seria criar versões sobrecarregadas do método imprimePlaca, tornando um código redundante
    











  
  
















