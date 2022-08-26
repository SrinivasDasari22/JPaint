package view.gui;

import model.ShapeParameters;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;


public  class ShapeFactory{


    public IDraw shape;

    private ShapeParameters shapeParameters;
    public IApplicationState appState;


    public ShapeFactory(){
//        this.shapeParameters = shapeParameters;
//        this.appState = appState;
    }

    public IDraw createShape(ShapeParameters shapeParameters){

        if(shapeParameters.getShapeType().equals(ShapeType.RECTANGLE)){
            shape = new Rectangle(shapeParameters);
        }
        else if(shapeParameters.getShapeType().equals(ShapeType.TRIANGLE)){
            shape = new Triangle(shapeParameters);
        }
        else if (shapeParameters.getShapeType().equals(ShapeType.ELLIPSE)){
            shape = new Ellipses(shapeParameters);
        } else{
            shape = new NullShape();
        }
         return shape;
    }




}