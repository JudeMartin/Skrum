import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{   /** Whether the message is permanently displayed in the world or for a short period **/ 
    private boolean isMessageTemporary = false;
    private GreenfootImage gi = null;
    private boolean DEBUG_FLAG = true;
    
    Message(int x,int y) {
        if(DEBUG_FLAG) { System.out.println("Message:Message(x,y):"+x+","+y); }
        gi = new GreenfootImage(x,y);
        setImage(gi);
    }

    Message(String message, int size, java.awt.Color FG) {
        if(DEBUG_FLAG) { System.out.println("Message:Message(String,int,Color): Creating '"+message+"'"); }
        gi = new GreenfootImage(message,size,FG,null);
        this.setImage(gi);
    }
    
    /** Method to create a message with default colour scheme **/
    public GreenfootImage createMessage(String message) {
        if(DEBUG_FLAG) { System.out.println("Message:createMessage(String): Creating '"+message+"'"); }
        gi.setColor( java.awt.Color.GREEN ) ;
        gi.fill() ;
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.drawString(message,5,15);       
        return gi;
    }
    
    /** Method to create a message with custom colour scheme **/
    public GreenfootImage createMessage(String message,java.awt.Color BG,java.awt.Color FG) {  
        if(DEBUG_FLAG) { System.out.println("Message:createMessage(String,Color,Color): Creating '"+message+"'"); }
        gi.setColor(BG) ;
        gi.fill();
        gi.setColor(FG) ;
        gi.drawString(message,5,15);       
        return gi;
    }
    
    public GreenfootImage createMessage(String message, int size, java.awt.Color FG, java.awt.Color BG) {
        if(DEBUG_FLAG) { System.out.println("Message:createMessage(String,size,Color,Color): Creating '"+message+"'"); }
        gi = new GreenfootImage(message,size,FG,BG);
        setImage(gi);
        return gi;
    }
    
    /** Setter Method that initializes whether to display message temporarily or permanently **/
    public void setIsMessageTemporary(boolean option) {
        if(DEBUG_FLAG) { System.out.println("Message:setIsMessageTemporary(boolean):"+option); }
        isMessageTemporary = option;
    }
       
    public void act() 
    {   /** Display message for short duration, before removing it **/
        if(isMessageTemporary) {
            setIsMessageTemporary(false);
            if(DEBUG_FLAG) { System.out.println("Message:act(): Temporary message displayed"); }
            try {
                java.lang.Thread.sleep(2000);
            }catch(java.lang.InterruptedException Ex) {
                }
            ScrumWorld gw = (ScrumWorld) getWorld();
            gw.removeObject(this);
        }
    }    
}
