/*

 _____ _                            ___                                 _       
/  __ \ |                          / _ \                               | |      
| /  \/ | __ _ ___ ___  ___  ___  / /_\ \_   ____ _ _ __   ___ __ _  __| | ___  
| |   | |/ _` / __/ __|/ _ \/ __| |  _  \ \ / / _` | '_ \ / __/ _` |/ _` |/ _ \ 
| \__/\ | (_| \__ \__ \  __/\__ \ | | | |\ V / (_| | | | | (_| (_| | (_| | (_) |
 \____/_|\__,_|___/___/\___||___/ \_| |_/ \_/ \__,_|_| |_|\___\__,_|\__,_|\___/ 

  */
                                                                                
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    


// Classe Estática

// Classes estáticas são utilizadas para agrupar métodos e atributos que não dependem de instâncias
// Um exemplo seria uma classe de funções, não faz sentido instanciar funções.
// Note no exemplo abaixo que a classe possui um construtor privado, o que impede que ela seja instanciada

 public class SortingUtilStatic {
    private SortingUtilStatic() {}

    public static void bubbleSort(int[] array) {
        // implementação do algoritmo bubble sort
    }

    public static void quickSort(int[] array) {
        // implementação do algoritmo quick sort
    }

    public static void mergeSort(int[] array) {
        // implementação do algoritmo merge sort
    }
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


  // Classes internas

  ---Classe interna membro--- : é uma classe definida como um membro de outra classe. Necessita de uma instância da classe externa para ser instanciada.

   // É preciso haver uma instância da classe externa a partir da qual instancia-se a classe interna.
   // A classe interna tem acesso a todos os membros da classe externa, inclusive os membros privados.
   // Há uma declaração da classe interna para cada instância da classe externa, ou seja, é alocada memória para a classe interna a cada vez que a classe externa é instanciada.


 public class TextEditor {
    private String text;

    /**
     * Classe interna para contagem de caracteres
     * Acessa o membro privado 'text' da classe externa
     */
    public class CharacterCounter {
        public int countCharacters() {
            // Acessa a propriedade 'text' da classe externa usando 'TextEditor.this'
            return TextEditor.this.text.length();
        }
    }

    public TextEditor(String text) {
        this.text = text;
    }

    public int getCharacterCount() {
        return text.length();
    }
}
   // Note que para instanciar a classe interna membro, precisamos chamar o operador new após a instância da classe externa: editor.new CharacterCounter();

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor("Hello, world!");
        TextEditor.CharacterCounter counter = editor.new CharacterCounter();
        
        System.out.println(counter.countCharacters());
    }
}



 
  ---Classe interna anônima--- : é uma classe interna local que não possui nome. É utilizada para implementar interfaces ou classes abstratas.

   // Não possui nome.
   // Pode ser instanciada apenas uma vez.
   // Pode ser utilizada para implementar interfaces ou classes abstratas

 
  ---Classe interna estática---: é uma classe interna que é declarada com o modificador static. A classe interna estática pode ser instanciada sem a necessidade de instanciar a classe externa.
   // Somente as classes internas podem ser declaradas com o modificador static: seu uso em classes externas é proibido

   public class TextEditor {
    private String text;

    // Classe interna estática para contagem de caracteres
    public static class CharacterCounter {
        
        public int countCharacters(String text) {
            return text.length();
        }
    }

    public TextEditor(String text) {
        this.text = text;
    }

    public int getCharacterCount() {
        return text.length();
    }
}
  // A classe CharacterCounter não tem acesso aos membros da classe TextEditor, exceto membros estáticos
  // Podemos acessar esse tipo de classe da seguinte forma:


 public class Main {
    public static void main(String[] args) {
        TextEditor.CharacterCounter counter = new TextEditor.CharacterCounter();
        
        System.out.println(counter.countCharacters("Hello, world!"));
    }
}

 ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
 
   // Relacionamentos entre classes

   ---Associação---

   // Uma associação é uma relação entre duas classes que indica que uma classe “usa” a outra
  
   // Uma classe possui uma propriedade que é uma instância de outra classe.
   // Uma classe recebe um objeto de outra classe como parâmetro de um método.
   // Uma classe retorna um objeto de outra classe como resultado de um método.
   // Uma classe cria uma instância de outra classe dentro de um método.


  // Por exemplo, uma classe Turma pode ter uma associação com uma classe Disciplina

  Disciplina (1) <------------------ (0,n) Turma //(Uma disciplina tem 0 a n turmas)

  

   ---Agregação---


  // A agregação é um tipo de associação que indica que uma classe é composta por outras classes. (estabele uma semântica de todo-parte entre as classes)
  // Nesse relacionamento, um dos lados é o todo e o outro lado é a parte
  // Possui um "diamante" na parte que representa o "todo"
  
  // Um exemplo seria: "Um curso tem um corpo docente composto por vários professores. Podemos então dizer que um curso agrega professores." 


  Curso (0,3)<> ------------------> (0,n) Professor



  ---Composição---

   // Em particular, no relacionamento de composição o tempo de vida das instâncias da classe “parte” é dependente do tempo de vida da instância da classe “todo”.
   // Feito com um diamante preenchido.
  
   // Por exemplo, considere o relacionamento entre as classes Cliente e Conta, nodomínio bancário. 
   // Um cliente pode ter várias contas, e uma conta pertence a um único cliente. 
   // Nesse caso, podemos dizer que um cliente do banco é composto, dentre outros fatores, por um conjunto de contas das quais ele é titular.


   Cliente (1)<=> ------------------> (0,n) Contas


  /*
             Meronimia  Multiplicidade Navegabilidade  Tempo de vida
  Associação  Fraca     Qualquer        Varíavel       Independente
  Agregação   Forte     Qualquer        Unidirecional  Independente
  Composição  Forte     Qualquer        Unidirecional  Dependente


*/

** Meronímia. Nesse relacionamento, um dos lados é o todo e o outro lado é a parte





























 ]
