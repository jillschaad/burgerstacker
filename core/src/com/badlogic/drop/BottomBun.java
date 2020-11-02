package com.badlogic.game;

import com.badlogic.drop.FoodManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class BottomBun {
    Array<String> Order;
    com.badlogic.game.Food food; // bun
    FoodManager foodManager; // other foods
    Array<com.badlogic.game.Food> caughtFoods;
    Sound welldone;
    float speed;
    float topBunTimer;
    float topBunTime;
    Array<com.badlogic.game.Food> Level1;
    com.badlogic.game.Food food1;
    int x;

    public BottomBun(FoodManager foodManager) {
        Level1 = new Array<com.badlogic.game.Food>();
        food1 = new com.badlogic.game.Food("lettuce.png","lettuce");
        Level1.add(food1);



        this.foodManager = foodManager;

        caughtFoods = new Array<com.badlogic.game.Food>();

        food = new com.badlogic.game.Food("bottom_bun.png", "bun");
        food.hitBox.x = Gdx.graphics.getWidth() / 2;
        food.hitBox.y = Gdx.graphics.getHeight() - 80;
        food.sprite.setScale(6); // make bun bigger
        food.hitBox.width = food.sprite.getWidth() * food.sprite.getScaleX(); // fix width of hitbox
        food.hitBox.height = 6 * food.sprite.getScaleY(); // bun is 6 pixels high
        speed = 10;
        x =5;
        Order= FoodManager.makeOrder(x);
        caughtFoods.add(food);

    }


    public void update() {

        welldone = Gdx.audio.newSound(Gdx.files.internal("Yeah.wav"));
        // movement
        food.dx = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.Q)) {
            food.dx = -speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.P)) {
            food.dx = speed;
        }


        food.update();


        // collect food
        for (int i = 0; i < foodManager.foodArray.size; i++) {
            if (caughtFoods.get(caughtFoods.size - 1).hitBox.overlaps(foodManager.foodArray.get(i).hitBox)) {
                foodManager.foodArray.get(i).active = false;
                caughtFoods.add(foodManager.foodArray.get(i));
            }
        }

        // manage caught foods
        // caughtFood[0] is the bun, so i is 1
        for (int i = 1; i < caughtFoods.size; i++) {
            caughtFoods.get(i).hitBox.x = food.hitBox.x + food.hitBox.width / 2 - caughtFoods.get(i).hitBox.width / 2;
            caughtFoods.get(i).hitBox.y = food.hitBox.y - i * caughtFoods.get(i).hitBox.height / 2.5f;
            if (caughtFoods.get(i).name.equals("top bun")) { // adjust height of top bun
                caughtFoods.get(i).hitBox.y += caughtFoods.get(i).hitBox.height / 2f;
                welldone.play();
                x++;
                Order= FoodManager.makeOrder(x);
                //comapare method call goes here
            }
            caughtFoods.get(i).sprite.setPosition(caughtFoods.get(i).hitBox.x, caughtFoods.get(i).hitBox.y);
        }

        if (caughtFoods.get(caughtFoods.size - 1).name.equals("top bun")) {
            while (caughtFoods.size > 1) {
                caughtFoods.removeIndex(caughtFoods.size - 1);
            }
        }

    }

    public void draw(SpriteBatch batch) {

        //food.draw(batch);

        for (int i = 0; i < caughtFoods.size; i++) {
            caughtFoods.get(i).draw(batch);
        }

    }
    // compare method goes here
}
