package Proxys;

import model.ShapeParameters;
import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.awt.*;

public class EllipseOutline {



    public void draw(ShapeParameters shapeParameters, Graphics2D graphics){

//        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics.setStroke(stroke);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(shapeParameters.Start_point.getX_value()-5 , shapeParameters.Start_point.getY_value()-5, shapeParameters.getWidth()+10, shapeParameters.getHeight() + 10);
    }
}
