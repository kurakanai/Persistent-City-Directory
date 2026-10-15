package dataStructures;

import java.io.Serializable;

/**
 * Node Interface
 * @author AED  Team
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 2.0
 * @param <E> Generic Element
 *
 */
public interface Node<E> extends Serializable {
    /**
     * Method to get the element stored on this node.
     * @return the element
     *
     */
    E getElement();
}
