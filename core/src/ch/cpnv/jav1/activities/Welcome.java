package ch.cpnv.jav1.activities;

import Model.cpnv.jav1.data.Language;
import Model.cpnv.providers.VocProvider;
import ch.cpnv.jav1.jav1bird;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;

import Model.cpnv.jav1.*;

public class Welcome extends Game implements InputProcessor{

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
	public static Random random;
	public String firstLanguage = "(choisir)";
	public String secondLanguage = "(choisir)";
	public String firstISOLanguage = "";
	public String secondISOLanguage = "";
	private Texture background;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BitmapFont font;
	private ArrayList<Language> languages;
	private ArrayList<Button> buttons1 = new ArrayList<Button>();
	private int Y_buttons = 350;
	private ArrayList<Button> buttons2 = new ArrayList<Button>();
	private Button ok;
	private VocProvider vocSource = VocProvider.getInstance();

	public Welcome() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();
		random = new Random();
		background = new Texture("background.jpg");
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.getData().setScale(3f);
		Gdx.input.setInputProcessor(this);
		languages = vocSource.getLanguages();
		for(Language language :languages) {
			Button button = new Button(WORLD_WIDTH/3,Y_buttons,language.getDisplayName(),language.getISO_639_1()); buttons1.add(button);
			Y_buttons -= (button.getHeight()+10);
		}
		Y_buttons = 350;
		for(Language language :languages) {
			Button button = new Button(WORLD_WIDTH/2,Y_buttons,language.getDisplayName(),language.getISO_639_1()); buttons2.add(button);
			Y_buttons -= (button.getHeight()+10);
		}
		ok = new Button(WORLD_WIDTH/4,WORLD_HEIGHT/5*3,"ok","");
	}

	@Override
	public void create(){
	}

	@Override
	public void render () {
		update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
		font.draw(batch, "Angryyy Zawarudo", WORLD_WIDTH/3, WORLD_HEIGHT/5*4);
		font.draw(batch, "Exercice de "+ firstLanguage +" en "+ secondLanguage, WORLD_WIDTH/3, WORLD_HEIGHT/5*3);
		for(Button button : buttons1){
			button.draw(batch);
		}
		for(Button button : buttons2){
			button.draw(batch);
		}
		if(firstLanguage != "(choisir)" && secondLanguage != "(choisir)") {
			ok.draw(batch);
		}
		batch.end();
	}

	public void update() {
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		return false;
	}
	@Override
	public boolean keyDown (int keycode) {
		return false;
	}
	@Override
	public boolean keyUp (int keycode) { return false; }
	@Override
	public boolean keyTyped (char character) { return false; }
	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {
		Vector3 pointTouch = camera.unproject(new Vector3(x, y, 0));
		Vector2 point = new Vector2(pointTouch.x,pointTouch.y);
		for(Button b :buttons1){
			if(b.IsTouched(point)){
				firstLanguage = b.getWord();
				firstISOLanguage = b.getValue();
				buttons1 = new ArrayList<Button>();
			}
		}
		for(Button b :buttons2){
			if(b.IsTouched(point)){
				secondLanguage = b.getWord();
				secondISOLanguage = b.getValue();
				buttons2 = new ArrayList<Button>();
			}
		}
		if(firstLanguage != "(choisir)" && secondLanguage != "(choisir)") {
			if (ok.IsTouched(point)) {
				jav1bird.pages.push(new Play(firstISOLanguage,secondISOLanguage,firstLanguage,secondLanguage));
			}
		}
		return false;
	}
	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		return false;
	}
	@Override
	public boolean mouseMoved (int x, int y) { return false; }
	@Override
	public boolean scrolled (int amount) { return false;}
}
