/*
 _____ _     _      _              _____                _                  _     
|  _  | |   (_)    | |            |_   _|              | |                (_)    
| | | | |__  _  ___| |_ ___  ___    | | _ __ ___  _   _| |_ __ ___   _____ _ ___ 
| | | | '_ \| |/ _ \ __/ _ \/ __|   | || '_ ` _ \| | | | __/ _` \ \ / / _ \ / __|
\ \_/ / |_) | |  __/ || (_) \__ \  _| || | | | | | |_| | || (_| |\ V /  __/ \__ \
 \___/|_.__/| |\___|\__\___/|___/  \___/_| |_| |_|\__,_|\__\__,_| \_/ \___|_|___/
           _/ |                                                                  
          |__/                                                                   

*/

-------------------------------------------------------------------------------------------------------------------------------------------------

  // Objeto cujo estado interno não pode ser alterado após a criação.
  // Propriedades são inicializadas no construtor e NÃO HÁ SETTER.
  // Tipos: String, Integer, Double....

  // Segurança. Objetos imutáveis são mais seguros, pois não podem ser modificados após a sua criação. Isso evita que dados sejam alterados inadvertidamente, o que pode levar a erros difíceis de detectar.
  
  //  Concorrência. Objetos imutáveis são mais fáceis de usar em ambientes concorrentes, pois não há a necessidade de sincronização para garantir a consistência dos dados.
  
  // Simplicidade. Objetos imutáveis são mais simples de usar e de entender, pois não têm efeitos colaterais e não dependem do estado do sistema.
  
  // Testabilidade. Objetos imutáveis são mais fáceis de testar, pois seu comportamento é determinístico e não depende do estado do sistema.
  
  // Declaratividade. Objetos imutáveis facilitam a integração da orientação aobjetos com paradigmas declarativos, como a programação funcional. 
  
  // Diferentes linguagens de programação, como Scala, Clojure e Haskell, incentivam o uso de objetos imutáveis para facilitar a programação funcional.

  // Se for utilizar strings em loop DEVE-SE utilizar o StringBuilder. 
  // Em loops onde a concatenação de strings é feita repetidamente, usar StringBuilder pode resultar em um desempenho significativamente melhor do que simplesmente concatenar strings usando o operador '+'.

-------------------------------------------------------------------------------------------------------------------------------------------------

---Palavra chave--- 
  final

// Pode ser aplicado em classes, métodos, variáveis, propriedades.
  
// Ao aplicar final em uma classe o método não pode ser sobrescrito e na classe ela não pode ser extendida (uma questão de herança, diferentemente de varíaveis/propriedades)

---Regras---

// Todas as propriedades devem ser final ou private.
  
// Apenas getters (NÃO EXISTE SETTER)
  
// Construtor provê os valores iniciais de cada propriedade.



-------------------------------------------------------------------------------------------------------------------------------------------------
  
---Ponto2D.java---
  
public class Ponto2D {
 private final double x;
 private final double y;

 public Ponto2D(double x, double y) {
  this.x = x;
  this.y = y;
 }

 public double getX() {
  return x;
 }

 public double getY() {
  return y;
 }

  // Para uma possivel modificacao deve-se instanciar uma classe 
  public Ponto2D mover(double dx, double dy) {
   return new Ponto2D(x + dx, y + dy);
 }
}

public static void main(String[] args){
  Ponto2D p1 = new Ponto2D(2,3);
  Ponto2D p2 = p1.move(3,2);

}


-------------------------------------------------------------------------------------------------------------------------------------------------

  ---Procedimentos---

// Definir propriedades como privadas. As propriedades de um objeto imutável devem ser definidas como privadas, para garantir o encapsulamento dos dados.
  
// Definir propriedades como finais. As propriedades de um objeto imutável devem ser definidas como finais, para garantir que não possam ser modificadas após a sua definição.
  
// Definir métodos acessores. Os métodos acessores devem ser definidos para permitir que outras classes acessem o estado interno do objeto, sem a possibilidade de modificá-lo.
  
// Não definir métodos mutatores. Objetos imutáveis não devem definir métodos mutatores, pois isso violaria o princípio de imutabilidade.
  
// Definir um construtor. Um construtor deve ser definido para inicializar as propriedades do objeto, garantindo que ele seja criado em um estado consistente.
  
// Definir métodos para operações imutáveis. Métodos que realizam operações que modificam o estado do objeto devem retornar um novo objeto, mantendo o objeto original inalterado.

-------------------------------------------------------------------------------------------------------------------------------------------------

---Variavel X Objeto---

  public class Imutabilidade {
   public static void main(String[] args) {
     
      // variável imutável, objeto imutável
      final Ponto2D o1 = new Ponto2D(0, 0);
     
      // variável mutável, objeto imutável
      Ponto2D o2 = o1;
     

      // variável imutável, objeto mutável
      final Estudante o3 = new Estudante("João", 2000, new double[] {8.0, 7.5, 9.0});
      // Não posso fazer o3 = o5;
     
      // variável mutável, objeto mutável
      Estudante o4 = new Estudante("João", 2000, new double[] {8.0, 7.5, 9.0});
      // Posso fazer o4 = o5;
   }
}

// A variável o1 é imutável, pois é precedida pelo modificador final. Ao mesmo tempo, a variável o1 armazena uma referência para um objeto imutável (conforme definimos no programa). 

// Duas coisas não podem acontecer: i) não podemos alterar a referência (memória) armazenada em o1, ou melhor, não conseguimos substituir o seu valor por outro objeto e ii) não podemos mudar o estado interno do objeto referenciado por o1.

// Por outro lado, a variável o2, por ser mutável, elimina a restrição i) discutida acima.

// A variável o3 é imutável, portanto não podemos alterar a referência que ela armazena. Mas, a classe Estudante, é mutável, pois possui métodos mutatores.

// Isso significa que podemos modificar o estado interno do objeto referenciado por o3. 

// Por fim, a variável o4 é mutável, pois não é precedida pelo modificador final e armazena uma referência para um objeto mutável. Isso significa que podemos alterar a referência armazenada em o4 e modificar o estado interno do objeto referenciado por o4.


-------------------------------------------------------------------------------------------------------------------------------------------------

  // Exemplos mais concretos 
  

  ---Objeto mutável, variável mutável---
  
     // permite modificar seu conteúdo
  
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(" World");
  System.out.println(sb.toString());

     //  pode ser modificada para referenciar outro objeto 

  sb = new StringBuilder("New StringBuilder");



  ---Objeto imutável, variável mutável---

    //  Uma vez criada, não pode ser modificada
    
  String str = "Hello";
  str = str.concat(" World");
  System.out.println(str);

    // Pode ser modificada para referenciar outra

  str = "New String";


  ---Objeto imutável, variável imutável---

    // Objeto imutável pode ser uma classe que possui todos os seus campos declarados como final e não fornece métodos para modificar seu estado
    // Não pode ser modificada para referenciar outro objeto
    

  ---Objeto mutável, variável imutável---

    //  Onde seu conteúdo pode ser alterado.

  List<String> list = new ArrayList<>();
  list.add("Hello");
  list.add("World");
  System.out.println(list);  // Saída: ["Hello", "World"]

    // Não pode ser modificada para referenciar outra lista











  
