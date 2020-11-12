package Model.cpnv.jav1;
import com.badlogic.gdx.graphics.g2d.Batch;

import Model.cpnv.jav1.data.SemanticWord;
import Model.cpnv.jav1.data.Vocabulary;
import Model.cpnv.jav1.data.Word;
import ch.cpnv.jav1.activities.Play;
import ch.cpnv.jav1.customException.OutOfSceneryException;

import java.util.ArrayList;

public class Scenery {
    private static int BlockSize = 40;
    public ArrayList<PhysicalObject> scene;

    public Scenery(){
        scene = new ArrayList<PhysicalObject>();
    }

    public void addElement(PhysicalObject element){
        for(PhysicalObject object :scene) {
            if (element.Overlap(object)) {
                element.setY(object.getY() + object.getHeight());
            }
        }
        try {
            if (element.getX() < 0 || element.getX() > Play.WORLD_WIDTH || element.getY() < 0 || element.getY() > Play.WORLD_HEIGHT)throw new OutOfSceneryException("Element out of scenery");
                scene.add(element);
        }catch(OutOfSceneryException e){
        }
    }

    public void addPig(Vocabulary voc){
        for(int i = 0 ; i < 4 ; i++ ){
            int x = (int)(Math.random() * (Play.WORLD_WIDTH - 500)) + 500;
            addElement(new Pig(x,Play.FLOOR_HEIGHT,voc.pickAWord(),(int)Math.random()*10));
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

    public void createLevel(Vocabulary voc){
        addBlock();
        addTnt();
        addPig(voc);
    }

    public void draw(Batch batch){
        for(PhysicalObject element :scene){
            element.draw(batch);
        }
    }

    public PhysicalObject OverlapBlock(PhysicalObject element){
        for(PhysicalObject object :scene) {
            if(element.Overlap(object)){
                return object;
            }
        }
        return null;
    }

    public ArrayList<Pig> GetPig(){
       ArrayList<Pig> pigs = new ArrayList<Pig>();
        for(PhysicalObject object :scene){
            if(object instanceof Pig){
                pigs.add((Pig)object);
            }
        }
        return pigs;
    }

    public SemanticWord GetRandomPigWord(){
        ArrayList<Pig> pigs = new ArrayList<Pig>();
        for(PhysicalObject object :scene){
            if(object instanceof Pig){
                pigs.add((Pig)object);
            }
        }
        return pigs.get(Play.random.nextInt(pigs.size())).sayWord();
    }
}
