/**
 * City Interface
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 1.0
 *
 */

package cityDataBase;

import java.io.Serializable;

public interface City extends Serializable {
    /**
     * Method for getting a city's name.
     * @return City's name
     *
     */
    String getName();
    /** Method for getting a city's country's name.
     * @return Country's name
     *
     */
    String getCountry();

    /** Method for getting a city's population.
     * @return City's population
     *
     */
    int getPopulation();
}
