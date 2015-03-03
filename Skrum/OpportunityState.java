import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class OpportunityState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpportunityState extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public OpportunityState(Player p, int x, int y)
    {
        super(p, x, y);
         if(DEBUG_FLAG) { System.out.println("OpporunityState:OpportunityState(Player,x,y)");}
        setImage("white.png");
    }
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("OpportunityState:doAction()");}
        OpportunityCard OC = new OpportunityCard();
        ScrumWorld sw = (ScrumWorld)getWorld();
        sw.addObject(OC,94,222);
        sw.setMainDiceInActive();
    }
    
    /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
    }
    public void pickOpportunity(OpportunityStrategy s)
    {
        ScrumWorld sw = (ScrumWorld)getWorld();
        if(s != null)
        {
            s.doCardAction(sw.getCurrentPlayer());
        }
        sw.resetMainDiceActive();
        sw.switchUser();
    }
}
