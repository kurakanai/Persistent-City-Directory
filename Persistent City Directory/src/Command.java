/**
 * The Command enum, including all commands and their descriptions. Also includes a parser.
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 1.0
 *
 */
public enum Command implements CommandInterface {
    ADD_CITY("addCity", "Adds a new city to the directory."),
    REMOVE_CITY("removeCity", "Removes an existing city from the directory."),
    POPULATION("population", "Returns the number of inhabitants of a city."),
    LIST_CITIES("listCities", "Lists all cities currently stored in the directory."),
    HELP("help", "Displays the list of available commands."),
    QUIT("quit", "Terminates the application."),
    UNKNOWN("", "");

    private final String commandName;
    private final String description;

    Command(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Gets a command from a string.
     * @param text The string to parse as a Command.
     * @return The command object the string corresponds to.
     *
     */
    public static Command fromString(String text) {
        Command comm = UNKNOWN;
        for(Command command : values()){
            if(command.commandName.equalsIgnoreCase(text))
                comm = command;
        }
        return comm;
    }
}
