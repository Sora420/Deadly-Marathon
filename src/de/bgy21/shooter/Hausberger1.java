package de.bgy21.shooter;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;

import java.util.Random;

public class Hausberger1 extends BasicGame {

    private Circle playerCircle;
    private Circle[] fallingCircles;
    private Random random;
    private Input input;
    private int screenWidth;
    private int screenHeight;
    private float playerSpeed = 2.0f;
    private float[] circleSpeeds = {0.05f, 0.1f, 0.15f};
    private float playerRadius = 50;
    private boolean playerEnlarged = false;

    public Hausberger1() {
        super("Catch the falling Circles");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Hausberger1());
        container.setDisplayMode(1400, 800, false);
        container.start();
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.fill(playerCircle);

        g.setColor(Color.white);
        for (Circle circle : fallingCircles) {
            g.fill(circle);
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        container.setMinimumLogicUpdateInterval(15);
        container.setMaximumLogicUpdateInterval(15);
        input = container.getInput();
        random = new Random();
        screenWidth = container.getWidth();
        screenHeight = container.getHeight();

        //Create player circle in the center of the screen
        playerCircle = new Circle(screenWidth / 2, screenHeight / 2, playerRadius);

        //Create falling circles with random x-coordinates outside the screen
        fallingCircles = new Circle[3];
        for (int i = 0; i < fallingCircles.length; i++) {
            fallingCircles[i] = generateCircle();
        }
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        //Player movement
        if (input.isKeyDown(Input.KEY_LEFT) && playerCircle.getCenterX() - playerSpeed * delta > playerCircle.radius) {
            playerCircle.setCenterX(playerCircle.getCenterX() - playerSpeed * delta);
        }
        if (input.isKeyDown(Input.KEY_RIGHT) && playerCircle.getCenterX() + playerSpeed * delta < screenWidth - playerCircle.radius) {
            playerCircle.setCenterX(playerCircle.getCenterX() + playerSpeed * delta);
        }
        if (input.isKeyDown(Input.KEY_DOWN) && playerCircle.getCenterX() - playerSpeed * delta > playerCircle.radius) {
            playerCircle.setCenterY(playerCircle.getCenterY() - playerSpeed * delta);
        }
        if (input.isKeyDown(Input.KEY_UP) && playerCircle.getCenterX() + playerSpeed * delta < screenWidth - playerCircle.radius) {
            playerCircle.setCenterY(playerCircle.getCenterY() + playerSpeed * delta);
        }


        //Update falling circle
        for (Circle circle : fallingCircles){
            circle.setY(circle.getY() + circleSpeeds[(int)circle.getCenterX()] % 3 * delta);
            if (circle.getY() > screenHeight){
                resetCircle(circle);
            }
            if (circle.intersects(playerCircle)){
                if (!playerEnlarged){
                    playerRadius += 10; //increases player radius by 10 pixles
                    playerCircle.setRadius(playerRadius);
                    playerEnlarged = true;
                }
                circleSpeeds [(int) circle.getCenterX() % 3] += 0.01f;
            }
        }
        //Check for collision and handle growth
        for (Circle circle : fallingCircles){
            if (circle.intersects(playerCircle)){
                playerCircle.setRadius(playerCircle.getRadius() + 10); //Increases player radius by 10 pixles
                circleSpeeds [(int) circle.getCenterX() % 3] += 0.01f; //Increase circle speed
                resetCircle(circle);
            }
        }
    }
    private Circle generateCircle(){
        int x = random.nextInt(screenWidth);
        while (x > screenWidth / 3 && x < 2 * screenWidth / 3){
            x = random.nextInt(screenWidth);
        }
        return new Circle(x, -100, random.nextInt(30) + 20);
    }

    private void resetCircle(Circle circle){
        circle.setCenterX(random.nextInt(screenWidth));
        circle.setY(-100);
        circle.setRadius(random.nextInt(30) + 20);
    }

}