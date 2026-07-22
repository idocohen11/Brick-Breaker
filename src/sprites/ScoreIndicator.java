package sprites;

import biuoop.DrawSurface;
import game.Counter;
import game.GameLevel;
import geometry.Rectangle;
import java.awt.*;

public class ScoreIndicator implements Sprite {

    private Counter score;
    private Rectangle shape;
    private Color color;

    public ScoreIndicator(Counter score, Rectangle shape, Color color) {
        this.score = score;
        this.shape = shape;
        this.color = color;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) this.shape.getUpperLeft().getX(),(int) this.shape.getUpperLeft().getY(),
                (int) this.shape.getWidth(), (int) this.shape.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) shape.getUpperLeft().getX(), (int) shape.getUpperLeft().getY(),
                (int) shape.getWidth(), (int) shape.getHeight());

        d.drawText(325, 20, "The score is:" + this.score.getValue(), 25);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
