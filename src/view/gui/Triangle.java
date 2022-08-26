package view.gui;

import Proxys.ShapeOutlineProxy;
import commands.GroupCommand;
import controller.Point;
import model.ShapeColor;
import model.ShapeParameters;
import model.ShapeShadingType;
import model.SingletonColor;
import model.interfaces.IDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Triangle  implements IDraw {

    private ShapeParameters shapeParameters;
    private controller.Point Start_point;

    private final ArrayList<GroupCommand> groupCommandArrayList = new ArrayList<>();

    private Point End_Point;

    private int height,width;

    private Color finalColorPrimary;

    private ShapeColor primaryColor;

    private Color finalColorSecondary;

    private ShapeColor secondaryColor;

    private ShapeShadingType shadingType;

    private ShapeOutlineProxy shapeOutlineProxy;

//    private int x1,x2,y1,y2;

    private int min_x,min_y,max_x,max_y;
    private boolean isSelected = false;

//    private Boolean isSelected;



    public Triangle(ShapeParameters shapeParameters) {

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
    }


    @Override
    public void paint(Graphics2D graphics) {

        int x_points[] = {min_x,max_x,min_x};
        int y_points[] = {min_y,max_y,max_y};

//        System.out.println(x_points[0]+","+x_points[1] + "   " + y_points[0]+","+y_points[1]);

        if ((shadingType.equals(ShapeShadingType.FILLED_IN))){
            graphics.setColor(finalColorPrimary);
            graphics.setStroke(new BasicStroke(5));
            graphics.fillPolygon(x_points,y_points,3);
            System.out.println("Triangle Drawn");
        } else if ((shadingType.equals(ShapeShadingType.OUTLINE))){
            graphics.setColor(finalColorPrimary);
            graphics.setStroke(new BasicStroke(5));
            graphics.drawPolygon(x_points,y_points,3);
        } else if ((shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))) {
            graphics.setColor(finalColorPrimary);
            graphics.fillPolygon(x_points,y_points,3);
            graphics.setStroke(new BasicStroke(5));
            graphics.setColor(finalColorSecondary);
            graphics.drawPolygon(x_points,y_points,3);
        }

        Start_point.setX_value(min_x);
        Start_point.setY_value(min_y);
        End_Point.setX_value(max_x);
        End_Point.setY_value(max_y);
        shapeParameters.setStart_point(Start_point);
        shapeParameters.setEnd_Point(End_Point);


    }

    public void selectOutline(Graphics2D graphics){
        ShapeOutlineProxy shapeOutlineProxy = new ShapeOutlineProxy(shapeParameters,graphics);
        shapeOutlineProxy.drawOutline();
    }








    @Override
    public Boolean CheckCoordinates(Point S_point,Point E_point ) {

        int min_x_b = Math.min(S_point.getX_value(), E_point.getX_value());
        int min_y_b = Math.min(S_point.getY_value(), E_point.getY_value());
        int max_x_b = Math.max(S_point.getX_value(), E_point.getX_value());
        int max_y_b = Math.max(S_point.getY_value(), E_point.getY_value());


        return ((min_x < max_x_b) && (max_x > min_x_b ) && (min_y < max_y_b) && (max_y > min_y_b));
    }

    @Override
    public ShapeParameters getShapeParametrs() {
        return shapeParameters;
    }

    @Override
    public int getWidth() {

        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
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

    @Override
    public void addGroupShape(GroupCommand groupCommand) {

        groupCommandArrayList.add(groupCommand);
    }

    public ArrayList<GroupCommand> getShapeGroup() {
        return groupCommandArrayList;
    }

    @Override
    public void removeGroupShape() {

        groupCommandArrayList.remove(groupCommandArrayList.size() -1);
    }
}
