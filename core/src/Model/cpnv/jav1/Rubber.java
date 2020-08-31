package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.awt.HeadlessException;

public class Rubber extends Sprite {
    private static String picName = "rubber.png";
    private float HEIGHT = 15;
    private float WIDTH = 0;
    public static float Elasticity = 7;
    private float slingShotX;
    private float slingShotY;

    public Rubber(float slingShotX, float slingShotY){
        super(new Texture(picName));
        setBounds(slingShotX, slingShotY, WIDTH, HEIGHT);
        this.slingShotX = slingShotX;
        this.slingShotY = slingShotY;
    }

    public void update(Vector3 pointTouch,Bird bird){
        Vector2 Bvector = new Vector2(pointTouch.x - bird.getWidth()/2,pointTouch.y-bird.getHeight()/3);
        Vector2 Rvector = new Vector2(slingShotX,slingShotY);
        Vector2 RubberDirection = Rvector.sub(Bvector);
        setBounds(slingShotX,slingShotY,-RubberDirection.len(),HEIGHT);
        setOrigin(0,0);
        setRotation(RubberDirection.angle());
    }

    public void reset(){
        setX(slingShotX);
        setY(slingShotY);
        setSize(WIDTH,HEIGHT);
        setRotation(0);
    }
}
