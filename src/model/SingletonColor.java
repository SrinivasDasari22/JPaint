package model;

import model.ShapeColor;
import java.util.EnumMap;
import java.awt.Color;


public class SingletonColor {

    private static SingletonColor singletonColor =new SingletonColor();
    private SingletonColor() {
    }

    private static final EnumMap<ShapeColor, Color> color = new EnumMap<>(ShapeColor.class);

    static {

        color.put(ShapeColor.GREEN, Color.GREEN);
        color.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        color.put(ShapeColor.MAGENTA, Color.MAGENTA);
        color.put(ShapeColor.ORANGE, Color.ORANGE);
        color.put(ShapeColor.PINK, Color.PINK);
        color.put(ShapeColor.RED, Color.RED);
        color.put(ShapeColor.WHITE, Color.WHITE);
        color.put(ShapeColor.YELLOW, Color.YELLOW);
        color.put(ShapeColor.BLACK, Color.BLACK);
        color.put(ShapeColor.BLUE, Color.BLUE);
        color.put(ShapeColor.CYAN, Color.CYAN);
        color.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        color.put(ShapeColor.GRAY, Color.GRAY);


    }



    public static Color getColor(ShapeColor Color) {


        return color.get(Color);


    }

}