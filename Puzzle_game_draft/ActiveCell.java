import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ActiveCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActiveCell extends Cell
{
    /**
     * Act - do whatever the ActiveCell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean checked=false;
    public ActiveCell(int cellSize){
        this.cellSize=cellSize;
        setSize(cellSize,cellSize);
    }
    public boolean getchecked(){
        return checked;
    }
    public void act()
    {
        // Add your action code here.
        
        for(int i=0;i<this.getWorldOfType(GameWorld.class).startCell.getListOfAlredyActiveCells().size();i++){
            if (this.getWorldOfType(GameWorld.class).startCell.getListOfAlredyActiveCells().contains(this)){            
                checked=true;
                break;
            }
            else{
                checked=false;
            }
        }
        
        if(checked){
            if (this.getWorldOfType(GameWorld.class).startCell.getCurrentCell() == this){
                this.setImage("Active_tile_on_current.png.png");
            }
            else{
                this.setImage("Active_tile_on.png.png");
            }
        }
        
        else {
            this.setImage("Active_tile_off.png.png");
        }
        if(!this.getWorldOfType(GameWorld.class).getstart()){
            checked=false;
        }
        setSize(cellSize,cellSize);
    }
    
}
