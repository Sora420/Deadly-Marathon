
package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class Player extends Movement {

    //Variablen
    private float radius;
    private Image playerSprite;

    //Construktor
    public Player(float startX, float startY, float speed, float radius) {
        super(startX, startY, speed);
        this.radius = radius;
    }

    //Player wird gerendert
    public void render(Graphics g) {
        g.drawImage(playerSprite, x - radius, y - radius);
    }

    //Methode für Collision detection
    public Circle getBoundingBox() {
        return new Circle(x, y, radius);
    }

    //Methode um Sprite für den Spieler aus zu geben
    public void draw() throws SlickException {
        playerSprite = new Image("src/de/bgy21/shooter/DeadlyMarathon/sprites/croco.png");
    }

    //Collision check für "Player" und "Ground"
    public boolean checkCollision(Ground ground) {
        Rectangle groundRect = new Rectangle(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
        Circle playerCircle = getBoundingBox();
        return groundRect.intersects(playerCircle);
    }
}
