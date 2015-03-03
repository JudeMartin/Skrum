import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class StartState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class StartState extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public StartState(Player p, int x, int y)
    {
        super(p, x, y);
        if(DEBUG_FLAG) { System.out.println("StartState:StartState(Player,x,y)");} 
    }
    
    public void throwDice(int value)
    {
        if(DEBUG_FLAG) { System.out.println("StartState:throwDice(int):"+value);} 
       if(!player.isSprintPlanDone())
        {
            player.startPlanning();
            Greenfoot.delay(500);
            player.world().addSecondDice();
        }
        super.throwDice(value);
    }
    

    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
    }

     /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
    }
    public boolean isAutoUserSwitch()
    {
        return true;
    }
}
