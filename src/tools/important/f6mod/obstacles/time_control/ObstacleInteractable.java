package tools.important.f6mod.obstacles.time_control;

import tanks.Game;
import tanks.Movable;
import tanks.bullet.Bullet;
import tanks.gui.screen.ScreenPartyLobby;
import tanks.network.event.EventObstacleDestroy;
import tanks.obstacle.Obstacle;

public abstract class ObstacleInteractable extends Obstacle {
    public boolean destroyOnInteract = false;

    public ObstacleInteractable(String name, double posX, double posY) {
        super(name, posX, posY);
        this.allowBounce = false;
        this.checkForObjects = true;
        this.destructible = false;
    }

    @Override
    public void onObjectEntry(Movable movable) {
        if (!(movable instanceof Bullet)) {
            return;
        }

        interact((Bullet) movable);

        if (this.destroyOnInteract && !ScreenPartyLobby.isClient) {
            Game.removeObstacles.add(this);
            Game.eventsOut.add(new EventObstacleDestroy(this.posX, this.posY, this.name));
        }
    }

    public abstract void interact(Bullet bullet);
}