package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class CollisionHandler {

    public static int[] checkCollision(Player player, Rectangle[][] collisionGrid) {
        Circle playerCollision = player.getBoundingBox();

        // Check tile player is on
        for(int i = 0; i < collisionGrid.length; ++i) {
            for(int j = 0; j < collisionGrid[i].length; ++j) {
                if(collisionGrid[i][j].intersects(playerCollision)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void handleCollision(Player player, Rectangle collisionTile, int collisionId) {
        System.out.println(player.getY() + " " + collisionTile.getY() + " " + collisionId);
        switch(collisionId) {
            case 1:
                if(player.getY() + player.getBoundingBox().getRadius() > collisionTile.getY()) {
                    player.land(collisionTile.getY());
                }
                return;
            default:
        }
    }

}
