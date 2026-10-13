package dataStructures;

import java.io.*;

/**
 * Linked List
 * Includes description of general methods to be implemented by linked lists.
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
abstract class LinkedList<E> implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    /**
     *  Node at the head of the list.
     */
    transient LinkedNode<E> head;
    /**
     * Node at the tail of the list.
     */
    transient LinkedNode<E> tail;
    /**
     * Number of elements in the list.
     */
    transient int currentSize;
    /**
     * Constructor of an empty singly linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public LinkedList(){
        head=null;
        tail=null;
        currentSize=0;
    }
    /**
     * Returns true iff the list contains no elements.
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }
    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    public int size() {
        return currentSize;
    }

    /**
     * Returns an iterator of the elements in the list (in a proper sequence).
     * @return Iterator of the elements in the list
     */
    public Iterator<E> iterator() {
        return new LinkedIterator<>(head);
    }

    /**
     * Insert a node on the head of list
     * @param newNode
     */
    void addFirstNode(LinkedNode<E> newNode){
        newNode.setNext(head);
        this.head = newNode;
        if(isEmpty())
            this.tail = newNode;
        currentSize++;
    }
    /**
     * Insert a node on the tail of list
     * @param newNode
     */
    void addLastNode(LinkedNode<E> newNode){
        if(isEmpty())
            this.head = newNode;
        else
            tail.setNext(newNode);
        this.tail=newNode;
        currentSize++;
    }
    /**
     * Record with two nodes (prev, node)
     * @param prev
     * @param node
     */
    record pairNode<E>(LinkedNode<E> prev, LinkedNode<E> node){}

    /**
     * Insert node (newNode) between pair.previous() and pair.node()
     * @pre: pair.previous()!=null && pair.node()!=null
     * @param newNode
     */
    void addMiddleNode(pairNode<E> pair,LinkedNode<E> newNode){
        newNode.setNext(pair.node());
        pair.prev().setNext(newNode);
        currentSize++;
    }
    /**
     * Removes the first node in the list.
     * @pre: !isEmpty()
     * @return
     */
    E removeFirstNode(){
        E firstElem = head.getElement();
        head = head.getNext();
        if(head == null)
            tail = null;
        currentSize--;
        return firstElem;
    }

    /**
     * remove the last node (pair.node()) of the list
     * @return
     */
    E removeLastNode(pairNode<E> pair){
        E lastElem = pair.node().getElement();
        pair.prev().setNext(null);
        tail = pair.prev();
        currentSize--;
        return lastElem;
    }
    /**
     * remove the node pair.node()
     @pre: pair.previous()!=null && pair.node()!=null
     * @param pair
     */
    void removeMiddleNode(pairNode<E> pair) {
        pair.prev().setNext(pair.node().getNext());
        currentSize--;
    }

    /**
     *
     * @param element
     * @return pair with the previous node and the element node, Or null if no element
     */
    pairNode<E>  nodeOf(E element){
        LinkedNode<E> prev = null;
        LinkedNode<E> node = head;
        while (node != null) {
            if (node.getElement().equals(element))
                return new pairNode<>(prev, node);
            prev = node;
            node = node.getNext();
        }
        return null;
    }

    LinkedNode<E> getFirstNode(){
        return head;
    }

    LinkedNode<E> getLastNode(){
        return tail;
    }
     // MANUAL SERIALIZATION
    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        writeData(oos);
        oos.writeInt(currentSize);
        LinkedNode<E> node = head;
        while (node != null) {
            oos.writeObject(node.getElement());
            node = node.getNext();
        }
    }

    // MANUAL DESERIALIZATION
    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        int iSize = ois.readInt(); // read the size
        for (int i = 0; i < iSize; i++) { // add each element on the list
            @SuppressWarnings("unchecked")
            E element = (E) ois.readObject();
            addElem(element);
        }
    }

    void writeData(ObjectOutputStream out) throws IOException{
    }

    void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
    }

    abstract void addElem(E element);
}
