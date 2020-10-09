package ch.cpnv.jav1;

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
import java.util.Stack;

import ch.cpnv.jav1.activities.Play;
import ch.cpnv.jav1.activities.Welcome;

public class jav1bird extends Game {

	public static Stack<Game> pages;
	public static Random random;

	@Override
	public void create() {
		random = new Random();
		pages = new Stack<Game>();
		pages.push(new Welcome());
	}

	@Override
	public void render() {
		pages.peek().render();
	}

	public void update() {
	}
}
