import java.util.*;
// 3.2: SetO-fStacks should be composed of several stacks and
//  should create a new stack once the previous one exceeds 
//  capacity.
public class SetOfStacks{
  
  private ArrayList<Stack> stackSet = new ArrayList();
  int currentStack = 0;
  int threshold;

  public SetOfStacks(int threshold){
    this.threshold = threshold;
  }

  public void push(int element){
    if(stackSet.size() == 0){
      Stack newest = new Stack(threshold);
      stackSet.add(newest);
      newest.push(element);
      return;
    }

    if(!stackSet.get(currentStack).push(element)){
      Stack newest = new Stack(threshold);
      stackSet.add(newest);
      newest.push(element);
      currentStack++;
      return;
    }
  }

  public int pop(){
    int result = stackSet.get(currentStack).pop();
    if(stackSet.get(currentStack).size() == 0){
        stackSet.remove(currentStack);
      if(currentStack != 0){
        currentStack --;
      }
    }
    return result;
  }

}