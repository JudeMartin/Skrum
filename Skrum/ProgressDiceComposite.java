import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ProgressDiceComposite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProgressDiceComposite extends DiceComposite
{
    public void notifyRoll()
    {
        System.out.println(world.getCurrentPlayer());
        world.getCurrentPlayer().throwProgressDice(getValue());
    }
    public int getValue()
    {
        int sum = 0;
        int numScrum = 0;
        List<Integer> vals = new ArrayList<Integer>();
        for(Dice d: dices)
        {
            int v = d.getValue();
            if(v == SCRUM)
            {
                numScrum++;
            }
            vals.add(v);
        }
        Collections.sort(vals, Collections.reverseOrder());
        for(int v : vals)
        {
            if(numScrum > 0)
            {
                sum += v * 2;
                numScrum--;
            }
            else
            {
                sum += v;
            }
        }
        return sum;
    }
}