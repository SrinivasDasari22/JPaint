package controller;

public class Point{

    public int x_point;
    public int y_point;

    public Point(int x_point,int y_point){
        this.x_point = x_point;
        this.y_point = y_point;
    }

    public int getX_value() {
        return this.x_point;
    }

    public int getY_value() {
        return this.y_point;
    }

    public void setX_value(int x_point){
        this.x_point = x_point;
    }

    public void setY_value(int y_point){
        this.y_point = y_point;
    }



}
