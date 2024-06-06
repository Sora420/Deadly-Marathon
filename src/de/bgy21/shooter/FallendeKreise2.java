package de.bgy21.shooter;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class FallendeKreise2 extends BasicGame {

    private Shape circle,circle2,circle3,circle4;
    private Input input;
    private Random random;
    private Image image,image2,image3,image4;
    private int xPosKreis1, yPosKreis1, yKreis1,xPosKreis2, yPosKreis2, yKreis2, xPosKreis3,yPosKreis3,yKreis3,xPosKreis4,yPosKreis4,yKreis4;


    public FallendeKreise2() {
        super("Mmmhhhh Orang");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new FallendeKreise2());
        container.setDisplayMode(800, 600, false);
        container.start();
    }

    @Override
    public void render(GameContainer container, Graphics g)
            throws SlickException {
        g.drawImage(image,xPosKreis1,yPosKreis1);
        g.drawImage(image2,xPosKreis2,yPosKreis2);
        g.drawImage(image3,xPosKreis3,yPosKreis3);
        g.drawImage(image4,xPosKreis4,yPosKreis4);

    }

    @Override
    public void init(GameContainer container) throws SlickException {

        container.setMinimumLogicUpdateInterval(55);
        container.setMaximumLogicUpdateInterval(55);

        input = container.getInput();
        random = new Random();

        yKreis1 = 12;
        xPosKreis1 = random.nextInt(container.getWidth());
        yPosKreis1= -100;

        yKreis2 = 15;
        xPosKreis2 = random.nextInt(container.getWidth());
        yPosKreis2 = -50;

        yKreis3 = 10;
        xPosKreis3 = random.nextInt(container.getWidth());
        yPosKreis3 = -150;

        yKreis4 = 18;
        xPosKreis4 = random.nextInt(container.getWidth());
        yPosKreis4 = -200;

        circle = new Circle(xPosKreis1,yPosKreis1,25);
        circle2 = new Circle(xPosKreis2,yPosKreis2,50);
        circle3 = new Circle(xPosKreis3,yPosKreis3,75);
        circle4 = new Circle(xPosKreis4,yPosKreis4,100);
        image = new Image("testdata/circle_orange_basis_t_50.png");
        image2 = new Image("testdata/circle_orange_basis_t_75.png");
        image3 = new Image("testdata/circle_orange_basis_t_100.png");
        image4 = new Image("testdata/circle_orange_basis_t_125.png");

    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {

    yPosKreis1 = (int) circle.getCenterY();
    xPosKreis1 = (int) circle.getCenterX();

    yPosKreis2 = (int) circle2.getCenterY();
    xPosKreis2 = (int) circle2.getCenterX();

    yPosKreis3 = (int) circle3.getCenterY();
    xPosKreis3 = (int) circle3.getCenterX();

    yPosKreis4 = (int) circle4.getCenterY();
    xPosKreis4 = (int) circle4.getCenterX();

        //Verändern der y-Position vom Kreis
        yPosKreis1= yPosKreis1+yKreis1;
        circle.setCenterY(yPosKreis1);

        yPosKreis2= yPosKreis2+yKreis2;
        circle2.setCenterY(yPosKreis2);

        yPosKreis3= yPosKreis3+yKreis3;
        circle3.setCenterY(yPosKreis3);

        yPosKreis4= yPosKreis4 + yKreis4;
        circle4.setCenterY(yPosKreis4);

        image.rotate(7f);
        image2.rotate(7f);
        image3.rotate(7f);
        image4.rotate(7f);


        if(circle.getY()>container.getHeight()){

            circle.setX(random.nextInt(container.getWidth()));
            circle.setCenterY(-10);
        }

        if(circle.getY()>container.getHeight()){
            circle.setCenterY(-100);
            circle.setCenterX(random.nextInt(container.getWidth()));
        }

        if(circle2.getY()>container.getHeight()){

            circle2.setX(random.nextInt(container.getWidth()));
            circle2.setCenterY(-10);
        }

        if(circle2.getY()>container.getHeight()){
            circle2.setCenterY(-100);
            circle2.setCenterX(random.nextInt(container.getWidth()));
        }

        if(circle3.getY()>container.getHeight()){

            circle3.setX(random.nextInt(container.getWidth()));
            circle3.setCenterY(-10);
        }

        if(circle3.getY()>container.getHeight()){
            circle3.setCenterY(-100);
            circle3.setCenterX(random.nextInt(container.getWidth()));
        }

        if(circle4.getY()>container.getHeight()){

            circle4.setX(random.nextInt(container.getWidth()));
            circle4.setCenterY(-10);
        }

        if(circle4.getY()>container.getHeight()){
            circle4.setCenterY(-100);
            circle4.setCenterX(random.nextInt(container.getWidth()));
        }


        //fenster mit ESC schließen
        if (input.isMousePressed(Input.KEY_ESCAPE)) {
            container.exit();
        }
    }
}
