package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class MovingObject extends PhysicalObject {

    public final static float G = 9.81f;
    protected Vector2 speed;

    public MovingObject(String picName, int srcX, int srcY, int WIDTH, int HEIGHT, Vector2 speed) {
        super(picName, srcX, srcY, WIDTH, HEIGHT);
        this.speed = speed;
    }

    public void move(float dt){
        translate(speed.x*dt, speed.y*dt);
    }

    public abstract void accelerate(float dt);
}
