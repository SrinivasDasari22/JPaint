package model.persistence;

import commands.SelectShapeCommand;
import model.ShapeList;
import model.ShapeParameters;
import model.interfaces.IStateMouse;
import view.gui.PaintCanvas;

public class SelectMouseState implements IStateMouse {

    @Override
    public void run(PaintCanvas paintCanvas, ShapeParameters shapeParameters, ShapeList shapeList) {

        SelectShapeCommand selectShapeCommand = new SelectShapeCommand(shapeParameters,shapeList,paintCanvas);
        selectShapeCommand.run();
    }
}
