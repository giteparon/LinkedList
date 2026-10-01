

/*
Problem:  Write a program that keeps and manipulates a linked list of
        String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
    Input:  commands listed above
    Output:  the results to the screen of each menu
        choice, and error messages where appropriate.
*/
//name: amir header:this is a linked list class, which can add an element, remove an element, show all elements, clear all and more
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
  ListNode front = null;
  ListNode first = null;
  //a(front) -> b -> c(first), front is latest added first is first element in list with NO parent
  //constructors go here
  public LinkedList(){

  }
  public int length(){
    ListNode _n = front;
    int counter = 0;
    while(_n != null){
      _n = _n.getParent();
      counter++;
    }
    return counter;
  }
  public ListNode get(int i){
    ListNode _n = front;
    if(i > this.length()){
      throw new IndexOutOfBoundsException();
    }
    else if (i == 0){
      return _n;
    }
    for(int j = 0; j < i; j++){
      _n = _n.getParent();
    }
    return _n; // as for loop ends one before
  }
  public void set(ListNode newNode, int i){
    if(i == this.length() -1 ){
      newNode.setParent(first);
      first = newNode;
      return;
    }
    else if(i == 0){
      newNode.setParent(front);
      front = newNode;
      return;
    }
    else if(i >= this.length()){
      throw new IndexOutOfBoundsException();
    }
    else{
      ListNode _p = this.get(i - 1).getParent();
      this.get(i - 1).setParent(newNode);
      newNode.setParent(_p);

    }


  }

  public int find(ListNode node){

    for(int j = 0; j < this.length(); j++){
      if(get(j) == node){
        return j;
      }
    }
    return -1;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    if(first == null) {
      first = new ListNode(line, null);
      front = first;
      return front;
    }
    else{
      // new ListNode(line, );
      ListNode _n = front;
      ListNode _prev = null;
      while(line.compareTo(_n.getValue()) >= 0){
        _prev = _n;
        _n = _n.getParent();

        if(_n == null){
          System.out.println(line);
          first.setParent(new ListNode(line, null));
          first = first.getParent();
          return first;
        }
      }
      _prev.setParent(new ListNode(line, _n));
      return _prev.getParent();

    }



  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    ListNode _n = front;
    ListNode _prev = null;
    while(!_n.getValue().equals(line)) {
      _prev = _n;
      _n = _n.getParent();
    }
    if(_prev == null) {
      front = _n.getParent();
    }
    else if(_n.getParent() == null) {
      first = _prev;
      first.setParent(null);
    }
    else{
      _prev.setParent(_n.getParent());

    }
    return _n;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    if(this.front == null || this.first == null) {
      return "";
    }
    String _s = "List Values: ";
    ListNode _n = front;
    while (_n != first){
      _s = _s + _n.getValue() + " ";
      _n = _n.getParent();
    }
    _s += first.getValue() + " ";
    return _s;
  }
  //pre and post
  public void reverse(){
    System.out.println("reversing in method");
    if(this.length() == 0 || this.length() == 1){
      return;
    }
    ListNode _nprev = null;
    ListNode _n = front;
    ListNode _first = _n;
    ListNode _n1 = _n.getParent();
    System.out.println("" + _n.getValue() + " " + _nprev+ " " + _n1.getValue() + " " + first.getValue());
    while(_n1 != first){
      System.out.println("" + _n.getValue() + " " + _nprev + " " + _n1.getValue() + " " + first.getValue());
      _n.setParent(_nprev);
      _nprev = _n;
      _n = _n1;
      _n1 = _n.getParent();

    }
    System.out.println("" + _n.getValue() + " " + _nprev + " " + _n1.getValue() + " " + first.getValue());
    _n1.setParent(_n);
    front = _n1;
    first = _first;
    

    
    return;

  }
  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    first = null;
    front = null;
  }
}