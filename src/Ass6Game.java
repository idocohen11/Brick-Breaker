//name:ido cohen id:206531808

import animations.AnimationRunner;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import game.GameFlow;
import levels.FirstLevel;
import levels.LevelInformation;
import levels.SecondLevel;
import levels.ThirdLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * main class.
 */
public class Ass6Game {
    /**
     * game object, initializes and runs it.
     * @param args from user.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        KeyboardSensor ks = gui.getKeyboardSensor();
        AnimationRunner ar = new AnimationRunner(60, gui);
        GameFlow gf = new GameFlow(ar, ks, gui);
        List<LevelInformation> levels = new ArrayList<>();

        if(args.length == 0) {
            levels.add(new FirstLevel());
            levels.add(new SecondLevel());
            levels.add(new ThirdLevel());
            gf.runLevels(levels);
        } else {
            int size = args.length;
            for(int i = 0; i < size; i++) {
                try {
                    int number = Integer.parseInt(args[i]);
                    if(number < 0 || number >= 4) {
                        continue;
                    } else if(number == 1) {
                        levels.add(new FirstLevel());
                    } else if(number == 2) {
                        levels.add(new SecondLevel());
                    } else {
                        levels.add(new ThirdLevel());
                    }
                } catch(NumberFormatException e) {
                    continue;
                }
            }
            gf.runLevels(levels);
        }
    }
}

