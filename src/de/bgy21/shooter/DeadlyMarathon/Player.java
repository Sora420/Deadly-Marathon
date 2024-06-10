package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class Player extends Movement {

    private float radius;

    public Player(float startX, float startY, float speed, float radius) {
        super(startX, startY, speed);
        this.radius = radius;
    }

    public void render(Graphics g) {
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public Circle getBoundingBox() {
        return new Circle(x, y, radius);
    }

    public boolean checkCollision(Ground ground) {
        Rectangle groundRect = new Rectangle(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
        Circle playerCircle = getBoundingBox();
        return groundRect.intersects(playerCircle);
    }
}
