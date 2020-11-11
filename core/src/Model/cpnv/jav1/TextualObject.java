package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;

import Model.cpnv.jav1.data.Word;

public class TextualObject extends PhysicalObject {
    protected Word word;

    public TextualObject(String picName, float srcX, float srcY,  int WIDTH, int HEIGHT, Word word) {
        super(picName, srcX, srcY, WIDTH, HEIGHT);
        this.word = word;
    }

    protected Word getWord(){
        return word;
    }
}
