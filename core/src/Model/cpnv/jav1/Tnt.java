package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;

public class Tnt extends PhysicalObject {
    private int negativePoints;
    private static String picName = "tnt.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    public Tnt(int srcX, int srcY, int negativePoints) {
        super(picName, srcX, srcY, WIDTH, HEIGHT);
        this.negativePoints = negativePoints;
    }
}
