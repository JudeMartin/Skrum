import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialBoard extends Actor
{
    /**
     * Act - do whatever the InitialBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean DEBUG_FLAG = true;
    public void act() 
    {   
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)) {
        if(DEBUG_FLAG) { System.out.println("InitialBoard:act() Mouse Clicked. Moving to next screen.");}
            ScrumWorld SW = ((ScrumWorld)getWorld());
            SW.setBackground("ScrumBoard.png");
            SW.initializeWorld();
            SW.removeObject(this);
        }
    }    
}
