import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class StartCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartCell extends ActiveCell
{
    /**
     * Act - do whatever the StartCell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    ActiveCell currentCell;
    boolean LevelBeaten=false;
    List<ActiveCell> ListOfAlredyActiveCells = new ArrayList<>();
    boolean start=false;
    public StartCell(int cellSize){
        super(cellSize);
        this.cellSize=cellSize;
    }
    public boolean getstart(){
        return start;
    }
    public boolean beaten(){
        return LevelBeaten;
    }
    public void act()
    {
        // Add your action code here.
        // if this cell is clicked start logic and reset needed stuff
      
        if (click()){
            start=true;
            this.setImage("InactiveCell.png.png");
            setSize(cellSize,cellSize);
            ListOfAlredyActiveCells.clear();
            currentCell=null;
        }
        if (start){
            // if mouse is not held and end cell is checked beat level
            if(Greenfoot.mouseClicked(null) && this.getWorld().getObjects(EndCell.class).get(0).getchecked()){
                LevelBeaten=true;
            }
            // if only the mouse is not held reset logic
            else if (Greenfoot.mouseClicked(null)){
                start=false;
                ListOfAlredyActiveCells.clear();
                currentCell=null;
                this.setImage("StartCell_StateOne.png.png");
                setSize(cellSize,cellSize);
            }
            // if there is an inactive cell under the mouse reset logic
            else if (getInactiveUnderMouse() != null) {
                start = false;
                ListOfAlredyActiveCells.clear();
                currentCell=null;
                setImage("StartCell_StateOne.png.png");
                setSize(cellSize, cellSize);
            }
            // if the mouse goes back to an alredy checked cell
            else if (getActiveUnderMouseCheckedAndNotInList()) {
                setImage("StartCell_StateOne.png.png");
                setSize(cellSize, cellSize);
                ListOfAlredyActiveCells.clear();
                currentCell=null;
                start = false;
            }
        }
    }
    private InactiveCell getInactiveUnderMouse() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return null;
    
        List<InactiveCell> cells = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), InactiveCell.class);
        return cells.isEmpty() ? null : cells.get(0);
    }
    public boolean getActiveUnderMouseCheckedAndNotInList(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return true;
       List<ActiveCell> cells = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), ActiveCell.class);
        //checks if there is a cell under the mouse
       if (cells.isEmpty()){
            return true;
        }
        //checks if the length of List of alredy active cells is biger than two entries
        else if (ListOfAlredyActiveCells.size()>2){
        // checks if second to last cell that got added 
        if (ListOfAlredyActiveCells.get(ListOfAlredyActiveCells.size()-2)==cells.get(0)){
            ListOfAlredyActiveCells.remove(ListOfAlredyActiveCells.size()-1);
            currentCell=cells.get(0);
            return false;
           }
        //checks if current cell is in listofalredyactivecell and is not equal to current cell
        else if (ListOfAlredyActiveCells.remove(cells.get(0)) && !(cells.get(0)==currentCell) ){
            return true;
        }
        else  {
            ListOfAlredyActiveCells.add(cells.get(0));
            currentCell=cells.get(0);
            return false;
        }
      }
        else {
            ListOfAlredyActiveCells.add(cells.get(0));
            currentCell=cells.get(0);
            return false;
        }
    
        
    }
    public List getListOfAlredyActiveCells(){
        return ListOfAlredyActiveCells;
    }
}
