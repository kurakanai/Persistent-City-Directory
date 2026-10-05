package Interfaces.Objects;

public interface CityObject {
    /// Method for getting a city's name.
    ///
    /// @return The city's assigned name string.
    String getName();

    /// Method for setting a city's name.
    ///
    /// @param newName The desired name for the city.
    void setName(String newName);

    /// Method for getting the assigned country of a city.
    ///
    /// @return The country where the city is located.
    CountryObject getCountry();

    /// Method for setting a city's parent country.
    ///
    /// @param newCountry The country object of the country where this city is located.
    void setCountry(CountryObject newCountry);

    /// Method for getting a city's population in integer form.
    ///
    /// @return The population of the city (int).
    int getPop();

    /// Method for setting a city's population.
    ///
    /// @param newPop The city's current population.
    void setPop(int newPop);
}
