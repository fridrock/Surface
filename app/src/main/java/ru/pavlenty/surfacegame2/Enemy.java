package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Enemy {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed;
    private boolean boosting;
    private final int maxSpeed = 25;
    private final int minSpeed = 5;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    public Enemy(Context context,int screenX,int screenY){
        Random generator  = new Random();
        this.maxY = screenY;
        this.speed = 1;
        this.x = screenX-generator.nextInt(350);
        this.y = generator.nextInt(maxY);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);


    }
    public void update(int playerSpeed){
        this.x -=speed+playerSpeed
        ;


    }

    public void setBoosting() {
        boosting = true;
    }

    public void stopBoosting() {
        boosting = false;
    }
    public void update(boolean boosting){
        if(boosting){
            this.speed+=5;
            if(this.speed>maxSpeed){
                this.speed = maxSpeed;
            }
        }else{
            if(this.speed <minSpeed){
                this.speed = minSpeed;
            }
            this.speed -= 2;
        }
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() { return y; }
    public void restart(int x ){
        Random generator = new Random();

        this.x = x-generator.nextInt(350);
        this.y = generator.nextInt(maxY);

    }
    public int getSpeed() {
        return speed;
    }
}
