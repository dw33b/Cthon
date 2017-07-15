package chthon;

import java.util.logging.*;
import org.lwjgl.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.opengl.GL11.*;

public class Main{
    
    private static Game game;
    private static int width = 800;
    private static int height = 600;
    
    
    public static void main(String[] args){
        //init
        initDisplay();
        initGL();
        initGame();
        gameLoop();
        cleanUp();
    }
    
    private static void initDisplay(){
        
        try{
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Display.setTitle("big meme");
            Display.setVSyncEnabled(true);
            Keyboard.create();
            Mouse.create();
        }catch(LWJGLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void initGL(){
        
        glClearColor(0, 0, 0, 1);
        
        glDisable(GL_DEPTH_TEST);
        
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        
        // enable alpha blending
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
       	GL11.glViewport(0,0,width,height);
	GL11.glMatrixMode(GL11.GL_MODELVIEW);
        
	GL11.glMatrixMode(GL11.GL_PROJECTION);
	GL11.glLoadIdentity();
	GL11.glOrtho(0, width, height, 0, 1, -1);
	GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }
    
    private static void initGame(){
        game = new Game();
    }
    
    private static void gameLoop(){
        
        while(!Display.isCloseRequested()){
            getInput();
            update();
            render();
            Display.update();
        }
    }
    
    private static void cleanUp(){
        
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
    }
    
    private static void getInput(){
        game.getInput();
    }
    
    private static void update(){
        game.update();
    }
    
    private static void render(){
        
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();
        
        game.render();
            
        Display.update();
        Display.sync(60);
    }
}
