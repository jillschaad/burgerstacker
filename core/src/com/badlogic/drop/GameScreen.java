package com.badlogic.drop;
import java.util.*;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {

	OrthographicCamera camera;
	SpriteBatch batch;
	FoodManager foodManager;
	com.badlogic.game.BottomBun bottomBun;
	Sprite backgroundSprite;
	Texture backgroundTexture;

	// Sprite demo
	int framecount = 1;
	int incr = 1;

	public GameScreen(final Drop gam) {


		Gdx.graphics.setWindowedMode(700, 900);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true,700,900);

		foodManager = new FoodManager();
		bottomBun = new com.badlogic.game.BottomBun(foodManager);
		backgroundTexture= new Texture("background.jpg");
		backgroundSprite = new Sprite(backgroundTexture);
		batch = new SpriteBatch();

	}

	@Override
	public void render (float delta) {

		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		foodManager.update();
		bottomBun.update();

		batch.begin();
		backgroundSprite.draw(batch);
		foodManager.draw(batch);
		bottomBun.draw(batch);

		batch.end();

		batch.setProjectionMatrix(camera.combined);



	}
	public void resize(int width, int height) {
	}

	public void show() {
	}

	public void hide() {
	}

	public void pause() {
	}

	public void resume() {
	}

	public void dispose() {
	}
}
