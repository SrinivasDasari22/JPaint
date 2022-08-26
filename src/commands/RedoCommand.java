package commands;

public class RedoCommand implements ICommand {

    @Override
    public void run() {
        CommandHistory.redo();
//        System.out.println("redo in redo command");
    }



}
