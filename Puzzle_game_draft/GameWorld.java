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
    boolean StoryMode=false;
    boolean LevelActive=false;
    int currentLevel=1;
    int currentStory=1;
    static final int screenWidth=1000;
    static final int screenHeight=600;
    StartCell startCell;
    Menu menu;
   
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with screenwidthXscreenheight cells with a cell size of 1x1 pixels.
        super(screenWidth, screenHeight, 1); 
        menu = new Menu(level_available);
        this.addObject(menu,-20,-20);
        this.addObject(new StoryMode(),-20,-20);
        this.addObject(new StoryModeSelect(),100,100);
        this.addObject(new LevelSelectButton(),200,200);
        this.getBackground().scale(screenWidth,screenHeight);
    }
    public void act(){
        //if there is a menu 
        if(! (menu==null)){
            //if menu.menuactive=false and this.levelactive=false set level active to true and load level
        if (!menu.menuActive()&&!LevelActive){
            LevelActive=true;
            currentLevel=menu.getCurrentLevel();
            
            loadLevel(currentLevel);
            menu=null;
        }
      }
      if (StoryMode && !LevelActive){
           loadLevel(currentStory);
           LevelActive=true;
      }
      if (menu != null){
          StoryMode=menu.getStoryMode();
      }
                
        if(startCell != null ){
            if ( startCell.beaten()){
                if (StoryMode){
                    if (getLevels().size()==currentStory){
                        removeObjects(getObjects(Actor.class));
                        StoryMode=false;
                        
                        LevelActive=false;
                        menu=null;
                        currentStory=1;
                        menu=new Menu(level_available);
                        this.addObject(menu,0,0);
                   this.addObject(new StoryModeSelect(),100,100);
                   this.addObject(new LevelSelectButton(), 200, 200);
                    }
                    else{
                    currentStory++;
                    loadLevel(currentStory);
                }
                }
                else{
                LevelActive=false;
                if (level_available==getLevels().size()){
                    
                }
                else if (level_available<currentLevel+1){
                    level_available=currentLevel+1;
                }
                removeObjects(getObjects(Actor.class));
                startCell=null;
                menu = new Menu(level_available);
                this.addObject(menu,0,0);
                this.addObject(new StoryModeSelect(),100,100);
                this.addObject(new LevelSelectButton(), 200, 200);
              }
                  }
                    }                       }
    public void loadLevel(int level)
    {
        removeObjects(getObjects(Actor.class)); 
        createGrid(level);
    } 
   
    public StartCell getStartCell() {
        return startCell;
    }
    public List getLevel(int level_ID){
        return levelcache.getLevel(level_ID); //get level from levelcache
    }
    public Map getLevels(){
        return levelcache.getLevels();
    }
    public boolean getstart(){
        return startCell != null && startCell.getstart();
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
                    startCell = new StartCell(cellSize);
                    addObject(startCell, x, y);
                }
                else if(current == 3){
                    addObject(new EndCell(cellSize), x, y);
                }
            }
        }
        
    }
}
