import java.util.Scanner;
import cityDataBase.*;
import cityDataBase.exceptions.*;
import dataStructures.Iterator;

public class Main {
    public static final String LOAD_SUCCESS = "City directory restored successfully.\n";
    public static final String LOAD_EMPTY = "City directory not found.\n" +
            "Creating an empty city directory.\n";
    public static final String CITY_SUCCESS = "City successfully added.\n";
    public static final String REMOVE_SUCCESS = "City successfully removed.\n";
    public static final String CITY_NOT_FOUND = "City not found.\n";
    public static final String CITY_ALREADY_EXISTS = "City already exists.\n";
    public static final String NO_CITIES = "No cities available.\n";
    /// %d is the population number.
    public static final String POPULATION_OUTPUT = "Population: %d\n";
    /// Should be in the following format: <country> - <population> - <city>
    public static final String LIST_OUTPUT = "%s - %d - %s\n";
    public static final String BYE_MESSAGE = "City directory saved.\n" +
            "Goodbye.\n";

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

    private static void listCitiesCmd(CityDB cityDB){
        try{
            Iterator<City> iterator = cityDB.cityIterator();
            while (iterator.hasNext()){
                City city = iterator.next();
                System.out.printf(LIST_OUTPUT, city.getCountry(), city.getPopulation(),
                        city.getName());
            }
        }catch (NoSavedCitiesException e){
            System.out.printf(NO_CITIES);
        }
    }

    private static void populationCmd(Scanner sc, CityDB cityDB){
        try{
            String cityName = sc.nextLine();
            String countryName = sc.nextLine();
            int pop = cityDB.getCityPopulation(cityName, countryName);
            System.out.printf(POPULATION_OUTPUT, pop);
        }catch (CityDontExistException e){
            System.out.printf(CITY_NOT_FOUND);
        }
    }

    private static void removeCityCmd(Scanner sc, CityDB cityDB){
        try{
            String cityName = sc.nextLine();
            String countryName = sc.nextLine();
            cityDB.removeCity(cityName, countryName);
            System.out.printf(REMOVE_SUCCESS);
        } catch(CityDontExistException e){
            System.out.printf(CITY_NOT_FOUND);
        }
    }

    private static void addCityCmd(Scanner sc, CityDB cityDB){
        try{
            String cityName = sc.nextLine();
            String countryName = sc.nextLine();
            int population = sc.nextInt();
            sc.nextLine();
            cityDB.addCity(cityName, countryName, population);
            System.out.printf(CITY_SUCCESS);
        } catch (CityAlreadyExistsException e){
            System.out.printf(CITY_ALREADY_EXISTS);
        }
    }

    private static void helpCmd(){
        for (Command cmd : Command.values()) {
            if (cmd != Command.UNKNOWN) {
                System.out.println(cmd.getCommandName() + ": " + cmd.getDescription());
            }
        }
    }

    private static void quitCmd(CityDB cityDB){
        cityDB.save();
        System.out.printf(BYE_MESSAGE);
    }

    private static void cmdLoad(CityDB cityDB) {
        try {
            cityDB.load();
            System.out.printf(LOAD_SUCCESS);
        } catch (NoSavedCitiesException e) {
            System.out.printf(LOAD_EMPTY);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CityDB cityDB = new CityDBClass();
        cmdLoad(cityDB);
        cmdLoop(sc, cityDB);
        sc.close();
    }
}