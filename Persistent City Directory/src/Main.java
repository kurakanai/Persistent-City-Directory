import Classes.CityDBClass;
import Enums.Command;
import Interfaces.Objects.City;
import Records.CityRecord;
import dataStructures.Iterator;

public static final String appLoadSuccessful = "City directory restored successfully.\n";
public static final String appLoadEmptyDir = "City directory not found.\n" +
        "Creating an empty city directory.";
public static final String helpOut = "addCity: Adds a new city to the directory.\n" +
        "removeCity: Removes an existing city from the directory.\n" +
        "population: Returns the number of inhabitants of a city.\n" +
        "listCities: Lists all cities currently stored in the directory.\n" +
        "help: Displays the list of available commands.\n" +
        "quit: Terminates the application.\n";
public static final String addCitySuccess = "City successfully added.\n";
public static final String removeCitySuccess = "City successfully removed.\n";
public static final String cityFailureNotFound = "City not found.\n";
public static final String cityFailureDuplicate = "City already exists.\n";
public static final String cityFailureNoCities = "No cities available.\n";
/// %d is the population number.
public static final String populationStandardOut = "Population: %d\n";
/// Should be in the following format: <country> - <population> - <city>
public static final String listCitiesStandardOut = "%s - %d - %s\n";
public static final String goodbyeMessage = "City directory saved.\n" +
        "Goodbye.\n";
private CityDBClass cityDB;


/// Logic for the help command. Prints the help string.
private static void helpCmd() {
    for (Command cmd : Command.values()) {
        if (cmd != Command.UNKNOWN) {
            System.out.println(cmd.getCommandName() + " - " + cmd.getDescription());
        }
    }
}

/// Prints the quit message. The quit variable is NOT set in this method.
public static void quitCmd(){
    System.out.printf(goodbyeMessage);
}

public static void addCityCmd(Scanner scanner){
    String cityName = scanner.nextLine();
    String countryName = scanner.nextLine();
    int population = scanner.nextInt();
    /// Sample country object
    CountryObject countryObject = new CountryClass(null);
    CityClass newCity = new CityClass(cityName, countryObject, population);
    Iterator iterator = countryObject.getcitiesDBCountry().iterator();
    boolean isDupe = false;
    while (iterator.hasNext()){
        CityObject city = (CityObject) iterator.next();
        if(city.getName().equalsIgnoreCase(cityName)){
            isDupe = true;
        };
    }
    if(!isDupe){
        countryObject.getcitiesDBCountry().add(newCity);
        System.out.printf(addCitySuccess);
    }
    else {
        System.out.printf(cityFailureDuplicate);
    }
}

public static void removeCityCmd(Scanner scanner){
    String cityName = scanner.nextLine();
}

private void populationCmd(Scanner scanner) {
    String cityName = scanner.nextLine();
    String countryName = scanner.nextLine();
    /// Sample city added to not rely on unfinished classes for now.
    CityClass targetCity = new CityClass(null, null, 0);
    if(targetCity != null){
        System.out.printf(populationStandardOut, targetCity.getPop());
    }
    else {
        System.out.printf(cityFailureNotFound);
    }
}
private void listCitiesCmd() {
    Iterator iterator = cityDB.citySortedList.iterator();
    if(iterator.hasNext()){
        while (iterator.hasNext()){
            City currentCity = (City)iterator.next();
            System.out.printf(listCitiesStandardOut, currentCity.getCountry(), currentCity.getPopulation(),
                    currentCity.getName());
        }
    }
    else {
        System.out.println(cityFailureNoCities);
    }
}

void main(){
    Scanner sc = new Scanner(System.in);
    cityDB = new CityDBClass();
    Command cmd;
    do {
        cmd = Command.fromString(sc.nextLine());
        switch (cmd) {
            case ADD_CITY -> addCityCmd(sc);
            case REMOVE_CITY -> removeCityCmd(sc);
            case POPULATION -> populationCmd(sc);
            case LIST_CITIES -> listCitiesCmd();
            case HELP -> helpCmd();
            case QUIT -> quitCmd();
        }
        sc.nextLine();
    } while (!cmd.equals(Command.QUIT));
}




