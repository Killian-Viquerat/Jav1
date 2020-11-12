package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

import Model.cpnv.jav1.data.Word;

public class Button extends TextualObject {

    private static String picName = "button.png";
    private static final int WIDTH= 20;
    private static final int HEIGHT= 10;
    private BitmapFont font;
    private GlyphLayout glyphLayout;
    private String value;

    public Button(float srcX, float srcY,  String word){
        super(picName, srcX, srcY, WIDTH, HEIGHT , word);
        font = new BitmapFont();
        font.getData().setScale(2f);
        font.setColor(Color.WHITE);
        glyphLayout = new GlyphLayout(font, word);
        setSize(glyphLayout.width*2,glyphLayout.height*4);
    }

    public String getValue(){
        return value;
    }

    public boolean IsTouched(Vector2 point){
        if(this.getBoundingRectangle().contains(point.x, point.y)){
            return true;
        }
        return false;
    }

    public void drawFont(Batch batch){
        font.draw(batch, glyphLayout, getX()+(getWidth()-glyphLayout.width)/2, getY()+(getHeight()+glyphLayout.height*2)/2);
    }

    @Override
    public void draw(Batch batch){
        super.draw(batch);
        this.drawFont(batch);
    }
}
