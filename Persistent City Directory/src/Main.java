import cityDataBase.City;
import cityDataBase.CityDB;
import cityDataBase.CityDBClass;
import cityDataBase.exceptions.CityAlreadyExistsException;
import cityDataBase.exceptions.CityNotFoundException;
import cityDataBase.exceptions.NoSavedCitiesException;
import dataStructures.Iterator;

public static final String LOAD_SUCCESS = "City directory restored successfully.\n";
public static final String LOAD_EMPTY = """
        City directory not found.
        Creating an empty city directory.
        """;
public static final String CITY_SUCCESS = "City successfully added.\n";
public static final String REMOVE_SUCCESS = "City successfully removed.\n";
public static final String CITY_NOT_FOUND = "City not found.\n";
public static final String CITY_ALREADY_EXISTS = "City already exists.\n";
public static final String NO_CITIES = "No cities available.\n";
/// %d is the population number.
public static final String POPULATION_OUTPUT = "Population: %d\n";
/// Should be in the following format: country - population - city.
public static final String LIST_OUTPUT = "%s - %d - %s\n";
public static final String BYE_MESSAGE = """
        City directory saved.
        Goodbye.
        """;

/// This method keeps the input going, parsing the commands and executing their respective
/// method until a quit command is issued.
///
/// @param sc Main's scanner.
/// @param cityDB The loaded city database.
private static void cmdLoop(Scanner sc, CityDB cityDB) {
    Command cmd;
    do {
        cmd = Command.fromString(sc.nextLine());
        switch (cmd) {
            case ADD_CITY -> addCityCmd(sc, cityDB);
            case REMOVE_CITY -> removeCityCmd(sc, cityDB);
            case POPULATION -> populationCmd(sc, cityDB);
            case LIST_CITIES -> listCitiesCmd(cityDB);
            case HELP -> helpCmd();
            case QUIT -> quitCmd(cityDB);
        }
    } while (!cmd.equals(Command.QUIT));
}

/// Logic for the listCities command. Prints all cities sorted by country name, population and name (in that order).
///
/// @param cityDB The target database to pull the cities from.
private static void listCitiesCmd(CityDB cityDB) {
    try {
        Iterator<City> iterator = cityDB.cityIterator();
        while (iterator.hasNext()) {
            City city = iterator.next();
            System.out.printf(LIST_OUTPUT, city.getCountry(), city.getPopulation(),
                    city.getName());
        }
    } catch (NoSavedCitiesException e) {
        System.out.printf(NO_CITIES);
    }
}

/// Logic for the population command. Reads the target city's name and country and returns its population number.
///
/// @param sc Scanner to read name and country fields.
/// @param cityDB Database where the cities are stored.
private static void populationCmd(Scanner sc, CityDB cityDB) {
    try {
        String cityName = sc.nextLine();
        String countryName = sc.nextLine();
        int pop = cityDB.getCityPopulation(cityName, countryName);
        System.out.printf(POPULATION_OUTPUT, pop);
    } catch (CityNotFoundException e) {
        System.out.printf(CITY_NOT_FOUND);
    }
}
/// Logic for the removeCity command. Reads the target city's name and country and attempts to remove it.
///
/// @param sc Scanner to read name and country fields.
/// @param cityDB Database where the target city is located.
private static void removeCityCmd(Scanner sc, CityDB cityDB) {
    try {
        String cityName = sc.nextLine();
        String countryName = sc.nextLine();
        cityDB.removeCity(cityName, countryName);
        System.out.printf(REMOVE_SUCCESS);
    } catch (CityNotFoundException e) {
        System.out.printf(CITY_NOT_FOUND);
    }
}

/// Logic for the addCity command. Reads the desired city name, country where the city
/// is located and the city's population.
///
/// @param sc Scanner to read name, country and population fields.
/// @param cityDB Database where the city will be added.
private static void addCityCmd(Scanner sc, CityDB cityDB) {
    try {
        String cityName = sc.nextLine();
        String countryName = sc.nextLine();
        int population = sc.nextInt();
        sc.nextLine();
        cityDB.addCity(cityName, countryName, population);
        System.out.printf(CITY_SUCCESS);
    } catch (CityAlreadyExistsException e) {
        System.out.printf(CITY_ALREADY_EXISTS);
    }
}

/// Logic for the help command. Simply prints all available commands and what they do.
private static void helpCmd() {
    for (Command cmd : Command.values()) {
        if (cmd != Command.UNKNOWN) {
            IO.println(cmd.getCommandName() + ": " + cmd.getDescription());
        }
    }
}

/// Logic for the quit command. This also saves the database onto a file and prints a quit message.
///
/// @param cityDB Database that will be saved.
private static void quitCmd(CityDB cityDB) {
    cityDB.save();
    System.out.printf(BYE_MESSAGE);
}

/// Logic responsible for loading the city database file onto memory. Creates an empty one on failure.
///
/// @param cityDB The empty database's object.
private static void cmdLoad(CityDB cityDB) {
    try {
        cityDB.load();
        System.out.printf(LOAD_SUCCESS);
    } catch (NoSavedCitiesException e) {
        System.out.printf(LOAD_EMPTY);
    }
}

void main() {
    Scanner sc = new Scanner(System.in);
    CityDB cityDB = new CityDBClass();
    cmdLoad(cityDB);
    cmdLoop(sc, cityDB);
    sc.close();
}