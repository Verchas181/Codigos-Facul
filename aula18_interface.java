/*
 _____      _             __               
|_   _|    | |           / _|              
  | | _ __ | |_ ___ _ __| |_ __ _  ___ ___ 
  | || '_ \| __/ _ \ '__|  _/ _` |/ __/ _ \
 _| || | | | ||  __/ |  | || (_| | (_|  __/
 \___/_| |_|\__\___|_|  |_| \__,_|\___\___|

*/
------------------------------------------------------------------------------
  // Classe puramente abstrata

  // Considere como exemplo uma hierarquia de formas geométricas bidimensionais
  // Nesse exemplo em particular, detectamos a necessidade de especificar que toda forma geométrica deve possuir os métodos getArea() e getPerimetro(). 
  // Podemos dizer que esses métodos representam um contrato que deve ser seguido por todas as formas geométricas.

  // A interface é considerada uma classe puramente abstrata.
  // Uma classe puramente abstrata é uma classe abstrata que não possui métodos concretos, ou melhor, uma classe que possui apenas métodos abstratos.
  // Uma classe puramente abstrata é um modo de definir um contrato estrutural, ou seja, um conjunto de métodos que devem ser implementados pelas classes que obedecem ao contrato.

  public abstract class Forma2D {
    public abstract double getArea();
    public abstract double getPerimetro();
}

public class Retangulo extends Forma2D {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return largura * altura;
    }

    @Override
    public double getPerimetro() {
        return 2 * (largura + altura);
    }
}

public class Circulo extends Forma2D {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * raio;
    }
}


------------------------------------------------------------------------------
  // Interface

  // Definida usando a palavra-chave interface. 
  // Uma interface é uma especificação declarativa que define o que uma classe deve fazer, mas não como ela deve fazer.
  // O relacionamento entre uma classe e uma interface é chamado de implementação, ou realização.
  // Na implementação, a classe não herda propriedades ou métodos da interface, mas sim se compromete a implementar os métodos especificados na interface.
  // Implementação/realização de uma interface é um exemplo de subtipagem, pois uma classe que implementa uma interface pode ser tratada como um objeto do tipo da interface

  // Uma interface deve possuir apenas métodos abstratos, porém pode possuir constantes e outros facilitadores
  // Java permite que uma classe implemente várias interfaces, o que é uma forma de contornar a proibição da herança múltipla. 

  public interface Forma2D {
    double area();
    double perimetro();
}


---Implementação--- 

  public class Retangulo implements Forma2D {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double area() {
        return largura * altura;
    }

    @Override
    public double perimetro() {
        return 2 * (largura + altura);
    }
}

    public class Circulo implements Forma2D {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }
}

------------------------------------------------------------------------------
  // Interface "Comparable" e "Comparator"

    // Vamos considerar uma classe Pessoa, com propriedades como nome, idade, e altura.
    // Vamos considerar que queremos comparar duas pessoas com base na idade.
  
    // Uma forma de fazer isso seria definir um método customizado, por exemplo comparar(Pessoa p1) que compara o objeto atual com o objeto passado comoparâmetro. 
    // Porém, existe um modo mais padronizado e robusto de fazê-lo, que é utilizar como convenção a interface Comparable

    public interface Comparable<T> {
     int compareTo(T o);
      }

  ---Implementação---
    public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.idade - o.idade;
    }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos, " + altura + "m)";
    }
}

    // Aqui estamos utilizando programação genérica, que será visto mais à frente.


    // Quando queremos definir múltiplos critérios de ordenação para um objeto, podemos usar a interface Comparator.

    public interface Comparator<T> {
  int compare(T o1, T o2);
  }

  ---Implementação---
  
  import java.util.Comparator;

public class AlturaComparator implements Comparator<Pessoa> {
    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return Double.compare(o1.altura, o2.altura);
    }
}

public class NomeComparator implements Comparator<Pessoa> {
    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return o1.nome.compareTo(o2.nome);
    }
}


    // Comparator VS. Comparable:
/* Note que o nome do método é compare() e
não compareTo(): essa diferença de nomenclatura visa justamente trazer diferenciação entre as interfaces Comparable e Comparator. Além dos nomes diferentes,
outra diferença importante é que o método compare() (de Comparator) recebe
dois objetos como parâmetro, enquanto o método compareTo() (de Comparable)
compara o objeto atual com um único objeto passado como parâmetro. A vantagem dessa abordagem é que podemos definir múltiplos Comparators, cada um
com um critério de ordenação específico. */


------------------------------------------------------------------------------
  // Extensão de Interface
  
  // Interfaces podem estender outras interfaces, o que é uma forma de adicionar funcionalidades a uma interface existente.
  // A extensão de interfaces é útil para criar hierarquias de interfaces, que permitem organizar e reutilizar funcionalidades comuns

public interface Forma {
    double area();
}

public interface Forma2D extends Forma {
    double perimetro();
}

public interface Forma3D extends Forma {
    double volume();
}

   // Definimos uma interface Forma que define um método area(). 
   //Em seguida, definimos duas interfaces Forma2D e Forma3D que estendem a interface Forma e adicionam métodos perimetro() e volume(), respectivamente

















