import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImpedimentState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImpedimentState extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public ImpedimentState(Player p, int x, int y)
    {
        super(p, x, y);
        if(DEBUG_FLAG) { System.out.println("ImpedimentState:ImpedimentState(Player,x,y)");}
        setImage("white.png");
    }
    public void throwDice(int total)
    {
       if(DEBUG_FLAG) { System.out.println("PlayerState:throwDice(int):"+total); }
       if(!player.isImpedimentSet())
       {
           super.throwDice(total);
       }
       else
       {
           if(player.world().isMainDiceActive() && player.world().isScrumDice())
           {
               player.resetImpediment();
               if(total != 0)
               {
                   player.move(total);
               }
               else
               {
                   player.world().switchUser();
               }
           }
           else
           {
               player.world().switchUser();
           }
       }
    }
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("ImpedimentState:doAction()");}
        ImpedimentCard OC = new ImpedimentCard();
        ScrumWorld sw = (ScrumWorld)getWorld();
        sw.addObject(OC,94,222);
        Player player = sw.getCurrentPlayer();
        player.setImpediment();
        sw.setMainDiceInActive();
    }
    
    /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
    }
    public void pickImpediment()
    {
        ScrumWorld sw = (ScrumWorld)getWorld();
        sw.resetMainDiceActive();
        sw.switchUser();
    }
}
