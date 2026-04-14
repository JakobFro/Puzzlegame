import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter=0;
    public void act()
    {
        // Add your action code here.
        if (counter >= 360){
            this.getWorld().removeObject(this);
        }
        if(Click()){
            this.getWorld().removeObject(this);
        }
        counter+=1;
    }
    public TextBox(String text){
        setImage(new GreenfootImage(text,30,null,null));
        //System.out.println("TextBox created");
    }
    public boolean Click(){
        return Greenfoot.mousePressed(this);
    }
}
