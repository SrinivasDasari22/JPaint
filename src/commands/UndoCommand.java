package commands;



import controller.JPaintController;
//import model.ShapeList;
import model.interfaces.IApplicationState;
import view.gui.PaintCanvas;
import commands.CommandHistory;
import commands.ICommand;
import java.util.ArrayList;
import model.persistence.MyMousehandler;
import view.gui.Rectangle;

import model.persistence.MyMousehandler;
public class UndoCommand implements ICommand {


    public void run(){
        CommandHistory.undo();
//        System.out.println("undo in undo command");

    }



}
