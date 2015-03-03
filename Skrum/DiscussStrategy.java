import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiscussStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiscussStrategy extends Actor implements OpportunityStrategy
{
   public DiscussStrategy()
   {
   }
   public void doCardAction(Player p)
   {
       //add progress dice
       p.world().addProgressDice();
   }
}
