//ID:206531808 NAME:ido cohen
package levels;

import biuoop.DrawSurface;
import game.GameLevel;
import sprites.Sprite;

import java.awt.*;

/**
 * The Sky class represents the background sky in a game level.
 * It implements the Sprite interface to be drawable on the screen.
 */
public class Sky implements Sprite {
    private static final int CLOUD_X = 100;
    private static final int CLOUD_Y = 100;
    private static final int CLOUD_WIDTH = 150;
    private static final int CLOUD_HEIGHT = 80;
    private static final int RAINBOW_RADIUS = 300;

    /**
     * Draws the sky, sun, clouds, and trees on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        drawSky(d);
        drawSun(d);
        drawCloud(d);
        drawTree(d);
    }

    /**
     * Draws the sky background on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawSky(DrawSurface d) {
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
    }

    /**
     * Draws the sun on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawSun(DrawSurface d) {
        int sunCenterX = 150;
        int sunCenterY = 150;
        int sunRadius = 80;

        d.setColor(Color.YELLOW);
        d.fillCircle(sunCenterX, sunCenterY, sunRadius);
    }

    /**
     * Draws the trees on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawTree(DrawSurface d) {
        d.setColor(new Color(139, 69, 19)); // Brown color
        // First Tree
        d.fillRectangle(d.getWidth() - 50, d.getHeight() - 200, 20, 200); // Tree trunk
        d.setColor(Color.GREEN);
        d.fillCircle(d.getWidth() - 40, d.getHeight() - 200, 80); // Tree leaves

        d.setColor(new Color(139, 69, 19)); // Brown color
        // Second Tree
        d.fillRectangle(30, d.getHeight() - 200, 20, 200); // Tree trunk
        d.setColor(Color.GREEN);
        d.fillCircle(40, d.getHeight() - 200, 80); // Tree leaves
    }

    /**
     * Draws the clouds on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawCloud(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillOval(CLOUD_X, CLOUD_Y, CLOUD_WIDTH, CLOUD_HEIGHT);
        d.fillOval(CLOUD_X + CLOUD_WIDTH / 3, CLOUD_Y - CLOUD_HEIGHT / 2, CLOUD_WIDTH, CLOUD_HEIGHT);
        d.fillOval(CLOUD_X + CLOUD_WIDTH, CLOUD_Y, CLOUD_WIDTH, CLOUD_HEIGHT);
    }

    /**
     * Performs an empty action, as the background does not change over time.
     */
    @Override
    public void timePassed() {
        // Empty implementation, as the background does not change over time
    }

    /**
     * Adds the sky to the given game level as a sprite.
     *
     * @param game The game level to add the sky to.
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
