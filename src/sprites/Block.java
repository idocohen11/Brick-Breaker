//name:ido cohen id:206531808
package sprites;

import biuoop.DrawSurface;
import game.GameLevel;
import game.HitListener;
import game.HitNotifier;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * this class implements a block which is collidable and a sprite.
 * this class has the following methods:
 * constructors, getters, setters, draw on a given surface, time passed which moves the ball, adds the block to a given
 * game and the hit method which returns new velocity after an expected hit to the block.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle shape;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * this method creates a new block which is in a shape of a rectangle.
     *
     * @param shape Geometry.Rectangle the shape of the block
     * @param color
     */
    public Block(geometry.Rectangle shape, Color color) {
        this.color = color;
        this.shape = shape;
        hitListeners = new ArrayList<>();
    }


    /**
     *
     * @return Geometry.Rectangle returns the shape of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * this method returns the velocity after an object with a velocity hits the block in a given point.
     * @param collisionPoint Geometry.Point the collision point.
     * @param currentVelocity geometry.Velocity the current velocity before the hit.
     * @return geometry.Velocity the velocity after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        List<Line> lines = new ArrayList<>();
        lines.add(shape.getLeftEdge());
        lines.add(shape.getUpperEdge());
        lines.add(shape.getRightEdge());
        lines.add(shape.getLowerEdge());
        for(int i = 0; i < 4; i++) {
            // hits a horizontal edge (upper or lower edges) so we change the vertical direction
            if((i == 1 || i == 3) && lines.get(i).isPointOnLine(collisionPoint)) {
                this.notifyHit(hitter);
                return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
            }
            // hits a vertical edge (left or right edges) so we change horizontal direction
            else if((i == 0 || i == 2) && lines.get(i).isPointOnLine(collisionPoint)) {
                this.notifyHit(hitter);
                return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
            }

        }
        // if the ball didn't hit a block and we don't need to change direction
        return currentVelocity;
    }

    /**
     * this method adds the block to the game, both as a sprite and as a collidable.
     * @param game the game to add the block in
     */

    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * this method draws the block on a given surface.
     * @param surface DrawSurface the surface to draw the block on.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillRectangle((int) this.shape.getUpperLeft().getX(),(int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) shape.getUpperLeft().getX(), (int) shape.getUpperLeft().getY(),
                (int) shape.getWidth(), (int) shape.getHeight());
    }

    @Override
    public void timePassed() {

    }

    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
