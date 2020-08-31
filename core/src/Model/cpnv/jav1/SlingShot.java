package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SlingShot extends Sprite {
    private float srcX =150;
    private float srcY =125;
    public static final int WIDTH = 70;
    public static final int HEIGHT = 150;

    public SlingShot(String picName) {
        super(new Texture(picName));
        setBounds(srcX, srcY, WIDTH, HEIGHT);
    }
}
