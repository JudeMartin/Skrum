import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int currentStateNum = 0;
    PlayerState currentState; 
    PlayerStates ps;
    boolean sprintPlanDone = false;
    boolean imepdimentSet = false;
    ScrumWorld sw;
    boolean DEBUG_FLAG = true;
    
    public void startPlanning()
    {
        if(DEBUG_FLAG) { System.out.println("Player:startPlanning()");}
        sprintPlanDone = true;
        sw = (ScrumWorld) getWorld();
    }
    
    public ScrumWorld world()
    {
        if(DEBUG_FLAG) { System.out.println("Player:world()");}
        return sw;
    }
    
    public boolean isSprintPlanDone()
    {
        if(DEBUG_FLAG) { System.out.println("Player:isSPrintPlanDone(): "+sprintPlanDone);}
        return sprintPlanDone;
    }
    
    public void setPlayerStateTransition(PlayerStates ps)
    {
        if(DEBUG_FLAG) { System.out.println("Player:setPlayerStateTransition");}
        this.ps = ps;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void setDimension(int x, int y)
    {
        if(DEBUG_FLAG) { System.out.println("Player:setDimension(x,y):"+x+","+y);}
        this.setLocation(x, y);
    }
    
    public void move(int n)
    {
        if(DEBUG_FLAG) { System.out.println("Player:move(int):"+n);}
        int s = ps.addState(currentStateNum, n, false);
        setState(s, ps.getState(s));
        currentState.doAction();
        if(currentState.isAutoUserSwitch())
        {
            sw.switchUser();
        }
    }
    
    public void moveTo(int s)
    {
        if(DEBUG_FLAG) { System.out.println("Player:moveTo(int):"+s);}
        setState(s, ps.getState(s));
        currentState.doAction();
    }
    
    public int currentStateNumber()
    {
        if(DEBUG_FLAG) { System.out.println("Player:currentStateNumber():");}
        return currentStateNum;        
    }
    
    public void throwDice(int value)
    {
        if(DEBUG_FLAG) { System.out.println("Player:throwDice(int):"+value);}
        currentState.throwDice(value);
    }
    
    public void throwProgressDice(int value)
    {
        if(DEBUG_FLAG) { System.out.println("Player:throwProgressDice(int):"+value);}
        if(sprintPlanDone)
        {
            int total = 0;
            total = currentState.throwProgressDice(value);
            currentState.burnUpDownUpdate(total);
        }
    }
    public void pickTool()
    {
        currentState.pickTool();
    }
    public void pickImpediment()
    {
        currentState.pickImpediment();
    }
    public void pickOpportunity(OpportunityStrategy s)
    {
        currentState.pickOpportunity(s);
    }
    public void setState(int s, PlayerState ps)
    {
        if(DEBUG_FLAG) { System.out.println("Player:setState(int,PlayerState)");}
        currentStateNum = s;
        currentState = ps;
        currentState.activate();
    }
    
    public boolean isImpedimentSet()
    {
        if(DEBUG_FLAG) { System.out.println("Player:isImpedimentSet()");}
        return imepdimentSet;
    }
    
    public void setImpediment()
    {
        if(DEBUG_FLAG) { System.out.println("Player:setImpediment()");}
        imepdimentSet = true;
    }
    
    public void resetImpediment()
    {
        if(DEBUG_FLAG) { System.out.println("Player:resetImpediment()");}
        imepdimentSet = false;
    }

}
