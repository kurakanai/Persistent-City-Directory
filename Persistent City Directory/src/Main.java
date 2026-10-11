import Classes.AppMessages;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public enum Command {
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

    public String getCommandName() {
        return commandName;
    }

    public String getDescription() {
        return description;
    }

    public static Command fromString(String text) {
        Command comm = UNKNOWN;
        for(Command command : values()){
            if(command.commandName.equalsIgnoreCase(text))
                comm = command;
        }
        return comm;
    }
}

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
    System.out.printf(AppMessages.goodbyeMessage);
}
void main(){
    Scanner sc = new Scanner(System.in);
    Command cmd;
    do {
        cmd = Command.fromString(sc.nextLine());
        switch (cmd) {
            case HELP -> helpCmd();
            case QUIT -> quitCmd();
        }
    } while (!cmd.equals(Command.QUIT));
}
