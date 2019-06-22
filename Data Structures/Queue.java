public class Queue<E> {
    private SinglyLinkedList<E> data = new SinglyLinkedList();
  
    public int size(){
      return data.size();
    }
  
    public boolean isEmpty(){
      return data.isEmpty();
    }
  
    public void enqueue(E element){
      data.addLast(element);
    }
  
    public E dequeue(){
      return data.removeFirst();
    }
  
    public E first(){
      return data.first();
    }
}