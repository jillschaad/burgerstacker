package com.badlogic.drop;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntFloatMap;


public class FoodManager {

    public Array<com.badlogic.game.Food> foodArray;
   static String[] foodNames = { "cheese" , "tomato", "burger", "lettuce", "pickles", "top bun" };
   static String[] foodImageFileNames = { "cheese.png", "tomato.png", "burger.png", "lettuce.png", "pickles.png", "top_bun.png" };


    public FoodManager() {

        foodArray = new Array<com.badlogic.game.Food>();

    }
    public static Array<String> makeOrder(int x) {
       Array<String> array = new Array<String>();
        for (int i = 0; i < x; i++){
            int index = (int) (Math.random() * foodNames.length);
            array.add( foodNames[index]);

        }
        return array;
    }

    public void makeFood() {

        int index = (int)(Math.random() * foodNames.length);
        com.badlogic.game.Food food = new com.badlogic.game.Food(foodImageFileNames[index], foodNames[index]);
        food.hitBox.x = (int)(Math.random() * Gdx.graphics.getWidth());
        food.hitBox.y = -(int)food.sprite.getHeight() * food.sprite.getScaleY();
        food.dx = (float)(Math.random() * 2 - 1);
        food.dy = (float)(Math.random() * 5 + 3);

        if (food.name.equals("top bun")) {
            food.sprite.setScale(6);
            food.hitBox.width = food.sprite.getWidth() * food.sprite.getScaleX();
            food.hitBox.height = food.sprite.getHeight() * food.sprite.getScaleY();

        }

        foodArray.add(food);

    }

    public void update() {

        // make food at random intervals
        if (Math.random() < .03) {
            makeFood();
        }

        // update all food
        for (int i = 0; i < foodArray.size; i++) {

            foodArray.get(i).dy += .3f; // gravity
            foodArray.get(i).update(); // movement

            // out of bounds
            if (foodArray.get(i).hitBox.y > Gdx.graphics.getHeight()) {
                foodArray.get(i).active = false;
            }

        }

        // remove nonactive food
        for (int i = 0; i < foodArray.size; i++) {
            if (!foodArray.get(i).active) {
                foodArray.removeIndex(i);
                i -= 1;
            }
        }

    }

    public void draw(SpriteBatch batch) {

        for (int i = 0; i < foodArray.size; i++) {
            foodArray.get(i).draw(batch);
        }

    }

}
