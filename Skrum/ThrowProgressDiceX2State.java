import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ThrowProgressDiceX2State extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public ThrowProgressDiceX2State(Player p, int x, int y)
    {
         super(p, x, y);
         if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceX2State:ThrowProgressDiceX2State(Player,x,y)");} 
    }
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceX2State:doAction()");} 
        player.world().setPorgressDiceActive();
        player.world().setMainDiceInActive();
    }
      
     /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
        if(DEBUG_FLAG) { System.out.println("ThrowProgressDiceX2State:burnUpDownUpdate(int):"+totalHours);} 
        int hours = -(2*totalHours);
        player.world().updateBurnDownHours(hours);
    }
}
