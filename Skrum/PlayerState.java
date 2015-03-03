import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Arrays; //codechanges APOORVA GOUNI

/**
 * Write a description of class PlayerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public abstract class PlayerState extends Actor
{
    private boolean DEBUG_FLAG = true;
    Player player;
    int x;
    int y;
    PlayerState(Player p, int x, int y)
    {
        if(DEBUG_FLAG) { System.out.println("PlayerState:PlayerState(Player,x,y)"); }
        this.player = p;
        this.x = x;
        this.y = y;
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void activate()
    {
        if(DEBUG_FLAG) { System.out.println("PlayerState:activate()"); }
        player.setDimension(x + Greenfoot.getRandomNumber(20), y + Greenfoot.getRandomNumber(20));
    }
    public void throwDice(int total)
    {
       if(DEBUG_FLAG) { System.out.println("PlayerState:throwDice(int):"+total); }
       if(player.world().isMainDiceActive())
       {
            if(total != 0)
            {
                player.move(total);
            }
        }
    }
    public int throwProgressDice(int total)
    {
       if(DEBUG_FLAG) { System.out.println("PlayerState:throwProgressDice(int):"+total); }
       if(player.world().isProgressDiceActive())
       {
           player.world().resetPorgressDiceActive();
           player.world().switchUser();
           player.world().resetMainDiceActive();
           return total;
       }
       return 0;
    }
    public void pickTool()
    {
    }
    public void pickImpediment()
    {
    }
    public void pickOpportunity(OpportunityStrategy s)
    {
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
        return false;
    }
   
}
