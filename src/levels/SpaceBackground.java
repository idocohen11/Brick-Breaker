//ID:206531808 NAME:ido cohen
package levels;

import biuoop.DrawSurface;
import game.GameLevel;
import sprites.Sprite;

import java.awt.Color;

/**
 * The SpaceBackground class represents the background of a space-themed game level.
 * It implements the Sprite interface to be drawable on the screen.
 */
public class SpaceBackground implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int EARTH_RADIUS = 50;

    /**
     * Draws the space background, stars, Earth, Saturn, and aliens on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Draw the background
        d.setColor(Color.black);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);

        // Draw stars
        drawStars(d);

        // Draw the Earth
        drawEarth(d);

        // Draw Saturn
        drawSaturn(d);

        // Draw aliens
        drawAliens(d);
    }

    /**
     * Performs an empty action, as the background does not change over time.
     */
    @Override
    public void timePassed() {
        // Empty implementation since the background is static
    }

    /**
     * Adds the space background to the given game level as a sprite.
     *
     * @param game The game level to add the space background to.
     */
    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * Draws stars on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawStars(DrawSurface d) {
        d.setColor(Color.white);
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            d.fillRectangle(x, y, 1, 1);
        }
    }

    /**
     * Draws the Earth on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawEarth(DrawSurface d) {
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        // Draw the outer blue circle
        d.setColor(new Color(30, 144, 255));
        d.fillCircle(centerX, centerY, EARTH_RADIUS);

    }

    /**
     * Draws Saturn on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawSaturn(DrawSurface d) {
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        // Draw the outer ring of Saturn
        d.setColor(new Color(222, 184, 135)); // Sandy brown
        d.fillOval(centerX - 100, centerY - 15, 200, 40);

        // Draw the inner solid part of Saturn
        d.setColor(new Color(255, 215, 0)); // Gold
        d.fillOval(centerX - 70, centerY - 10, 140, 20);
    }

    /**
     * Draws aliens on the given draw surface.
     *
     * @param d The draw surface to draw on.
     */
    private void drawAliens(DrawSurface d) {
        // Alien spaceship 1
        d.setColor(Color.green);
        d.fillOval(100, 100, 50, 20);
        d.setColor(Color.black);
        d.drawOval(100, 100, 50, 20);
        d.setColor(Color.white);
        d.fillOval(105, 105, 10, 10);
        d.fillOval(125, 105, 10, 10);
        d.setColor(Color.red);
        d.fillOval(103, 102, 5, 5);
        d.fillOval(132, 102, 5, 5);
        // Alien spaceship 2
        d.setColor(Color.green);
        d.fillOval(260, 250, 50, 20);
        d.setColor(Color.black);
        d.drawOval(260, 250, 50, 20);
        d.setColor(Color.white);
        d.fillOval(265, 255, 10, 10);
        d.fillOval(285, 255, 10, 10);
        d.setColor(Color.red);
        d.fillOval(263, 252, 5, 5);
        d.fillOval(292, 252, 5, 5);

        // Alien spaceship 3
        d.setColor(Color.green);
        d.fillOval(340, 190, 50, 20);
        d.setColor(Color.black);
        d.drawOval(340, 190, 50, 20);
        d.setColor(Color.white);
        d.fillOval(345, 195, 10, 10);
        d.fillOval(365, 195, 10, 10);
        d.setColor(Color.red);
        d.fillOval(343, 192, 5, 5);
        d.fillOval(372, 192, 5, 5);
    }
}