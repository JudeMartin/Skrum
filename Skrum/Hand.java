import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hand extends Actor
{
    /**
     * Act - do whatever the Hand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {  
        super.act();
        ScrumWorld sw = (ScrumWorld)getWorld();
        
        if (!sw.isConnected())
            return;
        
        UserData[] us = sw.getTrackedUsers();
        GreenfootImage gihand = new GreenfootImage("Hand.png");
        for (UserData u: us)
        {
            Actor ac = getOneObjectAtOffset(0,-70,Dice.class);
            if(ac != null)
            {
                setImage("Hand2.png");
            } else {
                setImage("Hand.png");
            }
            setLocation(u.getJoint(Joint.RIGHT_HAND).getX(),u.getJoint(Joint.RIGHT_HAND).getY());
        }
    }
}
