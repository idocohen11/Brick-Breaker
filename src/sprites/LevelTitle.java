package sprites;


import biuoop.DrawSurface;
import game.GameLevel;

public class LevelTitle implements Sprite {

    private String title;

    public LevelTitle(String title) {
        this.title = title;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(520, 20, "Level Name:" + this.title, 17);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
