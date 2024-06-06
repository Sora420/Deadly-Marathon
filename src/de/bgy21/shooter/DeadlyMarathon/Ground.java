package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.Graphics;

import java.awt.*;

public class Ground {

    protected float groundWidth,groundHeight,groundX,groundY;


    public Ground(float groundWidth, float groundHeight,float groundX, float groundY){
       this.groundWidth = groundWidth;
       this.groundHeight = groundHeight;
       this.groundX = groundX;
       this.groundY = groundY;

    }

    public void render(Graphics g) { g.fillRect(groundX,groundY,groundWidth,groundHeight);}
}
