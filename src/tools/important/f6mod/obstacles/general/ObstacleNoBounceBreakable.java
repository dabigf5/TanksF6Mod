package tools.important.f6mod.obstacles.general;

import tanks.obstacle.ObstacleBreakable;

public class ObstacleNoBounceBreakable extends ObstacleBreakable {
    public ObstacleNoBounceBreakable(String name, double posX, double posY) {
        super(name, posX, posY);
        this.allowBounce = false;
        this.colorR -= 100;
        this.colorG -= 100;
        this.colorB -= 100;

        for(int i = 0; i < 8; ++i) {
            double c = ((this.stackColorR[i] + this.stackColorG[i] + this.stackColorB[i]) / 3.0 + 50.0) / 2.0;
            this.stackColorR[i] -= c;
            this.stackColorG[i] -= c;
            this.stackColorB[i] -= c;

        }

        this.description = "A block which breaks when hit by a bullet and stops the bullet from bouncing";
    }
}
