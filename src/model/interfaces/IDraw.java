package model.interfaces;
import commands.GroupCommand;
import model.ShapeList;
import model.ShapeParameters;
import controller.Point;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface IDraw {

    void paint(Graphics2D graphics);


    Boolean CheckCoordinates(Point S_point,Point E_point);

    ShapeParameters getShapeParametrs();

    int getWidth();

    int getHeight();
    void selectOutline(Graphics2D g);


    void updateMove(int delta_x, int delta_y);


    void addGroupShape(GroupCommand groupCommand);


    ArrayList<GroupCommand> getShapeGroup();

    void removeGroupShape();

}
