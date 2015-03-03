import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class EndOfDayState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndOfDayState extends PlayerState implements Subject
{
    private boolean DEBUG_FLAG = true;
    public EndOfDayState(Player p, int x, int y)
    {
        super(p, x, y);
        if(DEBUG_FLAG) { System.out.println("EndOfDayState:EndOfDayState(Player,x,y)");}
    }
    
    /* doAction() function is called to perform the state specific action.
       */
    public void doAction()
    {
        if(DEBUG_FLAG) { System.out.println("EndOfDayState:doAction()");}
        ++subjectState;
        if(subjectState >= 10) {
            setState(subjectState);
            player.moveTo(26);
            return;
        }
        setState(subjectState);
        player.world().resetMainDiceActive();
    }
    
    /* burnUpDownUpdate(int hours) function is called to calculate burn up or down.
       */
    public void burnUpDownUpdate(int totalHours)
    {
    }
    
    private static int subjectState;  
    ArrayList<Observer>observer=new ArrayList<Observer>();

    public int getState(){
       if(DEBUG_FLAG) { System.out.println("EndOfDayState:getState():"+subjectState);} 
       return subjectState;
    }
    public void setState(int status){
        if(DEBUG_FLAG) { System.out.println("EndOfDayState:setState(int)"+status);} 
        subjectState=status;
        notifyObservers();
    }  
    
     public void attach(Observer obj){
        if(DEBUG_FLAG) { System.out.println("EndOfDayState:attach(Observer)");}  
        observer.add(obj);
    }
    public void detach(Observer obj){
        if(DEBUG_FLAG) { System.out.println("EndOfDayState:detach(Observer)");} 
        observer.remove(obj);
    }
    
    public void notifyObservers(){
        if(DEBUG_FLAG) { System.out.println("EndOfDayState:notifyObservers()");} 
        /**Here logic to check when the token stops on the End */
       for(Observer obj :observer){
            obj.update();
        }
     }
    public boolean isAutoUserSwitch()
    {
        return true;
    }
}
