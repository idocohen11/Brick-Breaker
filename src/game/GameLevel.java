//ID:206531808 NAME:ido cohen
package game;
import animations.Animation;
import animations.AnimationRunner;
import animations.KeyPressStoppableAnimation;
import animations.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometry.Rectangle;
import levels.LevelInformation;
import sprites.*;

import java.awt.*;

/**
 * The GameLevel class represents a single level in the game. It implements the Animation interface and controls the
 * animation logic for the level.
 */
public class GameLevel implements Animation {

    private AnimationRunner runner;
    private boolean shouldStop;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private LevelInformation levelInformation;
    private KeyboardSensor ks;

    /**
     * Constructs a GameLevel with the specified level information, KeyboardSensor, AnimationRunner, and score counter.
     *
     * @param level the level information for the game level
     * @param ks    the KeyboardSensor for input handling
     * @param ar    the AnimationRunner to run animations
     * @param score the score counter for the game
     */
    public GameLevel(LevelInformation level, KeyboardSensor ks, AnimationRunner ar, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.score = score;
        this.shouldStop = false;
        this.levelInformation = level;
        this.runner = ar;
        this.ks = ks;
    }

    /**
     * Adds a collidable object to the game environment.
     *
     * @param c the collidable object to add
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Adds a sprite object to the game.
     *
     * @param s the sprite object to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initializes the game level by setting up the game objects, blocks, paddle, balls, and borders.
     */
    public void initialize() {
        this.remainingBalls.setValue(levelInformation.numberOfBalls());
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        levelInformation.getBackground().addToGame(this);

        // Add paddle
        Paddle paddle = new Paddle(ks,
                new Rectangle(new geometry.Point(380 - this.levelInformation.getPaddleOffset(), 560),
                        levelInformation.paddleWidth(), 15), 775, this.levelInformation.paddleSpeed());
        paddle.addToGame(this);

        // Add balls
        addBalls();

        // Add titles such as score, level title
        addTitles();

        // Add borders
        setGameBorder(ballRemover);

        for (Block block : this.levelInformation.blocks()) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            block.addToGame(this);
        }

        remainingBlocks.setValue(levelInformation.numberOfBlocksToRemove());
    }

    /**
     * Removes a collidable object from the game environment.
     *
     * @param c the collidable object to remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Removes a sprite object from the game.
     *
     * @param s the sprite object to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Adds the balls to the game.
     */
    private void addBalls() {
        for (Ball ball : this.levelInformation.getBalls()) {
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
        }
    }

    /**
     * Adds the score indicator to the game.
     */
    private void addTitles() {
        Rectangle shape = new Rectangle(new geometry.Point(0, 0), 800, 25);
        new ScoreIndicator(this.score, shape, Color.white).addToGame(this);
        new LevelTitle(this.levelInformation.levelName()).addToGame(this);
    }

    /**
     * Sets the game borders and adds the ball remover.
     *
     * @param ballRemover the BallRemover object to remove balls
     */
    private void setGameBorder(BallRemover ballRemover) {
        new Block(new geometry.Rectangle(new geometry.Point(0, 25), 800, 25), Color.gray).addToGame(this);
        new Block(new geometry.Rectangle(new geometry.Point(0, 25), 25, 575), Color.gray).addToGame(this);
        new Block(new Rectangle(new geometry.Point(775, 25), 25, 575), Color.gray).addToGame(this);
        Block deathRegion = new Block(new geometry.Rectangle(new geometry.Point(25, 575), 750, 25), Color.gray);
        deathRegion.addHitListener(ballRemover);
        deathRegion.addToGame(this);
    }

    /**
     * Performs one frame of the game animation.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            System.out.println(this.score.getValue());
            this.shouldStop = true;
        }

        if (this.remainingBalls.getValue() == 0) {
            this.shouldStop = true;
        }

        if (this.ks.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
    }

    /**
     * Determines whether the game animation should stop.
     *
     * @return true if the game animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }

    /**
     * Returns the GUI of the game.
     *
     * @return the GUI of the game
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * Runs the game animation.
     */
    public void run() {
        this.runner.run(this);
    }

    /**
     * Returns the remaining number of balls.
     *
     * @return the remaining number of balls
     */
    public int getRemainingNumberOfBalls() {
        return this.remainingBalls.getValue();
    }
}

