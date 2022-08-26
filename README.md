# SE_450_JPaint_Project
###### **SE - 450 Object-Oriented Software Development**

---

### FEATURES

It will have the following features:
- Pick a shape 

  - Ellipse 
  - Triangle
  - Rectangle
- Pick a primary color
- Pick a secondary color
- Select shading type (outline only, filled-in, outline and filled-in)
- Click and drag to draw a shape
- Click and drag to select shapes
- Click and drag to move selected shapes
- Copy selected shapes
- Paste copied shapes
- Delete selected shapes
- Undo last action
- Redo last action
- Group selected shapes
- Ungroup selected shapes
- Selected shapes have dashed outline


### LIST OF MISSING FEATURES

- None

All the features are working as expected. None of them are left.

### BUGS

- Offset for shape which has pasted, will vary has paste uses on. But size and parameters will remain the same as expected.

### EXTRA CREDIT

- Total of six Design patterns are implemented.

### MISCELLANEOUS NOTES

- For selecting the group, instead of clicking on the group boundary, we  need to click on any of the shapes in the group.

### GITHUB REPOSITORY LINK

- [GitHub Link](https://github.com/DasariHNNSKSrinivasaRao/SE_450_JPaint_Project)

### List of Design patterns

- **Six Design Patterns Implemented :**
    
      1. Strategy Pattern
      2. Command pattern
      3. Proxy Pattern
      4. State pattern
      5. NullObject Pattern
      6. Singleton Pattern



- Design patterns implemented for sprint 2 are Strategy pattern and command pattern.


- Design patterns implemented for sprint 3 are proxy pattern and state pattern.


- Design patterns implemented for sprint 4 are NullObject pattern and Singleton pattern.



**_Interfaces and Classes involved_**

1. Strategy pattern:


    Interface : IDraw
    
    Classes : Triangle, Ellipses , Rectangle

2. Command pattern:


    Interfaces : ICommand, IUndoable
    
    Classes : UndoCommand, RedoCommand, SelectShapeCommand, MoveShapeCommand, CreateShapeCommand, CopyCommand, PasteCommand, DeleteCommand, GroupCommand, UngroupCommand

3. Proxy pattern:


    Interface : IProxyOutline
    
    Classes : ShapeOutlineProxy, ShapeOutline, RectangleOutline, TriangleOutline, EllipseOutline

4. State Pattern:


    Interface : IStateMouse
    
    Classes : MoveMouseState, SelectMouseState, DrawMouseState, MyMouseHandler 

5. Null Object Pattern:


    Interface used : IDraw
    
    Class used : NullShape

6. Singleton Pattern:


    Class used: SingletonColor