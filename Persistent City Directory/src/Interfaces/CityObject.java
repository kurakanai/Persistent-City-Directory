package Interfaces;

public interface CityObject {
    String getName();
    void setName(String newName);
    CountryObject getCountry();
    void setCountry(CountryObject newCountry);
    int getPop();
    void setPop(int newPop);
}
