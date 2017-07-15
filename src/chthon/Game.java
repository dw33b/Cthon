package chthon;

import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import static chthon.Data.actorList;

public class Game{
    
    public Game(){
        
        actorList = new ArrayList<Actor>();
        Actor testActor = new Actor(400, 400, 1, 1, 1000, 1000, "human", "bIG DICK IS BACK IN TOWN BABY", "mindless", "gassy");
    }
    public void update(){
        
        for(Actor actor : actorList)
            actor.update();
    }
    
    public void getInput(){
        
        if(Mouse.isInsideWindow()){
            Mouse.setGrabbed(true);
        }
    }
    
    public void render(){
        
        for(Actor actor : actorList) actor.render();
    }
}
