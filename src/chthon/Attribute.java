package chthon;



public class Attribute{
    public String type;
    public int priority;
    
    public Attribute(String type, int priority){
        this.type = type;
        this.priority = priority;
    }
    
    public int choice(int danger, int hazard, int pain, int time, int offput, int space, String... misc){ // what would jesus - I mean, what would something with this attribute do in this situation?
        
        boolean trigDanger = false, trigHazard = false, trigPain = false, trigTime = false, trigOffput = false, trigSpace = false;
        
        if((this.type == "elderly") || (this.type == "child") || (this.type == "sick") || (this.type == "wimp")){
            if(danger > 0) trigDanger = true;
            if(hazard > 0) trigHazard = true;
            if(pain > 0) trigPain = true;
            if(offput > 0) trigOffput = true;
        }
        
        if((this.type == "adult") || (this.type == "adolescent") || (this.type == "healthy") || (this.type == "brave")){
            if(danger > 10) trigDanger = true;
            if(hazard > 10) trigHazard = true;
            if(pain > 10) trigPain = true;
            if(offput > 10) trigOffput = true;
        }
        
        if((this.type == "inanimate") || (this.type == "numb") || (this.type == "mindless") || (this.type == "plant")){
            trigPain = false;
        }
        
        
        return 0;//debug
    }
}
