//ID:206531808 NAME:ido cohen
package game;
/**
 * he Counter class represents a simple counter that can be increased, decreased, and queried for its value.
 */
public class Counter {
    int count;

    /**
     * Constructs a Counter object with an initial count of 0.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Increases the counter by the specified number.
     *
     * @param number the value to increase the counter by
     */
    public void increase(int number) {
        count = count + number;
    }

    /**
     * Decreases the counter by the specified number.
     *
     * @param number the value to decrease the counter by
     */
    public void decrease(int number) {
        count = count - number;
    }

    /**
     * Returns the current value of the counter.
     *
     * @return the current count value
     */
    public int getValue() {
        return count;
    }

    /**
     * Sets the value of the counter to the specified value.
     *
     * @param val the new value for the counter
     */
    public void setValue(int val) {
        this.count = val;
    }
}