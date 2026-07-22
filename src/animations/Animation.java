//ID:206531808 NAME:ido cohen
package animations;
import biuoop.DrawSurface;

/**
 * The Animation interface represents an animation in a game.
 * It defines methods for updating and rendering the animation frame.
 */
public interface Animation {

    /**
     * Performs one frame of the animation.
     *
     * @param d the DrawSurface to draw on
     */
    void doOneFrame(DrawSurface d);

    /**
     * Checks if the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    boolean shouldStop();

}
