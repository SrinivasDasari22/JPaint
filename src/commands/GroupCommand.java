package commands;

import model.ShapeList;
import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.util.ArrayList;



public class GroupCommand implements ICommand,IUndoable {


    private final ArrayList<IDraw> groupedList = new ArrayList<>();

    private ShapeList shapeList;

    private PaintCanvas paintCanvas;

    public GroupCommand(ShapeList shapeList,PaintCanvas paintCanvas){
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }
    @Override
    public void run() {
//        shapeList.removeAllSelectedShapes();

//        ArrayList<IDraw> group = new ArrayList<>();
        groupedList.clear();

        System.out.println("GroupedList : " +groupedList);

        System.out.println("selected shapes in group coammnd:: " + shapeList.getSelectedList());
        groupedList.addAll(shapeList.getSelectedList());

        for(IDraw shape: groupedList) {

            shape.addGroupShape(this);
        }
        CommandHistory.add(this);
        paintCanvas.update();
        System.out.println("GroupedList : " +groupedList);
//        shapeList.removeAllSelectedShapes();
    }


    @Override
    public void redo() {

        for(IDraw shape : groupedList ){
            shapeList.addSelectedShape(shape);
            shape.addGroupShape(this);
        }
        paintCanvas.update();
    }

    @Override
    public void undo() {

        for(IDraw shape: groupedList){
            shape.removeGroupShape();
        }
        paintCanvas.update();
    }
}
