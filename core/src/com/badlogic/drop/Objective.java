package com.badlogic.drop;

import com.badlogic.drop.Drop;
import com.badlogic.drop.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite; // Sprite demo
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Objective implements Screen{

    final Drop game;
    OrthographicCamera camera;
    Texture backgroundTexture;
    Sprite backSprite;

    public Objective(Drop gam) {
        game = gam;
        backgroundTexture= new Texture("Objective.jpg");
        backSprite = new Sprite(backgroundTexture);
        backSprite.setSize(800,480);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800.0F, 480.0F);
    }
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,2f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        backSprite.draw(game.batch);

        game.batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.B)){
            game.setScreen(new MainMenu(this.game));
            dispose();

        }



         /*   if (Gdx.input.isTouched()) {
                this.game.setScreen(new GameScreen(this.game));
                this.dispose();
            }
*/


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



