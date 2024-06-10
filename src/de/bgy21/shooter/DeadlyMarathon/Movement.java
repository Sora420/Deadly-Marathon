package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.Input;

public class Movement {
    protected float x, y;
    protected float speed;

    public Movement(float startX, float startY, float speed) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
    }

    public void move(Input input, int delta) {
        if (input.isKeyDown(Input.KEY_UP)) {
            y -= speed * delta;
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            y += speed * delta;
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            x -= speed * delta;
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            x += speed * delta;
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}