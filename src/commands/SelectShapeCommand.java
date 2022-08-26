package commands;
import model.ShapeList;

import model.ShapeParameters;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;


import controller.Point;

import view.gui.PaintCanvas;

import java.util.ArrayList;


public class SelectShapeCommand implements ICommand{

    private IDraw shape;



    private ShapeList shapeList;

    private ShapeParameters shapeParameters;

    private Point start_point,end_point;
    private PaintCanvas paintCanvas;

//    private boolean isSelected;

    public SelectShapeCommand(ShapeParameters shapeParameters, ShapeList shapeList,PaintCanvas paintCanvas){
        this.shapeList = shapeList;
        this.shapeParameters = shapeParameters;
        this.start_point = shapeParameters.getStart_point();
        this.end_point = shapeParameters.getEnd_Point();
        this.paintCanvas = paintCanvas;
    }


    @Override
    public void run() {

        shapeList.removeAllSelectedShapes();
        shapeList.removeCopiedList();
        for(IDraw shape : shapeList.getArrayList()) {

            paintCanvas.update();

//            System.out.println("SelectedCommand" +shape.CheckCoordinates(start_point,end_point));
            if (shape.CheckCoordinates(start_point, end_point)) {
                if(!shape.getShapeGroup().isEmpty()){
                    groupSelectedShape(shapeList.getArrayList(),shape);

                } else {
//                    System.out.println("adding shape to selected list");
                    if(!shapeList.getSelectedList().contains(shape)){
                        shapeList.addSelectedShape(shape);
                    }

                }


            }

            paintCanvas.update();

        }

//        System.out.println(shapeList.getSelectedList());
    }

    private void groupSelectedShape(ArrayList<IDraw> arrayList, IDraw shape){
        GroupCommand groupCommand = shape.getShapeGroup().get(shape.getShapeGroup().size()-1);
        for(IDraw shape1: arrayList){
            if(!shape1.getShapeGroup().isEmpty()){
                GroupCommand groupCommand1 = shape1.getShapeGroup().get(shape1.getShapeGroup().size()-1);

                if(groupCommand1.equals(groupCommand)){
                    if(!shapeList.getSelectedList().contains(shape1)){
                        shapeList.addSelectedShape(shape1);
                    }

                }
            }
        }
    }

}
