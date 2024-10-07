package tools.important.f6mod.obstacles.general;

import tanks.Drawing;
import tanks.Game;
import tanks.obstacle.Obstacle;


public class ObstacleAntiBulletField extends Obstacle {
    public ObstacleAntiBulletField(String name, double posX, double posY) {
        super(name, posX, posY);
        this.bulletCollision = true;
        this.tankCollision = false;
        this.destructible = false;
        this.allowBounce = true;
        this.colorR = 0;
        this.colorG = Math.random() * 127 + 128.0;
        this.colorB = 100;

        for(int i = 1; i < 8; ++i) {
            this.stackColorR[i] = 0.0;
            this.stackColorG[i] = Math.random() * 55.0 + 200.0;
            this.stackColorB[i] = Math.random() * 50.0 + 100;
            if (!Game.fancyTerrain) {
                this.stackColorR[i] = 128;
            }
        }
        this.replaceTiles = false;
        this.description = "A block that will block bullets but allow tanks through";
        this.drawLevel = 1;
    }

    @Override
    public double getTileHeight() {
        return 0.0;
    }

    @Override
    public void draw() {
        //double offset = 0;
        if (!Game.enable3d) {
            Drawing.drawing.setColor(this.colorR, this.colorG, this.colorB, 255.0, 1.0);
            Drawing.drawing.fillRect(this, this.posX, this.posY, Obstacle.draw_size, Obstacle.draw_size);
        } else {
            Drawing.drawing.setColor(this.colorR, this.colorG, this.colorB, 64.0, 1.0);
            Drawing.drawing.fillBox(this, this.posX, this.posY, 0.0, Obstacle.draw_size, Obstacle.draw_size, 50.0);
        }
    }
}
