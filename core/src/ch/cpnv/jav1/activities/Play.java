package ch.cpnv.jav1.activities;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;

import Model.cpnv.jav1.Bird;
import Model.cpnv.jav1.Bubble;
import Model.cpnv.jav1.PhysicalObject;
import Model.cpnv.jav1.Pig;
import Model.cpnv.jav1.Rubber;
import Model.cpnv.jav1.Scenery;
import Model.cpnv.jav1.SlingShot;
import Model.cpnv.jav1.Tnt;
import Model.cpnv.jav1.Wasp;

public class Play extends Game implements InputProcessor{
	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
	public static final int FLOOR_HEIGHT = 125;

	public static Random random;
	public int Score;
	private Texture background;
	private Texture panel;
	private Bubble bubble;
	private Bird bird;
	private Wasp wasp;
	private SpriteBatch batch;
	private BitmapFont font;
	private Scenery scene;
	private SlingShot slingshot1;
	private SlingShot slingshot2;
	private Rubber rubber1;
	private Rubber rubber2;
	private OrthographicCamera camera;
	private Sound sound;
	private PhysicalObject hit;

	public Play() {
		random = new Random();
		//Camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();
		//Texture
		background = new Texture("background.jpg");
		panel = new Texture("panel.png");
		//Batch
		batch = new SpriteBatch();
		//Bird/Wasp
		bird = new Bird(new Vector2(800,500));
		wasp = new Wasp(500,500,  new Vector2(0,0));
		//Level element
		scene = new Scenery();
		scene.createLevel();
		slingshot1 = new SlingShot("slingshot1.png");
		slingshot2 = new SlingShot("slingshot2.png");
		rubber1 = new Rubber(170,238);
		rubber2 = new Rubber(210,238);
		//Input
		Gdx.input.setInputProcessor(this);
		//Sound
		sound = Gdx.audio.newSound(Gdx.files.internal("data/CeTrucLa.mp3"));
		//Text
		Score = 0;
		font = new BitmapFont();
		font.getData().setScale(3f);
		//bubble
		bubble = new Bubble(0,0,"",0);
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
		batch.draw(panel, 100, WORLD_HEIGHT-250,250,250);
		slingshot1.draw(batch);
		rubber1.draw(batch);
		bird.draw(batch);
		rubber2.draw(batch);
		slingshot2.draw(batch);
		wasp.draw(batch);
		scene.draw(batch);
		if(bubble.getDuration()>0) {
			bubble.draw(batch);
			bubble.drawFont(batch);
		}
		font.draw(batch, "Score:"+Score, 1300, 800);
		batch.end();
	}

	public void update() {
		float dt = Gdx.graphics.getDeltaTime();
		if(dt < 1) {
			wasp.accelerate(dt);
			wasp.move(dt);
			if(!bird.freeze) {
				bird.accelerate(dt);
				bird.move(dt);
				if(bird.getY() < FLOOR_HEIGHT){
					bird.reset();
				}
			}
			hit = scene.OverlapBlock(bird);
			if(bird.Overlap(wasp)){
				bird.reset();
			}
			if(hit != null){
				if(hit.getClass() == Tnt.class){
					Score -= 1;
				}
				bird.reset();
			}
			
		}
		if(bubble.getDuration()>0) {
			bubble.updateDuration(dt);
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		Vector3 pointTouch = camera.unproject(new Vector3(x, y, 0));
		if (bird.freeze) {
			if (bird.getBoundingRectangle().contains(pointTouch.x, pointTouch.y))
				{
				if ((pointTouch.x >= 50 && pointTouch.x <= 200) && (pointTouch.y >= 125 && pointTouch.y <= 500)){
					bird.drag = true;
					bird.setPosition(pointTouch.x - bird.WIDTH / 2, pointTouch.y - bird.HEIGHT / 2);
					rubber1.update(pointTouch,bird);
					rubber2.update(pointTouch,bird);
				}
			}
		}
		return false;
	}
	@Override
	public boolean keyDown (int keycode) { return false; }
	@Override
	public boolean keyUp (int keycode) { return false; }
	@Override
	public boolean keyTyped (char character) { return false; }
	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {
		Vector3 pointTouch = camera.unproject(new Vector3(x, y, 0));
		ArrayList<PhysicalObject> pigs = scene.GetPig();
		for(PhysicalObject object :pigs) {
			if(object.getBoundingRectangle().contains(pointTouch.x, pointTouch.y)){
				bubble = new Bubble((object.getX()-object.getWidth()),(object.getY()+object.getHeight()),((Pig)object).sayWord(),2);
			}
		}
		return false;
	}
	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		if(bird.freeze && bird.drag) {
			Vector3 pointTouch = camera.unproject(new Vector3(x, y, 0));
			if ((pointTouch.x >= 50 && pointTouch.x <= 200) && (pointTouch.y >= 125 && pointTouch.y <= 500)) {
				bird.setSpeed(bird.originX + bird.WIDTH / 2 - pointTouch.x, bird.originY + bird.HEIGHT / 2 - pointTouch.y, rubber1);
				bird.freeze = false;
				bird.drag = false;
				rubber1.reset();
				rubber2.reset();
				sound.play(0.5f);
			}
		}
		return false;
	}
	@Override
	public boolean mouseMoved (int x, int y) { return false; }
	@Override
	public boolean scrolled (int amount) { return false;}
}
