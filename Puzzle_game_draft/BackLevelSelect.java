import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class backLeveSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackLevelSelect extends LevelSelectMenu
{
    /**
     * Act - do whatever the backLeveSelect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean LevelSelectb=true;
    public void act()
    {
        // Add your action code here.
        // when clicked set levelselectb to false
        if (Click()){
            LevelSelectb=false;
        }
    }
    public BackLevelSelect(){
        
    }
    public boolean getLevelSelect(){
        return LevelSelectb;
    }
}
