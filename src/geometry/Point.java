package geometry;//id:206531808 , name:ido cohen.
/**
 *A point has an x and a y value, and can measure the distance to other points, and if it is equal to another point.
 */
public class Point {
    private double x;
    private double y;

    /**
     * @param x The X point in the axes.
     * @param y The Y point in the axes.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param other A different point in the axes.
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        double a = ((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y));
        return Math.sqrt(a);
    }

    /**
     *
     * @param other A different point in the axes.
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return  other.x == this.x && other.y == this.y;
    }

    /**
     *
     * @return the x values of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     *
     * @return the y values of this point.
     */
    public double getY() {
        return this.y;
    }
}