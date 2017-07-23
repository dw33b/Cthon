package chthon;

import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.*;
import java.util.*;
import org.newdawn.slick.util.*;

public class Visual{
    
    public ArrayList<Texture> textures = new ArrayList<Texture>();
    String type;
    String sub;
    int rate = 1;
    int frame = 0;
    public double scale = 1.0;
    boolean bumpMap = false;
    
    public Visual(String type, String sub, int rate, boolean bumpMap){
        this.type = type;
        this.sub = sub;
        this.rate = rate;
        this.bumpMap = bumpMap;
        initNewTextureGroup(type);
    }
    
    public Visual(String type, String sub, int rate){
        this.type = type;
        this.sub = sub;
        this.rate = rate;
        initNewTextureGroup(type);
    }
    
    public void draw(int screenX, int screenY){
        
        frame = ((int)Math.round(((System.currentTimeMillis() * rate) % (textures.size() * 1000)) / 1000));
        
        if(bumpMap){
            drawRect(screenX, screenY, textures.get(frame).getImageWidth(), textures.get(frame).getImageHeight(), textures.get(frame));   
        }else{
            drawRect(screenX, screenY, textures.get(frame).getImageWidth(), textures.get(frame).getImageHeight(), textures.get(frame));
        }
        
    }
    
    public void initNewTextureGroup(String type){
        try{
            int i = 0;
            while(ResourceLoader.resourceExists(("res/" + type + "/" + sub + i + ".png"))){
                textures.add(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/" + type + "/" + sub + i + ".png")));
                System.out.println("\n[o]SUCCESS: LOADED \"" + type + "/" + sub + i + ".png\"[o]\n[x]IMAGE WIDTH:" + textures.get(i).getImageWidth() + "\n[x]IMAGE HEIGHT:" + textures.get(i).getImageHeight() + "\n[x]TEXTURE WIDTH:" + textures.get(i).getTextureWidth() + "\n[x]TEXTURE HEIGHT:" + textures.get(i).getTextureHeight() + "\n[x]TEXTURE ID:" + textures.get(i).getTextureID());
                
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
            if(e.getClass() == ArrayIndexOutOfBoundsException.class) System.out.println("\n[!]YOU NEED A BIGGER ARRAY, IDIOT[!]");
            System.exit(15);
        }
    }
    
    public void drawRect(int x, int y, int width, int height, Texture image){
        image.bind();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
	GL11.glVertex2f(x,y);
	GL11.glTexCoord2f(1,0);
	GL11.glVertex2f(x + (int)(width * scale),y);
	GL11.glTexCoord2f(1,1);
	GL11.glVertex2f(x + (int)(width * scale),y + (int)(height * scale));
	GL11.glTexCoord2f(0,1);
	GL11.glVertex2f(x,y + (int)(height * scale));
	GL11.glEnd();
    }
}
