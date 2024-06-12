package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.Input;

public class Movement {

    // Variablen
    protected float x, y;
    protected float speed;
    protected float yVelocity;
    protected boolean isJumping;
    protected float gravity;
    protected final float JUMP_STRENGTH = -2f; // Stärke des Sprungs

    // Konstruktor
    public Movement(float startX, float startY, float speed) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.yVelocity = 0;
        this.isJumping = false;
        this.gravity = 0.009f; // Anpassen der Schwerkraft
    }

    // Inputs werden in Movement umgewandelt
    public void move(Input input, int delta) {
        if (input.isKeyDown(Input.KEY_LEFT)) {
            x -= speed * delta;
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            x += speed * delta;
        }
        if (input.isKeyPressed(Input.KEY_SPACE) && !isJumping) {
            jump();
        }

        // Apply gravity
        y += yVelocity;
        yVelocity += gravity;
    }

    public void jump() {
        isJumping = true;
        yVelocity = JUMP_STRENGTH; // Setzt die Sprungkraft
    }

    public void land(float groundY) {
        isJumping = false;
        yVelocity = 0;
        y = groundY - 20; // Stellt sicher, dass der Spieler genau auf dem Boden landet
    }

    // Getter & Setter
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
