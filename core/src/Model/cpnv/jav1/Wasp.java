package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ch.cpnv.jav1.activities.Play;

public class Wasp extends MovingObject {
    private static final int AGITATION = 15;
    private static String picName = "wasp.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;

    @Override
    public void accelerate(float dt){
            Vector2 craziness = new Vector2((Play.random.nextFloat() - (getX() / Play.WORLD_WIDTH))* 0.5f , (Play.random.nextFloat() - (getY() / Play.WORLD_HEIGHT))* 0.5f);
            speed = speed.add(craziness.scl(AGITATION));
    }

    public Wasp(int srcX, int srcY, Vector2 speed) {
        super(picName, srcX, srcY, WIDTH, HEIGHT, speed);
    }
}
