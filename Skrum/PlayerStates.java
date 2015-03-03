import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerStates here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerStates extends Actor
{
    PlayerState []states = new PlayerState[27];
    public static final int PLANNING_STEPS = 5;
    public static final int REVIEW_STEP = 26;
    private boolean DEBUG_FLAG = true;
    
    PlayerStates(Player p)
    {
        if(DEBUG_FLAG) { System.out.println("PlayerStates:PlayerStates(Player)");}
        states[0] = new StartState(p, 40, 533);
        states[1] = new BurnUp50State(p, 115, 533); 
        states[2] = new AddProgressDiceState(p, 179,533);
        states[3] = new BurnUp25State(p, 252, 533);
        states[4] = new BurnDown25State(p, 316, 533); 
        states[5] = new BurnUp50State(p, 378, 533); 
        states[6] = new EndOfDayState(p, 555, 533);
        states[7] = new ImpedimentState(p, 707, 457);
        states[8] = new OpportunityState(p, 743, 382);
        states[9] = new ToolState(p, 745, 305);
        states[10] = new EndOfDayState(p, 716, 235);
        states[11] = new ImpedimentState(p, 659, 178);
        states[12] = new OpportunityState(p, 592, 155);
        states[13] = new ToolState(p, 516, 152);
        states[14] = new EndOfDayState(p, 448, 185);
        states[15] = new ThrowProgressDiceX2State(p, 339, 213);
        states[16] = new ThrowProgressDiceState(p, 289, 237);
        states[17] = new ThrowProgressDiceX2State(p, 229, 217);
        states[18] = new ThrowProgressDiceUpState(p, 212, 151);
        states[19] = new ThrowProgressDiceState(p, 245, 113);
        states[20] = new ThrowProgressDiceX2State(p, 307, 93);
        states[21] = new ThrowProgressDiceUpState(p, 351, 136);
        states[22] = new ThrowProgressDiceX2State(p, 395, 239);
        states[23] = new ImpedimentState(p, 361, 306);
        states[24] = new OpportunityState(p, 365, 381);
        states[25] = new ToolState(p, 401, 457);
        states[26] = new SprintReviewState(p, 788, 538);
        setImage("white.png");
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public int addState(int currentState, int delta, boolean burntDown)
    {
        if(DEBUG_FLAG) { System.out.println("PlayerStates:addState(int,int,boolean):"+currentState+","+delta+","+burntDown);}
        int result = currentState + delta;
        System.out.println(result);
        if(currentState > PLANNING_STEPS)
        {
            if(result < REVIEW_STEP)
            {
                return result;
            } else if(burntDown)
            {
                return REVIEW_STEP;
            } else
            {
                return PLANNING_STEPS  + (result + 1) % REVIEW_STEP;
            }
        }
        return result;
    }
    
    public PlayerState getState(int n)
    {
        if(DEBUG_FLAG) { System.out.println("PlayerStates:setState(int):"+n);}
        return states[n];
    }
    
    public void initialize() {
        if(DEBUG_FLAG) { System.out.println("PlayerStates:initialize(): Initializing ConcreteObserver pattern objects");}
        ConcreteObserver CO1 = new ConcreteObserver((EndOfDayState)states[6]);
        ConcreteObserver CO2 = new ConcreteObserver((EndOfDayState)states[10]);
        ConcreteObserver CO3 = new ConcreteObserver((EndOfDayState)states[14]);
        ((EndOfDayState)states[6]).attach(CO1);
        ((EndOfDayState)states[10]).attach(CO2);
        ((EndOfDayState)states[14]).attach(CO3);
        ScrumWorld sw = (ScrumWorld)getWorld();
        
        CO1.setInitialCOR(sw.getInitialCOR());
        CO2.setInitialCOR(sw.getInitialCOR());
        CO3.setInitialCOR(sw.getInitialCOR());
        
        sw.addObject(states[8],983,18);
        sw.addObject(states[12],983,18);
        sw.addObject(states[24],983,18);
        sw.addObject(states[7],983,18);
        sw.addObject(states[9],983,18);
        sw.addObject(states[11],983,18);
        sw.addObject(states[13],983,18);
        sw.addObject(states[23],983,18);
        sw.addObject(states[25],983,18);
    }
}
