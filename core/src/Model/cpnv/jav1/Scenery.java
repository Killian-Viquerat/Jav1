package Model.cpnv.jav1;
import com.badlogic.gdx.graphics.g2d.Batch;

import ch.cpnv.jav1.activities.Play;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Math.*;

public class Scenery {
    private static int BlockSize = 40;
    private ArrayList<PhysicalObject> scene;
    public Scenery(){
        scene = new ArrayList<PhysicalObject>();
    }

    public void addElement(PhysicalObject element){
        for(PhysicalObject object :scene) {
            if (element.Overlap(object)) {
                element.setY(object.getY() + object.getHeight());
            }
        }
        scene.add(element);
    }

    public void addPig(){
        for(int i = 0 ; i < 4 ; i++ ){
            int x = (int)(Math.random() * (Play.WORLD_WIDTH - 500)) + 500;
            addElement(new Pig(x,Play.FLOOR_HEIGHT,"Coucou",(int)Math.random()*10));
        }
    }

    public void addTnt(){
        for(int i = 0 ; i < 3 ; i++ ){
            int x = (int)(Math.random() * (Play.WORLD_WIDTH - 500)) + 500;
            addElement(new Tnt(x,Play.FLOOR_HEIGHT,(int)Math.random()*10));
        }
    }

    public void addBlock(){
        for(int i = 500;i < Play.WORLD_WIDTH; i+= BlockSize){
            addElement(new PhysicalObject("block.png",i,Play.FLOOR_HEIGHT,BlockSize,BlockSize));
        }
    }

    public void createLevel(){
        addBlock();
        addPig();
        addTnt();
    }

    public void draw(Batch batch){
        for(PhysicalObject element :scene){
            element.draw(batch);
        }
    }

    public PhysicalObject OverlapBlock(PhysicalObject element){
        for(PhysicalObject object :scene) {
            if(element.Overlap(object)){
                if(object.getClass() == Pig.class){
                    scene.remove(object);
                }
                return object;
            }
        }
        return null;
    }

    public ArrayList<PhysicalObject> GetPig(){
       ArrayList<PhysicalObject> pigs = new ArrayList<PhysicalObject>();
        for(PhysicalObject object :scene){
            if(object.getClass() == Pig.class){
                pigs.add(object);
            }
        }
        return pigs;
    }
}
