package tools.important.f6mod.obstacles.time_control;

import tanks.Drawing;
import tanks.Game;
import tanks.bullet.Bullet;
import tanks.gui.screen.ScreenGame;
import tanks.obstacle.Obstacle;

public class ObstacleTimeGiver extends ObstacleInteractable {
    public ObstacleTimeGiver(String name, double posX, double posY) {
        super(name, posX, posY);
        this.description = "An block that will give you time when shot";

        final int r = 35;
        final int g = 108;
        final int b = 217;

        this.colorR = r;
        this.colorG = g;
        this.colorB = b;

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
        screen.timeRemaining += this.stackHeight*600;
        Drawing.drawing.playSound("shield.ogg",1.5f);
    }
}
