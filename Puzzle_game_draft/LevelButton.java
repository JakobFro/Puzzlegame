import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelButton extends LevelSelectMenu
{
    /**
     * Act - do whatever the LevelButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int Level_ID;
    
    boolean pressed=false;
    public LevelButton(int Level_ID){
       this.Level_ID=Level_ID; 
       setSize(50,50);
       GreenfootImage TextImag =new GreenfootImage(Integer.toString(Level_ID), 64, new Color(255,255,255), null);    
        this.getImage().drawImage(TextImag,10,-5);
    }
    public void act()
    {
        // Add your action code here.
        //when clicked set pressed to true for menu logic to spawn the level
        if (Click()){
            pressed=true;
        }
    }
    public boolean getPressed(){
        return pressed;
    }
    public int getLevel_ID(){
        return Level_ID;
    }
}
