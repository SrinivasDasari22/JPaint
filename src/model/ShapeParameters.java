package model;

import controller.Point;
import model.interfaces.IApplicationState;

import java.awt.*;

public class ShapeParameters {

    private static int x =1;
    public Point Start_point;

    public Point End_Point;

    public void inc_x(){
        x = x+1;

    }
    public void dec_x(){
        x = x-1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int height,width;

    public ShapeColor primaryColor;

    public ShapeType shapeType;

    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    public ShapeShadingType shadingType;

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected = false;

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public ShapeColor secondaryColor;

    public Point getStart_point() {
        return Start_point;
    }

    public void setStart_point(Point start_point) {
        Start_point = start_point;
    }

    public Point getEnd_Point() {
        return End_Point;
    }

    public ShapeType getShapeType(){
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType){
        this.shapeType = shapeType;
    }

    public void setEnd_Point(Point end_Point) {
        End_Point = end_Point;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addOffset(){

        System.out.println("Clicked  ("+ Start_point.x_point+","+ Start_point.y_point+")");

        System.out.println("Released  (" + End_Point.x_point + "," + End_Point.y_point + ")");
        Start_point.setX_value(Start_point.getX_value()+(x*50));
        Start_point.setY_value(Start_point.getY_value()+(x*50));
        End_Point.setY_value(End_Point.getY_value()+(x*50));
        End_Point.setX_value(End_Point.getX_value()+(x*50));
        x = x+1;
        System.out.println("Start off  ("+ Start_point.x_point+","+ Start_point.y_point+")");
        System.out.println("End off  (" + End_Point.x_point + "," + End_Point.y_point + ")");

    }

    public void setAllValues(Point Start_point,Point End_Point,int height, int width,ShapeColor primaryColor,ShapeType shapeType,ShapeShadingType shadingType,ShapeColor secondaryColor){


//        this.Start_point = Start_point;

        this.Start_point = new Point(Start_point.getX_value(),Start_point.getY_value());
        this.End_Point = new Point(End_Point.getX_value(),End_Point.getY_value());
//        x++;
        this.height = height;
        this.width = width;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
    }
}
