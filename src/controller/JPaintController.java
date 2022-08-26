package controller;

import commands.*;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    private ShapeList shapeList;
    private PaintCanvas paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList, PaintCanvas paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, this::undo);
        uiModule.addEvent(EventName.REDO, this::redo);
        uiModule.addEvent(EventName.COPY, this::copy);
        uiModule.addEvent(EventName.PASTE,this::paste);
        uiModule.addEvent(EventName.DELETE,this::delete);
        uiModule.addEvent(EventName.GROUP,this::group);
        uiModule.addEvent(EventName.UNGROUP,this::ungroup);

    }


    public void undo(){
        UndoCommand undoCommand = new UndoCommand();
        undoCommand.run();
    }

    public void redo(){

        RedoCommand redoCommand = new RedoCommand();
        redoCommand.run();
    }

    public void copy(){
        CopyCommand copyCommand = new CopyCommand(shapeList);
        copyCommand.run();
    }

    public void paste(){
        PasteCommand pasteCommand = new PasteCommand(shapeList,paintCanvas,applicationState);
        pasteCommand.run();
    }

    public void delete(){
        DeleteCommand deleteCommand = new DeleteCommand(shapeList,paintCanvas);
        deleteCommand.run();
    }

    public void group(){
        GroupCommand groupCommand = new GroupCommand(shapeList,paintCanvas);
        groupCommand.run();
    }
    public void ungroup(){
        UngroupCommand ungroupCommand = new UngroupCommand(shapeList,paintCanvas);
        ungroupCommand.run();
    }
}
