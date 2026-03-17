import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    LevelCache levelcache =new LevelCache();
    List<Integer> temp =Collections.<Integer>emptyList();
    int cellSize;
    int cellsPerRow;
    int level_available=1;
    int cellsPerFile;
    int current;
    boolean LevelActive=false;
    int currentLevel=1;
    static final int screenWidth=1000;
    static final int screenHeight=600;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with screenwidthXscreenheight cells with a cell size of 1x1 pixels.
        super(screenWidth, screenHeight, 1); 
        this.addObject(new Menu(level_available),0,0);
        this.addObject(new LevelSelectButton(),100,100);
        this.getBackground().scale(screenWidth,screenHeight);
    }
    public void act(){
        //if there is a menu 
        if(!this.getObjects(Menu.class).isEmpty()){
            //if menu.menuactive=false and this.levelactive=false set level active to true and load level
        if (!this.getObjects(Menu.class).get(0).menuActive()&&!LevelActive){
            LevelActive=true;
            currentLevel=this.getObjects(Menu.class).get(0).getCurrentLevel();
            loadLevel(currentLevel);
        }
      }
        if(!this.getObjects(StartCell.class).isEmpty()){
            if (this.getObjects(StartCell.class).get(0).beaten()){
                LevelActive=false;
                level_available=currentLevel+1;
                removeObjects(getObjects(Actor.class));
                this.addObject(new Menu(level_available),0,0);
                this.addObject(new LevelSelectButton(),100,100);
            }
        }
    }
    public void loadLevel(int level)
    {
        removeObjects(getObjects(Actor.class)); // clear grid
        createGrid(level);
    }  
    public List getLevel(int level_ID){
        return levelcache.getLevel(level_ID); //get level from levelcache
    }
    public boolean getstart(){
        return this.getObjects(StartCell.class).get(0).getstart();
    }
    public void createGrid(int level_ID){
        //gets the level map from LevelCache for a specific level
        temp = getLevel(level_ID);
        //gets the cellSize from the level map
        cellSize= temp.get(0);
        //calculates cells per row and file for further operations
        cellsPerRow=screenWidth/cellSize;
        cellsPerFile=screenHeight/cellSize;
        /**
         * iterates trough every location of file and row to crate a cell there
         * in acordance with the level map. Here is b 0 at the beginning so that
         * current which is the index doesnt directly go to cells per row as it
         * gets multipied by that i however is 1 as it has to start at one not 0 
         * since we have cellsize at 0. trough this however we lose a row since
         * we now iterste trough 1-cellsperrow so we add 1 to cellsperrow.
         */
         for(int b = 0; b < cellsPerFile; b++){
            for(int i = 1; i < cellsPerRow+1; i++){
                current=temp.get(b*cellsPerRow+i);
                //where the current cell is +1 to b as if b==0 then it would have a negative koordinate which is imposible
                int x = i * cellSize - cellSize / 2;
                int y = (b+1) * cellSize - cellSize / 2;
                //checks which type of cell it is

                if (current == 0){
                    addObject(new InactiveCell(cellSize), x, y);
                }
                else if(current == 1){
                    addObject(new ActiveCell(cellSize), x, y);
                }
                else if(current == 2){
                    addObject(new StartCell(cellSize), x, y);
                }
                else if(current == 3){
                    addObject(new EndCell(cellSize), x, y);
                }
            }
        }
        
    }
}
