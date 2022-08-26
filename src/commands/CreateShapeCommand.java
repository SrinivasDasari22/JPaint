package commands;

import model.ShapeList;
import model.ShapeParameters;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.gui.*;

import java.io.IOException;
import java.util.ArrayList;

public class CreateShapeCommand implements ICommand,IUndoable{



    ShapeFactory shapeFactory = new ShapeFactory();
    private ShapeParameters shapeParameters;

    private ShapeList shapeList;
    private IDraw shape;

    public PaintCanvas paintCanvas;


    public CreateShapeCommand(PaintCanvas paintCanvas, ShapeParameters shapeParameters, ShapeList shapeList) {
        this.shapeParameters = shapeParameters;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;

    }


    @Override
    public void redo() {

        shapeList.addShape(shape);
        paintCanvas.update();

    }

    @Override
    public void undo() {

        shapeList.removeShape(shape);
        paintCanvas.update();
    }
    @Override
    public void run() {


        shape = shapeFactory.createShape(shapeParameters);
        this.shapeList.addShape(shape);
        paintCanvas.update();
        CommandHistory.add(this);

    }

}
