import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndofDayStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndofDayStrategy extends Actor implements OpportunityStrategy
{
    EndofDayStrategy()
    {
    }
    
    public void doCardAction(Player p)
    {
        p.moveTo(6);
    }
}
