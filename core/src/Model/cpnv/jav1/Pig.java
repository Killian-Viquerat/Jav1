package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import Model.cpnv.jav1.data.SemanticWord;
import Model.cpnv.jav1.data.Word;
import ch.cpnv.jav1.activities.Play;

public class Pig extends TextualObject {
    private int Points;
    public Bubble bubble = null;
    private static String picName = "pig.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    public boolean talking = false;
    public SemanticWord word;

    public Pig(int srcX, int srcY, SemanticWord word, int points) {
        super(picName, srcX, srcY, WIDTH, HEIGHT , word.getValue(Play.ISO2));
        this.word = word;
        Points = points;
    }
    @Override
    public void draw(Batch batch){
        super.draw(batch);
        if(talking){ bubble.draw(batch);}
    }

    public void createBubble(){
        if(bubble == null) {
            bubble = new Bubble((this.getX() - this.getWidth()), (this.getY() + this.getHeight()), ((Pig) this).sayWord(), 2);
        }
    }
    public SemanticWord sayWord(){
        return word;
    }
}
