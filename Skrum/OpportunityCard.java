import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Thread;

public class OpportunityCard extends Cards
{
    private boolean DEBUG_FLAG = true;
    public OpportunityCard() {
        super();
        if(DEBUG_FLAG) { System.out.println("OpportunityCard:OpportunityCard()");}
    }
    
    public void act() 
    {   
        PickCard pick = null;
        /** Start of kinect code */
        
        ScrumWorld sw = (ScrumWorld) getWorld();
        UserData[] us = sw.getTrackedUsers();
        
        for (UserData u: us)
        {
            Actor ac = getOneObjectAtOffset(0,0,Hand.class);
            if(ac == null) {
                return;
            }
            else {
                 if(DEBUG_FLAG) { System.out.println("OpportunityCard:act() Opportunity Card flipped");}
                 //int oppNum = Greenfoot.getRandomNumber(3);
                 int oppNum = 2;
                 ScrumWorld se = (ScrumWorld) getWorld();
                 OpportunityStrategy s = null;
                 switch(oppNum)
                 {
                     //end of day strategy
                     case 0:
                     {
                         pick = new PickCard("Opportunity0.png");
                         se.addObject(pick,300,200);
                         //Sleeper.sleep(30);
                         s = new EndofDayStrategy();
                         se.removeObject(this);
                         //se.removeObject(pick);
                     }
                     break;
                     //discuss strategy
                     case 1:
                     {
                        pick = new PickCard("Opportunity1.png");
                        se.addObject(pick,300,200);
                        //Sleeper.sleep(30);
                        s = new DiscussStrategy();
                        se.removeObject(this);
                        //se.removeObject(pick);
                     }
                     break;
                     //daily scrum strategy
                     case 2:
                     {
                         pick = new PickCard("Opportunity2.png");
                         se.addObject(pick,300,200);
                         //Sleeper.sleep(30);
                         s = new DailyScrumStrategy();
                         se.removeObject(this);
                         //se.removeObject(pick);
                     }
                     break;
                 }
                 se.getCurrentPlayer().pickOpportunity(s);
                 se.setMainDiceInActive();
            }
        } 
        /** End of kinect code */
        
        /**  Testing Purpose: Use mouse click instead of kinect.
         
        if(Greenfoot.mouseClicked(this)) 
        {
            //int oppNum = 2;
            int oppNum = Greenfoot.getRandomNumber(3);
            ScrumWorld se = (ScrumWorld) getWorld();
            OpportunityStrategy s = null;
            switch(oppNum)
            {
                //end of day strategy
                case 0:
                {
                    pick = new PickCard("Opportunity0.png");
                    se.addObject(pick,300,200);
                    //Sleeper.sleep(30);
                    s = new EndofDayStrategy();
                    se.removeObject(this);
                    //se.removeObject(pick);
                }
                break;
                //discuss strategy
                case 1:
                {
                    pick = new PickCard("Opportunity1.png");
                    se.addObject(pick,300,200);
                    //Sleeper.sleep(30);
                    s = new DiscussStrategy();
                    se.removeObject(this);
                    //se.removeObject(pick);
                }
                break;
                //daily scrum strategy
                case 2:
                {
                    pick = new PickCard("Opportunity2.png");
                    se.addObject(pick,300,200);
                    //Sleeper.sleep(30);
                    s = new DailyScrumStrategy();
                    se.removeObject(this);
                    //se.removeObject(pick);
                }
                break;
            }
            se.getCurrentPlayer().pickOpportunity(s);
            se.setMainDiceInActive();
        } */
    } // End of method act()

}
