package animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The KeyPressStoppableAnimation class represents a key-press stoppable animation.
 * It wraps an animation and allows it to be stopped by pressing a specific key.
 */
public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor ks;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean shouldStop;

    /**
     * Constructs a KeyPressStoppableAnimation with the specified keyboard sensor, key, and animation.
     *
     * @param sensor the KeyboardSensor used to detect key presses
     * @param key the key that stops the animation when pressed
     * @param animation the animation to wrap and control
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.ks = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = false;
        shouldStop = false;
    }

    /**
     * Performs one frame of the key-press stoppable animation.
     * If the specified key is pressed and not already pressed before, the animation should stop.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.ks.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        } else if (this.ks.isPressed(this.key) && !this.isAlreadyPressed) {
            this.shouldStop = true;
        }
        this.animation.doOneFrame(d);
    }

    /**
     * Checks if the key-press stoppable animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}
