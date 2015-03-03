import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Day5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Day5 extends Actor implements Handler
{
   public Handler successor=null;
   private boolean DEBUG_FLAG = true; 
   public void handleRequest(int request){        
           if(request == 5){              
               setImage("DayRed.png");
               if(DEBUG_FLAG) { System.out.println("Day5:handleRequest(int): Request '"+request+"' is handled."); }
           }
            else{
                if(successor!=null){
                    if(DEBUG_FLAG) { System.out.println("Day5:handleRequest(int): Request '"+request+"' is sent to successor."); }
                    successor.handleRequest(request);
                }
            }
        }
        
     public void setSuccessor( Handler next ){
            if(DEBUG_FLAG) { System.out.println("Day5:setSuccessor(Handler)"); }
            this.successor=next;
     } 
}
