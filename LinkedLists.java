class LinkedLists{

  // 2.1: Write code to remove duplicates from an unsorted linked list. 
  public void removeDups() {
    Hashtable dups = new Hashtable();

    Node<E> pointer = head;
    Node<E> lastNonDup = head;

    while( pointer != null ){
    E value = pointer.getElement();

    if (dups.containsKey(value)){
        size--;
    }
    else {
        if (lastNonDup != pointer) {
            lastNonDup.setNext(pointer);
            lastNonDup = pointer;
        }
        dups.put(value, 1);
    }

    pointer = pointer.getNext();
    }
  }

  // 2.2: Implement an algorithm to find the kth to last element of a singly linked list. 
  public E kthLast(int k) {

    if (size < k) { return null; }

    Node<E> firstPointer = head;
    Node<E> kThPointer = head;
    
    for (int i = 0; i < k; i++) {
      kThPointer = kThPointer.getNext();
    }

    while (kThPointer.getNext() != null){
      kThPointer = kThPointer.getNext();
      firstPointer = firstPointer.getNext();
    }

    return firstPointer.getElement();
  }

  // 2.4: Write code to partition a linked list around a value x, such that all nodes
  //  less than x come before all nodes greater than or equal to x. 
  public void partition(int pivot) {

    Node  smallHead = null;
    Node  smallPntr = null;
    Node  bigHead = null;
    Node  bigPntr = null;
    Node  mainPntr = head;

    while (mainPntr!=null) {
      if (mainPntr.getElement() < pivot) {
        if (smallHead == null ) { 
          smallHead = mainPntr;
          smallPntr = mainPntr;
          }
        else { 
          smallPntr.setNext(mainPntr);
          smallPntr = smallPntr.getNext();
          }
      }
      else {
        if (bigHead == null ) { 
          bigHead = mainPntr;
          bigPntr = mainPntr;
        }
        else { 
          bigPntr.setNext(mainPntr);
          bigPntr = bigPntr.getNext();
          }
      }
        mainPntr = mainPntr.getNext();                  
    }

    smallPntr.setNext(bigHead);
  
  }

  // 2.5: Write a function that adds two numbers
  //  and returns the sum as a linked list. 
  public SinglyIntList sumLists(SinglyIntList list2) {
    Node pntr1 = head;
    Node pntr2 = list2.head;
    SinglyIntList sums = new SinglyIntList();

    int sum; 
    boolean overflow = false;
    while(pntr1 != null && pntr2 != null) {
      sum = pntr1.getElement() + pntr2.getElement();
      if (overflow){
        sum ++;
        overflow = false;
      }
      if (sum >= 10){
        overflow = true;
      }
      sums.addLast(sum % 10);

      pntr1 = pntr1.getNext();
      pntr2 = pntr2.getNext();
    }

    while(pntr1 != null){
      sum = pntr1.getElement();
      if (overflow){
        if (sum + 1 == 10){
          sums.addLast(0);
        }
        else{
          overflow = false;
          sums.addLast(sum + 1);
        }
      }
      else{
        sums.addLast(pntr1.getElement());
      }
      pntr1 = pntr1.getNext();
    }

    while(pntr2 != null){
      if (overflow){
        sums.addLast(pntr2.getElement() + 1);
        overflow = false;        
      }
      else{
        sums.addLast(pntr2.getElement());
      }
      pntr2 = pntr2.getNext();
    }

    if (overflow){
      sums.addLast(1);
    }

    return sums;
  }

  // 2.6: : Implement a function to check if a linked list is a palindrome. 
  public boolean isPalindrome() {
    SinglyLinkedList<E> half = new SinglyLinkedList();
    Node<E> pntr = head;
    boolean result = true;

    for(int i = 0; i < size/2; i++) {
      half.addFirst(pntr.getElement());
      pntr = pntr.getNext();
    }

    if (size % 2 == 1){
      pntr = pntr.getNext();
    }

    while(!half.isEmpty()) {
      if (half.removeFirst() != pntr.getElement()){
        result = false;
      }
      pntr = pntr.getNext();
    }

    return result;
}

  // 2.7: : Given two (singly) linked lists, determine if the two lists intersect.
  public void findIntersection(SinglyLinkedList<E> second) {
    Node<E> pntr1 = head;
    Node<E> pntr2 = second.head;
    if (tail != second.tail) {
      return; 
    }

    int diff = size - second.size();
    if (diff > 0){
      pntr1 = pntr1.getNext();
      diff--;
    }
    else if (diff < 0){
      pntr2 = pntr2.getNext();
      diff++;
    }

    System.out.println(pntr1.getElement() + ":" + pntr2.getElement());
    while(pntr1 != null) {
      if (pntr1 == pntr2){
        System.out.println(pntr1);
        return;
      }
      else{
        pntr1 = pntr1.getNext();
        pntr2 = pntr2.getNext();
      }
    }
  }

  // 2.8: : Given a circular linked list, implement an algorithm
  //  that returns the node at the beginning of the loop. 
  public boolean loopDetection(){
    Node<E> slow = head;
    Node<E> fast = head;
    int count;

    while(fast != null){
      slow = slow.getNext();
      fast = fast.getNext();
      count++;
      if (slow == fast){
        return true;
      }
    }
    return false;
  }

}