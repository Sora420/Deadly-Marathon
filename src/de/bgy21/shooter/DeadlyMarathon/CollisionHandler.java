package de.bgy21.shooter.DeadlyMarathon;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class CollisionHandler{

    //checkt ob der Spieler "Ground" berührt
    public static boolean checkCollision(Player player, Ground ground) {
        Circle playerCircle = player.getBoundingBox();
        Rectangle groundRect = ground.getBoundingBox();
        return groundRect.intersects(playerCircle);
    }

    // Simple collision handling for falling
    public static void handleCollision(Player player, Ground ground) {
        if (player.getY() + player.getBoundingBox().getRadius() > ground.getY()) {
            player.setY(ground.getY() - player.getBoundingBox().getRadius());
        }
    }
}