package model.persistence;

import commands.CreateShapeCommand;
import model.ShapeList;
import model.ShapeParameters;
import model.interfaces.IStateMouse;
import view.gui.PaintCanvas;

public class DrawMouseState implements IStateMouse {

    @Override
    public void run(PaintCanvas paintCanvas, ShapeParameters shapeParameters, ShapeList shapeList) {

        shapeList.removeAllSelectedShapes();
        shapeList.removeAllCopiedShapes();

        CreateShapeCommand createShape = new CreateShapeCommand(paintCanvas, shapeParameters, shapeList);
        createShape.run();
    }
}
