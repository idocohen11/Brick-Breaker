//name:ido cohen id:206531808
package sprites;

import game.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

/**
 * this is a collidable interface which will be used by objects that can be collided with.
 */
public interface Collidable {
    /**
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     *this method receives a collision point and the current velocity of an object, and returns the velocity after the
     * hit.
     * @param collisionPoint  Geometry.Point the collision point.
     * @param currentVelocity geometry.Velocity the current velocity before the hit.
     * @return the new velocity after the hit.
     */


    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    void addToGame(GameLevel game);
}