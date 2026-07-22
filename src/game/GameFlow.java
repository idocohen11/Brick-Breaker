//ID:206531808 NAME:ido cohen
package game;
import animations.Animation;
import animations.AnimationRunner;
import animations.EndScreen;
import animations.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.LevelInformation;

import java.util.List;

/**
 * The GameFlow class manages the flow of the game, including running levels and displaying end screens.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private GUI gui;
    private final String WIN_MESSAGE = "You Win! Your score is: ";
    private final String LOSE_MESSAGE = "Game Over. Your score is: ";

    /**
     * Constructs a GameFlow with the specified AnimationRunner, KeyboardSensor, and GUI.
     *
     * @param ar   the AnimationRunner to run animations
     * @param ks   the KeyboardSensor for input handling
     * @param gui  the GUI for displaying the game
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.score = new Counter();
    }

    /**
     * Runs the specified levels in order.
     * Displays an end screen based on whether the player wins or loses.
     *
     * @param levels the list of LevelInformation objects representing the game levels
     */
    public void runLevels(List<LevelInformation> levels) {

        boolean flagForLost = false;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score);

            level.initialize();

            while (!level.shouldStop()) {
                level.run();
            }

            if (level.getRemainingNumberOfBalls() == 0) {
                flagForLost = true;
                break;
            }
        }

        if (flagForLost) {
            Animation loseAnimation = new EndScreen(this.score.getValue(), LOSE_MESSAGE);
            KeyPressStoppableAnimation stoppableAnimation = new KeyPressStoppableAnimation(
                    this.keyboardSensor, KeyboardSensor.SPACE_KEY, loseAnimation);
            this.animationRunner.run(stoppableAnimation);
        } else {
            Animation winAnimation = new EndScreen(this.score.getValue(), WIN_MESSAGE);
            KeyPressStoppableAnimation stoppableAnimation = new KeyPressStoppableAnimation(
                    this.keyboardSensor, KeyboardSensor.SPACE_KEY, winAnimation);
            this.animationRunner.run(stoppableAnimation);
        }
        this.gui.close();
    }
}
