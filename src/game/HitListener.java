//ID:206531808 NAME:ido cohen
package game;
import sprites.Ball;
import sprites.Block;

/**
 * The HitListener interface represents an object that listens for hit events in the game.
 * Classes implementing this interface can respond to hit events by implementing the hitEvent method.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit by the hitter ball.
     * @param beingHit The block being hit.
     * @param hitter The ball that is doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}