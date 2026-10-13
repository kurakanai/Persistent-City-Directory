package dataStructures;
import dataStructures.exceptions.NoSuchElementException;


/**
 *  Doubly Linked List
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class DoublyLinkedList<E> extends SequenceLinkedList<E> implements TwoWayList<E> {

    /**
     * Constructor of an empty double linked list.
     * head and tail are initialized as null.
     * currentSize is initialized as 0.
     */
    public DoublyLinkedList( ) {
        super();
    }


    /**
     * Returns a two-way iterator of the elements in the list.
     *
     * @return Two-Way Iterator of the elements in the list
     */
    public TwoWayIterator<E> twoWayiterator() {
        return new TwoWayLinkedIterator<>(head, tail);
    }
    /**
     * Inserts the element at the first position in the list.
     * @param element - Element to be inserted
     */
    public void addFirst( E element ) {
        DoublyListNode<E> newNode = new DoublyListNode<>(element);
        if(!isEmpty())
            ((DoublyListNode<E>)head).setPrevious(newNode);
        addFirstNode(newNode);
    }
    /**
     * Inserts the element at the last position in the list.
     * @param element - Element to be inserted
     */
    public void addLast( E element ) {
        DoublyListNode<E> newNode = new DoublyListNode<>(element, (DoublyListNode<E>) tail, null);
        addLastNode(newNode);
    }
    /**
     * Inserts the specified element at the specified position in the list.
     * Pre-condition: position ranges from 1 to currentSize-1.
     * @param position - middle position for insertion of element
     * @param element - element to be inserted at middle position
     */
    void addMiddle( int position, E element ) {
        pairNode<E> pair = getNodes(position);
        DoublyListNode<E> prev = (DoublyListNode<E>) pair.prev();
        DoublyListNode<E> node = (DoublyListNode<E>) pair.node();
        DoublyListNode<E> newNode = new DoublyListNode<>(element, prev, node);
        addMiddleNode(pair, newNode);
        node.setPrevious(newNode);
    }
    /**
     * Removes and returns the element at the first position in the list.
     * @return element removed from the first position of the list
     * @throws NoSuchElementException - if size() == 0
     */
    public E removeFirst( ) {
        if (isEmpty())
            throw new NoSuchElementException();
        E elem = removeFirstNode();
        if (head != null)
            ((DoublyListNode<E>) head).setPrevious(null);
        return elem;
    }

    /**
     * Removes the node from the specified position of the list.
     * Pre-condition: the position is neither 0 nor the currentSize of the list.
     * @param position - position of node to be removed
     * @return element removed from the first position of the list
     */
    E removeMiddle( int position ) {
        if (isEmpty())
            throw new NoSuchElementException();
        pairNode<E> pair = removeMiddleNode(position);
        DoublyListNode<E> node = (DoublyListNode<E>) pair.node().getNext();
        node.setPrevious(pair.prev());
        return pair.node().getElement();
    }

    pairNode<E> getNodes(int position){
        LinkedNode<E> node;
        //if the position is on the first half it starts searching from the beginning
        if (position < currentSize / 2)
            node = getNode(position);
        //if the position is on the second half it starts searching from the end
        else {
            node = tail;
            for (int i = currentSize - 1; i > position; i--)
                node = ((DoublyListNode<E>) node).getPrevious();
        }
        return new pairNode<>(((DoublyListNode<E>) node).getPrevious(), node);
    }
}
