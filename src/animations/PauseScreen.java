//ID:206531808 NAME:ido cohen
package animations;
import biuoop.DrawSurface;

/**
 * The PauseScreen class represents a pause screen animation displayed during the game.
 * It displays a message and allows the game to be resumed by pressing a key.
 */
public class PauseScreen implements Animation {

    private boolean stop;

    /**
     * Constructs a PauseScreen animation.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * Performs one frame of the pause screen animation.
     *
     * @param d the DrawSurface to draw on
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(170, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * Checks if the pause screen animation should stop.
     *
     * @return false, indicating that the animation should continue indefinitely
     */
    public boolean shouldStop() {
        return false;
    }
}
