package tools.important.f6mod;

import tools.important.f6mod.obstacles.general.*;
import tools.important.f6mod.obstacles.time_control.*;
import main.Tanks;
import tanks.Game;
import tanks.extension.Extension;
import tools.important.f6mod.tanks.TeamDoorTank;

public class F6Mod extends Extension
{
    public F6Mod() {
        super("F6mod");
    }
    @Override
    public void setUp() {
        // Obstacles //

        // Row 1
        Game.registerObstacle(ObstacleBouncyIndestructible.class,"f6mod_bci");
        Game.registerObstacle(ObstacleNoBounceBreakable.class,"f6mod_nbb");
        Game.registerObstacle(ObstacleBoostPanelBulletOnly.class,"f6mod_bpbo");
        Game.registerObstacle(ObstacleBoostPanelTankOnly.class,"f6mod_bpto");
        Game.registerObstacle(ObstacleAntiBulletField.class,"f6mod_abf");
        Game.registerObstacle(ObstacleFirstAidKit.class,"f6mod_1staid");

        // Row 2
        Game.registerObstacle(ObstacleTimeStarter.class,"f6mod_timestr");
        Game.registerObstacle(ObstacleTimeStopper.class,"f6mod_timestp");
        Game.registerObstacle(ObstacleTimeGiver.class,"f6mod_timegvr");


        // Tanks //
        Game.registerTank(TeamDoorTank.class,"f6mod_teamdoor",0,false);
//        Game.registerTank(AehmttwTank.class, "f6mod_aehmttw", 0, true);
    }
    public static void main(String[] args) {
      Tanks.launchWithExtensions(new String[]{"debug"}, new Extension[]{new F6Mod()}, null);
    }
}