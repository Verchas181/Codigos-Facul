/*

 _   _                                
| | | |                               
| |_| | ___ _ __ __ _ _ __   ___ __ _ 
|  _  |/ _ \ '__/ _` | '_ \ / __/ _` |
| | | |  __/ | | (_| | | | | (_| (_| |
\_| |_/\___|_|  \__,_|_| |_|\___\__,_|
                                      
                                      

*/

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


// Especialização. Processo de derivar entidades mais específicas a partir de entidades mais gerais.

// Generalização. Processo de derivar entidades mais gerais a partir de entidades mais específicas.

// Um exemplo é a relação entre mamifero, gatos e cachorros.
// Mamifero é uma generalização de gatos e cachorros, já ambos são especialização de mamífero.

// Hierarquia. Quando aplicamos as abstrações de especialização e de generalização a classes, obtemos uma hierarquia de tipos. 
// Dentro dessa hierarquia, a classe mais geral fica no topo e as classes mais específicas ficam na base.

// Todos os membros de uma classe superior são herdados por classes inferiores mas não ao contrário. *** NÃO SE DEVE DUPLICAR OS MEMBROS

// Podemos criar uma classe pessoa, em um exemplo análogo à um hospital. Onde temos especializações como paciente e funcionário, de funcionario temos médicos, enfermeiros e outros.

// No contexto de desenvolvimento de software, a palavra extensão é usada para indicar que um componente de software aumenta ou modifica o comportamento de outro componente, sem alterar o seu código-fonte

// Modelagem X Refatoração. A herança pode ser usada tanto para modelagem de um problema “do zero” quanto para refatoração melhoria de um modelo pré-existente). 
// No primeiro caso, a herança é usada para criar uma hierarquia de classes que represente fielmente o domínio do problema.
// No segundo caso, a herança é usada para refatorar um modelo de classes que possui baixa coesão, de modo a obter um modelo mais coeso e mais fácil de manter

  class Aluno {
    String nome;
    String ra;
    int anoNascimento;
}

class Graduando extends Aluno {
    String curso;
}

class PosGraduando extends Aluno {
    String programa;
    String orientador;
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Visibilidade 


//  O acesso é unidirecional, ou seja, as classes filhas podem acessar os membros da classe mãe, mas não o contrário.
  
// O acesso da classe filha a um membro da classe mãe é dependente do modificador de acesso que foi aplicado ao membro.
  
// Membros privados na classe-mãe. Não são acessíveis pelas classes-filhas (assim como não o são por qualquer outra classe).
// Membros públicos na classe-mãe. São acessíveis pelas classes-filhas (assim como por qualquer outra classe).
// Membros default na classe-mãe. São acessíveis pelas classes-filhas que estejam no mesmo pacote que a classe-mãe (assim como por qualquer outra classe que esteja no mesmo pacote).
// Membros protected na classe-mãe. É acessível por qualquer classe que esteja no mesmo pacote que a classe-mãe e  por qualquer classe-filha, mesmo que esteja em um pacote diferente.

  package base;

class Aluno {
    protected String nome;
    protected int ra;
    protected int anoNascimento;
}

package derivadas;

class Graduando extends Aluno {
    private String curso;

    public String toString() {
        return String.format("Nome: %s\n", nome)
            + String.format("RA: %s\n", ra)
            + String.format("Ano de Nascimento: %s\n", anoNascimento)
            + String.format("Curso: %s\n", curso);
    }
}

package derivadas;

class PosGraduando extends Aluno {
    private String programa;
    private String orientador;

    public String toString() {
        return String.format("Nome: %s\n", nome)
            + String.format("RA: %s\n", ra)
            + String.format("Ano de Nascimento: %s\n", anoNascimento)
            + String.format("Programa: %s\n", programa)
            + String.format("Orientador: %s\n", orientador);
    }
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Sobrescrita de propriedades

// A propriedade da classe-filha sobrescreve a propriedade da classe-mãe, de modo que a propriedade da classe-filha é, por padrão, acessada no lugar da propriedade da classe-mãe


  public class A {
    protected int x = 10;
}

public class B extends A {
    private int x = 20;

    public int m1() {
        return this.x;
    }

    public int m2() {
        return super.x;
    }
}


// “this” & “super”. 

// Toda subclasse possui duas referências implícitas: a referência this, que se refere à instância da subclasse, e a referência super, que se refere à instância da superclasse. 
// Na referência this.x se refere à propriedade x da classe B, enquanto a referência super.x se refere à propriedade x da classe A. 
// Em geral, utilizamos a referência super para eliminar ambiguidades de nomes quando a classe filha sombreia/sobrescreve algum membro da classe mãe, seja esse membro uma propriedade ou um método.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Sobrescrita de métodos

// Permite que uma classe-filha modifique o comportamento de um método da classe-mãe sem alterar o seu código-fonte.
// O mais interessante é que a sobrescrita é uma operação não-destrutiva, ou seja, sobrescrever não significa “apagar” 


  public class A {
    public void m1() {
        System.out.println("Método m1 da classe A");
    }
}

public class B extends A {
    public void m1() {
        System.out.println("Método m1 da classe B");
    }

    public void m2() {
        super.m1();
    }
}

// Regras

// O método da classe-filha deve ter a mesma assinatura do método da classe-mãe.
// O modificador de acesso do método da classe-filha não pode ser mais restritivo que o modificador de acesso do método da classe-mãe.
// O método da classe-filha não pode lançar exceções que não são lançadas pelo método da classe-mãe.


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//  Sobrescrita do método toString()


// Object. Em Java, toda classe herda naturalmente da classe Object, mesmo que não declare isso explicitamente via extends. 
// Ou seja, Object é a superclasse de todas as classes em Java, e fornece métodos que são comuns a todas as classes.
// Um dos métodos bastante utilizados de Object é o método toString().

// Esse método é chamado em muitas situações, como quando um objeto é passado como argumento para o método println() de System.out, ou quando um objeto é concatenado com uma string.
// O método toString() é um método que deve ser sobrescrito em muitas classes, para que a representação textual do objeto seja mais significativa.


  class Aluno {
    protected String nome;
    protected int ra;
    protected int anoNascimento;

    public String toString() {
        return String.format("Nome: %s\n", nome)
            + String.format("RA: %s\n", ra)
            + String.format("Ano de Nascimento: %s\n", anoNascimento);
    }
}

class Graduando extends Aluno {
    private String curso;

    public String toString() {
        return super.toString() + String.format("Curso: %s\n", curso);
    }
}

class PosGraduando extends Aluno {
    private String programa;
    private String orientador;

    public String toString() {
        return super.toString() + String.format("Programa: %s\n", programa)
            + String.format("Orientador: %s\n", orientador);
    }
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 // Sobrescrita do método equals















