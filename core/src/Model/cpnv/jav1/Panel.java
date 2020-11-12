package Model.cpnv.jav1;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import Model.cpnv.jav1.data.SemanticWord;
import Model.cpnv.jav1.data.Word;
import ch.cpnv.jav1.activities.Play;
import ch.cpnv.jav1.activities.Welcome;

public class Panel extends Sprite {

    private static final String PICNAME = "panel.png";
    private static final float WIDTH = 250;
    private static final float HEIGHT = 250;
    private static final float POSX = 100;
    private static final float POSY = Play.WORLD_HEIGHT-WIDTH;
    private static final float TEXT_OFFSET_X = 125;
    private static final float TEXT_OFFSET_Y = 125;

    private BitmapFont font;
    public SemanticWord word;

    public Panel(SemanticWord word){
        super(new Texture(PICNAME));
        setBounds(POSX,POSY,WIDTH,HEIGHT);
        this.word = word;
        font = new BitmapFont();
        font.getData().setScale(2f);
        font.setColor(Color.BLACK);
    }

    public void drawFont(Batch batch){
        font.draw(batch, word.getValue(Play.ISO1),getX()+TEXT_OFFSET_X, getY()+TEXT_OFFSET_Y);
    }

    public void draw(Batch batch){
        super.draw(batch);
        this.drawFont(batch);
    }
}
