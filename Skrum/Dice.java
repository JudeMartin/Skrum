import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Dice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dice extends DiceComponent
{
    int currentDiceNo=0;
    Boolean intersected = true;
    int height = 0;
    private boolean DEBUG_FLAG = true;
    
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
             
             if( sw.isMainDiceActive()) {
                 //sw.setMainDiceInActive();
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
  
      if(Greenfoot.mouseClicked(this) && sw.isMainDiceActive()) 
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

   public void notifyRoll()
    {
        if(DEBUG_FLAG) { System.out.println("Dice:notifyRoll()");}
        ScrumWorld sw = (ScrumWorld) getWorld();
        System.out.println(sw.getCurrentPlayer());
        sw.getCurrentPlayer().throwDice(getValue());
    }
    
    public void roll()
    {
        if(DEBUG_FLAG) { System.out.println("Dice:roll()");}
        for(int j=0;j<5;j++) 
        {
            int xy = 10;
            //int speed = 1;
            int speed = 12000;
            for(int i=0;i<360/xy;i++)
            {   
                setRotation(getRotation()+xy);
                turn(1);move(20);
                Greenfoot.delay(speed);
            }
            speed = speed - 6000;
            currentDiceNo = Greenfoot.getRandomNumber(6);
            setImage("Dice"+currentDiceNo+".png");
        }
    }
    
    public int getValue()
    {
        if(DEBUG_FLAG) { System.out.println("Dice:getValue():"+currentDiceNo);}
        return currentDiceNo;
    }
    public boolean isScrum()
    {
        return currentDiceNo == SCRUM;
    }
   
}
