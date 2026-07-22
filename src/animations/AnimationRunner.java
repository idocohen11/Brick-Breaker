//ID:206531808 NAME:ido cohen
package animations;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The AnimationRunner class is responsible for running the game animation loop.
 * It controls the timing of frames and handles the rendering of animations.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * Constructs an AnimationRunner with the specified frames per second and GUI.
     *
     * @param fps the number of frames per second
     * @param gui the GUI to display the animation on
     */
    public AnimationRunner(int fps, GUI gui) {
        this.framesPerSecond = fps;
        this.gui = gui;
    }

    /**
     * Runs the given animation.
     *
     * @param animation the animation to run
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            gui.show(d);
        }
    }
}
