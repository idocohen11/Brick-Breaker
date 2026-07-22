//name:ido cohen id:206531808
package geometry;

/**
 *geometry.Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * @param dx The speed on the X axis.
     * @param dy The speed on the Y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     *
     * @return The speed on the X axis.
     */

    public double getDx() {
        return this.dx;
    }

    /**
     *
     * @return The speed on the Y axis.
     */

    public double getDy() {
        return this.dy;
    }

    /**
     *
     * @param p Take a point with position (x,y).
     * @return return a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }

    /**
     *
     * @param angle the angle of the ball.
     * @param speed the speed of the ball.
     * @return new velocity.
     */

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(Math.toRadians(angle - 90));
        double dy = speed * Math.sin(Math.toRadians(angle - 90));
        if (Math.abs(dx) < 0.00000001) {
            dx = 0;
        }
        if (Math.abs(dy) < 0.00000001) {
            dy = 0;
        }
        return new Velocity(dx, dy);
    }
}