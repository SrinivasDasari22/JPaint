package model.interfaces;

import model.ShapeList;
import model.ShapeParameters;
import view.gui.PaintCanvas;

public interface IStateMouse {

    void run(PaintCanvas paintCanvas, ShapeParameters shapeParameters, ShapeList shapeList);

}
