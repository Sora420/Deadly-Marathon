package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
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
        app.setTargetFrameRate(120);
        app.start();
    }

    private class PlayState extends BasicGameState {

        // Variablen
        private Player player;

        // Map dependencies
        private TiledMap map;
        private final int MAP_Y_OFFSET = -6;
        private int terrainId;
        private int[][] collisionIds; // 0 for empty, 1 for terrain
        private Rectangle[][] collisionGrid;

        // Methode zum Initialisieren
        @Override
        public void init(GameContainer container, StateBasedGame game) throws SlickException {
            player = new Player(400, 300, 0.2f, 20);
            player.draw();

            map = new TiledMap("res/Level_1.tmx", "res");
            collisionIds = new int[map.getHeight()][map.getWidth()];
            collisionGrid = new Rectangle[map.getHeight()][map.getWidth()];
            terrainId = map.getLayerIndex("Terrain");

            // populate collisionID map with terrain values (functions not optimized for runtime call...)
            for(int i = 0; i < collisionIds.length; ++i) {
                for(int j = 0; j < collisionIds[i].length; ++j) {
                    int tileId =map.getTileId(j, i, terrainId);
                    if (map.getTileProperty(tileId, "blocked", "false")
                            .equals("true")) collisionIds[i][j] = 1;
                    else collisionIds[i][j] = 0;
                }
            }
            // populate collision grid for detection where pawn is
            for(int i = 0; i < collisionGrid.length; ++i) {
                for(int j = 0; j < collisionGrid[i].length; ++j) {
                    collisionGrid[i][j] = new Rectangle(
                            1 + j*map.getTileWidth(),
                            1 + i*map.getTileHeight(),
                            map.getTileWidth(),
                            map.getTileHeight());
                }
            }
        }

        // Methode zum Rendern
        @Override
        public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
            map.render(0, MAP_Y_OFFSET * map.getTileHeight());

            player.render(g);
        }

        // Methode für Updates
        @Override
        public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
            Input input = container.getInput();
            player.move(input, delta);

            // check for collision and adjust position
            int[] collisionCoordinates = CollisionHandler.checkCollision(player, collisionGrid);
            System.out.print(collisionCoordinates[0] + " " + collisionCoordinates[1] + " ");
            CollisionHandler.handleCollision(
                    player,
                    collisionGrid[collisionCoordinates[0]][collisionCoordinates[1]],
                    collisionIds[collisionCoordinates[0] - MAP_Y_OFFSET +1][collisionCoordinates[1]]);
        }

        @Override
        public int getID() {
            return 0;
        }
    }
}
