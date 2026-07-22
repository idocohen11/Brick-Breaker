//ID:206531808 NAME:ido cohen
package animations;
import biuoop.DrawSurface;

/**
 * The EndScreen class represents an end screen animation displayed at the end of a game.
 * It displays a message and the final score on the screen.
 */
public class EndScreen implements Animation {

    private int finalScore;
    private String message;
    private static final int FONT_SIZE = 40;
    private static final int TEXT_X_COORDINATES = 100;
    private static final int TEXT_Y_COORDINATES = 300;

    /**
     * Constructs an EndScreen with the specified final score and message.
     *
     * @param finalScore the final score to display
     * @param message the message to display
     */
    public EndScreen(int finalScore, String message) {
        this.finalScore = finalScore;
        this.message = message;
    }

    /**
     * Performs one frame of the end screen animation.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(TEXT_X_COORDINATES, TEXT_Y_COORDINATES, this.message + this.finalScore, FONT_SIZE);
    }

    /**
     * Checks if the end screen animation should stop.
     *
     * @return false, indicating that the animation should continue indefinitely
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
