package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.Graphics;

public class Player extends Movement {

    private float radius;

    public Player(float startX, float startY, float speed, float radius) {
        super(startX, startY, speed);
        this.radius = radius;
    }

    public void render(Graphics g) {
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
