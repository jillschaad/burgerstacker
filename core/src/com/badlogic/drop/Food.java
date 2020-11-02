package com.badlogic.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Food {

    public Texture texture;
    public  Sprite sprite;
    public Rectangle hitBox;
    public String name;

    public float dx;
    public float dy;

    public boolean active;

    public Food(String imageFileName, String name) {

        this.texture = new Texture(Gdx.files.internal(imageFileName));
        this.name = name;

        sprite = new Sprite(texture);
        sprite.flip(false, true);
        sprite.setScale(5);
        sprite.setOrigin(0, 0);
        hitBox = new Rectangle(0, 0, (int)sprite.getWidth(), (int)sprite.getHeight());
        hitBox.width = sprite.getWidth() * sprite.getScaleX();
        hitBox.height = sprite.getHeight() * sprite.getScaleY();

        dx = 0;
        dy = 0;

        active = true;

    }

    public void update() {

        hitBox.x += dx;
        hitBox.y += dy;
        sprite.setPosition(hitBox.x, hitBox.y);


    }

    public void draw(SpriteBatch batch) {

        sprite.draw(batch);

    }

}
