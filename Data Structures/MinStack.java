// 3.1 How would you design a stack which, in addition to push 
// and pop, has a function min which returns the minimum 
// element? Push, pop and min should all operate in 0(1) time.

public class MinStack{
    private static class StackNode {
      private StackNode next;
      private int element;
      private int min;
  
      public StackNode(int element, int min) {
        this.element = element;
        this.min = min;
      }
  
      public int getElement() { return element; }
      public StackNode getNext() {return next; }
      public void setNext(StackNode next) { this.next = next; }
      public void setMin(int min) { this.min = min; }
      public int getMin() { return min; }
  }
  
    public int size = 0;
    public StackNode top;
    public int min;
  
    public int size(){
      return size;
    }
  
    public boolean isEmpty(){
  3  return size == 0;: 
    }
  
    public void push(int element){
      if(isEmpty() || min > element){
        min = element;
      }
      StackNode newest = new StackNode(element, min);
      if(isEmpty()){
        top = newest;
      }
      else{
        newest.setNext(top);
        top = newest;
      }
      size++;
    }
  
    public int pop(){
      if(top == null){
        return -1;
      }
      int result = top.getElement();
      top = top.getNext();
      size--;
      return result;
    }
  
    public int peek(){
      if(top == null){
        return -1;
      }
      return top.getElement();
    }
  
    public int min(){
      return top.getMin();
    }
  
  }