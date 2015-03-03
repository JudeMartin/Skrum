import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThrowProgressDiceState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThrowProgressDiceState extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public ThrowProgressDiceState(Player p, int x, int y)
    {
        super(p, x, y);
         if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceState:ThrowProgressDiceState(Player,x,y)");} 
    }
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
       if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceState:doAction()");} 
       player.world().setPorgressDiceActive();
       player.world().setMainDiceInActive();
    }
    
     /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
        if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceState:burnUpDownUpdate(int):"+totalHours);} 
        int hours = -(totalHours);
        player.world().updateBurnDownHours(hours);
    }
}
