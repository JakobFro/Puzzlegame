import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoryModeSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryModeSelect extends StoryMode
{
    /**
     * Act - do whatever the StoryModeSelect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean StoryMode=false;
    public void act()
    {
        // Add your action code here.
        if (Click()){
            StoryMode=true;
            if (!(this.getWorldOfType(GameWorld.class).currentStory>1)){
                //this.getWorld().addObject(new TextBox("cheese"),500,300);
            }
        }
    }
    public StoryModeSelect(){
        GreenfootImage TextImag =new GreenfootImage("Play", 64, new Color(255,255,255), null);    
        this.setImage(TextImag);
    }
    public boolean StorySelect(){
        return StoryMode;
    }
}
