package tools.important.f6mod.obstacles.time_control;

import tanks.Drawing;
import tanks.Game;
import tanks.bullet.Bullet;
import tanks.gui.screen.ScreenGame;
import tanks.obstacle.Obstacle;

public class ObstacleTimeStarter extends ObstacleInteractable {
    public ObstacleTimeStarter(String name, double posX, double posY) {
        super(name, posX, posY);

        final int r = 25;
        final int g = 141;
        final int b = 74;

        this.description = "An block that will explode and begin the level timer when shot. If the height of the block is set to 0.5, it will immediately make you lose.";
        this.colorR = r;
        this.colorG = g;
        this.colorB = b;

        this.destructible = false;
        this.destroyOnInteract = true;

        for(int i = 0; i < Obstacle.default_max_height; i++) {
            this.stackColorR[i] = r-Math.random()*30;
            this.stackColorG[i] = g-Math.random()*30;
            this.stackColorB[i] = b-Math.random()*30;
        }
    }
    @Override
    public void interact(Bullet bullet) {
        ScreenGame screen = (ScreenGame) Game.screen;
        Game.currentLevel.timed = true;

        if (this.stackHeight == 0.5) {
            return;
        }

        screen.timeRemaining = this.stackHeight*600;
        Drawing.drawing.playSound("rampage.ogg");
    }
}
