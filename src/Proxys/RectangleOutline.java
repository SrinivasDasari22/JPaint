package Proxys;

import model.ShapeParameters;
import model.interfaces.IDraw;
import view.gui.PaintCanvas;

import java.awt.*;



public class RectangleOutline {
    public void draw(ShapeParameters shapeParameters, Graphics2D graphics2D){



//        System.out.println((shapeParameters.Start_point.getX_value()-5)+",,"+ (shapeParameters.Start_point.getY_value()-5 ));

        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.BLACK);

        graphics2D.drawRect(shapeParameters.Start_point.getX_value()-5 , shapeParameters.Start_point.getY_value()-5, shapeParameters.getWidth()+10, shapeParameters.getHeight() + 10);
    }
}
