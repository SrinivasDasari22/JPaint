package commands;

import model.ShapeList;
import model.ShapeParameters;
import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class DeleteCommand implements ICommand,IUndoable {

    private ShapeList shapeList;
    private final ArrayList<IDraw> deleteList;
    private PaintCanvas paintCanvas;

    public DeleteCommand(ShapeList shapeList, PaintCanvas paintCanvas){
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        deleteList = new ArrayList<IDraw>();

    }


    @Override
    public void run() {
        for (IDraw shape: shapeList.getSelectedList()){
            shapeList.removeShape(shape);
            deleteList.add(shape);
        }
        CommandHistory.add(this);
        paintCanvas.update();


    }

    @Override
    public void redo() {

        for (IDraw shape: deleteList){
            shapeList.removeShape(shape);
        }
        paintCanvas.update();
    }

    @Override
    public void undo() {
        for (IDraw shape : deleteList){
            shapeList.addShape(shape);
        }
        paintCanvas.update();

    }
}
