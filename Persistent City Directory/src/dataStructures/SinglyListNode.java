package dataStructures;

/**
 * Singly List Node Implementation
 * @author AED  Team
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 2.0
 * @param <E> Generic Element
 *
 */
class SinglyListNode<E> implements LinkedNode<E> {

    /**
     * Element stored in the node.
     */
    private E element;

    /**
     * (Pointer to) the next node.
     */
    private LinkedNode<E> next;

    /**
     * @param theElement - The element to be contained in the node
     * @param theNext - the next node
     */
    public SinglyListNode( E theElement, SinglyListNode<E> theNext ) {
        element = theElement;
        next = theNext;
    }

    /**
     *
     * @param theElement to be contained in the node
     */
    public SinglyListNode( E theElement ) {
        this(theElement, null);
    }

    /**
     * Method to get the element stored on the node.
     * @return the element contained in the node
     *
     */
    public E getElement( ) {
        return element;
    }

    /**
     * Method to get the next node from a node.
     * @return the next node
     *
     */
    public LinkedNode<E> getNext( ) {
        return next;
    }

    /**
     * Method to set this node's element, replacing the current element.
     * @param newElement - New element to replace the current element
     *
     */
    public void setElement( E newElement ) {
        element = newElement;
    }

    /**
     * Method to set a new node as this node's next node.
     * @param newNext - node to replace the next node
     *
     */
    public void setNext( LinkedNode<E> newNext ) {
        next = newNext;
    }
}