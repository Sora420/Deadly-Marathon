package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

public class Player extends Movement {

    // Variablen
    private float radius;
    private Image playerSprite;

    // Konstruktor
    public Player(float startX, float startY, float speed, float radius) {
        super(startX, startY, speed);
        this.radius = radius;
    }

    // Player wird gerendert
    public void render(Graphics g) {
        g.drawImage(playerSprite, x - radius, y - radius);
    }

    // Methode für Collision detection
    public Circle getBoundingBox() {
        return new Circle(x, y, radius);
    }

    // Methode um Sprite für den Spieler auszugeben
    public void draw() throws SlickException {
        playerSprite = new Image("src/de/bgy21/shooter/DeadlyMarathon/sprites/croco.png");
    }

    // Methode für Gravitation des Spielers
    public void fall() {
        yVelocity += gravity;
        y += yVelocity;
    }

    // Methode zum Landen des Spielers
    public void land(float groundY) {
        super.land(groundY);
    }

    // Collision check für "Player" und "Ground"
    public boolean checkCollision(Ground ground) {
        return getBoundingBox().intersects(ground.getBoundingBox());
    }
}
