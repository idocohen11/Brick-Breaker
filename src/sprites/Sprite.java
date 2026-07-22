//name:ido cohen id:206531808
package sprites;
import biuoop.DrawSurface;
import game.GameLevel;

public interface Sprite {
    // draw the sprite to the screen
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed
    void timePassed();
    void addToGame(GameLevel game);
}