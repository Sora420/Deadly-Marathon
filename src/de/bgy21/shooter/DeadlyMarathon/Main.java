package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.*;
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

    // Container wird erstellt
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main("Deadly Marathon"));
        app.setDisplayMode(1920, 1080, false);
        app.start();
    }

    private class PlayState extends BasicGameState {

        // Variablen
        private Player player;
        private Ground ground;

        // Methode zum Initialisieren
        @Override
        public void init(GameContainer container, StateBasedGame game) throws SlickException {
            player = new Player(400, 300, 0.2f, 20);
            ground = new Ground(2000, 100, 0, 1000);
            player.draw();
            ground.draw();
        }

        // Methode zum Rendern
        @Override
        public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
            player.render(g);
            ground.render(g);
        }

        // Methode für Updates
        @Override
        public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
            Input input = container.getInput();
            player.move(input, delta);

            // Check for collision and adjust position
            if (CollisionHandler.checkCollision(player, ground)) {
                CollisionHandler.handleCollision(player, ground);
            }

        }

        @Override
        public int getID() {
            return 0;
        }
    }
}
