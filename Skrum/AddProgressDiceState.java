import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AddProgressDice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddProgressDiceState extends PlayerState
{
    Player player;
    private boolean DEBUG_FLAG = true;
    public AddProgressDiceState(Player p, int x, int y)
    {
        super(p, x, y);
        if(DEBUG_FLAG) { System.out.println("AddProgressDiceState:AddProgressDiceState(Player,x,y)");} 
        this.player = p;
    }
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("AddProgressDiceState:doAction()");} 
        player.world().addProgressDice();
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
