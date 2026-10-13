package dataStructures;

/**
 * Implementation of Singly Linked List
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 *
 */
public class SinglyLinkedList<E> extends SequenceLinkedList<E> {

    public SinglyLinkedList( ) {
        super();
    }

    /**
     * Inserts the specified element at the first position in the list.
     *
     * @param element to be inserted
     */
    @Override
    public void addFirst(E element) {
        addFirstNode(new SinglyListNode<>(element));
    }

    /**
     * Inserts the specified element at the last position in the list.
     *
     * @param element to be inserted
     */
    @Override
    public void addLast(E element) {
        addLastNode(new SinglyListNode<>(element));
    }

    void addMiddle(int position, E element) {
        addMiddleNode(getNodes(position), new SinglyListNode<>(element));
    }
}
