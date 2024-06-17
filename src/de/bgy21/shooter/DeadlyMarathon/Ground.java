
package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class Ground {

    //Variablen
    protected float groundWidth, groundHeight, groundX, groundY;
    private Image groundSprite;

    //Construktor
    public Ground(float groundWidth, float groundHeight, float groundX, float groundY) {
        this.groundWidth = groundWidth;
        this.groundHeight = groundHeight;
        this.groundX = groundX;
        this.groundY = groundY;
    }

    //Rendert den Boden
    //TODO:Fix Ground Overlapping
    public void render(Graphics g) {
        g.fillRect(groundX, groundY, groundWidth, groundHeight);
        //g.drawImage(groundSprite,groundX, groundY);
    }

    //Methode um Sprite für den Boden aus zu geben
    public void draw() throws SlickException {
        groundSprite = new Image("src/de/bgy21/shooter/DeadlyMarathon/sprites/ground.png");
    }

    //Getter & Setter
    public float getWidth() {
        return groundWidth;
    }

    public float getHeight() {
        return groundHeight;
    }

    public float getX() {
        return groundX;
    }

    public float getY() {
        return groundY;
    }

    //Methode für Collision detection
    public Rectangle getBoundingBox() {
        return new Rectangle(groundX, groundY, groundWidth, groundHeight);
    }
}