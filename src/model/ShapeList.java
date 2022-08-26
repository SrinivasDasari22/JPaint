package model;

import model.interfaces.IDraw;

import java.util.ArrayList;

public class ShapeList {

    private ArrayList<IDraw> arrayList;

    private ArrayList<IDraw> selectedList;

    private ArrayList<IDraw> copiedList;

    public ShapeList(){
        arrayList = new ArrayList<IDraw>();
        selectedList = new ArrayList<IDraw>();
        copiedList = new ArrayList<IDraw>();

    }

//    public ArrayList<IDraw> groupedList(){
//        ArrayList<IDraw> group_list = new ArrayList<>();
//        return group_list;
//    }

    public void addShape(IDraw shape){
        arrayList.add(shape);
    }
    public void removeShape(IDraw shape){
        arrayList.remove(shape);

    }


    public void addSelectedShape(IDraw shape){
        selectedList.add(shape);
//        System.out.println("in shapelist add ,,select ::"+ selectedList);

    }
    public void removeSelectedShape(IDraw shape){
        selectedList.remove(shape);
    }

    public ArrayList<IDraw> getSelectedList(){
        return selectedList;
    }

    public void removeAllSelectedShapes(){
        selectedList.clear();
//        System.out.println("in shapelist clear ,,select ::"+ selectedList);
    }
    public void removeAllCopiedShapes(){
        copiedList.clear();
    }

    public ArrayList<IDraw> getArrayList() {
        return arrayList;
    }

    public void addCopiedShape(IDraw shape){
        copiedList.add(shape);
    }

    public ArrayList<IDraw> getCopiedList(){
        return copiedList;
    }

    public void removeCopiedList(){
        copiedList.clear();
    }

}
