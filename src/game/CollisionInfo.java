//name:ido cohen id:206531808
package game;
import geometry.Point;
import sprites.Collidable;

/**
 * this class implements an object of collision info which holds the collision point and the object involved
 * in the collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     *
     * @param p point the new collision point.
     * @param obj the object involved in the collision.
     */
    public CollisionInfo(Point p, Collidable obj) {
        this.collisionPoint = p;
        this.collisionObject = obj;
    }

    /**
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}