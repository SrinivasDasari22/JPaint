package commands;

import model.ShapeList;
import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.HashMap;

public class UngroupCommand implements ICommand,IUndoable {

    private PaintCanvas paintCanvas;
    private ShapeList shapeList;

    private final ArrayList<IDraw> ungroupedList = new ArrayList<>();

    private GroupCommand group;

    private HashMap<IDraw,GroupCommand> dict;
    public UngroupCommand(ShapeList shapeList, PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        ungroupedList.clear();

        ungroupedList.addAll(shapeList.getSelectedList());
//        dict.clear();
        dict = new HashMap<IDraw,GroupCommand>();

        for(IDraw shape : ungroupedList){
            if(!shape.getShapeGroup().isEmpty()){
                dict.put(shape,shape.getShapeGroup().get(shape.getShapeGroup().size()-1));
            }
        }


//        System.out.println("ungrouped:::"+ungroupedList);

        //code for multiple ungroup
//        ArrayList<GroupCommand> groups =new ArrayList<GroupCommand>();
//        for(IDraw shapes: ungroupedList){
//
//            if(!shapes.getShapeGroup().isEmpty()){
//                if(!groups.contains(shapes.getShapeGroup().get(shapes.getShapeGroup().size()-1))){
//                    groups.add(shapes.getShapeGroup().get(shapes.getShapeGroup().size()-1));
//                }
//
//            }
//        }
        //end
//        IDraw lastShape = ungroupedList.get(ungroupedList.size()-1);

//        group = lastShape.getShapeGroup().get(lastShape.getShapeGroup().size()-1);

        for(IDraw shape: ungroupedList){
            if(!shape.getShapeGroup().isEmpty()) {
                shape.removeGroupShape();
            }
        }

//        System.out.println("ungrouped--2::::"+ungroupedList);
        CommandHistory.add(this);
        paintCanvas.update();
    }

    @Override
    public void redo() {

        for(IDraw shape : ungroupedList){
            shape.removeGroupShape();
        }
        paintCanvas.update();
    }

    @Override
    public void undo() {
        for(IDraw shape : ungroupedList){

            shape.addGroupShape(dict.get(shape));


            shapeList.addSelectedShape(shape);
        }

        paintCanvas.update();


    }
}
