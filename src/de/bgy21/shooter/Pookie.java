package de.bgy21.shooter;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Pookie extends BasicGame {

    private Shape playerCircle;
    private int XPos1,XPos2;
    private int YPos1,YPos2;

    public Pookie() {
        super("Fensinator");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Pookie());
        container.setDisplayMode(800, 600, false);
        container.start();

    }

    @Override
    public void render(GameContainer container, Graphics g)
            throws SlickException {
        g.setColor(Color.red);
        g.fill(playerCircle);
    }

    @Override
    public void init(GameContainer container) throws SlickException {

        XPos1 = 400;
        YPos1 = 300;
        playerCircle = new Ellipse(XPos1, YPos1, 50, 50);
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        Input input = container.getInput();

        if (input.isMousePressed(Input.KEY_RIGHT)){
            playerCircle.setX(playerCircle.getX() + 10);
        }

            //Fenster mit ESC sclie�en
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            container.exit();
        }
    }
}
