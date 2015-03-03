import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BurnDownState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BurnDown25State extends PlayerState
{
    int hours = 0;
    Player player;
    private boolean DEBUG_FLAG = true;
    public BurnDown25State(Player p, int x, int y)
    {
        super(p, x, y);
        if(DEBUG_FLAG) { System.out.println("BurnDown25State:BurnDown25State(Player,x,y)");} 
        this.hours = -25;
        this.player = p;
    }
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("BurnDown25State:doAction()");} 
        player.world().updateBurnDownHours(this.hours);
        player.world().resetMainDiceActive();
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
