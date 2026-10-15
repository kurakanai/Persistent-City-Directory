/**
 * Command Interface
 * @author Dinis Pó - d.po@campus.fct.unl.pt - 70975
 * @author Afonso Martins - afma.martins@campus.fct.unl.pt - 74365
 * @version 1.0
 *
 */
public interface CommandInterface {
    /**
     * Gets this command's name.
     * @return The name of the command.
     *
     */
    String getCommandName();
    /**
     * Gets this command's description.
     * @return The description of the command.
     *
     */
    String getDescription();
}
