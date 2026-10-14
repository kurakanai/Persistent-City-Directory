package cityDataBase;

import cityDataBase.exceptions.CityAlreadyExistsException;
import cityDataBase.exceptions.CityNotFoundException;
import cityDataBase.exceptions.NoSavedCitiesException;
import dataStructures.Iterator;

import java.io.Serializable;

public interface CityDB extends Serializable {
    /// Method for saving the entire database.
    void save();
    /// Method for loading the database from disk.
    ///
    /// @throws NoSavedCitiesException if the file doesn't contain any cities / is corrupted.
    void load() throws NoSavedCitiesException;

    /// Method for adding a city into the database.
    ///
    /// @param cityName The name of the city to add.
    /// @param countryName The name of the country where the city is located.
    /// @param population The city's population.
    /// @throws CityAlreadyExistsException if a duplicate is detected (case-insensitive).
    void addCity(String cityName, String countryName, int population) throws CityAlreadyExistsException;
    /// Method for getting a city object from its name and country name strings.
    ///
    /// @param cityName Name of the city.
    /// @param countryName Name of the country where the city is located.
    /// @return Target city as an object.
    City getCity(String cityName, String countryName);
    /// Method for removing a city from the database.
    ///
    /// @param cityName The name of the city to remove.
    /// @param countryName The name of the country where the city is located.
    /// @throws CityNotFoundException if the city is not found on the database.
    void removeCity(String cityName, String countryName) throws CityNotFoundException;
    /// Method for getting a city's population.
    ///
    /// @param cityName The city's name.
    /// @param countryName The name of the country where the city is located.
    /// @return City's population number.
    /// @throws CityNotFoundException if the city is not found on the database.
    int getCityPopulation(String cityName, String countryName)  throws CityNotFoundException;
    /// Method for getting the city database's iterator.
    ///
    /// @return The city database's iterator.
    /// @throws NoSavedCitiesException if the database is empty.
    Iterator<City> cityIterator() throws NoSavedCitiesException;
}
