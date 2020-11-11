package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import Model.cpnv.jav1.data.Word;

public class Bubble extends TextualObject {
    private float Duration;
    private static String picName = "bubble.png";
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    private BitmapFont font;
    private GlyphLayout glyphLayout;

    public Bubble(float srcX, float srcY, Word word, float duration) {
        super(picName, srcX, srcY, WIDTH, HEIGHT, word);
        Duration = duration;
        font = new BitmapFont();
        font.getData().setScale(2f);
        font.setColor(Color.BLACK);
        glyphLayout = new GlyphLayout(font, word.getValue2());
        setSize(glyphLayout.width*2,glyphLayout.height*4);
    }

    public float getDuration() {
        return Duration;
    }

    public void updateDuration(float dt){
        Duration -=dt;
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
