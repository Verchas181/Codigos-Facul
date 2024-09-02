/*
 _____    _              _                         _       ______          _                   ______ _____  _____ 
|  ___|  | |            | |                       | |      |  _  \        | |                  | ___ \  _  ||  _  |
| |__ ___| |_ _ __ _   _| |_ _   _ _ __ __ _    __| | ___  | | | |__ _  __| | ___  ___    ___  | |_/ / | | || | | |
|  __/ __| __| '__| | | | __| | | | '__/ _` |  / _` |/ _ \ | | | / _` |/ _` |/ _ \/ __|  / _ \ |  __/| | | || | | |
| |__\__ \ |_| |  | |_| | |_| |_| | | | (_| | | (_| |  __/ | |/ / (_| | (_| | (_) \__ \ |  __/ | |   \ \_/ /\ \_/ /
\____/___/\__|_|   \__,_|\__|\__,_|_|  \__,_|  \__,_|\___| |___/ \__,_|\__,_|\___/|___/  \___| \_|    \___/  \___/ 

*/

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  // TAD

  // É uma abstração em que os dados são encapsulados e não devem ser manipulados diretamente, apenas através de uma interface
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  // Pilha

  // LIFO (Last in first out)

  package stack;

  import exceptions.StructureEmptyException;
  import exceptions.StructureFullException;

  public interface Stack{
    void push(int element) throws StructureFullException;
    int pop() throws StructureEmptyException;
    int size();
    int top() throws StructureEmptyException;
    int capacity;
    boolean isEmpty();
    boolean isFull();

}

xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  public class StackEmptyException extends Exception{
    public StackEmptyException(int capacity, int size){
      super(String.format("Stack is empty: Capacity = %d Size = %d", capacity, size);
    }
  }

xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  public class StackFullException extends Exception{
    public StackFullException(int capacity, int size){
      super(String.format("Stack is full: Capacity = %d Size = %d", capacity, size);
    }
  }

xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  public class InvalidCapacityException extends Exception{
      @Override
      public InvalidCapacityException(int capacity){
          super(String.format("Invalid capacity: %d",capacity));
      }
  }
xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  public class ArrayStack implements Stack {
    
    private int[] elements;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) throws InvalidCapacityException{
          this.capacity = capacity;
          this.element = new int[capacity];
          this.top = 0;
          if(capacity < 0){
          throw new InvalidCapacityException(capacity);
          }
    }

    @Override 
    public int size(){
       return this.top; 
    }

    @Override
    public int capacity(){
      return this.capacity;
    }

    @Override
    public boolean isEmpty(){
      return this.top == 0;
    }

    @Override
    public boolean isFull(){
      return this.top == this.capacity;
  }
    
    @Override
    public boolean top() throws StackEmptyException{
      if(this.isEmpty()){
        throw new StackEmptyException(this.capacity, this.size())
      }
      return this.elements[top-1];
  }

    @Override
    public void push(int element) throws StackFullException{
       if(isFull()){
        throw new StackFullException(this.capacity, this.size())
      }
      this.elements[top++] = element;
      }

    @Override
    public int pop() throws StackEmptyException{
       if(this.isEmpty()){
        throw new StackEmptyException(this.capacity, this.size())
      }
        return this.elements[--top];
      }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack top - > [")
          for(int i = top - 1; i >= 0 ; i--){
          sb.append(this.elements[i]);
          if(i>0){
              sb.append(", ");
          }
        }
      sb.append("]")
      return sb.toString();
    }

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Pilha

  // FIFO (First in first out)


  package queue;

  public interface Queue{

    voi enqueue(int value);
    int dequeue();
    int front();
    int rear();
    int size();
    int capacity();
    boolean isEmpty();
    boolean isFull();
  }



  

  




  
  
