package com.badlogic.drop;

import com.badlogic.drop.Drop;
import com.badlogic.drop.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite; // Sprite demo
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class MainMenu implements Screen {

    final Drop game;
    OrthographicCamera camera;
    Texture backgroundTexture;
    Sprite blankSprite;
    SpriteBatch blankBatch;
    Texture blankImage;
    Rectangle blank;
    TextureAtlas buttonAtlas;
    Stage blankStage;
    TextButton newGameButton;
    Music mainscreenmusic;

    public MainMenu(Drop gam) {
        this.game = gam;
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 800.0F, 480.0F);

        blankImage = new Texture(Gdx.files.internal("tb81pqr.jpg-2.png"));
        blankSprite = new Sprite(blankImage);

        blank = new Rectangle();
        blank.x = 200;
        blank.y = 80;

        blank.width = 100;
        blank.height = 80;
        mainscreenmusic = Gdx.audio.newMusic(Gdx.files.internal("Liluzi.mp3"));
        mainscreenmusic.play();
    }

        public void render(float delta) {
            //Gdx.gl.glClearColor(0.0F, 0.0F, 0.2F, 1.0F);
            //Gdx.gl.glClear(16384);
            backgroundTexture = new Texture("kitchenNEW2.jpg");


            camera.update();
            game.batch.setProjectionMatrix(this.camera.combined);
            game.batch.begin();
            game.batch.draw(new TextureRegion(backgroundTexture, 0, 0, backgroundTexture.getWidth(), backgroundTexture.getHeight()), 0, 0);
            //this.game.font.draw(this.game.batch, "CHEF HAMZA'S BURGER STACKER!!! ", 100.0F, 80.0F);

            game.batch.draw(blankImage, blank.x, blank.y);
            blankSprite.setPosition(blank.x, blank.y);
            blankSprite.draw(game.batch);


            //this.game.font.draw(this.game.batch, "Press SPACE to begin!", 100.0F, 60.0F);
            game.batch.end();

           if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
               this.game.setScreen(new GameScreen(this.game));
               this.dispose();
               mainscreenmusic.stop();
           }
            if(Gdx.input.isKeyPressed(Input.Keys.I)){
                this.game.setScreen(new InstructionScreen(game));
                this.dispose();
                mainscreenmusic.stop();
            }
            if(Gdx.input.isKeyPressed(Input.Keys.O)) {
                this.game.setScreen(new Objective(game));
                this.dispose();
                mainscreenmusic.stop();



         /*   if (Gdx.input.isTouched()) {
                this.game.setScreen(new GameScreen(this.game));
                this.dispose();
            }
*/

            }
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


