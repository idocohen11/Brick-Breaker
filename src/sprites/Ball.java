//name:ido cohen id:206531808
package sprites;
import game.CollisionInfo;
import game.GameLevel;
import game.GameEnvironment;
import geometry.Line;
import geometry.Point;
import biuoop.DrawSurface;
import geometry.Velocity;

import java.awt.*;
import java.util.Random;

/**
 * Balls have size (radius), color, and location (a Geometry.Point). Balls also know how to draw themselves on a DrawSurface.
 */
public class Ball implements Sprite {
    private geometry.Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private int borderX;
    private int borderY;
    private int offset;
    private GameEnvironment environment;
    // constructor

    /**
     * creates a new ball.
     * @param center the center of a ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(geometry.Point center, int r, java.awt.Color color) {
        this.center = center;
        this.color = color;
        this.radius = r;
        this.velocity = null;
        this.borderX = 200;
        this.offset = 0;
    }

    /**
     * creates a new ball.
     * @param x The X point of the ball in the axes.
     * @param y The Y point of the ball in the axes.
     * @param r The radios point of the ball.
     * @param color the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.color = color;
        this.radius = r;
        this.velocity = null;
        this.borderX = 200;
        this.offset = 0;
    }


    /**
     * creates a new ball.
     * @param center the center of a ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     * @param environment game environment
     */
    public Ball(geometry.Point center, int r, java.awt.Color color, GameEnvironment environment) {
        this.center = center;
        this.color = color;
        this.radius = r;
        this.velocity = null;
        this.borderX = 200;
        this.offset = 0;
        this.environment = environment;
    }

    /**
     *
     * @return the X center of the point ball in the axes.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     *
     * @return the Y center of the point ball in the axes.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     *
     * @return the size of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw the ball on the given DrawSurface.
     * @param surface The DrawSurface on which to draw the ball.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * this methods adds the ball to a given game as a sprite.
     * @param game  the game to add to ball to.
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * this method sets a velocity to the ball.
     * @param v is the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * this method sets a velocity to the ball with dx and dy.
     * @param dx The speed on the X axis.
     * @param dy The speed on the Y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     *
     * @return the geometry.Velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     *
     * @param borderX is the x border of the Board.
     */
    public void setBorderX(int borderX) {
        this.borderX = borderX;
    }

    /**
     *
     * @param borderY is the y border of the Board.
     */
    public void setBorderY(int borderY) {
        this.borderY = borderY;
    }

    /**
     *
     * @param offset is The offset of the ball.
     */

    public void setOffset(int offset) {
        this.offset = offset;
    }


    /**
     * A class that knows how to calculate which direction the ball should move once it hits the wall.
     * If the ball hits the borders of the screen, it changes its direction.
     */

    public void moveOneStep() {
        if (this.velocity == null) {
            return;
        }
        int radiusX = this.radius;
        int radiusY = this.radius;
        if(this.velocity.getDx() < 0) {
            radiusX = -radiusX;
        }
        if(this.velocity.getDy() < 0) {
            radiusY = -radiusY;
        }
        //Check  if moving on this trajectory will hit anything.
        Line trajectory = new Line(this.center.getX(), this.center.getY(),
                this.center.getX() + this.velocity.getDx() + radiusX, this.center.getY() + this.velocity.getDy() + radiusY);
        CollisionInfo collisionInfo = this.environment.getClosestCollision(trajectory);
        //If no, then move the ball to the end of the trajectory.
        if(collisionInfo == null) {
            geometry.Point currCenter = this.getVelocity().applyToPoint(this.center);
            double x = currCenter.getX(), y = currCenter.getY();
            double dx = this.velocity.getDx();
            double dy = this.velocity.getDy();
            if (currCenter.getX() + this.radius >= this.borderX) {
                dx = -dx;
                x = this.borderX - this.radius;
            } else if (currCenter.getX() - this.radius <= this.offset) {
                dx = -dx;
                x = this.offset + this.radius;
            }
            if (currCenter.getY() + this.radius >= this.borderY) {
                dy = -dy;
                y = this.borderY - this.radius;
            } else if (currCenter.getY() - this.radius <= this.offset) {
                dy = -dy;
                y = this.offset + this.radius;
            }
            this.setVelocity(dx, dy);
            this.center = new geometry.Point(x, y);
        }
        //Otherwise (there is a hit)
        else {
            double collisionX = collisionInfo.collisionPoint().getX();
            double collisionY = collisionInfo.collisionPoint().getY();
            if(this.velocity.getDy() > 0) {
                collisionY = collisionY - this.radius;
            } else if(this.velocity.getDy() < 0){
                collisionY = collisionY + this.radius;
            }
            if(this.velocity.getDx() > 0) {
                collisionX = collisionX  - this.radius;
            } else if(this.velocity.getDx() < 0){
                collisionX = collisionX + this.radius;
            }
            // place the ball a little before the collision point
            this.center = new geometry.Point(collisionX, collisionY);
            // change the velocity according to the collision
            this.velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.velocity);
        }
    }

    /**
     * this method creates a random ball white dirent color.
     * @param radius the radius of the ball.
     * @param screenSize The size of the screen.
     * @param offset the offset of the ball.
     * @return a random ball on the Board.
     */

    public static Ball createRandomBall(int radius, int screenSize, int offset) {
        Random random = new Random();
        float red = random.nextFloat();
        float green = random.nextFloat();
        float blue = random.nextFloat();
        Color randomColor = new Color(red, green, blue);
        int x = random.nextInt(screenSize - 2 * radius - offset) + offset + radius;
        int y = random.nextInt(screenSize - 2 * radius - offset) + offset + radius;
        double speed = (double) ((50 - Math.min(50, radius) + 1)) / (double) Math.min(50, radius);
        Velocity v = Velocity.fromAngleAndSpeed(random.nextInt(360), speed);
        Ball ball = new Ball(new geometry.Point(x, y), radius, randomColor);
        ball.setVelocity(v);
        ball.setBorderX(screenSize);
        ball.setOffset(offset);
        return ball;
    }

    public void setGameEnvironment(GameEnvironment env) {
        this.environment = env;
    }

    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}