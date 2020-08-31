package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;

public class TextualObject extends PhysicalObject {
    protected String word;

    public TextualObject(String picName, float srcX, float srcY,  int WIDTH, int HEIGHT, String word) {
        super(picName, srcX, srcY, WIDTH, HEIGHT);
        this.word = word;
    }

    protected String getWord(){
        return word;
    }
}
