import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelectButton extends MainMenu
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean LevelSelect=false;
    public void act()
    {
        // Add your action code here.
        // when clicked set levelselect to true
        
    
    
        if (Click()){
            LevelSelect=true;
        }
        
    }
    public LevelSelectButton(){
        // sets size to 100X100
        GreenfootImage TextImag =new GreenfootImage("Level Select", 64, new Color(255,255,255), null);    
        this.setImage(TextImag);
        
    }
    public boolean getLevelSelect(){
        return LevelSelect;
    }
}
