package commands;

import model.ShapeList;
import model.interfaces.IDraw;

public class CopyCommand implements ICommand {

    private ShapeList shapeList;


    public CopyCommand(ShapeList shapeList){
        this.shapeList = shapeList;
    }


    @Override
    public void run() {
        shapeList.removeCopiedList();

        for (IDraw shape : shapeList.getSelectedList()){
            shapeList.addCopiedShape(shape);
        }
    }

}
