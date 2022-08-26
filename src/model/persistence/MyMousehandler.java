package model.persistence;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import commands.CreateShapeCommand;
import commands.MoveShapeCommand;
import commands.SelectShapeCommand;
import model.MouseMode;
import model.ShapeList;
import model.ShapeParameters;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import model.interfaces.IStateMouse;
import view.gui.PaintCanvas;
import controller.Point;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class MyMousehandler extends MouseAdapter {

    private IApplicationState appState;

    private PaintCanvas paintCanvas;

    private ShapeList shapeList;
    private ShapeParameters shapeParameters;

    private Point Start_point;
    private Point End_point;

    private IStateMouse mouseState;


//    ShapeParameters shapeParameters = new ShapeParameters();

    public MyMousehandler(ShapeList shapeList, IApplicationState appState, PaintCanvas paintCanvas){
        this.appState = appState;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;


//

    }

    public void mousePressed(MouseEvent e) {
        shapeParameters = new ShapeParameters();
        Start_point = new Point(e.getX(),e.getY());
        shapeParameters.setStart_point(Start_point);
        System.out.println("Clicked  ("+ Start_point.x_point+","+ Start_point.y_point+")");


    }

    public void mouseReleased(MouseEvent e) {


        End_point = new Point(e.getX(), e.getY());
        shapeParameters.setEnd_Point(End_point);
        shapeParameters.setPrimaryColor(appState.getActivePrimaryColor());
        shapeParameters.setSecondaryColor(appState.getActiveSecondaryColor());
        shapeParameters.setShadingType(appState.getActiveShapeShadingType());
        shapeParameters.setShapeType(appState.getActiveShapeType());
        System.out.println("Released  ("+ End_point.x_point+","+ End_point.y_point+")");


        if (appState.getActiveMouseMode().equals(MouseMode.DRAW)) {
            mouseState = new DrawMouseState();
            mouseState.run(paintCanvas,shapeParameters,shapeList);
        }
        if (appState.getActiveMouseMode().equals(MouseMode.SELECT)) {
            mouseState = new SelectMouseState();
            mouseState.run(paintCanvas,shapeParameters,shapeList);
        }
        if(appState.getActiveMouseMode().equals(MouseMode.MOVE)){
            mouseState = new MoveMouseState();
            mouseState.run(paintCanvas,shapeParameters,shapeList);
        }

    }


}
