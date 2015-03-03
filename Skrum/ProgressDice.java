import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProgressDice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ProgressDice extends Dice
{
    public void act() 
    {
        ScrumWorld sw = (ScrumWorld) getWorld();
        /** Start of kinect code */
        
         if(!sw.isConnected())
             return;
         
         UserData[] us = sw.getTrackedUsers();
         for (UserData u: us)
         {
             Actor ac = getOneObjectAtOffset(0,0,Hand.class);
            
             if(ac == null) {
                 return;
             }
             
             if( sw.isProgressDiceActive()) {
                 sw.isProgressDiceActive();
                 if(parent == null) 
                 {
                     roll();
                     notifyRoll();
                 }
                 else
                 {
                     parent.roll();
                     parent.notifyRoll();
                 }
             }
         }
         
        /** End of kinect code */
        
 /*  Testing Purpose: Use mouse click instead of kinect.
  
        if(Greenfoot.mouseClicked(this) && sw.isProgressDiceActive()) 
        {
            if(parent == null) 
            {
                roll();
                notifyRoll();
            }
            else
            {
                parent.roll();
                parent.notifyRoll();
            }
    } */
    } //End of method act();
    
    private boolean DEBUG_FLAG = true;
    public void notifyRoll()
    {
        if(DEBUG_FLAG) { System.out.println("ProgressDice:notifyRoll()");}
        ScrumWorld sw = (ScrumWorld) getWorld();
        sw.getCurrentPlayer().throwProgressDice(getValue());
    }
    
    public void roll()
    {
        if(DEBUG_FLAG) { System.out.println("ProgrssDice:roll()");}
        for(int j=0;j<3;j++) 
        {
            int xy = 10;
            for(int i=0;i<360/xy;i++)
            {   
                setRotation(getRotation()+xy);
                Greenfoot.delay(6000);
                //Greenfoot.delay(1);
            }
            currentDiceNo = Greenfoot.getRandomNumber(6);
            setImage("ProgressDice"+currentDiceNo+".png");
        }
    }
}
