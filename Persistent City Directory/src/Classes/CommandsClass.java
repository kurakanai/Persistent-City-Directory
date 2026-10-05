package Classes;

public class CommandsClass {
    /// Logic for the help command. Prints the help string.
    public static void commandHelp(){
        System.out.printf(AppMessages.helpOut);
    }

    /// Prints the quit message. The quit variable is NOT set in this method.
    public static void commandQuit(){
        System.out.printf(AppMessages.goodbyeMessage);
    }
}
