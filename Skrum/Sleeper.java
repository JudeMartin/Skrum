import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sleeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sleeper extends Actor
{
    /**
     * Act - do whatever the Sleeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public static void sleep(int secs)
    {
        Greenfoot.setSpeed(35);
        Greenfoot.delay(secs);
        Greenfoot.setSpeed(100);
    }
}
