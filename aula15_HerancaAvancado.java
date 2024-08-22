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










  
