package tools.important.f6mod.tanks;

import tanks.Drawing;
import tanks.Game;
import tanks.bullet.Bullet;
import tanks.bullet.BulletHoming;
import tanks.hotbar.item.ItemBullet;
import tanks.tank.TankAIControlled;

// todo: finish off this boss one day
public class AehmttwTank extends TankAIControlled {
    public AehmttwTank(String name, double x, double y, double angle) {
        super(name, x, y, Game.tile_size, 255, 255, 0, angle, ShootAI.alternate);
        this.description = "The developer of the game. Has access to crazy random bullshit that may be considered unfair.";
        this.secondaryColorR = 255;
        this.secondaryColorG = 160;
        this.secondaryColorB = 0;
        
        this.baseHealth = 25;
        this.health = this.baseHealth;

        this.bullet.maxLiveBullets = 0;
        this.cooldownBase = 2;
        this.cooldownRandom = 5;
    }

    // not static because random is being accessed
    void reforgeBullet(ItemBullet bullet) {
        bullet.cooldownBase = random.nextInt(100);
        bullet.maxLiveBullets = random.nextInt(25)+1;
        bullet.speed = random.nextInt(40);
        bullet.damage = random.nextInt(100);
        bullet.bounces = random.nextInt(10);

        if (Math.random() > 0.5) {
            bullet.bulletClass = BulletHoming.class;
        } else {
            bullet.bulletClass = Bullet.class;
        }

    }

    @Override
    public void update() {
        super.update();
            if (random.nextInt(1000) != 1) {
                return;
            }

            int effect = random.nextInt(5);

            switch (effect) {
                case 1:
                case 2:
                {
                    Drawing.drawing.playSound("nice.ogg", 1f+(float) Math.random()/2);

                    posX += random.nextInt(1000)-500;
                    posY += random.nextInt(1000)-500;
                    break;
                }
                case 3: {
                    Drawing.drawing.playSound("arc.ogg", 1f+(float) Math.random(), 2f);

                    reforgeBullet(bullet);
                    break;
                }
                case 4: {
                    Drawing.drawing.playSound("bonus1.ogg");

                    Game.playerTank.posX += random.nextInt(1000)-500;
                    Game.playerTank.posY += random.nextInt(1000)-500;
                    break;
                }
            }
    }
}
