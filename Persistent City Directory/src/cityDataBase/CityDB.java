package cityDataBase;

import cityDataBase.exceptions.CityAlreadyExistsException;
import cityDataBase.exceptions.CityDontExistException;
import cityDataBase.exceptions.NoSavedCitiesException;
import dataStructures.Iterator;

import java.io.Serializable;

public interface CityDB extends Serializable {
    void save();
    void load() throws NoSavedCitiesException;
    void addCity(String cityName, String countryName, int population) throws CityAlreadyExistsException;
    void removeCity(String cityName, String countryName) throws CityDontExistException;
    int getCityPopulation(String cityName, String countryName)  throws CityDontExistException;
    Iterator<City> cityIterator() throws NoSavedCitiesException;
}
