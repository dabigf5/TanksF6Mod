package tools.important.f6mod.obstacles.general;

import tanks.Game;
import tanks.obstacle.Obstacle;

public class ObstacleBouncyIndestructible extends Obstacle {
    public ObstacleBouncyIndestructible(String name, double posX, double posY) {
        super(name, posX, posY);
        this.destructible = false;
        this.bouncy = true;
        this.colorR = Math.random() * 64.0 + 128.0;
        this.colorG = 0.0;
        this.colorB = 64.0;

        for(int i = 1; i < 8; ++i) {
            this.stackColorR[i] = Math.random() * 128.0 + 64.0;
            this.stackColorG[i] = 0.0;
            this.stackColorB[i] = Math.random() * 64.0;
            if (!Game.fancyTerrain) {
                this.stackColorR[i] = 127.0;
            }
        }

        this.stackColorR[0] = this.colorR;
        this.stackColorG[0] = this.colorG;
        this.stackColorB[0] = this.colorB;
        if (!Game.fancyTerrain) {
            this.colorR = 127.0;
        }

        this.description = "An indestructible block which allows bullets to bounce more";
    }
}
