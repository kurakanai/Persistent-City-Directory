package Classes;

import Interfaces.CityDB;
import Interfaces.Objects.City;
import dataStructures.SortedLinkedList;
import dataStructures.SortedList;

///  THIS IS USING JAVA UTIL STRICTLY AS A PLACEHOLDER!
public class CityDBClass implements CityDB {
    public SortedList<City> citySortedList;
    public CityDBClass(){
        citySortedList = new SortedLinkedList<>(new CityComparatorClass());
    }
}
