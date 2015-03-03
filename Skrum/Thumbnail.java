import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thumbnail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thumbnail  extends Actor
{
    private boolean DEBUG_FLAG = true; 
    public Thumbnail()
    {
        if(DEBUG_FLAG) { System.out.println("Thumnail:Thumbnail()");}
    }

    /**
     * Act - do whatever the Thumbnail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = ((KinectWorld)getWorld()).getThumbnailUnscaled();
        setImage(img);
    }
}
