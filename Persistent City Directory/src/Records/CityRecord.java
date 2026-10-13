package Records;

import Interfaces.Objects.City;

public record CityRecord(String name, String country, int population) implements City
{
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