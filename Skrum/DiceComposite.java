import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class DiceComposite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DiceComposite extends DiceComponent
{
    List<Dice> dices = new ArrayList<Dice>();
    public void notifyRoll()
    {
        System.out.println(world.getCurrentPlayer());
        world.getCurrentPlayer().throwDice(getValue());
    }
    public void roll()
    {
        for(Dice d: dices)
        {
            d.roll();
        }
    }
    public int getValue()
    {
        int sum = 0;
        int numScrum = 0;
        Player player = world.getCurrentPlayer();
        for(Dice d: dices)
        {
            sum += d.getValue();
        }
        return sum;
    }
    public void add(Dice d)
    {
        if(dices.size() >= 2 && !(d instanceof ProgressDice)) {
            throw new RuntimeException();
        }
        dices.add(d);
    }
    public boolean isScrum()
    {
        for(Dice d: dices)
        {
            if(d.isScrum())
            {
                return true;
            }
        }
        return false;
    }
}