/**
 * City Record
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 1.0
 *
 */

package cityDataBase;

public record CityRecord(String name, String country, int population) implements City {

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getCountry(){
        return country;
    }

    @Override
    public int getPopulation(){
        return population;
    }
}
