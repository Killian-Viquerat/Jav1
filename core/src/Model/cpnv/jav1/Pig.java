package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;

public class Pig extends TextualObject {
    private int Points;
    private static String picName = "pig.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    public Pig(int srcX, int srcY, String word, int points) {
        super(picName, srcX, srcY, WIDTH, HEIGHT , word);
        Points = points;
    }

    public String sayWord(){
        return getWord();
    }
}
