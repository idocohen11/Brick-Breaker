//name:ido cohen id:206531808
package sprites;
import game.GameLevel;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Velocity;
import java.awt.*;

/**
 * this class implements a paddle controlled by the user, which is a sprite and a collidable.
 * this class has the following methods:
 * Constructors, notify that time passed, adds the paddle to a given game, hit method, get collision rectangle
 * draws the paddle on a given surface and moves the paddle to the left and the right.
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private geometry.Rectangle shape;
    private int borderX;
    private int speed;

    /**
     * this method constructs a new paddle.
     * @param keyboard KeyboardSensor.
     * @param shape the shape of the paddle.
     * @param border the border of the paddle.
     */
    public Paddle(KeyboardSensor keyboard, geometry.Rectangle shape, int border, int speed) {
        this.keyboard = keyboard;
        this.shape = shape;
        this.borderX = border;
        this.speed = speed;
    }

    /**
     * this method moves the paddle to the left.
     */
    public void moveLeft() {
        double newX = this.shape.getUpperLeft().getX() - speed;
        if(newX <= 25) {
            newX = 25;
        }
        double y = this.shape.getUpperLeft().getY();
        this.shape = new geometry.Rectangle(new Point(newX, y), this.shape.getWidth(), this.shape.getHeight());
    }

    /**
     * this method moves the paddle to the Right.
     */
    public void moveRight() {
        double newX = this.shape.getUpperLeft().getX() + speed;
        if(newX + this.shape.getWidth() >= borderX) {
            newX = borderX - this.shape.getWidth();
        }
        double y = this.shape.getUpperLeft().getY();
        this.shape = new geometry.Rectangle(new geometry.Point(newX, y), this.shape.getWidth(), this.shape.getHeight());
    }

    /**
     * this method notifies the paddle that time has passed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * his method draws the paddle on a given surface.
     * @param d DrawSurface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.ORANGE);
        d.fillRectangle((int) this.shape.getUpperLeft().getX(),(int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.shape.getUpperLeft().getX(),(int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
    }

    /**
     * this method returns the shape of the paddle.
     * @return Geometry.Rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * this method returns new velocity after a hit with the paddle.
     * @param collisionPoint  Geometry.Point the collision point.
     * @param currentVelocity geometry.Velocity the current velocity before the hit.
     * @return new velocity according to the hit in the paddle.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line upperEdge = this.shape.getUpperEdge();
        // get the region size
        double regionSize = upperEdge.length()  / 5;
        Line leftEdge = this.shape.getLeftEdge();
        Line rightEdge = this.shape.getRightEdge();
        // convert the velocity into a speed vector
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        if(upperEdge.isPointOnLine(collisionPoint)) {
            double distance = this.shape.getUpperLeft().distance(collisionPoint);
            if(distance < (1 * regionSize)) {
                return Velocity.fromAngleAndSpeed(-60, speed);
            } else if(distance < (2 * regionSize)) {
                return Velocity.fromAngleAndSpeed(-30, speed);
            } else if(distance < (3 * regionSize)) {
                return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            } else if(distance < (4 * regionSize)) {
                return Velocity.fromAngleAndSpeed(30, speed);
            } else if(distance < (5 * regionSize)) {
                return Velocity.fromAngleAndSpeed(60, speed);
            }
        }
        else if (leftEdge.isPointOnLine(collisionPoint) || rightEdge.isPointOnLine(collisionPoint)) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        return currentVelocity;
    }

    /**
     * this method adds the paddle to the game, as a sprite and a collidable.
     * @param g game.Game
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}