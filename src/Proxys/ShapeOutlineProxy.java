package Proxys;

import model.ShapeParameters;
import model.interfaces.IProxyOutline;
import view.gui.PaintCanvas;

import java.awt.*;
import java.lang.reflect.Array;

public class ShapeOutlineProxy  implements IProxyOutline {

    private ShapeParameters shapeParameters;

    private Graphics2D graphics;

    private ShapeOutline shapeOutline;

    public ShapeOutlineProxy(ShapeParameters shapeParameters, Graphics2D graphics ){
        this.shapeParameters = shapeParameters;
        this.graphics = graphics;

        shapeOutline = new ShapeOutline(shapeParameters,graphics);

    }
    @Override
    public void drawOutline() {
        shapeOutline.drawOutline();

    }
}
