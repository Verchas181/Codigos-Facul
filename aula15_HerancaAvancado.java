/*
 _   _                                   ___                                 _       
| | | |                                 / _ \                               | |      
| |_| | ___ _ __ __ _ _ __   ___ __ _  / /_\ \_   ____ _ _ __   ___ __ _  __| | ___  
|  _  |/ _ \ '__/ _` | '_ \ / __/ _` | |  _  \ \ / / _` | '_ \ / __/ _` |/ _` |/ _ \ 
| | | |  __/ | | (_| | | | | (_| (_| | | | | |\ V / (_| | | | | (_| (_| | (_| | (_) |
\_| |_/\___|_|  \__,_|_| |_|\___\__,_| \_| |_/ \_/ \__,_|_| |_|\___\__,_|\__,_|\___/ 
                                                                                     
                                                                                  
*/
------------------------------------------------------------------------------------------------------------------------------
  
// Em algumas hierarquias, é necessário que uma classe não possa ser instanciada, ou que um método não possa ser sobrescrito. 
//  Em Java, essas restrições são aplicadas por meio de palavras-chave específicas, como abstract e final.

------------------------------------------------------------------------------------------------------------------------------
// Classe Abstratas

// É uma classe que não pode ser instanciada. 
// Há dois tipos de restrição de participação:

  
// Restrição de participação total:  Uma instância não pode ser originada a partir da classe mãe. (Exemplo de universidade: todo funcionario ou é técnico ou professor)
// Restrição de participação parcial:  uma instância pode ser originada de qualquer classe da hierarquia. (Exemplo de universidade: existem funcionarios que não são apenas técnicos ou professores)

// O uso de classes abstratas auxilia na reutilização de código, manutenção, restrição de participação e consistência.

// *** Uma classe que não é abstrata deve ser chamada de classe concreta

// Classes abstratas podem ter métodos concretos e abstratos

------------------------------------------------------------------------------------------------------------------------------
// Métodos abstratos

// São métodos que não possuem implementação na classe MÃE, porém necessáriamente devem ter implementação nas classes filhas.
//Classes abstratas vs Métodos abstratos :  enquanto uma classe abstrata não pode ser instanciada, um método abstrato DEVE ser sobrescrito

// O operador abstract serve para declarar uma classe ou método abstrato

  package funcionarios;

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salarioBase;
    protected double descontos;

    public Funcionario(String nome, String cpf, double salarioBase, double descontos) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        this.descontos = descontos;
    }

    protected abstract double getAdicionais();

    protected double getSalarioBruto() {
        return this.salarioBase + this.getAdicionais();
    }

    protected double getSalarioLiquido() {
        return this.getSalarioBruto() - this.descontos;
    }
}


// Construtor de classe abstrata: Embora não possa ser instanciada, uma classe abstrata pode definir um construtor.
// A finalidade disso fica clara quando lembramos que, numa hierarquia de classes, o processo de instanciação hierárquico

// Implementação de método abstrato: Para exemplificar a implementação de um método abstrato, considere as definições das classes Vendedor e Assistente

package funcionarios;

public class Vendedor extends Funcionario {
    private double vendas;
    private double taxaComissao;

    public Vendedor(String nome, String cpf, double salarioBase, double descontos, double vendas, double taxaComissao) {
        super(nome, cpf, salarioBase, descontos);
        this.vendas = vendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    protected double getAdicionais() {
        return this.vendas * this.taxaComissao;
    }
}


package funcionarios;

public class AssistenteAdministrativo extends Funcionario {
    private double horasExtras;

    public AssistenteAdministrativo(String nome, String cpf, double salarioBase, double descontos, double horasExtras) {
        super(nome, cpf, salarioBase, descontos);
        this.horasExtras = horasExtras;
    }

    @Override
    protected double getAdicionais() {
        return this.salarioBase / 220 * 1.5 * this.horasExtras;
    }
}

------------------------------------------------------------------------------------------------------------------------------
// Classe anônima

// Uma classe que não possui nome, é uma forma de criar uma instância de uma classe abstrata sem precisar criar uma classe concreta
// São também um modo de implementar de modo conciso as partes abstratas de uma classe.

package funcionarios;

public class ClasseAnonima {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("João", "123.456.789-00", 1000, 100) {
            @Override
            protected double getAdicionais() {
                return salarioBase * 0.3;
            }
        };
        System.out.printf("Salário bruto: %.2f\n", funcionario.getSalarioBruto());
        System.out.printf("Adicionais: %.2f\n", funcionario.getAdicionais());
        System.out.printf("Salário líquido: %.2f\n", funcionario.getSalarioLiquido());
    }
}

// A classe anônima é definida por meio da chamada do construtor da classe abstrata
// Seguida de um bloco de código que implementa o método abstrato getAdicionais()

------------------------------------------------------------------------------------------------------------------------------

// Subclasses abstratas:

// Em algumas hierarquias, podemos ter uma situação peculiar, em que tanto uma superclasse quanto uma subclasse são abstratas. 
// Por exemplo, poderíamos definir, na hierarquia de funcionários, uma classe abstrata Gerente, que é subclasse de Funcionário.
// A classe gerente foi definida como abstrata, a partir da suposição que gerentes devem ser ou gerentes de vendas ou gerentes admnistrativos, necessariamente.
// Para tal, definimos as subclasses concretas de gerente: GerenteVendas e GerenteAdministrativo.

package funcionarios;

import java.util.ArrayList;

public abstract class Gerente extends Funcionario {
    protected enum Nivel {
        JUNIOR, PLENO, SENIOR
    }

    protected Nivel nivel;
    protected ArrayList<Funcionario> equipe;

    public Gerente(String nome, String cpf, double salarioBase, double descontos, Nivel nivel) {
        super(nome, cpf, salarioBase, descontos);
        this.nivel = nivel;
        this.equipe = new ArrayList<>();
    }
}



package funcionarios;

import java.util.ArrayList;

public class GerenteVendas extends Gerente {
    public GerenteVendas(String nome, String cpf, double salarioBase, double descontos, Nivel nivel, ArrayList<Vendedor> equipe) {
        super(nome, cpf, salarioBase, descontos, nivel);
        this.equipe.addAll(equipe);
    }

    @Override
    protected double getAdicionais() {
        if (this.nivel == Nivel.JUNIOR) {
            return this.salarioBase * 0.1;
        } else if (this.nivel == Nivel.PLENO) {
            return this.salarioBase * 0.15;
        } else {
            return this.salarioBase * 0.2;
        }
    }
}



package funcionarios;

import java.util.ArrayList;

public class GerenteAdministrativo extends Gerente {
    public GerenteAdministrativo(String nome, String cpf, double salarioBase, double descontos, Nivel nivel, ArrayList<AssistenteAdministrativo> equipe) {
        super(nome, cpf, salarioBase, descontos, nivel);
        this.equipe.addAll(equipe);
    }

    @Override
    protected double getAdicionais() {
        if (this.nivel == Nivel.JUNIOR) {
            return this.salarioBase * 0.05;
        } else if (this.nivel == Nivel.PLENO) {
            return this.salarioBase * 0.1;
        } else {
            return this.salarioBase * 0.15;
        }
    }
}


// A classe GerenteVendas implementa o método getAdicionais(), que calcula o bônus do gerente de vendas de acordo com o nível. 
// O bônus varia de 10% a 20% do salário base, de acordo com o nível do gerente.
// A classe GerenteAdministrativo é análoga à classe GerenteVendas, porém aplica um bônus diferente, de acordo com o nível do gerente.


------------------------------------------------------------------------------------------------------------------------------

 // Classes finais

 // Uma classe fechada, é uma classe que não pode ser estendida. Em Java, como em outras linguagens, uma classe é aberta por padrão
 // Podemos definir uma classe como fechada, ou seja, uma classe que não pode ser estendida. Para isso, utilizamos a palavra-chave final.

package funcionarios;

import java.util.ArrayList;

public final class GerenteVendas extends Gerente {
    // (...)
}

------------------------------------------------------------------------------------------------------------------------------

 // Métodos Finais

 // Um método final é um método que não pode ser sobrescrito pelas subclasses
 // Um exemplo é getSalarioLiquido, em que classes abaixo de Funcionario não conseguirão sobrescrever este método

 package funcionarios;

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salarioBase;
    protected double descontos;

    public Funcionario(String nome, String cpf, double salarioBase, double descontos) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        this.descontos = descontos;
    }

    protected abstract double getAdicionais();

    public final double getSalarioBruto() {
        return this.salarioBase + this.getAdicionais();
    }

    public final double getSalarioLiquido() {
        return this.getSalarioBruto() - this.descontos;
    }
}

------------------------------------------------------------------------------------------------------------------------------

 // Herança Múltipla

 // CONCEITUALMENTE, é possível que uma classe herde de mais de uma superclasse.
 
 // A herança múltipla é um recurso poderoso, porém complexo. Em Java, a herança múltipla de classes não é permitida. 
 // A justificativa para essa restrição é que a herança múltipla pode gerar ambiguidades, especialmente quando duas superclasses possuem métodos com a mesma assinatura.
 // Essa anomalia é conhecida como diamente de herança ou problema do diamante.


 // Diamante de hereança (Diamond Problem): O diamente de herança é uma situação em que uma classe herda de duas superclasses que possuem um método com a mesma assinatura.


 // Por exemplo, suponha que As classes Vendedor e Chefe sobrescrevem, a partir de Funcionario, o método abstrato getAdicionais().
 // Como saber qual implementação deve ser herdada?

 // Em C++, por exemplo, é possível definir a herança múltipla, porém é necessário especificar qual das superclasses fornecerá a implementação do método.

         
         +----------------------+
         |    Funcionário       |
         +----------------------+
         | - nivel: Nivel       |
         +----------------------+
         | + getAdicionais(): double |
         +----------------------+
                   ^   ^
                  /     \
                 /       \
+------------------+   +------------------+
|   GerenteVendas  |   |     Chefe        |
+------------------+   +------------------+
| - nivel: Nivel   |   |                  |
+------------------+   +------------------+
| + getAdicionais(): double | + getAdicionais(): double |
+------------------+   +------------------+
                 ^          ^
                  \        /
                   \      /
                    \    /
            +------------------+
            |    Vendedor      |
            +------------------+
            |                  |
            +------------------+
            | + getAdicionais(): double |
            +------------------+
















 




  
