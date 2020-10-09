package ch.cpnv.jav1.activities;

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
	private Texture background;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BitmapFont font;

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
		font.draw(batch, "Welcome to Angryyy Worst", WORLD_WIDTH/3, WORLD_HEIGHT/4*3);
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
		jav1bird.pages.push(new Play());
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
