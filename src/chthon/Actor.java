package chthon;

import java.util.*;

public class Actor{
    
    public int x, y, worldX, worldY, health, healthMax;
    public short[] skillExp = new short[16];
    public long levelExp;
    public String dispName, type;
    public ArrayList attributes = new ArrayList<String>();
    public Visual visuals;
    
    public Actor(int x, int y, int worldX, int worldY, int health, int healthMax, String type, String dispName, String... attributes){
        this.x = x;
        this.y = y;
        this.worldX = worldX;
        this.worldY = worldY;
        this.health = health;
        this.healthMax = healthMax;
        this.type = type;
        this.dispName = dispName;
        this.visuals = new Visual(this.type, 4, false);
        
        for(int i = 0; i < attributes.length; i++){
            this.attributes.add(attributes[i]);
        }
        
    }
    
    public Actor(String type){
        
    }
    
    public void update(){
        finalDecision();
    }
    
    public void finalDecision(){
        
    }
    
    public void render(){
        visuals.draw(this.x, this.y);
    }
    
    //{ MEL , RNG , ESP , CHN , BRL , GRP , DDG , BLK , ACR , IMM , SNK , LIT , PRS , FAB , ALC , SMT }
    public void setLevel(String skill, int level){
        switch(skill.toUpperCase()){
            
            //<> WEAPONS<>//
            
            case "MEL":
                this.skillExp[0] = (short)(Math.pow(3.0, (double)level));
                break;
            
            case "RNG":
                this.skillExp[1] = (short)(Math.pow(3.0, (double)level));
                break;
                
            case "ESP":
                this.skillExp[2] = (short)(Math.pow(3.0, (double)level));
                break;
            
            case "CHN":
                this.skillExp[3] = (short)(Math.pow(3.0, (double)level));
                break;
            
            //<> UNARMED <>//
            
            case "BRL":
                this.skillExp[4] = (short)(Math.pow(3.0, (double)level));
                break;
                
            case "GRP":
                this.skillExp[5] = (short)(Math.pow(3.0, (double)level));
                break;
                
            case "DDG":
                this.skillExp[6] = (short)(Math.pow(3.0, (double)level));
                break;
            
            case "BLK":
                this.skillExp[7] = (short)(Math.pow(3.0, (double)level));
                break;
                
            //<> BODY <>//
            
            case "ACR":
                this.skillExp[8] = (short)(Math.pow(3.0, (double)level));
                break;
                
            case "IMM":
                this.skillExp[9] = (short)(Math.pow(3.0, (double)level));
                break;
                
            case "SNK":
                this.skillExp[10] = (short)(Math.pow(3.0, (double)level));
                break;
            
            case "LIT":
                this.skillExp[11] = (short)(Math.pow(3.0, (double)level));
                break;
            
            //<> UTIL <>//
                
            case "PRS":
                this.skillExp[12] = (short)(Math.pow(3.0, (double)level));
                break;
                
            case "FAB":
                this.skillExp[13] = (short)(Math.pow(3.0, (double)level));
                break;
                
            case "ALC":
                this.skillExp[14] = (short)(Math.pow(3.0, (double)level));
                break;
            
            case "SMT":
                this.skillExp[15] = (short)(Math.pow(3.0, (double)level));
                break;
                
            //<> LEVEL <>//
                
            default:
                this.levelExp = (short)(Math.pow(3.0, (double)level));
                break;
        }
    }
    
    public int getLevel(String skill){
        switch(skill.toUpperCase()){
            
            //<> WEAPONS<>//
            
            case "MEL":
                return (int)(Math.log10(this.skillExp[0]) / Math.log10(3.0));
            
            case "RNG":
                return (int)(Math.log10(this.skillExp[1]) / Math.log10(3.0));
                
            case "ESP":
                return (int)(Math.log10(this.skillExp[2]) / Math.log10(3.0));
            
            case "CHN":
                return (int)(Math.log10(this.skillExp[3]) / Math.log10(3.0));
            
            //<> UNARMED <>//
            
            case "BRL":
                return (int)(Math.log10(this.skillExp[4]) / Math.log10(3.0));
                
            case "GRP":
                return (int)(Math.log10(this.skillExp[5]) / Math.log10(3.0));
                
            case "DDG":
                return (int)(Math.log10(this.skillExp[6]) / Math.log10(3.0));
            
            case "BLK":
                return (int)(Math.log10(this.skillExp[7]) / Math.log10(3.0));
                
            //<> BODY <>//
            
            case "ACR":
                return (int)(Math.log10(this.skillExp[8]) / Math.log10(3.0));
                
            case "IMM":
                return (int)(Math.log10(this.skillExp[9]) / Math.log10(3.0));
                
            case "SNK":
                return (int)(Math.log10(this.skillExp[10]) / Math.log10(3.0));
            
            case "LIT":
                return (int)(Math.log10(this.skillExp[11]) / Math.log10(3.0));
            
            //<> UTIL <>//
                
            case "PRS":
                return (int)(Math.log10(this.skillExp[12]) / Math.log10(3.0));
                
            case "FAB":
                return (int)(Math.log10(this.skillExp[13]) / Math.log10(3.0));
                
            case "ALC":
                return (int)(Math.log10(this.skillExp[14]) / Math.log10(3.0));
            
            case "SMT":
                return (int)(Math.log10(this.skillExp[15]) / Math.log10(3.0));
                
            //<> that's it, nerd <>//
                
            default:
                return (int)(Math.log10(this.levelExp) / Math.log10(3.0));
        }
    }
}
