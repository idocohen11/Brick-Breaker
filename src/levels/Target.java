//ID:206531808 NAME:ido cohen
package levels;

import biuoop.DrawSurface;
import game.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The Target class represents a target sprite in a game level. It draws a target consisting of concentric circles
 * on the screen.
 */
public class Target implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int TARGET_SIZE = 100;

    /**
     * Draws the target on the given draw surface.
     *
     * @param d the draw surface on which to draw the target
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Draw the background
        d.setColor(Color.PINK);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);

        // Draw the target circles
        int centerX = 410;
        int centerY = 210;

        // Draw the target circles' radii
        int outerRadius = TARGET_SIZE;
        int middleRadius1 = TARGET_SIZE - 20;
        int middleRadius2 = TARGET_SIZE - 40;
        int middleRadius3 = TARGET_SIZE - 60;
        int innerRadius = TARGET_SIZE - 80;

        // Draw the outer circle in dark gray
        d.setColor(Color.DARK_GRAY);
        d.fillCircle(centerX, centerY, outerRadius);

        // Draw the middle circles in black, blue, and green
        d.setColor(Color.BLACK);
        d.fillCircle(centerX, centerY, middleRadius1);

        d.setColor(Color.BLUE);
        d.fillCircle(centerX, centerY, middleRadius2);

        d.setColor(Color.GREEN);
        d.fillCircle(centerX, centerY, middleRadius3);

        // Draw the inner circle in yellow
        d.setColor(Color.YELLOW);
        d.fillCircle(centerX, centerY, innerRadius);
    }

    /**
     * Updates the target over time. (Empty implementation since the background is static)
     */
    @Override
    public void timePassed() {
        // Empty implementation since the background is static
    }

    /**
     * Adds the target to the given game level.
     *
     * @param game the game level to add the target to
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
