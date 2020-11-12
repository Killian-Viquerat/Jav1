package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;

import Model.cpnv.jav1.data.Word;

public abstract class TextualObject extends PhysicalObject {
    protected String text;

    public TextualObject(String picName, float srcX, float srcY,  int WIDTH, int HEIGHT, String word) {
        super(picName, srcX, srcY, WIDTH, HEIGHT);
        this.text = word;
    }

    protected String getWord(){
        return text;
    }
}
