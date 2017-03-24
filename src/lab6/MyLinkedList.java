/*
 * 
 * Practice Program with Linked Lists
 * 
 */
package lab6;

/**
 *
 * @author Hannah Bloyd
 * @param <E>
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;

    /** Create a default list */
    public MyLinkedList() {
    }//default constructor

    /** Create a list from an array of objects
     * @param objects */
    public MyLinkedList(E[] objects) {
        super(objects);
    }//constructor

    /** Return the head element in the list
     * @return  E the first element*/
    public E getFirst() {
       if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }//get first

    /** Return the last element in the list
     * @return  E the last element*/
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }//get last

    /** Add an element to the beginning of the list
     * @param e element to be added at beginning*/
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
        {
            tail = head;
        }

    }//add first

    /** Add an element to the end of the list
     * @param e element to be added at end*/
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }
        size++; // Increase size
    }//addLast

    /** Add a new element at the specified index in this list
     * The index of the head element is 0
     * @param index where the element should be added
     * @param e the element to be added*/
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }

    }//add

    /** Remove the head node and
     *  return the object that is contained in the removed node.
     * @return  E removed element from list*/
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }//else
    }//removeFirst

    /** Remove the last node and
     * return the object that is contained in the removed node.
     * @return  E element removed from list*/
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }//else
    }//removeLast

    /** Remove the element at the specified position in this list.
     *  Return the element that was removed from the list.
     * @param index which element should be removed
     * @return  E element removed from list*/
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }//Remove

    /** Override toString() to return elements in the list
     * @return  String */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }//else
        }//for
        return result.toString();
    }//toString

    /** Clear the list */
    public void clear() {
        head = tail = null;
    }//clear
    
    /**
     methods for lab 8 should be implemented here
     * @param e Element being checked for in the list
     * @return boolean if element is in list
     */
    public boolean contains(E e){
        
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if(temp.element.equals(e))
                return true;
            
            temp=temp.next;
            
        }//for
        
        return false;
    }//contains
    
    public E get(int index){
      
        if (index < 0 || index >= size)
            return null;
        Node<E> temp=head;
        for (int i = 0; i < index; i++) 
                temp=temp.next;
        
        return temp.element;
    }//get
    
    public int indexOf(E e){

            Node<E> temp = head;
            for (int i = 0; i < size; i++) {
                if(temp.element.equals(e))
                    return i;
                temp=temp.next;
            }
        return -1;
    }//indexOf
    
    public int lastIndexOf(E e){

        int temp=-1;
  
            Node<E> test = head;
            for (int i = 0; i < size; i++) {
                if(test.element.equals(e))
                    temp=i;
                test=test.next;
                
            }//for
            

        return temp;
    }//lastIndexOf
    
    public E set(int index, E e){

        if(index < 0 || index >= size)
            return null;
        
        Node<E> temp = head;
        for (int i = 0; i < index; i++)
            temp=temp.next;
        E n = temp.element;
        temp.element=e;
        
            
        
        return n;
        
            
    }//set
    
    public boolean contains (E e, int[] count){
        
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if(e.equals(temp.element)){
                count[0]=(i+1);
                return true;
                
            }
            temp=temp.next;
            
        }//for
        count[0]=size;
        return false;
        
        
    }//contains

    
    
    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }//constructor
    }//Node class
}//myLinkedList class
    
    
