import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean menuActive=true;
    int currentLevel=1;
    boolean LevelSelect=false;
    int level_available;
    
    BackLevelSelect backLevelSelect;
    public void act()
    {
        // Add your action code here.
        World world = this.getWorldOfType(GameWorld.class);
        //if level button pressed set current level to that (goes trough all levelbuttons and looks if any of them have been preesed)
        // and set levelselect aswell as menu active to false
        for (LevelButton btn : world.getObjects(LevelButton.class)) {
            if (btn.getPressed()) {
                currentLevel = btn.getLevel_ID();
                LevelSelect = false;
                menuActive = false;
                return; 
            }
        }
        // if levelSelcetButton exists set this.levelselect to level select in levelselectbutton
        if (!(world.getObjects(LevelSelectButton.class).isEmpty())){
            LevelSelect=this.getWorldOfType(GameWorld.class).getObjects(LevelSelectButton.class).get(0).getLevelSelect();
        }
        // if backLevelSelect exists
        System.out.println("LevelSelectButton count: " + world.getObjects(LevelSelectButton.class).size());
for (int i = 0; i < world.getObjects(LevelSelectButton.class).size(); i++) {
    System.out.println("Button " + i + ": " + world.getObjects(LevelSelectButton.class).get(i).LevelSelect);
}
        if (backLevelSelect!=null){
            // if level selcet in back level select is false remove levelbuttons and back levelselect aswell as add levelselectbutton and set levelselect to false
            if (!backLevelSelect.getLevelSelect()){
                world.removeObject(backLevelSelect);
                backLevelSelect=null;
                world.removeObjects(this.getWorld().getObjects(LevelButton.class));
                world.addObject(new LevelSelectButton(),100,100);
                LevelSelect=false;
            }
        }
        // if this.levelselect= true remove level select button and add all the levelbuttons aswell as backlevelselect
        if (LevelSelect){
            backLevelSelect=new BackLevelSelect();
            this.getWorld().addObject(backLevelSelect,400,200);
            for(int i=0;i<level_available;i++){
                this.getWorld().addObject(new LevelButton(i+1),100*i+100,100);
            }
            this.getWorld().removeObjects(this.getWorld().getObjects(LevelSelectButton.class));
            LevelSelect=false;
        }
    }
    public Menu(){
         menuActive=true;
        
    }
    public Menu(int level_available){
         menuActive=true;
        this.level_available=level_available;
        this.backLevelSelect = null;
    }
    
    public void setSize(int x,int y){
        this.getImage().scale(x,y);
    }
    public boolean Click(){
        return Greenfoot.mousePressed(this);
    }
    public boolean menuActive(){
        return menuActive;
    }
    public int getCurrentLevel(){
        return currentLevel;
    }
}
