package Classes;

import Interfaces.Objects.City;
import Records.CityRecord;
import dataStructures.Comparator;

public class CityComparatorClass implements Comparator<City> {
    @Override
    public int compare(City x, City y){
        if(x.getCountry().compareTo(y.getCountry()) != 0){
            return x.getCountry().compareTo(y.getCountry());
        }
        if(x.getPopulation() != y.getPopulation()){
            return x.getPopulation() - y.getPopulation();
        }
        if(x.getName().compareTo(y.getName()) != 0){
            return x.getName().compareTo(y.getName());
        }
        return 0;
    }
}
