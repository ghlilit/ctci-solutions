class MyQueue{
    // 3.3: Implement a MyQueue class which implements
    //  a queue using two stacks
    Stack first = new Stack();
    Stack second = new Stack();
  
    public int size(){
      return first.size() + second.size();
    }
  
    public boolean isEmpty(){
      return size() == 0;
    }
  
    public void enqueue(int element){
      second.push(element);
    }
  
    public int dequeue(){
      if(this.isEmpty()) { return -1;}
      if(first.isEmpty()){
        while(!second.isEmpty()){
          first.push(second.pop());
        }
      }
        return first.pop();
    }
  }