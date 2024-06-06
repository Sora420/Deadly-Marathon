package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class Main extends StateBasedGame {

    public Main(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new PlayState());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main("Deadly Marathon"));
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    private class PlayState extends BasicGameState {

        private Player player;

        @Override
        public void init(GameContainer container, StateBasedGame game) throws SlickException {
            player = new Player(400, 300, 0.2f, 20);
        }

        @Override
        public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
            player.render(g);
        }

        @Override
        public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
            Input input = container.getInput();
            player.move(input, delta);
        }

        @Override
        public int getID() {
            return 0;
        }
    }
}