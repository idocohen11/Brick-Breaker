//ID:206531808 NAME:ido cohen
package levels;

import geometry.Velocity;
import sprites.Ball;
import sprites.Block;
import sprites.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the second level of the game.
 */
public class SecondLevel implements LevelInformation {

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
     * Creates a new instance of the SecondLevel class.
     */
    public SecondLevel() {
        this.balls = new ArrayList<Ball>();

        // level name
        this.levelName = "Wide Easy";

        // balls
        this.numberOfBalls = 10;
        createBalls();

        // background
        this.background = new Sky();

        // paddle width
        this.paddleWidth = 450;
        // paddle speed
        this.paddleSpeed = 8;

        createBlocks();

        this.paddleOffset = 180;
    }

    private void createBalls() {
        // Create the first set of balls
        Ball ball1 = new Ball(new geometry.Point(415, 520), 5, Color.black);
        ball1.setVelocity(2, -4);
        ball1.setOffset(0);
        ball1.setBorderX(800);
        ball1.setBorderY(600);
        Ball ball2 = new Ball(new geometry.Point(415, 520), 5, Color.black);
        ball2.setVelocity(3, -4);
        ball2.setOffset(0);
        ball2.setBorderX(800);
        ball2.setBorderY(600);
        Ball ball3 = new Ball(new geometry.Point(415, 520), 5, Color.BLACK);
        ball3.setVelocity(4, -4);
        ball3.setOffset(0);
        ball3.setBorderX(800);
        ball3.setBorderY(600);
        Ball ball4 = new Ball(new geometry.Point(415, 520), 5, Color.BLACK);
        ball4.setVelocity(5, -4);
        ball4.setOffset(0);
        ball4.setBorderX(800);
        ball4.setBorderY(600);
        Ball ball5 = new Ball(new geometry.Point(415, 520), 5, Color.BLACK);
        ball5.setVelocity(6, -4);
        ball5.setOffset(0);
        ball5.setBorderX(800);
        ball5.setBorderY(600);

        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
        balls.add(ball4);
        balls.add(ball5);

        // Create the second set of balls
        Ball ball6 = new Ball(new geometry.Point(415, 520), 5, Color.black);
        ball6.setVelocity(-2, -4);
        ball6.setOffset(0);
        ball6.setBorderX(800);
        ball6.setBorderY(600);
        Ball ball7 = new Ball(new geometry.Point(415, 520), 5, Color.black);
        ball7.setVelocity(-3, -4);
        ball7.setOffset(0);
        ball7.setBorderX(800);
        ball7.setBorderY(600);
        Ball ball8 = new Ball(new geometry.Point(415, 520), 5, Color.BLACK);
        ball8.setVelocity(-4, -4);
        ball8.setOffset(0);
        ball8.setBorderX(800);
        ball8.setBorderY(600);
        Ball ball9 = new Ball(new geometry.Point(415, 520), 5, Color.BLACK);
        ball9.setVelocity(-5, -4);
        ball9.setOffset(0);
        ball9.setBorderX(800);
        ball9.setBorderY(600);
        Ball ball10 = new Ball(new geometry.Point(415, 520), 5, Color.BLACK);
        ball10.setVelocity(-6, -4);
        ball10.setOffset(0);
        ball10.setBorderX(800);
        ball10.setBorderY(600);
        balls.add(ball6);
        balls.add(ball7);
        balls.add(ball8);
        balls.add(ball9);
        balls.add(ball10);
    }

    private void createBlocks() {
        Color[] colors = {Color.RED, Color.orange, Color.yellow, Color.green, Color.blue, Color.pink, Color.cyan};
        int startX = (800 - 15 * 50) / 2; // Calculate the starting X position to center the blocks
        int startY = 250;
        int width = 50;
        int height = 20;
        this.blocks = new ArrayList<>();

        int maxBlocks = 15; // Calculate the maximum number of blocks that can fit within the board's width

        for (int i = 0; i < maxBlocks; i += 2) {
            Color color = colors[i / 2 % colors.length];
            Block lightBlock = new Block(new geometry.Rectangle(new geometry.Point(startX + i * width, startY), width, height), color.brighter());
            blocks.add(lightBlock);
            if (i == 14) {
                continue;
            }
            Block darkBlock = new Block(new geometry.Rectangle(new geometry.Point(startX + (i + 1) * width, startY), width, height), color.darker());
            blocks.add(darkBlock);
        }

        this.numberOfBlocksToRemove = 15;
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
     * Returns a list of velocities for the initial balls.
     *
     * @return a list of velocities
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
     * Returns the number of blocks that should be removed to pass the level.
     *
     * @return the number of blocks to remove
     */
    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }

    /**
     * Returns a list of balls
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

