package cityDataBase;

import dataStructures.*;

public class CityComparatorClass implements Comparator<City> {
    /// Comparator that compares by country name, population and then city name (in that order).
    ///
    /// @param x City to compare from.
    /// @param y City to compare against.
    /// @return int representing the comparison (negative for inferior, positive for greater and 0 for equal).
    @Override
    public int compare(City x, City y){
        if(x.getCountry().compareToIgnoreCase(y.getCountry()) != 0){
            return x.getCountry().compareToIgnoreCase(y.getCountry());
        }
        if(x.getPopulation() != y.getPopulation()){
            return y.getPopulation() - x.getPopulation();
        }
        if(x.getName().compareTo(y.getName()) != 0){
            return x.getName().compareToIgnoreCase(y.getName());
        }
        return 0;
    }
}