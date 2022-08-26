package Proxys;

import model.ShapeList;
import model.ShapeParameters;
import model.ShapeType;
import model.interfaces.IDraw;
import model.interfaces.IProxyOutline;
import view.gui.PaintCanvas;

import java.awt.*;

public class ShapeOutline implements IProxyOutline {



    private Graphics2D graphics;

    private ShapeParameters shapeParameters;

    RectangleOutline rectangleOutline = new RectangleOutline();
    TrainagleOutline trainagleOutline = new TrainagleOutline();
    EllipseOutline ellipseOutline = new EllipseOutline();

    public ShapeOutline(ShapeParameters shapeParameters,Graphics2D graphics){
        this.graphics = graphics;
        this.shapeParameters = shapeParameters;
    }
    @Override
    public void drawOutline() {

        if(shapeParameters.getShapeType().equals(ShapeType.RECTANGLE)){

            rectangleOutline.draw(shapeParameters,graphics);
        }
        if(shapeParameters.getShapeType().equals(ShapeType.TRIANGLE)){

            trainagleOutline.draw(shapeParameters,graphics);
        }
        if(shapeParameters.getShapeType().equals(ShapeType.ELLIPSE)){

            ellipseOutline.draw(shapeParameters,graphics);
        }
    }
}
