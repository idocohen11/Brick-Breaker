//name:ido cohen id:206531808
package sprites;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;
/**
 * this class implements a sprite collection.
 * this class has the following methods:
 * add sprite, notify all time passed for all of the sprite collection and draws the sprites on a given surface
 *
 */

public class SpriteCollection {
    List<Sprite> sprites;

    /**
     *  Creates a new sprite collection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * dds a sprite to the collection.
     * @param s sprites.Sprite a new sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * this method calls timePassed() for all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<Sprite>(this.sprites);
        for(Sprite s : spritesCopy) {
            s.timePassed();
        }
    }

    /**
     * this method draws all the sprites on a given surface.
     * @param d DrawSurface to draw the sprites on
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> spritesCopy = new ArrayList<Sprite>(this.sprites);
        for(Sprite s : spritesCopy) {
            s.drawOn(d);
        }
    }

    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}