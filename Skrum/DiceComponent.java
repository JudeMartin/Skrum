import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Dice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class DiceComponent extends Actor
{
    public static final int SCRUM = 0;
    ScrumWorld world;
    DiceComponent parent = null;
    /**
     * Act - do whatever the Dice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }
    
    public abstract void notifyRoll();
    
    public abstract void roll();
    
    public abstract int getValue();
    
    public void add(DiceComponent d)
    {
    }
    
    public void setParent(DiceComponent d)
    {
        parent = d;
    }
    
    public void setWorld(ScrumWorld world)
    {
        this.world = world;
    }
    public abstract boolean isScrum();
}