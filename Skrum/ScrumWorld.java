import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

 public class ScrumWorld extends KinectWorld
 {
    boolean debug = true; 
    
    /** Tracking players*/
    Player currentPlayer;
    Player p1;
    Player p2;
    
    /** Dice Objects */
    Dice d1;
    DiceComposite moveDices = new DiceComposite();
    ProgressDiceComposite progressDices = new ProgressDiceComposite();
    int progressDiceCount = 0; 
    boolean progressDiceActive = false;
    boolean mainDiceActive = true;
    Message popupMsg;         
    
    /** Burn Down Hours */
    Message burnDown;
    Message player1BurnDown;
    Message player2BurnDown;
    int estimateHours = 300;
    int player1Hours = 0;
    int player2Hours = 0;
    
    /** End Of Days Objects */
    Day1 day1;
    Day2 day2;
    Day3 day3;
    Day4 day4;
    Day5 day5;
    Day6 day6;
    Day7 day7;
    Day8 day8;
    Day9 day9;
    Day10 day10;
    
    /** UI */
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;
    Hand h;
 
    public ScrumWorld()
    {   
        super(80, 60, 1.0, false);
        if(debug) { System.out.println("ScrumWorld:ScrumWorld(): World created.");}
        addObject(new InitialBoard(),500,180);
    }
    
    public void initializeWorld() {
        Greenfoot.setSpeed(100);
        /** UI Initialization */
        if(debug) { System.out.println("ScrumWorld:initializeWorld():Initializing UI");}
        final int width = getWidth();
        final int height = getHeight();
        addObject(new Instructions(), width/2, height/2);         
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        h = new Hand();
        addObject(h,52,111);
        
        /** Initializing EOD Objects*/
        if(debug) { System.out.println("ScrumWorld:initializeWorld():Initializing EOD");}
        day1 = new Day1();
        day2 = new Day2();
        day3 = new Day3();
        day4 = new Day4();
        day5 = new Day5();
        day6 = new Day6();
        day7 = new Day7();
        day8 = new Day8();
        day9 = new Day9();
        day10 = new Day10();
        /** Chain of responsibility pattern for EOD*/
        day1.setSuccessor(day2);
        day2.setSuccessor(day3);
        day3.setSuccessor(day4);
        day4.setSuccessor(day5);
        day5.setSuccessor(day6);
        day6.setSuccessor(day7);
        day7.setSuccessor(day8);
        day8.setSuccessor(day9);
        day9.setSuccessor(day10);
        /** Adding EOD objects to Scrum World */
        addObject(day1,758,70);
        addObject(day2,803,70);
        addObject(day3,848,70);
        addObject(day4,893,70);
        addObject(day5,938,70);
        addObject(day6,758,115);
        addObject(day7,803,115);
        addObject(day8,848,115);
        addObject(day9,893,115);
        addObject(day10,939,115);
                
        /** Dice components initialization */
        if(debug) { System.out.println("ScrumWorld:initializeWorld():Initializing DICE components");}
        moveDices.setWorld(this);
        progressDices.setWorld(this);
        d1 = new Dice();
        addObject(d1,515,234);
        addProgressDice();
        addProgressDice();
        addProgressDice();
        popupMsg = new Message(120,30);
        
        /** Burn Down Counter Initialization*/
        if(debug) { System.out.println("ScrumWorld:initializeWorld():Initializing BurnDown Components");}
        Message total = new Message("300",30,java.awt.Color.WHITE);
        burnDown = new Message("" + estimateHours,30,java.awt.Color.WHITE);
        player1BurnDown = new Message("" + player1Hours,20,java.awt.Color.WHITE);
        player2BurnDown = new Message("" + player2Hours,20,java.awt.Color.WHITE);
        addObject(total,490,37);
        addObject(burnDown,677,37);
        addObject(player1BurnDown,490,66);
        addObject(player2BurnDown,677,66);
        
        /** PLayers initialization */
        if(debug) { System.out.println("ScrumWorld:initializeWorld():Initializing Players");}
        p1 = new Player();
        p1.setImage("ppl1.png");
        PlayerStates ps1 = new PlayerStates(p1);
        p1.setPlayerStateTransition(ps1);
        addObject(p1, 40, 533);
        p1.setState(0, ps1.getState(0));

        p2 = new Player();
        p2.setImage("ppl2.png");
        PlayerStates ps2 = new PlayerStates(p2);
        p2.setPlayerStateTransition(ps2);
        addObject(p2, 40, 533);
        p2.setState(0, ps2.getState(0));
        currentPlayer = p1;
               
        addObject(ps1,983,18);
        addObject(ps2,983,18);
        ps1.initialize();
        ps2.initialize();   
    }
    
   /** Dice Related Functions */    
    public boolean isProgressDiceActive()
    {
        if(debug) { System.out.println("ScrumWorld:isProgressDiceActive():"+progressDiceActive);}
        return progressDiceActive;
    }
    
    public void setPorgressDiceActive()
    {
        //showPopupMessage("Roll Progress Dice");
        progressDiceActive = true;
        if(debug) { System.out.println("ScrumWorld:setProgressDiceActive():"+progressDiceActive);}
    }
    
    public void resetPorgressDiceActive()
    {
        //removePopupMessage();
        progressDiceActive = false;
        resetMainDiceActive();
        if(debug) { System.out.println("ScrumWorld:resetProgressDiceActive():"+progressDiceActive); }
    }
    
    public boolean isMainDiceActive()
    {
        if(debug) { System.out.println("ScrumWorld:isMainDiceActive():"+mainDiceActive); }
        return mainDiceActive;
    }
    
    public void setMainDiceInActive()
    {
        //showPopupMessage("Roll Main Dice");
        mainDiceActive = false;
        if(debug) { System.out.println("ScrumWorld:setMainDiceInActive():"+mainDiceActive); }
    }
    
    public void resetMainDiceActive()
    {
        //removePopupMessage();
        mainDiceActive = true;
        if(debug) { System.out.println("ScrumWorld:resetMainDiceActive():"+mainDiceActive); }
    }
    
    public void addSecondDice()
    {
        if(p1.isSprintPlanDone() && p2.isSprintPlanDone())
        {
            if(debug) { System.out.println("ScrumWorld:addSecondDice()"); }
            Dice d2 = new Dice();
            moveDices.add(d1);
            d1.setParent(moveDices);
            moveDices.add(d2);
            d2.setParent(moveDices);
            addObject(d2,595,234);
        }
    }
    
    public void addProgressDice()
    {
        if(progressDiceCount < 3)
        {
            if(debug) { System.out.println("ScrumWorld:addProgressDice()"); }
            progressDiceCount++;
            ProgressDice pd = new ProgressDice();
            addObject(pd,10+(progressDiceCount*65),310);
            progressDices.add(pd);
            pd.setParent(progressDices);
        }
        else if(progressDiceCount >= 3 && progressDiceCount <6) {
            progressDiceCount++;
            ProgressDice pd = new ProgressDice();
            //addObject(pd,107+((progressDiceCount-4)*65),441);
            addObject(pd,10+((progressDiceCount-3)*65),383);
            progressDices.add(pd);
            pd.setParent(progressDices);
        } else {
            //showPopupMessage("Cant add another progress dice. Limit 6 reached.");
        }
    }
    
    public boolean isProgressDiceAvailable()
    {
        if(debug) { System.out.println("ScrumWorld:isProgressDiceAvailable()"); }
        if(progressDiceCount > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
/** No Longer used */ 
/*       
     public void showPopupMessage(String msg)
    {
        if(popupMsg.getWorld() != null)
        {
            this.removeObject(popupMsg);
        }
        popupMsg.createMessage(msg,java.awt.Color.BLUE,java.awt.Color.BLACK);
        this.addObject(popupMsg, 350, 50);
        if(debug) { System.out.println("ScrumWorld:showPopupMessage(String)"); }
    }

    public void showPopupMessage(boolean isProgressAvail)
    {
        if(popupMsg.getWorld() != null)
        {
            this.removeObject(popupMsg);
        }
        if(isProgressAvail)
        {
            popupMsg.createMessage("Roll Progress Dice",java.awt.Color.BLUE,java.awt.Color.BLACK);
        }
        else
        {
            popupMsg.createMessage("No Progress Dice!!",java.awt.Color.BLUE,java.awt.Color.BLACK);
        }
        this.addObject(popupMsg, 350, 50);
        if(debug) { System.out.println("ScrumWorld:showPopupMessage(boolean)"); }
    }
    
    public void removePopupMessage()
    {
        if(debug) { System.out.println("ScrumWorld:removePopupMessage()"); }
        if(popupMsg.getWorld() != null)
        {
            this.removeObject(popupMsg);
        }
    }
  */
 
    /** PLayer related functions */
    public void switchUser()
    {
        if(debug) { System.out.println("ScrumWorld:switchUser()"); }
        if(currentPlayer == p1)
        {
            currentPlayer = p2;
        } else 
        {
            currentPlayer = p1;
        }
    }
    
    public Player getCurrentPlayer() {
        if(debug) { System.out.println("ScrumWorld:getCurrentPlayer()"); }
        return currentPlayer;
    }
    
    /** Greenfoot functions */
    public void act()
     {
        super.act();
        if (!isConnected())
            return;
        
        UserData[] us = getTrackedUsers();
        setBackground("ScrumBoard.png");
        for (UserData u: us)
        {
            /** If you want to draw the stick figure */
            //u.drawStickFigure(getBackground(), 60);
        }           
    }
    
    /** Burn Down hours relates functions */    
    public void addHours(int hr)
    {
        if(debug) { System.out.println("ScrumWorld:addHours(int): TotalEstimateHours is "+estimateHours); }
        estimateHours += hr;
    } 

    public void updateBurnDownHours(int hrs)
    {
        estimateHours += hrs;
        if(currentPlayer == p1) {
            player1Hours += hrs;
        }
        if(currentPlayer == p2) {
            player2Hours += hrs;
        }

    
        if(burnDown != null)
        {
            removeObject(burnDown);
            removeObject(player1BurnDown);
            removeObject(player2BurnDown);
            burnDown = null;
            player1BurnDown = null;
            player2BurnDown = null;
            burnDown = new Message("" + estimateHours,30,java.awt.Color.WHITE);
            addObject(burnDown,677,37);
            player1BurnDown = new Message("" + player1Hours,20,java.awt.Color.WHITE);
            player2BurnDown = new Message("" + player2Hours,20,java.awt.Color.WHITE);
            addObject(player1BurnDown,490,66);
            addObject(player2BurnDown,677,66);
            if(estimateHours <=0) {
                resetPorgressDiceActive();
                setMainDiceInActive();
                Message gameOver = new Message("Game Over",30,java.awt.Color.WHITE);
                addObject(gameOver,555,328);
                currentPlayer.moveTo(26);
            }
        }
        if(debug) { System.out.println("ScrumWorld:updateBurnDownHours(int): TotalEstimateHours is "+estimateHours); }
    }

    /** EOD related functions */
    public Handler getInitialCOR() {
        if(debug) { System.out.println("ScrumWorld:getInitialCOR()"); }
        return day1;
    }
    public boolean isScrumDice()
    {
        return moveDices.isScrum();
    }
    /** Helper Functions that are not currently used */
    /*
    public void addTempObject(Actor obj) {
        addObject(obj,100,100);
        try {
                java.lang.Thread.sleep(20000);
            }catch(java.lang.InterruptedException Ex) {
            }
            System.out.println("Removing object");
            removeObject(obj);
    }
    
    public void removeObjectFromWorld(Actor obj) {
        removeObject((Actor)obj);
    }
    
     public void addObjectToWorld(Actor obj,int x,int y) {
        addObject(obj,x,y);
    }
    */
    
} /* End of class GumballWorld */
