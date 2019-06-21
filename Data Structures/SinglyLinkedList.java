import java.util.*;

public class SinglyLinkedList <E> {
  private static class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E element, Node<E> next) {
      this.element = element;
      this.next = next;
    }

    public E getElement() { return element; }
    public Node<E> getNext() {return next; }
    public void setNext(Node<E> next) { this.next = next; }

  }

  private int size = 0; 
  Node<E> head = null;
  Node<E> tail = null;
  
  public int size() { return size; }
  public boolean isEmpty() { return size == 0; }

  public E first() {
    if(!isEmpty()){
      return head.getElement();
    }
    return null;
  }

   public E last() {
    if(!isEmpty()){
      return tail.getElement();
    }
    return null;
  }

  public void addFirst(E element){
    head = new Node(element, head);
    if (size == 0){
      tail = head;
    }
    size++;
  }

  public void addLast(E element) {
    Node <E> newest = new Node(element, null);
    if (isEmpty()) {
      head = newest;
    }
    else {
      tail.setNext(newest);
    }
    tail = newest; 
    size++;
  }

  public E removeFirst(){
    if (isEmpty()) { return null; }
    E answer = head.getElement();
    head = head.getNext();
    size--;
    if (size == 0) {
      tail = null;
    }
    return answer;
  }
}