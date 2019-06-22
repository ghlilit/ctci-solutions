public class Stack {
    private SinglyLinkedList data = new SinglyLinkedList();
    private int threshold = Integer.MAX_VALUE;
  
    public Stack(int threshold){
      this.threshold = threshold;
    }
  
    public Stack(){ }
  
    public int size(){
      return data.size();
    }
  
    public boolean isEmpty(){
      return data.isEmpty();
    }
  
    public boolean push(int element){
      if(size() >= threshold){
        System.out.println("Threshold reached");
        return false;
      }
      data.addFirst(element);
      return true;
    }
  
    public int pop(){
      return data.removeFirst();
    }
  
    public int peek(){
      return data.first();
    }
  
  // 3.5: : Write a program to sort a stack such that the
  //  smallest items are on the top. You can use 
  //  an additional temporary stack.
    public Stack sort(){
      Stack tempStack = new Stack();
  
      while(!this.isEmpty()){
        int tmp = this.pop();   
        while(!tempStack.isEmpty() & tempStack.peek() < tmp){
          this.push(tempStack.pop());
        }
        tempStack.push(tmp);
      }
      return tempStack;
    }
  
  }