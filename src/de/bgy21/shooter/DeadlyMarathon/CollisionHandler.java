package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class CollisionHandler{

    public static boolean checkCollision(Player player, Ground ground) {
        Circle playerCircle = player.getBoundingBox();
        Rectangle groundRect = ground.getBoundingBox();
        return groundRect.intersects(playerCircle);
    }

    public static void handleCollision(Player player, Ground ground) {
        // Simple collision handling for falling
        if (player.getY() + player.getBoundingBox().getRadius() > ground.getY()) {
            player.setY(ground.getY() - player.getBoundingBox().getRadius());
        }
    }
}
