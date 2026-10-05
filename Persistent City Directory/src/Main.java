import Classes.AppMessages;
import Classes.CommandsClass;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
private boolean shouldQuit = false;
void main(){
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    while(inputString != null && !shouldQuit){
        switch (inputString.toLowerCase()){
            case "help":
                CommandsClass.commandHelp();
                break;
            case "quit":
                CommandsClass.commandQuit();
                shouldQuit = true;
                break;
        }
        if(!shouldQuit){
            inputString = scanner.nextLine();
        }
    }
}
