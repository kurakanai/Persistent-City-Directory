package Classes;

public class CommandsClass {
    public static void commandHelp(){
        System.out.printf(AppMessages.helpOut);
    }
    public static void commandQuit(){
        System.out.printf(AppMessages.goodbyeMessage);
    }
}
