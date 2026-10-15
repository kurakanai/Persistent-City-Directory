package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Sorted linked list Implementation
 * @author AED  Team
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 2.0
 * @param <E> Generic Element
 * 
 */
public class SortedLinkedList<E> extends LinkedList<E> implements SortedList<E> {
    /**
     * Comparator of elements.
     */
    private final Comparator<E> comparator;
    /**
     * Constructor of an empty sorted singly linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public SortedLinkedList(Comparator<E> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * Returns the first element of the list.
     * @return first element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMin( ) {
        if (isEmpty())
            throw new NoSuchElementException();
        return head.getElement();
    }

    /**
     * Returns the last element of the list.
     * @return last element in the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E getMax( ) {
        if (isEmpty())
            throw new NoSuchElementException();
        return tail.getElement();
    }
    /**
     * Returns the first occurrence of the element equals to the given element in the list.
     * @return element in the list or null
     */
    @Override
    public E get(E element) {
        LinkedNode<E> node = head;
        while (node != null) {
            int cmp = comparator.compare(node.getElement(), element);
            if (cmp == 0)
                return node.getElement();
            if (cmp > 0)
                return null;
            node = node.getNext();
        }
        return null;
    }
    /**
     * Returns true iff the element exists in the list.
     *
     * @param element to be found
     * @return true iff the element exists in the list.
     */
    public boolean contains(E element) {
        return get(element) != null;
    }

    /**
     * Inserts the specified element at the list, according to the comparator order.
     * If there is an equal element, the new element is inserted after it.
     * @param element to be inserted
     */
    public void add(E element) {
        if (isEmpty() || comparator.compare(element, head.getElement()) < 0)
            addFirst(element);
        else {
            LinkedNode<E> prev = head;
            LinkedNode<E> node = head.getNext();
            while (node != null && comparator.compare(element, node.getElement()) >= 0) {
                prev = node;
                node = node.getNext();
            }
            if (node == null)
                addLast(element);
            else
                addBeforeNode(element, prev);
        }
    }
    /**
     * Inserts the element before node after.
     * Precondition: after is not the head of the list.
     * @param element - Element to be inserted
     * @param before - Node to be previous to the new node
     */
    void addBeforeNode(E element, LinkedNode<E> before){
        addMiddleNode(new pairNode<>(before, before.getNext()), new SinglyListNode<>(element));
    }
    /**
     * Inserts the element at the first position in the list.
     * @param element - Element to be inserted
     */
    void addFirst( E element ) {
        addFirstNode(new SinglyListNode<>(element));
    }

    /**
     * Inserts the element at the last position in the list.
     * @param element - Element to be inserted
     *
     */
    void addLast( E element ) {
        addLastNode(new SinglyListNode<>(element));
    }

    /**
     * Removes and returns the first occurrence of the element equals to the given element in the list.
     *
     */
    public void remove(E element) {
        LinkedNode<E> prev = null;
        LinkedNode<E> node = head;
        while (node != null && comparator.compare(node.getElement(), element) < 0) {
            prev = node;
            node = node.getNext();
        }
        E removed = null;
        if (node != null && comparator.compare(node.getElement(), element) == 0) {
            removed = node.getElement();
            if (node == head)
                removeFirstNode();
            else if (node == tail)
                removeLastNode(new pairNode<>(prev, node));
            else
                removeMiddleNode(new pairNode<>(prev, node));
        }
    }

    /**
     * Method to add an element to the list
     * @param element - Element to add to the list.
     *
     */
    void addElem(E element){
        addLast(element);
    }

    /**
     * This method checks if the sorting was done properly. Think of it as a sanity checker.
     * @return whether the sorting is done correctly.
     *
     */
    private boolean invariant() {
        if (isEmpty())
            return true;
        Iterator<E> it = this.iterator();
        boolean ok = true;
        E elemP = it.next();
        while (ok && it.hasNext()) {
            E elemN= it.next();
            ok = comparator.compare(elemP, elemN) <= 0;
            elemP=elemN;
        }
        return ok;
    }

    /**
     * Serializes this object onto an ObjectOutputStream.
     * @param oos ObjectOutputStream to write the object on.
     * @throws IOException if the operation fails (IO failure).
     *
     */
    void writeData(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // write the normal attributes
    }

    /**
     * Deserializes the list and loads it onto memory, replacing this object with the loaded one.
     * @param ois ObjectInputStream to read from.
     * @throws IOException If an I/O operation fails.
     * @throws ClassNotFoundException If the object could not be found in the input stream.
     *
     */
    void readData(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // read the normal attributes
    }
}
