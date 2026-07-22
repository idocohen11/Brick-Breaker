//ID:206531808 NAME:ido cohen
package levels;

import geometry.Point;
import geometry.Velocity;
import sprites.Ball;
import sprites.Block;
import sprites.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the first level in the game.
 */
public class FirstLevel implements LevelInformation {

    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private List<Ball> balls;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;
    private int paddleOffset;

    /**
     * Constructs a new FirstLevel object.
     */
    public FirstLevel() {
        this.paddleOffset = 0;

        // Number of balls
        numberOfBalls = 1;
        Ball ball = new Ball(new Point(415, 520), 5, Color.white);
        ball.setVelocity(0, -5);
        ball.setOffset(0);
        ball.setBorderX(800);
        ball.setBorderY(600);
        balls = new ArrayList<>();
        balls.add(ball);

        // Paddle speed and width
        this.paddleSpeed = 8;
        this.paddleWidth = 90;

        // Level name
        this.levelName = "First Level";

        // Background
        this.background = new Target();

        // Blocks
        blocks = new ArrayList<>();
        blocks.add(new Block(new geometry.Rectangle(new geometry.Point(400, 200), 20, 20), Color.RED));
        numberOfBlocksToRemove = 1;
    }

    /**
     * Returns the number of balls in the level.
     *
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return numberOfBalls;
    }

    /**
     * Returns the initial velocities of the balls.
     *
     * @return a list of ball velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        return initialBallVelocities;
    }

    /**
     * Returns the speed of the paddle.
     *
     * @return the paddle speed
     */
    @Override
    public int paddleSpeed() {
        return paddleSpeed;
    }

    /**
     * Returns the width of the paddle.
     *
     * @return the paddle width
     */
    @Override
    public int paddleWidth() {
        return paddleWidth;
    }

    /**
     * Returns the name of the level.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return levelName;
    }

    /**
     * Returns the background sprite of the level.
     *
     * @return the background sprite
     */
    @Override
    public Sprite getBackground() {
        return background;
    }

    /**
     * Returns a list of blocks in the level.
     *
     * @return a list of blocks
     */
    @Override
    public List<Block> blocks() {
        return blocks;
    }

    /**
     * Returns the number of blocks to remove in the level.
     *
     * @return the number of blocks to remove
     */
    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }

    /**
     * Returns a list of balls in the level.
     *
     * @return a list of balls
     */
    @Override
    public List<Ball> getBalls() {
        return this.balls;
    }

    /**
     * Returns the offset of the paddle from the bottom of the screen.
     *
     * @return the paddle offset
     */
    @Override
    public int getPaddleOffset() {
        return this.paddleOffset;
    }
}

