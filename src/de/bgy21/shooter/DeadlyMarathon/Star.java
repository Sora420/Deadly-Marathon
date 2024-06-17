package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Star {
    // Variablen
    private float xStar;
    private float yStar;
    private float radius;

    // Konstruktor
    public Star(float xStar, float yStar, float radius) {
        this.xStar = xStar;
        this.yStar = yStar;
        this.radius = radius;
    }

    // Stern wird gerendert
    public void render(Graphics g) {
        g.fillOval(xStar - radius, yStar - radius, radius * 2, radius * 2);
    }

    // Methode für Collision detection
    public Circle getBoundingBox() {
        return new Circle(xStar, yStar, radius);
    }

    public float getX() {
        return xStar;
    }

    public float getY() {
        return yStar;
    }

    public float getRadius() {
        return radius;
    }
}
