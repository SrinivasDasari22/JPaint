package commands;

import controller.Point;
import model.ShapeList;
import model.ShapeParameters;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public class PasteCommand implements ICommand,IUndoable{

    private ShapeList shapeList;
    private PaintCanvas paintCanvas;

    private ShapeParameters pasteShape, t_p;
//    private Point point;

    private IDraw temp_shape;

    private ArrayList<IDraw> tempShapeList;
    private IApplicationState appState;

    private IDraw newShape;
//    private  Dictionary<GroupCommand,GroupCommand> dict;

    public PasteCommand(ShapeList shapeList, PaintCanvas paintCanvas,IApplicationState appState){
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        tempShapeList = new ArrayList<IDraw>();

    }

    @Override
    public void run() {


        HashMap<GroupCommand,GroupCommand> dict = new HashMap<GroupCommand,GroupCommand>();

        for(IDraw shape3: shapeList.getCopiedList()){
            if(!shape3.getShapeGroup().isEmpty()) {
                dict.put(shape3.getShapeGroup().get(shape3.getShapeGroup().size() - 1), null);
            }
        }



        System.out.println(shapeList.getCopiedList());


        for(IDraw shape : shapeList.getCopiedList()) {
            System.out.println("ShapeParametrs" + shape.getShapeParametrs().Start_point);
            temp_shape = shape;
            t_p = shape.getShapeParametrs();
            pasteShape = new ShapeParameters();
            pasteShape.setAllValues(t_p.getStart_point(), t_p.End_Point, t_p.getHeight(), t_p.getWidth(), t_p.getPrimaryColor(), t_p.shapeType, t_p.shadingType, t_p.getSecondaryColor());
            System.out.println("ShapeParametrs" + pasteShape.Start_point);
            pasteShape.addOffset();
            System.out.println(pasteShape.Start_point);
            CreateShapeCommand createShapeCommand = new CreateShapeCommand(paintCanvas, pasteShape, shapeList);
            IDraw newShape = createShapeCommand.shapeFactory.createShape(pasteShape);
            //new code for pasting group

            if(!shape.getShapeGroup().isEmpty()){
                if(dict.get(shape.getShapeGroup().get(shape.getShapeGroup().size()-1))!=null) {
                    newShape.addGroupShape(dict.get(shape.getShapeGroup().get(shape.getShapeGroup().size()-1)));
                }
                else{
                    GroupCommand groupCommand = new GroupCommand(shapeList,paintCanvas);
                    dict.put(shape.getShapeGroup().get(shape.getShapeGroup().size()-1),groupCommand);
                    newShape.addGroupShape(groupCommand);
                }
            }
            //ends
            tempShapeList.add(newShape);


        }





        for (IDraw shape : tempShapeList) {
//            shape.falseSelect();
            shapeList.addShape(shape);

        }

        CommandHistory.add(this);
        paintCanvas.update();
        System.out.println("Paste command run ");
        System.out.println("main++ "+shapeList.getArrayList());
        System.out.println("Paste++"+ shapeList.getSelectedList());
        System.out.println(tempShapeList);


    }


    @Override
    public void redo() {
        for (IDraw shape: tempShapeList){
            shapeList.addShape(shape);
            shape.getShapeParametrs().inc_x();
        }
        paintCanvas.update();



    }

    @Override
    public void undo() {

        for (IDraw shape: tempShapeList){
            shapeList.removeShape(shape);
            shape.getShapeParametrs().dec_x();
        }
        paintCanvas.update();

    }
}
