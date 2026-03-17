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
        System.out.println("LevelSelectButton.act() called");
        MouseInfo mouse = Greenfoot.getMouseInfo();
    
    
        if (Greenfoot.mouseClicked(this)){
            LevelSelect=true;
        }
        
    }
    public LevelSelectButton(){
        // sets size to 100X100
        setImage("balloon2.png");
        setSize(100,100);
    }
    public boolean getLevelSelect(){
        return LevelSelect;
    }
}
