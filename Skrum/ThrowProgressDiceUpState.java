import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThrowProgressDiceUpState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThrowProgressDiceUpState extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public ThrowProgressDiceUpState(Player p, int x, int y)
    {
        super(p, x, y);
         if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceUpState:ThrowProgressDiceUpState(Player,x,y)");} 
    }   
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceUpState:doAction()");} 
        player.world().setPorgressDiceActive();
        player.world().setMainDiceInActive();
    }
    
     /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
        if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceUpState:burnUpDownUpdate(int):"+totalHours);} 
        int hours = totalHours;
        player.world().updateBurnDownHours(hours);
    }
}
