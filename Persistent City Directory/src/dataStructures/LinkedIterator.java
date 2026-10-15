package dataStructures;

import dataStructures.exceptions.NoSuchElementException;

/**
 * Implementation of an Iterator for Linked List
 * @author AED  Team
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 2.0
 * @param <E> Generic Element
 *
 */

class LinkedIterator<E>  implements Iterator<E> {
    /**
     * First node of the list.
     */
    private final LinkedNode<E> first;
    /**
     * Node with the next element in the iteration.
     */
    LinkedNode<E> nextToReturn;

    /**
     * SinglyIterator constructor
     * @param first - Node with the first element of the iteration
     */
    public LinkedIterator(LinkedNode<E> first) {
        this.first=first;
        nextToReturn=first;
    }

    /**
     * Returns true iff the iteration has more elements
     */
    public boolean hasNext() {
        return nextToReturn != null;
    }

    /**
     * Returns the next element in the iteration.
     * @throws NoSuchElementException - if !hasNext()
     */
    public E next( ){
        if ( !this.hasNext() )
            throw new NoSuchElementException();
        E elem = nextToReturn.getElement();
        nextToReturn = nextToReturn.getNext();
        return elem;
    }

    /**
     * Restart the iterator
     */
    @Override
    public void rewind(){
        nextToReturn = first;
    }
}
