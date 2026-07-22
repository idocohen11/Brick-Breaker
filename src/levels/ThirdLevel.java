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
 * The ThirdLevel class implements the LevelInformation interface
 * and represents the third level of the game.
 */
public class ThirdLevel implements LevelInformation {

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
     * Constructs a new ThirdLevel object.
     * Initializes the level properties, such as the number of balls,
     * paddle speed, paddle width, level name, background, and blocks.
     */
    public ThirdLevel() {
        this.paddleOffset = 0;
        this.balls = new ArrayList<Ball>();

        // level name
        this.levelName = "Third and last Level";

        // balls
        this.numberOfBalls = 3;
        createBalls();

        // background
        this.background = new SpaceBackground();

        // paddle width
        this.paddleWidth = 70;
        // paddle speed
        this.paddleSpeed = 8;

        createBlocks();
    }

    /**
     * Creates the balls for the level and sets their properties.
     */
    private void createBalls() {
        Ball ball1 = new Ball(new geometry.Point(415, 520), 5, Color.ORANGE);
        ball1.setVelocity(5, -4);
        ball1.setOffset(0);
        ball1.setBorderX(800);
        ball1.setBorderY(600);
        Ball ball2 = new Ball(new geometry.Point(415, 520), 5, Color.ORANGE);
        ball2.setVelocity(6, -3);
        ball2.setOffset(0);
        ball2.setBorderX(800);
        ball2.setBorderY(600);
        Ball ball3 = new Ball(new geometry.Point(415, 520), 5, Color.ORANGE);
        ball3.setVelocity(2, -3);
        ball3.setOffset(0);
        ball3.setBorderX(800);
        ball3.setBorderY(600);

        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
    }

    /**
     * Creates the blocks for the level and sets their properties.
     */
    private void createBlocks() {
        // Define the colors we want to use
        Color purpleLilac = new Color(182, 102, 210);
        Color[] colors = {Color.red, Color.YELLOW, Color.green, Color.blue, purpleLilac, Color.magenta};
        int startX = 725, startY = 100, width = 50, height = 20;
        this.blocks = new ArrayList<Block>();
        for (int row = 0; row < 6; row++) {
            // Calculate the number of blocks in this row
            int numBlocks = 12 - row;
            // Create the blocks in this row
            for (int i = 0; i < numBlocks; i++) {
                int x = startX - i * width;
                int y = startY + row * height;
                // Choose the color based on the row number
                Color color = colors[row];
                // Create the block and add it to the game
                Block block = new Block(new geometry.Rectangle(new geometry.Point(x, y), width, height), color);
                blocks.add(block);
                //blocks[row * 12 + i] = block;
            }
            this.numberOfBlocksToRemove = 57;
        }
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
