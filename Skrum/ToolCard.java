import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToolsCards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToolCard extends Cards
{
    private boolean DEBUG_FLAG = true;
    public ToolCard() {
        super();
        if(DEBUG_FLAG) { System.out.println("ToolCard:ToolCard()");}
    }

    public void act() 
    {
        ScrumWorld sw = (ScrumWorld) getWorld();
        /** Start of kinect code */
        
        UserData[] us = sw.getTrackedUsers();
        for (UserData u: us)
        {
            Actor ac = getOneObjectAtOffset(0,0,Hand.class);
            
            if(ac == null) {
                return;
            }
            else {
                if(DEBUG_FLAG) { System.out.println("ToolCard:act() Tool Card flipped");}
                int toolNum = Greenfoot.getRandomNumber(3);
                ScrumWorld se = (ScrumWorld) getWorld();
                PickCard pick = new PickCard("Tools"+toolNum+".png");
                se.addObject(pick,300,200);
                //Sleeper.sleep(30);
                se.removeObject(this);
                //se.removeObject(pick);
                sw.getCurrentPlayer().pickTool();
                se.setMainDiceInActive();
            }
        }
        
       /** End of kinect code */
       
        /*  Testing Purpose: Use mouse click instead of kinect.
         
        if(Greenfoot.mouseClicked(this)) 
        {
            int toolNum = Greenfoot.getRandomNumber(3);
            ScrumWorld se = (ScrumWorld) getWorld();
            PickCard pick = new PickCard("Tools"+toolNum+".png");
            se.addObject(pick,300,200);
            //Sleeper.sleep(30);
            se.removeObject(this);
            //se.removeObject(pick);
            sw.getCurrentPlayer().pickTool();
            se.setMainDiceInActive();
        } */
        
    } //End of method act()    
}
