import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DailyScrumStrategy extends Actor implements OpportunityStrategy
{
    public DailyScrumStrategy()
    {
    }
    public void doCardAction(Player p)
    {
      p.moveTo(15);
      p.world().resetPorgressDiceActive();
    }
}
