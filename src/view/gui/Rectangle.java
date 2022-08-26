package view.gui;


import java.awt.*;
import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;


import Proxys.ShapeOutlineProxy;
import commands.CommandHistory;
import commands.GroupCommand;
import commands.ICommand;
import commands.IUndoable;
import controller.Point;
import model.*;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import model.persistence.ApplicationState;
import model.persistence.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
//import view.gui.Color;
//import model.ShapeList;


/*
CheckCoordinates is reference from stackoverflow
https://stackoverflow.com/questions/31022269/collision-detection-between-two-rectangles-in-java
 */

public class Rectangle implements IDraw {

    private ShapeParameters shapeParameters;
    private Point Start_point;

    private Point End_Point;
    private final ArrayList<GroupCommand> groupCommandArrayList = new ArrayList<>();


    private int height, width;

    private Color finalColorPrimary;

    private ShapeColor primaryColor;

    private Color finalColorSecondary;

    private ShapeColor secondaryColor;

    private ShapeShadingType shadingType;

    private boolean isselected;

    public int min_x,min_y,max_x,max_y;


//    private boolean isSelected = false;





    public Rectangle(ShapeParameters shapeParameters) {


        this.shapeParameters = shapeParameters;

        this.Start_point = shapeParameters.getStart_point();
        this.End_Point = shapeParameters.getEnd_Point();
        this.primaryColor = shapeParameters.getPrimaryColor();
        this.secondaryColor = shapeParameters.getSecondaryColor();
        this.shadingType = shapeParameters.getShadingType();
        this.finalColorPrimary = SingletonColor.getColor(primaryColor);

        this.finalColorSecondary = SingletonColor.getColor(secondaryColor);
        min_x = Math.min(Start_point.getX_value(), End_Point.getX_value());

        min_y = Math.min(Start_point.getY_value(), End_Point.getY_value());
        max_x = Math.max(Start_point.getX_value(), End_Point.getX_value());
        max_y = Math.max(Start_point.getY_value(), End_Point.getY_value());


        getWidth();
        getHeight();
        shapeParameters.setHeight(getHeight());
        shapeParameters.setWidth(getWidth());

    }

    public void paint(Graphics2D graphics) {

//        System.out.println("," +x1+","+y1);
//        System.out.println(x2+","+y2);
//        System.out.println(min_x+"draw,"+min_y);

        if (shadingType.equals(ShapeShadingType.FILLED_IN)) {
            graphics.setColor(finalColorPrimary);
            graphics.setStroke(new BasicStroke(5));
            graphics.fillRect(min_x, min_y, width, height);

//            System.out.println("Rectangle Drawn");
        } else if ((shadingType.equals(ShapeShadingType.OUTLINE))) {
            graphics.setColor(finalColorPrimary);
            graphics.setStroke(new BasicStroke(5));
            graphics.drawRect(min_x, min_y, width, height);
        } else if((shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))) {
            graphics.setColor(finalColorPrimary);
            graphics.fillRect(min_x, min_y, width, height);
            graphics.setStroke(new BasicStroke(5));
            graphics.setColor(finalColorSecondary);
            graphics.drawRect(min_x, min_y, width, height);
        }
        Start_point.setX_value(min_x);
        Start_point.setY_value(min_y);
        End_Point.setX_value(max_x);
        End_Point.setY_value(max_y);
        shapeParameters.setStart_point(Start_point);
        shapeParameters.setEnd_Point(End_Point);


    }

    public void selectOutline(Graphics2D graphics){
//        System.out.println(shapeParameters.Start_point.getX_value()+" Sele,"+ shapeParameters.Start_point.getY_value());
        ShapeOutlineProxy shapeOutlineProxy = new ShapeOutlineProxy(shapeParameters,graphics);
        shapeOutlineProxy.drawOutline();


    }




    @Override
    public ShapeParameters getShapeParametrs() {
        return shapeParameters;
    }

    public int getHeight() {
        height = max_y - min_y;
        return height;


    }

    public int getWidth() {
        width =  max_x - min_x;
        return width;
    }


    public Boolean CheckCoordinates(Point S_point,Point E_point ) {

        int min_x_b = Math.min(S_point.getX_value(), E_point.getX_value());
        int min_y_b = Math.min(S_point.getY_value(), E_point.getY_value());
        int max_x_b = Math.max(S_point.getX_value(), E_point.getX_value());
        int max_y_b = Math.max(S_point.getY_value(), E_point.getY_value());



        return ((min_x < max_x_b) && (max_x > min_x_b ) && (min_y < max_y_b) && (max_y > min_y_b));

    }

    public void updateMove(int delta_x, int delta_y){
        min_x = min_x+delta_x;
        min_y = min_y+delta_y;
        max_x = max_x+delta_x;
        max_y = max_y+delta_y;
        Start_point.setX_value(min_x);
        Start_point.setY_value(min_y);
        End_Point.setX_value(max_x);
        End_Point.setY_value(max_y);
        shapeParameters.setStart_point(Start_point);
        shapeParameters.setEnd_Point(End_Point);


    }

    public void addGroupShape(GroupCommand groupCommand) {

        groupCommandArrayList.add(groupCommand);
        System.out.println(this+"group shape array list :"+ groupCommandArrayList);
    }
    public ArrayList<GroupCommand> getShapeGroup() {
        return groupCommandArrayList;
    }

    @Override
    public void removeGroupShape() {

        groupCommandArrayList.remove(groupCommandArrayList.size() -1);
    }

}

