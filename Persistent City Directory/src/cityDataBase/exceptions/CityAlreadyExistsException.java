/**
 * Exception for a scenario where a city already exists when it can't.
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 1.0
 *
 */
package cityDataBase.exceptions;

public class CityAlreadyExistsException extends Exception {
    public CityAlreadyExistsException() {
        super();
    }
}
