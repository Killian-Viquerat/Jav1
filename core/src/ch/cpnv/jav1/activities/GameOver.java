package ch.cpnv.jav1.activities;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

import ch.cpnv.jav1.jav1bird;

public class GameOver extends Game implements InputProcessor{

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
	public static Random random;
	private Texture background;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BitmapFont font;

	public GameOver() {
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
		font.draw(batch, "Game Over", WORLD_WIDTH/3, WORLD_HEIGHT/4*3);
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
		jav1bird.pages.pop();
		jav1bird.pages.pop();
		jav1bird.pages.pop();
		jav1bird.pages.push(new Welcome());
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
