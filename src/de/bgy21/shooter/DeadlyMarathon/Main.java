package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

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

        // Map dependencies
        private TiledMap map;
        private int terrainId;
        private int[][] collisions; // 0 for empty, 1 for terrain

        // Methode zum Initialisieren
        @Override
        public void init(GameContainer container, StateBasedGame game) throws SlickException {
            player = new Player(400, 300, 0.2f, 20);
            ground = new Ground(2000, 100, 0, 1000);
            player.draw();
            ground.draw();

            map = new TiledMap("res/Level_1.tmx", "res");
            collisions = new int[map.getHeight()][map.getWidth()];
            terrainId = map.getLayerIndex("Terrain");

            // populate collision map with terrain values (functions not optimized for runtime call...)
            for(int i = 0; i < collisions.length; ++i) {
                for(int j = 0; j < collisions[i].length; ++j) {
                    int tileId =map.getTileId(j, i, terrainId);
                    if (map.getTileProperty(tileId, "blocked", "false").equals("true")) collisions[i][j] = 1;
                    else collisions[i][j] = 0;
                }
            }
        }

        // Methode zum Rendern
        @Override
        public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
            map.render(0, -200);

            player.render(g);
//            ground.render(g);
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
