import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToolState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToolState extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public ToolState(Player p, int x, int y)
    {
        super(p, x, y);
         if(DEBUG_FLAG) { System.out.println("ToolState:ToolState(Player,x,y)");} 
         setImage("white.png");
    }
    /**
     * Act - do whatever the ToolState wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("ToolState:doAction()");} 
        ToolCard OC = new ToolCard();
        ScrumWorld sw = (ScrumWorld)getWorld();
        sw.addObject(OC,94,222);
        sw.setMainDiceInActive();
    }
    
     /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
    }
    public void pickTool()
    {
        ScrumWorld sw = (ScrumWorld)getWorld();
        sw.resetMainDiceActive();
        sw.switchUser();
    }
}
