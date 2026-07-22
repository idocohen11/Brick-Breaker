//id:206531808 , name:ido cohen.

package geometry;

import java.util.List;

/**
 *A line (actually a line-segment) connects two points -- a start point and an end point. Lines have lengths,
 *  and may intersect with other lines. It can also tell if it is the same as another line segment.
 */
public class Line {
    private Point p1;
    private Point p2;

    /**
     * this method implements a line with a starting and ending points.
     * @param start a point that starts the line that consists of X and Y.
     * @param end a point that ends the line that consists of X and Y.
     */
    public Line(Point start, Point end) {
        this.p1 = start;
        this.p2 = end;
    }

    /**
     * this method implements a line with the x and y coordinate for the starting and ending points.
     * @param x1 The point of the X-axis of the first ball.
     * @param y1 The point of the y-axis of the first ball.
     * @param x2 The point of the X-axis of the second ball.
     * @param y2 The point of the y-axis of the second ball.
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        this.p1 = start;
        this.p2 = end;
    }

    /**
     * this method returns the length of a line.
     * @return the length of the line.
     */
    public double length() {
        return p1.distance(p2);
    }

    /**
     * this method returns the middle point of a line.
     * @return the middle point of the line.
     */
    public Point middle() {
        return new Point((this.p1.getX() + this.p2.getX()) / 2, (this.p1.getY() + this.p2.getY()) / 2);
    }

    /**
     * this method returns the start point of a line.
     * @return the start point of the line.
     */
    public Point start() {
        return this.p1;
    }

    /**
     * this method returns the end point of a line.
     * @return the end point of the line.
     */
    public Point end() {
        return this.p2;
    }

    /**
     * this method checks if two lines can intersect by checking their slopes.
     * @param other A different line in the axes.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        double dx1 = this.p2.getX() - this.p1.getX();
        double dy1 = this.p2.getY() - this.p1.getY();
        double dx2 = other.p2.getX() - other.p1.getX();
        double dy2 = other.p2.getY() - other.p1.getY();
        double dxx = this.p1.getX() - other.p1.getX();
        double dyy = this.p1.getY() - other.p1.getY();
        double div, t, s;

        div = (dy2 * dx1) - (dx2 * dy1);
        if (Math.abs(div) < 1.0e-10) {
            //collinear case
            return (this.p1.equals(other.p1) && !this.p1.equals(other.p2))
                    || (this.p2.equals(other.p1) && !this.p2.equals(other.p2));
        }
        t = ((dx1 * dyy) - (dy1 * dxx)) / div;
        if (t < 0 || t > 1.0) {
            return false; //intersection outside the first segment
        }
        s = (dx2 * dyy - dy2 * dxx) / div;
        return !(s < 0) && !(s > 1.0);  //intersection outside the second segment
    }


    /**
     * this method returns the intersection point of two lines, if no intersection was found
     * the method returns null.
     * @param other A different line in the axes.
     * @return the intersection point if the lines intersect,and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double dx1 = this.p2.getX() - this.p1.getX();
        double dy1 = this.p2.getY() - this.p1.getY();
        double dx2 = other.p2.getX() - other.p1.getX();
        double dy2 = other.p2.getY() - other.p1.getY();
        double dxx = this.p1.getX() - other.p1.getX();
        double dyy = this.p1.getY() - other.p1.getY();
        double div, t, s;

        div = (dy2 * dx1) - (dx2 * dy1);
        if (Math.abs(div) < 1.0e-10) {
            if (this.p1.equals(other.p1) && !this.p1.equals(other.p2)) {
                return this.p1;
            } else if (this.p2.equals(other.p1) && !this.p2.equals(other.p2)) {
                return this.p2;
            } else {
                //collinear case
                return null;
            }
        }

        t = ((dx1 * dyy) - (dy1 * dxx)) / div;
        if (t < 0 || t > 1.0) {
            return null; //intersection outside the first segment
        }
        s = (dx2 * dyy - dy2 * dxx) / div;
        if (s < 0 || s > 1.0) {
            return null;  //intersection outside the second segment
        }
        return new Point(this.p1.getX() + s * dx1, this.p1.getY() + s * dy1);
    }


    /**
     * this method checks if two lines are equal.
     * @param other A different line in the axes.
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        boolean b1 = this.p1.equals(other.p1) && this.p2.equals(other.p2);
        boolean b2 = this.p1.equals(other.p2) && this.p2.equals(other.p1);
        return b1 || b2;
    }

    /**
     * this method returns the closest intersection point to the start of a line and a given rectangle.
     * if the line doesn't intersect with the rectangle, the method returns null.
     *
     * @param rect Geometry.Rectangle to check the intersection with.
     * @return the closest intersection point, if none exist then null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if(intersectionPoints.size() == 0) {
            return null;
        }
        double minDistance = Integer.MAX_VALUE;
        Point minPoint = null;
        for(Point p : intersectionPoints) {
            double distance = this.p1.distance(p);
            if(distance <= minDistance) {
                minDistance = distance;
                minPoint = p;
            }
        }
        return minPoint;
    }


    public boolean isPointOnLine(Point point) {
        double startToIntersection = point.distance(this.p1);
        double endToIntersection = point.distance(this.p2);
        double checkedLength = startToIntersection + endToIntersection;
        return Math.abs(checkedLength - this.length()) < 0.00000001;
    }
}