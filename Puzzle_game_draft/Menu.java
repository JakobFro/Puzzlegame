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
    
    public void act()
    {
        // Add your action code here.
        //if level button pressed set current level to that (goes trough all levelbuttons and looks if any of them have been preesed)
        // and set levelselect aswell as menu active to false
        for (int i =0;i<this.getWorld().getObjects(LevelButton.class).size();i++){
            if(this.getWorld().getObjects(LevelButton.class).get(i).getPressed()){
                currentLevel=this.getWorld().getObjects(LevelButton.class).get(i).getLevel_ID();
                LevelSelect=false;
                menuActive=false;
            }
        }
        // if levelSelcetButton exists set this.levelselect to level select in levelselectbutton
        if (!(this.getWorld().getObjects(LevelSelectButton.class).isEmpty())){
            LevelSelect=this.getWorld().getObjects(LevelSelectButton.class).get(0).getLevelSelect();
        }
        // if backLevelSelect exists
        if (!(this.getWorld().getObjects(BackLevelSelect.class).isEmpty())){
            // if level selcet in back level select is false remove levelbuttons and back levelselect aswell as add levelselectbutton and set levelselect to false
            if (!(this.getWorld().getObjects(BackLevelSelect.class).get(0).getLevelSelect())){
                this.getWorld().removeObjects(this.getWorld().getObjects(BackLevelSelect.class));
                this.getWorld().removeObjects(this.getWorld().getObjects(LevelButton.class));
                this.getWorld().addObject(new LevelSelectButton(),100,100);
                LevelSelect=false;
            }
        }
        // if this.levelselect= true remove level select button and add all the levelbuttons aswell as backlevelselect
        if (LevelSelect){
            this.getWorld().addObject(new BackLevelSelect(),400,200);
            for(int i=0;i<5;i++){
                this.getWorld().addObject(new LevelButton(i+1),100*i+100,100);
            }
            this.getWorld().removeObjects(this.getWorld().getObjects(LevelSelectButton.class));
            LevelSelect=false;
        }
    }
    public Menu(){
        boolean menuActive=true;
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
