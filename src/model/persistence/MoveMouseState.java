package model.persistence;

import commands.MoveShapeCommand;
import model.ShapeList;
import model.ShapeParameters;
import model.interfaces.IStateMouse;
import view.gui.PaintCanvas;

public class MoveMouseState implements IStateMouse {

    @Override
    public void run(PaintCanvas paintCanvas, ShapeParameters shapeParameters, ShapeList shapeList) {

        MoveShapeCommand moveShapeCommand = new MoveShapeCommand(paintCanvas, shapeParameters, shapeList);
        moveShapeCommand.run();
    }
}
