import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImpedimentCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImpedimentCard extends Cards
{
    /**
     * Act - do whatever the ImpedimentCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean DEBUG_FLAG = true;
    public ImpedimentCard() {
        super();
        if(DEBUG_FLAG) { System.out.println("ImpedimentCard:ImpedimentCard()");}
    }
    public void act() 
    {
        ScrumWorld sw = (ScrumWorld) getWorld();
        /** Start of kinect code */
        
         if (!sw.isConnected())
             return;
        
        UserData[] us = sw.getTrackedUsers();
        for (UserData u: us)
        {
            Actor ac = getOneObjectAtOffset(0,0,Hand.class);

            if(ac == null) {
                return;
            }
            else {
                if(DEBUG_FLAG) { System.out.println("ImpedimentCard:act() Impediment Card flipped");}
                int impNum = Greenfoot.getRandomNumber(3);
                PickCard pick = new PickCard("Impediment"+impNum+".png");
                sw.addObject(pick,300,200);
                //Sleeper.sleep(30);
                sw.removeObject(this);
                //sw.removeObject(pick);
                sw.getCurrentPlayer().pickImpediment();
                sw.setMainDiceInActive();
            }
        }
        
        /** End of kinect code */   
        
        /*  Testing Purpose: Use mouse click instead of kinect.
         
        if(Greenfoot.mouseClicked(this) && sw.getCurrentPlayer().isImpedimentSet()) 
        {
            int impNum = Greenfoot.getRandomNumber(3);
            PickCard pick = new PickCard("Impediment"+impNum+".png");
            sw.addObject(pick,300,200);
            //Sleeper.sleep(30);
            sw.removeObject(this);
            //sw.removeObject(pick);
            sw.getCurrentPlayer().pickImpediment();
            sw.setMainDiceInActive();
        } */
    } //End of method act() 
}
