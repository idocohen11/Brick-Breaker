//ID:206531808 NAME:ido cohen
package game;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import sprites.Collidable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * this class implements a game environment which holds all of the objects that a ball can collide with.
 */
public class GameEnvironment {
    // the collidables in the game environment
    private List<Collidable> collidableList;

    /**
     * this method creates a new game environment.
     */
    public GameEnvironment() {
        collidableList = new ArrayList<>();
    }

    /**
     * add the given collidable to the environment.
     * @param c sprites.Collidable a new collidable to be added.
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }

    /**
     * this method returns the closest collision of an object with any of the collidables in the game environment.
     * if the object will not collide the method returns null.
     *
     * @param trajectory Geometry.Line the trajectory of the object
     * @return game.CollisionInfo the collision information, collision point and the object involved in the collision
     *         if no collision the return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<CollisionInfo> collisions = new ArrayList<>();
        List<Collidable> collidablesCopy = new ArrayList<Collidable>(this.collidableList);
        for(Collidable collidable : collidablesCopy) {
            Rectangle currShape = collidable.getCollisionRectangle();
            Point closestPoint = trajectory.closestIntersectionToStartOfLine(currShape);
            if(closestPoint == null) {
                continue;
            }
            collisions.add(new CollisionInfo(closestPoint, collidable));
        }
        if(collisions.size() == 0) {
            return null;
        }
        CollisionInfo closestCollision = null;
        double minDistance = Integer.MAX_VALUE;
        for(CollisionInfo collisionInfo : collisions) {
            Point currPoint = collisionInfo.collisionPoint();
            double currDistance = trajectory.start().distance(currPoint);
            if(currDistance <= minDistance) {
                minDistance = currDistance;
                closestCollision = collisionInfo;
            }
        }
        return closestCollision;
    }

    /**
     * Removes a collidable object from the game environment.
     * @param c The collidable object to be removed.
     */
    public void removeCollidable(Collidable c) {
        collidableList.remove(c);
    }
}
