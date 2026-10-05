package Classes.Objects;

import Interfaces.CityObject;
import Interfaces.CountryObject;

public class CityClass implements CityObject {
    private String name;
    private CountryObject country;
    private int population;
    public CityClass(String name, CountryObject country, int population){
        setName(name);
        setCountry(country);
        setPop(population);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public CountryObject getCountry() {
        return country;
    }

    @Override
    public void setCountry(CountryObject newCountry) {
        country = newCountry;
    }

    @Override
    public int getPop() {
        return population;
    }

    @Override
    public void setPop(int newPop) {
        population = newPop;
    }
}
