// The messages in this package are designed strictly with printf in mind!
package Classes;
public final class AppMessages {
    public final String helpOut = "addCity: Adds a new city to the directory.\n" +
            "removeCity: Removes an existing city from the directory.\n" +
            "population: Returns the number of inhabitants of a city.\n" +
            "listCities: Lists all cities currently stored in the directory.\n" +
            "help: Displays the list of available commands.\n" +
            "quit: Terminates the application.\n";
    public final String addCitySuccess = "City successfully added.\n";
    public final String removeCitySuccess = "City successfully removed.\n";
    public final String cityFailureNotFound = "City not found.\n";
    public final String cityFailureDuplicate = "City already exists.\n";
    public final String cityFailureNoCities = "No cities available.\n";
    /// %d is the population number.
    public final String populationStandardOut = "Population: %d\n";
    /// Should be in the following format: <country> - <population> - <city>
    public final String listCitiesStandardOut = "%s - %d - %s\n";
    public final String goodbyeMessage = "City directory saved.\n" +
            "Goodbye.\n";
}
