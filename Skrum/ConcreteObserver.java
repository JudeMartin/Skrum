import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class ConcreteObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteObserver extends Actor implements Observer 
{  EndOfDayState subject;  
   Handler h1;
   private boolean DEBUG_FLAG = true;
   
   public ConcreteObserver(EndOfDayState subject){
        if(DEBUG_FLAG) { System.out.println("ConcreteObserver:ConcreteObserver(EndOfDayState)");}
        this.subject=subject;
   }
   
   public void setInitialCOR(Handler h1) {
        if(DEBUG_FLAG) { System.out.println("ConcreteObserver:setInitialCOR(Handler)");}
        this.h1 = h1;
   }
    
   public void update(){
        if(DEBUG_FLAG) { System.out.println("ConcreteObserver:update(): handleRequest of H1 called");}
        h1.handleRequest(subject.getState());
   }
        
}
