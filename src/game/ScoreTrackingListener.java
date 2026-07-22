//ID:206531808 NAME:ido cohen
package game;
import sprites.Ball;
import sprites.Block;

/**
 * The ScoreTrackingListener class is responsible for tracking the score in the game.
 * It implements the HitListener interface to listen for hit events on blocks.
 * Whenever a block is hit, the score is increased by a fixed amount.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     Creates a new ScoreTrackingListener with the given score counter.
     @param scoreCounter The counter to track the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     This method is called whenever a block is hit by a ball.
     It increases the current score by a fixed amount.
     @param beingHit The block being hit.
     @param hitter The ball that is doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}