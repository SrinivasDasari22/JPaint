package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeParameters;
import model.ShapeType;
import model.interfaces.IDraw;
import model.persistence.ApplicationState;
import model.persistence.MyMousehandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.gui.Rectangle;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;


public class Main {
    public static void main(String[] args){

//        ShapeParameters shapeParameters = new ShapeParameters();
        ShapeList shapeList = new ShapeList();
        PaintCanvas paintCanvas = new PaintCanvas(shapeList);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState,shapeList,paintCanvas);
        MyMousehandler mousehandler = new MyMousehandler(shapeList,appState,paintCanvas);
        paintCanvas.addMouseListener(mousehandler);

        controller.setup();












//        rectangle.draw();


        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Filled in rectangle
//        graphics2d.setColor(Color.GREEN);

//        graphics2d.fillRect(1, 100, 200, 400);
//
//        graphics2d.fillRect(20,40,600, 700);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
    }
}
