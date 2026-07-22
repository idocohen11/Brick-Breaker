//name:ido cohen id:206531808
package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * this class implements a rectangle with a point to represent its upper left edge, width and height.
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * creates a new rectangle.
     *
     * @param upperLeft Geometry.Point the upper left point
     * @param width     double the width of the rectangle
     * @param height    double the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * this method checks if the rectangle intersects with a given line, if yes it returns a list of intersection
     * points, otherwise it returns null.
     *
     * @param line to check the intersection points with.
     * @return Return a (possibly empty) List of intersection points
     * with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height));
        lines.add(new Line(upperLeft.getX() + width, upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY() + height));
        lines.add(new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY()));
        lines.add(new Line(upperLeft.getX(), upperLeft.getY() + height, upperLeft.getX() + width, upperLeft.getY() + height));
        List<Point> intersectionPoints = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Point p = lines.get(i).intersectionWith(line);
            if (p != null) {
                intersectionPoints.add(p);
            }
        }
        return intersectionPoints;
    }

    /**
     * this method returns the width of the rectangle.
     *
     * @return the width rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * this method returns the height of the rectangle.
     *
     * @return the height rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * this method returns the upper-left point of the rectangle.
     *
     * @return the upper-left point rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    public Line getLeftEdge() {
        return new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height);
    }

    public Line getRightEdge() {
        return new Line(upperLeft.getX() + width, upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY() + height);
    }

    public Line getUpperEdge() {
        return new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
    }

    public Line getLowerEdge() {
        return new Line(upperLeft.getX(), upperLeft.getY() + height, upperLeft.getX() + width, upperLeft.getY() + height);
    }
}