package tools.important.f6mod.obstacles.time_control;

import tanks.Drawing;
import tanks.Game;
import tanks.Level;
import tanks.bullet.Bullet;
import tanks.obstacle.Obstacle;

public class ObstacleTimeStopper extends ObstacleInteractable {

    public ObstacleTimeStopper(String name, double posX, double posY) {
        super(name, posX, posY);

        final int r = 186;
        final int g = 34;
        final int b = 34;

        this.description = "An block that will halt the level timer when shot";
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
    public void interact(Bullet bullet)
    {
        Level currentLevel = Game.currentLevel;
        currentLevel.timed = false;
        Drawing.drawing.playSound("rampage.ogg",1.25f);
    }
}
