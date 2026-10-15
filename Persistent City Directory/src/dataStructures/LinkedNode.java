package dataStructures;
/**
 * Linked Node (with next)
 *
 * @author AED team
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 2.0
 *
 * @param <E> Generic Element
 */
interface LinkedNode<E> extends InfoNode<E> {
    /**
     * Method for getting the next node.
     * @return The next node
     *
     */
    LinkedNode<E> getNext( );

    /**
     * This method sets what node is this node's next node.
     * @param newNext New next node.
     *
     */
    void setNext(LinkedNode<E> newNext);
}
