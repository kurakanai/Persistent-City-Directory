/**
 * City Database Class
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 1.0
 *
 */

package cityDataBase;

import java.io.*;
import dataStructures.*;
import cityDataBase.exceptions.*;

public class CityDBClass implements CityDB{

    /**
     * Hardcoded filename where the database should be.
     *
     */
    private final static String FILE_NAME = "cities.dat";
    /**
     * SortedList containing all stored cities.
     *
     */
    public SortedList<City> citySortedList;

    public CityDBClass(){
        citySortedList = new SortedLinkedList<>(new CityComparatorClass());
    }

    @Override
    public Iterator<City> cityIterator() throws NoSavedCitiesException{
        if(citySortedList.isEmpty()){
            throw new NoSavedCitiesException();
        }
        return citySortedList.iterator();
    }

    @Override
    public int getCityPopulation(String cityName, String countryName)
            throws CityNotFoundException{
        City city = getCity(cityName, countryName);
        if(city == null){
            throw new CityNotFoundException();
        }
        return city.getPopulation();
    }

    @Override
    public void removeCity(String cityName, String countryName) throws CityNotFoundException{
        City removedCity = getCity(cityName, countryName);
        if(removedCity == null)
            throw new CityNotFoundException();
        citySortedList.remove(removedCity);
    }

    @Override
    public void addCity(String cityName, String countryName, int population)
            throws CityAlreadyExistsException{
        if(getCity(cityName, countryName) != null)
            throw new CityAlreadyExistsException();
        City newCity = new CityRecord(cityName, countryName, population);
        citySortedList.add(newCity);
    }

    /**
     * Method for getting a city object from its name and country name strings.
     * @param cityName Name of the city.
     * @param countryName Name of the country where the city is located.
     * @return Target city as an object.
     *
     */
    private City getCity(String cityName, String countryName){
        Iterator<City> iterator = citySortedList.iterator();
        City found = null;
        while(iterator.hasNext() && found == null){
            City city = iterator.next();
            if(city.getName().equalsIgnoreCase(cityName) &&
                    city.getCountry().equalsIgnoreCase(countryName)){
                found = city;
            }
        }
        return found;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void load() throws NoSavedCitiesException{
        File file = new File(FILE_NAME);
        if (!file.exists())
            throw new NoSavedCitiesException();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            citySortedList = (SortedList<City>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            citySortedList = new SortedLinkedList<>(new CityComparatorClass());
            throw new NoSavedCitiesException();
        }
    }

    @Override
    public void save(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(citySortedList);
            out.flush();
            out.close();
        } catch (IOException _) {
        }
    }
}
