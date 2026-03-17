import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LevelCache here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCache 
{
    
    Map<Integer, List<Integer>> levels = new HashMap<>();
    List<Integer> Level_2 =List.of(100,
                             0,0,0,0,1,1,0,0,0,0,
                             0,0,0,1,1,1,0,0,0,0,
                             0,0,2,1,1,1,1,1,0,0,
                             0,0,1,1,1,1,1,3,0,0,
                             0,0,0,1,1,1,1,0,0,0,
                             0,0,0,0,1,1,0,0,0,0);
    List<Integer> Level_3 =List.of(100,
                             0,0,0,0,1,1,0,0,0,0,
                             0,0,0,0,1,1,3,0,0,0,
                             0,0,1,1,1,1,1,1,0,0,
                             0,0,1,1,1,1,1,1,0,0,
                             0,0,0,2,1,1,1,0,0,0,
                             0,0,0,0,1,1,0,0,0,0);
    List<Integer> Level_4 =List.of(100,
                             0,0,0,0,1,1,1,0,0,0,
                             0,0,0,0,1,1,1,0,0,0,
                             0,0,1,1,2,3,1,1,0,0,
                             0,0,1,1,0,0,1,1,0,0,
                             0,0,0,1,1,1,1,0,0,0,
                             0,0,0,0,1,1,0,0,0,0);
    List<Integer> Level_5 =List.of(50,
                             0,0,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0,0,0,0,
                             0,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,0,0,0,0,
                             1,1,1,1,2,3,1,0,1,1,1,1,1,1,1,0,0,0,0,0,
                             1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,
                             0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,
                             0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,
                             0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,
                             0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,
                             0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,1,1,1,
                             0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,1,
                             0,0,0,0,1,0,1,1,0,0,0,0,0,0,1,1,1,1,1,1,
                             0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0);
    List<Integer> Level_1 =List.of(100,
                             0,0,0,0,0,0,0,0,0,0,
                             0,0,0,0,0,0,0,0,0,0,
                             0,0,2,3,0,0,0,0,0,0,
                             0,0,0,0,0,0,0,0,0,0,
                             0,0,0,0,0,0,0,0,0,0,
                             0,0,0,0,0,0,0,0,0,0);
     /**
     * Constructor for objects of class LevelCache.
     * 
     */
    public LevelCache()
    {        
          //Puts levels into hash map
          levels.put(1, Level_1);
          levels.put(2, Level_2);
          levels.put(3, Level_3);
          levels.put(4, Level_4);
          levels.put(5, Level_5);
    }
    public List getLevel(int level_ID){
        return levels.get(level_ID);
    }
    public Map getLevels(){
        return levels;
    }
}
