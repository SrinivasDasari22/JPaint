package commands;

import controller.Point;
import model.ShapeList;
import model.ShapeParameters;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.util.ArrayList;

public class MoveShapeCommand implements ICommand,IUndoable {



    private IDraw shape;

    private ShapeList shapeList;


    private ShapeParameters shapeParameters;

    private PaintCanvas paintCanvas;

    private Point Start_Point;

    private Point End_Point;

    private ArrayList<IDraw> tempShapeList;
    private int delta_x,delta_y,delta_x_u,delta_y_u;

    public MoveShapeCommand(PaintCanvas paintCanvas, ShapeParameters shapeParameters, ShapeList shapeList) {

        this.shapeList = shapeList;
        this.shapeParameters = shapeParameters;
        this.paintCanvas = paintCanvas;
        this.Start_Point = shapeParameters.getStart_point();
        this.End_Point = shapeParameters.getEnd_Point();
        delta_x = End_Point.getX_value() - Start_Point.getX_value();
        delta_y = End_Point.getY_value() - Start_Point.getY_value();
        delta_x_u = (delta_x *(-1));
        delta_y_u = (delta_y * (-1));
        tempShapeList = new ArrayList<IDraw>();

    }


    @Override
    public void run() {


        for (IDraw shape : shapeList.getSelectedList()) {

            if(shapeList.getArrayList().contains(shape)) {

                shapeList.removeShape(shape);
                shape.updateMove(delta_x, delta_y);
                shapeList.addShape(shape);
                tempShapeList.add(shape);
            }
//                    System.out.println(delta_x + "::" + delta_y);
        }
        paintCanvas.update();
        CommandHistory.add(this);

    }

    @Override
    public void redo() {

        System.out.println("into move redo");
        for (IDraw shape : tempShapeList) {
            shapeList.removeShape(shape);
            shape.updateMove(delta_x, delta_y);
            shapeList.addShape(shape);

//            System.out.println(delta_x+"::"+delta_y);

        }
        paintCanvas.update();
    }

    @Override
    public void undo(){

        System.out.println("into move undo");
        for(IDraw shape: tempShapeList){
            shapeList.removeShape(shape);
//            System.out.println(delta_x_u+"::"+delta_y_u);
            shape.updateMove(delta_x_u, delta_y_u);
            shapeList.addShape(shape);

        }
        paintCanvas.update();

    }


}
