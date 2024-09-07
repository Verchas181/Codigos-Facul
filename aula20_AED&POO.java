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

  // Fila

  // FIFO (First in first out)


  package queue;

import exceptions.StructureEmptyException;
import exceptions.StructureFullException;

public interface Queue {
    void enqueue(int value) throws StructureFullException;
    int dequeue() throws StructureEmptyException;
    int front() throws StructureEmptyException;
    int rear() throws StructureEmptyException;
    int size();
    int capacity();
    boolean isEmpty();
    boolean isFull();
}

xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

  // Fila Circular

  public class CircularQueue {
    private int size;
    private int[] elements;
    private int front;
    private int back;

    public CircularQueue(int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException(capacity);
        }
        this.size = 0;
        this.elements = new int[capacity];
        this.front = 0;
        this.back = 0;
    }

     public int size() {
     return size;
 }
 
 public boolean isEmpty() {
     return size == 0;
 }
 
 public boolean isFull() {
     return size == capacity();
 }
 
 public int capacity() {
     return elements.length;
 }
 
 public int front() throws StructureEmptyException {
     if (isEmpty()) {
         throw new StructureEmptyException(capacity(), size());
     }
     return elements[front];
 }
 
 public int rear() throws StructureEmptyException {
     if (isEmpty()) {
         throw new StructureEmptyException(capacity(), size);
     }
     return elements[(back - 1 + capacity()) % capacity()];
 }

  public void enqueue(int element) throws StructureFullException {
    if (isFull()) {
        throw new StructureFullException(capacity(), size);
    }
    elements[back] = element;
    back = (back + 1) % capacity();
    size++;
}

public int dequeue() throws StructureEmptyException {
    if (isEmpty()) {
        throw new StructureEmptyException(capacity(), size);
    }
    int element = elements[front];
    front = (front + 1) % capacity();
    size--;
    return element;
}

public void clear() {
    front = 0;
    back = 0;
    size = 0;
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 // Array Dinâmico

 public class DynamicArray {
    private int[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray() {
        elements = new int[DEFAULT_CAPACITY];
    }

    public DynamicArray(int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException(capacity);
        }
        elements = new int[capacity];
    }
}

 public int size() { 
    return size; 
}

public boolean isEmpty() { 
    return size == 0; 
}

public int capacity() {
    return elements.length;
}

 private void validateIndex(int index) throws InvalidIndexException {
    if (index < 0 || index >= size) {
        throw new InvalidIndexException(index, size);
    }
}

public int get(int index) throws InvalidIndexException {
    validateIndex(index);
    return elements[index];
}

public void set(int index, int element) throws InvalidIndexException {
    validateIndex(index);
    elements[index] = element;
}

private void resize() {
    int[] newElements = new int[elements.length * 2];
    for (int i = 0; i < size; i++) {
        newElements[i] = elements[i];
    }
    elements = newElements;
}

private void shiftRight(int index) {
    for (int i = size; i > index; i--) {
        elements[i] = elements[i - 1];
    }
}

public void insert(int index, int element) throws InvalidIndexException {
    validateIndex(index);
    if (size == elements.length) {
        resize();
    }
    shiftRight(index);
    elements[index] = element;
    size++;
}

private void shiftLeft(int index) {
    for (int i = index; i < size - 1; i++) {
        elements[i] = elements[i + 1];
    }
}

public int remove(int index) throws InvalidIndexException {
    validateIndex(index);
    int element = elements[index];
    shiftLeft(index);
    size--;
    return element;
}

public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DynamicArray: [");
    if (!isEmpty()) {
        sb.append(elements[0]);
        for (int i = 1; i < size; i++) {
            sb.append(", ");
            sb.append(elements[i]);
        }
    }
    sb.append("]");
    return sb.toString();
}


  

  




  
  
