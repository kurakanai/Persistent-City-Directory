package cityDataBase;

import dataStructures.*;

public class CityComparatorClass implements Comparator<City> {
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