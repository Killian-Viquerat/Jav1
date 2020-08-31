package Model.cpnv.jav1;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import javax.xml.XMLConstants;
import javax.xml.bind.ValidationException;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Bird extends MovingObject {
    private static String picName = "bird.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    public static int originX = 150;
    public static int originY = 225;
    public boolean freeze = true;
    public boolean drag = false;

    public Bird(Vector2 speed) {
        super(picName,originX, originY, WIDTH, HEIGHT, speed);
    }

    @Override
    public void accelerate(float dt) {
        speed.y = speed.y - MovingObject.G;
    }
    public void reset(){
        setX(originX);
        setY(originY);
        freeze = true;
    }
    public void setSpeed(float x,float y, Rubber rubber){
        speed = new Vector2(x*rubber.Elasticity,y*rubber.Elasticity);
    }

}
