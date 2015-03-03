import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SprintReviewState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SprintReviewState extends PlayerState
{
    private boolean DEBUG_FLAG = true;
    public SprintReviewState(Player p, int x, int y)
    {
        super(p, x, y);
        if(DEBUG_FLAG) { System.out.println("SpringReviewState:SpringReviewState(Player,x,y)");} 
    }
    /**
     * Act - do whatever the SprintReviewState wants to do. This method is called whenever
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
        if(DEBUG_FLAG) { System.out.println("SpringReviewState:doAction() Game is over!");} 
        player.world().resetPorgressDiceActive();
        player.world().setMainDiceInActive();
        Message gameOver = new Message("Game Over",30,java.awt.Color.WHITE);
        player.world().addObject(gameOver,555,328);
    }
    
     /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
    }
}
