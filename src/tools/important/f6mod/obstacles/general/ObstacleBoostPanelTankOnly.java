package tools.important.f6mod.obstacles.general;

import tanks.AttributeModifier;
import tanks.Effect;
import tanks.Movable;
import tanks.StatusEffect;
import tanks.gui.screen.ScreenGame;
import tanks.obstacle.ObstacleBoostPanel;
import tanks.tank.Tank;

public class ObstacleBoostPanelTankOnly extends ObstacleBoostPanel {
    public ObstacleBoostPanelTankOnly(String name, double posX, double posY) {
        super(name, posX, posY);
        this.drawLevel = 1;
        this.destructible = false;
        this.tankCollision = false;
        this.bulletCollision = false;
        this.checkForObjects = true;
        this.enableStacking = false;
        this.isSurfaceTile = true;
        this.update = true;
        this.colorR = 25.0;
        this.colorG = 255.0;
        this.colorB = 0;
        this.glow = Effect.createNewEffect(this.posX, this.posY, 0.0, Effect.EffectType.boostLight);
        this.description = "A panel which speeds up tanks only";
    }

    @Override
    public void onObjectEntry(Movable m) {
        if (Tank.class.isAssignableFrom(m.getClass())) {
            if (!ScreenGame.finishedQuick) {
                this.onObjectEntryLocal(m);
                AttributeModifier am = m.getAttribute(AttributeModifier.glow);
                boolean effect = am == null || am.age >= am.deteriorationAge && am.deteriorationAge > 0.0;
                if (effect) {
                    this.addEntryEffect(m);
                }

                m.addStatusEffect(StatusEffect.boost_tank, 0.0, 10.0, 50.0);
            }
        }
    }
}
