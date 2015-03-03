import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Thread;
/**
 * Write a description of class PickCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PickCard extends Actor 
{
    /**
     * Act - do whatever the PickCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean DEBUG_FLAG = true;
    public PickCard(String imagename)  
    {   
        if(DEBUG_FLAG) { System.out.println("PickCard:PickCard(String): Setting image "+imagename);}
        setImage(imagename);  
    } 
    
    public void act() 
    {        
        ScrumWorld sw = (ScrumWorld) getWorld();
        /** Start of kinect code */
        
        if (!sw.isConnected())
            return;
        
        UserData[] us = sw.getTrackedUsers();
        for (UserData u: us)
        {
            Actor ac = getOneObjectAtOffset(0,0,Hand.class);
                       
            if(ac == null) {
                return;
            }
            else {
                setLocation(ac.getX(),ac.getY());
                if(Math.abs(getX() - 80) > 40 || Math.abs(getY() - 400) > 40) {
                    sw.resetMainDiceActive();
                    if(DEBUG_FLAG) { System.out.println("PickCard:act() Removing card from world");}
                    sw.removeObject(this);
                }
            }
        }
        
        /** End of kinect code */
        
        /* Testing purpose
        if(Greenfoot.mouseClicked(this)) {
            sw.resetMainDiceActive();
            if(DEBUG_FLAG) { System.out.println("PickCard:act() Removing card from world");}
            sw.removeObject(this);
        } */
    }    
}
