/*
______                                                            _____                      _           
| ___ \                                                          |  __ \                    (_)          
| |_/ / __ ___   __ _ _ __ __ _ _ __ ___   __ _  ___ __ _  ___   | |  \/ ___ _ __   ___ _ __ _  ___ __ _ 
|  __/ '__/ _ \ / _` | '__/ _` | '_ ` _ \ / _` |/ __/ _` |/ _ \  | | __ / _ \ '_ \ / _ \ '__| |/ __/ _` |
| |  | | | (_) | (_| | | | (_| | | | | | | (_| | (_| (_| | (_) | | |_\ \  __/ | | |  __/ |  | | (_| (_| |
\_|  |_|  \___/ \__, |_|  \__,_|_| |_| |_|\__,_|\___\__,_|\___/   \____/\___|_| |_|\___|_|  |_|\___\__,_|
                 __/ |                                                                                   
                |___/                                                                                    
*/
-----------------------------------------------------------------------------------------------------------
  // Definir estrutura de dados que possa armazenar qualquer tipo de dado

  // Problema: Definir o tipo de dado como Object “desliga” a tipagem estática
  // Perdemos a capacidade de manter a tipagem homogênea dos elementos. Dessa forma, qualquer coisa pode ser inserida com o push.

  ObjectStack stack = new ObjectStackImpl(5);

try {
    stack.push(10);
    stack.push(20.0);
    stack.push("Hello");
} catch (StructureFullException e) {
    e.printStackTrace();
}

-----------------------------------------------------------------------------------------------------------
  // Programação genérica

  // Classe ou interface genérica é quando podemos operar diferentes tipos de dado em uma classe

  public class AClass<T> {
    private T attribute;
    
    public void setAttribute(T attribute) { 
        this.attribute = attribute; 
    }
    
    public T getAttribute() { 
        return attribute; 
    }
}

xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  
    public interface AnInterface<T> {
    void method(T param);
}

-----------------------------------------------------------------------------------------------------------
  // Exemplo de implementação:

  public interface Stack<T> {
    void push(T element) throws StructureFullException;
    T pop() throws StructureEmptyException;
    T top() throws StructureEmptyException;
    int size();
    int capacity();
    boolean isEmpty();
    boolean isFull();
}
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

  public class StackImpl<T> implements Stack<T> {
    private T[] elements;
    private int top;

    @SuppressWarnings("unchecked")
    public StackImpl(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) throws StructureFullException {
        if (isFull()) {
            throw new StructureFullException(capacity(), size());
        }
        elements[top++] = element;
    }

    @Override
    public T pop() throws StructureEmptyException {
        if (isEmpty()) {
            throw new StructureEmptyException(capacity(), size());
        }
        return elements[--top];
    }

    @Override
    public T top() throws StructureEmptyException {
        if (isEmpty()) {
            throw new StructureEmptyException(capacity(), size());
        }
        return elements[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == elements.length;
    }
}

-----------------------------------------------------------------------------------------------------------
  // Exemplos de instanciação de classe genérica:

  public static void testStackDouble() {
    Stack<Double> stack = new StackImpl<>(5);

    try {
        stack.push(10.0);
        stack.push(20.0);
        stack.push(30.0);
        stack.push(40.0);
        stack.push(50.0);

        System.out.println(stack);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

  Stack<String> stack = new StackImpl<>(5);

try {
    stack.push("Hello");
    stack.push("World");
    stack.push("Java");
    stack.push("Programming");
    stack.push("Language");

    System.out.println(stack);
} catch (Exception e) {
    e.printStackTrace();
}

-----------------------------------------------------------------------------------------------------------
  // Terminologia: tipos genéricos

  // Parâmetro de tipo (type parameter)
   public interface Stack<T> { ... }
   public class StackImpl<T> implements Stack<T> { ... }

  // Argumento de tipo (type argument)
   Stack<Double> stack = new StackImpl<Double>(5);

  // Apagamento de tipo (type erasure)
    // Em tempo de compilação:
    // Tipos genéricos são substituídos por tipos raw (e.g. Object) no bytecode
    // Em tempo de execução:
    // Metadados são usados para manter a segurança de tipos
-----------------------------------------------------------------------------------------------------------
  // Múltiplos parâmetros de tipo

  public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

Pair<String, Integer> pair = new Pair<>("Hello", 10);

-----------------------------------------------------------------------------------------------------------
  // Métodos genéricos

  // Um método genérico é um método que pode operar sobre qualquer tipo de dado.

    public <T> void metodoGenerico (T a , int b , char c) {}
    public static <T> void metodoEstaticoGenerico (T a , char c) {}

  // Exemplo de implementação de método generico para imprimir arrays:

    public static <T> String toString(T[] elements) {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < elements.length; i++) {
        sb.append(elements[i]);
        if (i < elements.length - 1)
            sb.append(",");
    }
    sb.append("]");

    return sb.toString();
}

-----------------------------------------------------------------------------------------------------------

  // Tipos limitados

  // Um tipo limitado é um tipo genérico que é restringido a um subconjunto de tipos.

  // Covariância (upper bound): extends restringe ao tipo e suas subclasses

  public class A<T extends Number> { ... }
  public class A<T extends Comparable<T>> { ... }

  // Contravariância (lower bound): super restringe ao tipo e suas superclasses (somente com máscaras)

  StackImpl<? super Integer> stack = new StackImpl<>(5);
  ArrayList<? super Number> list = new ArrayList<>();

-----------------------------------------------------------------------------------------------------------

  // Exemplo: método genérico de igualdade de arrays
  
public static <E extends Comparable<E>> boolean equals(E[] v1, E[] v2) {
    if (v1.length != v2.length) {
        return false;
    }

    for (int i = 0; i < v1.length; i++) {
        if (v1[i].compareTo(v2[i]) != 0) {
            return false;
        }
    }

    return true;
}



















