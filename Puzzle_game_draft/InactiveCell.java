import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InactiveCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InactiveCell extends Cell
{
    /**
     * Act - do whatever the InactiveCell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public InactiveCell(int cellSize, int cellState){
        
        if (cellState >= 8 && cellState<16){
            
            if (cellState == 8){
                this.setImage("Wall_Inactive_TopandRightandLeft_State8.png.png");
            }
            else if (cellState == 9){
                this.setImage("Wall_Inactive_TopandBottomandLeft_State9.png.png");
            }
            else if (cellState == 10){
                this.setImage("Wall_Inactive_LeftandRightandBottom_State10.png.png");
            }
            else if (cellState == 11){
                this.setImage("Wall_Inactive_All_State11.png.png");
            }
            else if (cellState == 12){
                this.setImage("Wall_Inactive_RightandTop_State12.png.png");
            }
            else if (cellState == 13){
                this.setImage("Wall_Inactive_RightandBottom_State13.png.png");
            }
            else if (cellState == 14){
                this.setImage("Wall_Inactive_LeftandTop_State14.png.png");
            }
            else if (cellState == 15){
                this.setImage("Wall_Inactive_LeftandBottom_State15.png.png");
            }
        }
        else if (cellState < 8){
            if (cellState == 1){
                this.setImage("Wall_Inactive_Bottom_State1.png.png");
            }
            else if (cellState == 2){
                this.setImage("Wall_Inactive_Left_State2.png.png");
            }
            else if (cellState == 3){
                this.setImage("Wall_Inactive_Right_State3.png.png");
            }
            else if (cellState == 4){
                this.setImage("Wall_Inactive_Top_State4.png.png");
            }
            else if (cellState == 5){
                this.setImage("Wall_Inactive_LeftandRight_State5.png.png");
            }
            else if (cellState == 6){
                this.setImage("Wall_Inactive_BottomandTop_State6.png.png");
            }
            else if (cellState == 7){
                this.setImage("Wall_Inactive_TopandRightandBottom_State7.png.png");
            }
        
        }
        else {
            this.setImage("Wall_Inactive_No_State16.png.png");
    
        } 
        setSize(cellSize,cellSize);
    }
    public void act()
    {
        // Add your action code here.
        
    }
}
