//ID:206531808 NAME:ido cohen
package game;
import sprites.Ball;
import sprites.Block;

/**
 * The BallRemover class implements the HitListener interface and is responsible for removing balls
 * from the game when they collide with a block. It keeps track of the remaining balls in the game.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructs a BallRemover object with the specified game and remainingBalls counters.
     *
     * @param game the game instance
     * @param remainingBalls the counter for remaining balls in the game
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * Handles the hit event when a ball collides with a block.
     * Removes the ball from the game and decreases the remaining balls count.
     *
     * @param beingHit the block that was hit
     * @param hitter   the ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
