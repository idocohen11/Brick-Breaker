//ID:206531808 NAME:ido cohen
package game;
import sprites.Ball;
import sprites.Block;

/**
 * The BlockRemover class implements the HitListener interface and is responsible for removing blocks
 * from the game when they are hit by a ball. It also keeps track of the remaining blocks in the game.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Constructs a BlockRemover object with the specified game and remainingBlocks counters.
     *
     * @param game the game instance
     * @param remainingBlocks the counter for remaining blocks in the game
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Handles the hit event when a block is hit by a ball.
     * Removes the block from the game and decreases the remaining blocks count.
     * Also removes this listener from the block to prevent further hit events.
     *
     * @param beingHit the block that was hit
     * @param hitter  the ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}