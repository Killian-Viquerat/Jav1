package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PhysicalObject extends Sprite {
    public PhysicalObject(String picName, float srcX, float srcY, int WIDTH, int HEIGHT)  {
        super(new Texture(picName));
        setBounds(srcX, srcY, WIDTH, HEIGHT);
    }

    public boolean Overlap(PhysicalObject Object){
        return this.getBoundingRectangle().overlaps(Object.getBoundingRectangle());
    }
}
