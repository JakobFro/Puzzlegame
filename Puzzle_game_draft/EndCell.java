import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class EndCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndCell extends ActiveCell
{
    /**
     * Act - do whatever the EndCell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean check=true;
    
    List<ActiveCell> cells =List.of() ;
    public EndCell(int cellSize){
        super(cellSize);
    }
    public void act()
    {
        // Add your action code here.
        
        cells=this.getWorldOfType(GameWorld.class).getObjects(ActiveCell.class);
        cells.removeAll(getWorldOfType(GameWorld.class).getObjects(EndCell.class));
        cells.removeAll(getWorldOfType(GameWorld.class).getObjects(StartCell.class));
        check=true;
            for (int i=0;i<cells.size();i++){
            if (!cells.get(i).getchecked()){
                check=false;
                
            }
          }
        if (this.getWorldOfType(GameWorld.class).getstart() && hover()){
           //checks if all other cells have been filled
           
          if (check){  
              checked=true;
            }
            
            
        }
        if(checked){
            this.setImage("InactiveCell.png.png");
        }
        else {
            this.setImage("EndCell-2.png.png");
        }
        if(!this.getWorldOfType(GameWorld.class).getstart()){
            checked=false;
        }
        setSize(cellSize,cellSize);
    }
}
