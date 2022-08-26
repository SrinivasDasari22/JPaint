package view.gui;

import java.awt.Graphics2D;


import commands.GroupCommand;
import model.ShapeList;
import view.interfaces.PaintCanvasBase;
import model.interfaces.IDraw;
//import view.gui.Rectangle;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class PaintCanvas extends PaintCanvasBase {


    private final ShapeList shapeList;



    public PaintCanvas(ShapeList shapeList){
        this.shapeList = shapeList;
    }


    public void update(){
        System.out.println("update in paint canvas");
        repaint();
    }

    @Override
    public void paintComponent(Graphics gr){
        Graphics2D g = (Graphics2D)gr;
        ArrayList<GroupCommand> groupOutlineList = new ArrayList<>();
//        System.out.println("main in paint canvas"+shapeList.getArrayList());
//        System.out.println("Select in paint canvas"+shapeList.getSelectedList());
        for (IDraw shape : shapeList.getArrayList())
        {
//            System.out.println("orig:"+shape);
            shape.paint(g);

            if(shapeList.getSelectedList().contains(shape) && shape.getShapeGroup().isEmpty()){
//                System.out.println("orig in loop:"+shape);
                    shape.selectOutline(g);

            }else if(shapeList.getSelectedList().contains(shape) && !shape.getShapeGroup().isEmpty()){

                System.out.println("get Shape Group :::"+shape+"::::"+shape.getShapeGroup());
                GroupCommand groupCommand = shape.getShapeGroup().get(shape.getShapeGroup().size()-1);
                System.out.println("size of group" +shape.getShapeGroup().size());
                if(!groupOutlineList.contains(groupCommand)){
                    groupOutlineList.add(groupCommand);
                }
            }
        }


        System.out.println("Group Highlights:::"+groupOutlineList);
        for(GroupCommand group : groupOutlineList){
            ArrayList<IDraw> finalGroups = new ArrayList<>();
            for(IDraw shape5: shapeList.getArrayList()){
                if(!shape5.getShapeGroup().isEmpty()){
                    System.out.println("imp  ::;"+shape5+"shape group size"+ shape5.getShapeGroup());
                    GroupCommand groupCommand1 = shape5.getShapeGroup().get(shape5.getShapeGroup().size()-1);
                    if(group.equals(groupCommand1)){
                        finalGroups.add(shape5);
                    }
                }
            }
            groupOutline(g,finalGroups);

        }
    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    public void groupOutline(Graphics2D g,List<IDraw> groupList){
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        int x_min =0;
        int x_max = 0;
        int y_min =0;
        int y_max =0;

        for(IDraw shapes1 : groupList){
            x.add(shapes1.getShapeParametrs().getStart_point().getX_value());
            x.add(shapes1.getShapeParametrs().getEnd_Point().getX_value());
            y.add(shapes1.getShapeParametrs().getStart_point().getY_value());
            y.add(shapes1.getShapeParametrs().getEnd_Point().getY_value());

            x_min = Collections.min(x);
             x_max = Collections.max(x);
             y_min = Collections.min(y);
             y_max = Collections.max(y);

        }




        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        g.drawRect(x_min -5,y_min-5,x_max - x_min+10,y_max - y_min +10);

    }


}
