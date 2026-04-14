import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Cell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class Cell extends Actor
{
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int cellSize;
    public void act()
    {
        // Add your action code here.
    }
    public void setSize(int x,int y){
        this.getImage().scale(x,y);
    }
    public boolean click(){
        return Greenfoot.mousePressed(this);
    }
    
    public boolean hover(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return false;

        // get mouse position
        int mx = mouse.getX();
        int my = mouse.getY();

        // check if mouse is inside this cell
        int left   = getX() - cellSize / 2;
        int right  = getX() + cellSize / 2;
        int top    = getY() - cellSize / 2;
        int bottom = getY() + cellSize / 2;

        return mx >= left && mx <= right && my >= top && my <= bottom;
    }
}
