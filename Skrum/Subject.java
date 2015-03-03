import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConcreteObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject 
{   void attach(Observer obj);
    void detach(Observer obj);
    void notifyObservers();   
}
