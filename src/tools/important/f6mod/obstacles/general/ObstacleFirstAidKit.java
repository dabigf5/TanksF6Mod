package tools.important.f6mod.obstacles.general;

import tanks.bullet.Bullet;
import tanks.obstacle.Obstacle;
import tools.important.f6mod.obstacles.time_control.ObstacleInteractable;

public class ObstacleFirstAidKit extends ObstacleInteractable {
    public ObstacleFirstAidKit(String name, double x, double y) {
        super(name, x, y);

        final double r = this.colorR/1.5;
        final double g = this.colorG*1.5;
        final double b = this.colorB/1.5;

        this.colorR = r;
        this.colorG = g;
        this.colorB = b;

        this.destroyOnInteract = true;

        for(int i = 0; i < Obstacle.default_max_height; i++) {
            this.stackColorR[i] = r+Math.random()*30;
            this.stackColorG[i] = g+Math.random()*30;
            this.stackColorB[i] = b+Math.random()*30;
        }

        this.description = "A first aid kit that will heal the tank that shoots it";
    }

    public void interact(Bullet bullet) {
        bullet.tank.health += this.stackHeight;
    }
}
