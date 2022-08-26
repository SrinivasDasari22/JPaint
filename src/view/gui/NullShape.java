package view.gui;

import commands.GroupCommand;
import controller.Point;
import model.ShapeParameters;
import model.interfaces.IDraw;

import java.awt.*;
import java.util.ArrayList;

public class NullShape implements IDraw {
    @Override
    public void paint(Graphics2D graphics) {

    }

    @Override
    public Boolean CheckCoordinates(Point S_point, Point E_point) {
        return null;
    }

    @Override
    public ShapeParameters getShapeParametrs() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void selectOutline(Graphics2D g) {

    }

    @Override
    public void updateMove(int delta_x, int delta_y) {

    }

    @Override
    public void addGroupShape(GroupCommand groupCommand) {

    }

    @Override
    public ArrayList<GroupCommand> getShapeGroup() {
        return null;
    }

    @Override
    public void removeGroupShape() {

    }
}
