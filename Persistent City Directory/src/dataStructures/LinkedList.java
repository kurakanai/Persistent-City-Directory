package dataStructures;

import java.io.*;

/**
 * Linked List
 * Includes description of general methods to be implemented by linked lists.
 * @author AED  Team
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 2.0
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
     * Removes the first node in the list and returns it.
     * @pre: !isEmpty()
     * @return The removed first node.
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
     * Removes the last node (pair.node()) of the list and returns it.
     * @return The removed last node.
     */
    E removeLastNode(pairNode<E> pair){
        E lastElem = pair.node().getElement();
        pair.prev().setNext(null);
        tail = pair.prev();
        currentSize--;
        return lastElem;
    }
    /**
     * Removes a node that's not on the start or end of the list.
     * @pre: pair.previous()!=null && pair.node()!=null
     * @param pair pairNode to remove.
     */
    void removeMiddleNode(pairNode<E> pair) {
        pair.prev().setNext(pair.node().getNext());
        currentSize--;
    }

    /**
     * Method to get the pairNode of the previous and current node from an element.
     * @param element - Element from which you want to get the pairNode.
     * @return pair with the previous node and the element node, Or null if no element
     *
     */
    pairNode<E> nodeOf(E element){
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

    /**
     * Method to get the first node (head) from this list.
     * @return First node from list.
     *
     */
    LinkedNode<E> getFirstNode(){
        return head;
    }

    /**
     * Method to get the last node (tail) from this list.
     * @return Last node from list.
     *
     */
    LinkedNode<E> getLastNode(){
        return tail;
    }

    /**
     * Method to manually serialize this list.
     * @param oos - Object output stream to write to.
     *
     */
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

    /**
     * Method to manually deserialize this list.
     * @param ois - Object input stream to read from.
     *
     */
    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        int iSize = ois.readInt(); // read the size
        for (int i = 0; i < iSize; i++) { // add each element on the list
            @SuppressWarnings("unchecked")
            E element = (E) ois.readObject();
            addElem(element);
        }
    }

    /**
     * Method to manually serialize a specific object.
     * @param out - Object output stream to write to.
     *
     */
    abstract void writeData(ObjectOutputStream out) throws IOException;

    /**
     * Method to add an element to the list.
     * @param element - Element to add to the list.
     *
     */
    abstract void addElem(E element);
}
