import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cards extends Actor
{
    /**
     * Act - do whatever the Cards wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean DEBUG_FLAG = true;
    public Cards()  
    {  
        GreenfootImage image = getImage();  
        image.scale(image.getWidth() - 700, image.getHeight() - 980);  
        setImage(image);
        if(DEBUG_FLAG) { System.out.println("Cards:Cards()");}
    }  
    
    public void act() 
    {
        // Add your action code here.
    }    
}
