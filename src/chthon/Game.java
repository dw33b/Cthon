package chthon;

import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import static chthon.Data.actorList;

public class Game{
    
    //private ArrayList = new ArrayList();
    
    public Game(){
        
        
        actorList = new ArrayList<Actor>();
        actorList.add(new Actor(400, 400, 1, 1, 1000, 1000, "human", "bIG DICK IS BACK IN TOWN BABY", "mindless", "gassy"));
        //Actor testActor = new Actor(400, 400, 1, 1, 1000, 1000, "human", "bIG DICK IS BACK IN TOWN BABY", "mindless", "gassy");
    }
    public void update(){
        
        getInput();
        
        for(Actor actor : actorList)
            actor.update();
    }
    
    public void getInput(){
        
        if(Mouse.isInsideWindow()){
            Mouse.setGrabbed(true);
            
            if(Keyboard.next()){
                for(int i = 0; i < Keyboard.getNumKeyboardEvents(); i++){
                    
                }
            }
            
            
        }
    }
    
    public void render(){
        
        for(Actor actor : actorList) actor.render();
    }
}
