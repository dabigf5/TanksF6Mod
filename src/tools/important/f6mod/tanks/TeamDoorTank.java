package tools.important.f6mod.tanks;

import tanks.Game;
import tanks.Movable;
import tanks.tank.Tank;
import tanks.tank.TankAIControlled;

public class TeamDoorTank extends TankAIControlled {
    final static int DOOR_DISTANCE = 50;

    final double placementX;
    final double placementY;

    final double placementAngle;

    public TeamDoorTank(String name, double x, double y, double angle) {
        super(name, x, y, Game.tile_size, 25, 25, 25, angle, ShootAI.none);
        this.enableMovement = false;
        this.enableMineLaying = false;

        this.resistBullets = true;
        this.resistExplosions = true;
        this.resistFreeze = true;
        this.turretLength = 0;
        this.turretSize = 0;

        this.mandatoryKill = false; // how does one kill a fucking door

        this.description = "A stationary tank that will act as a door, only allowing friendly tanks through";
        this.placementX = x;
        this.placementY = y;
        this.placementAngle = angle;
    }

    @Override
    public void update() {
        super.update();
        this.posX = placementX;
        this.posY = placementY;
        this.vX = 0;
        this.vY = 0;
        this.vZ = 0;

        boolean friendlyTankInDistance = false;

        for (Movable movable : Game.movables) {
            if (!(movable instanceof Tank)) {
                continue;
            }
            if (movable instanceof TeamDoorTank) {
                continue;
            }

            Tank tank = (Tank) movable;

            if (this.team != null && team != tank.team) {
                continue;
            }

            double distanceX = Math.abs(this.posX - tank.posX);
            double distanceY = Math.abs(this.posY - tank.posY);

            if (distanceX == 0 && distanceY == 0) {
                //System.out.println("OUR X:\t"+this.posX+" THEIR X:\t"+tank.posX);
                //System.out.println("OUR Y:\t"+this.posY+" THEIR Y:\t"+tank.posY);
                continue;
            }

            if (distanceX > DOOR_DISTANCE || distanceY > DOOR_DISTANCE) {
                continue;
            }

            friendlyTankInDistance = true;
            break;

            //System.out.println("Distance X: "+distanceX);
            //System.out.println("Distance Y: "+distanceY);
        }

        if (friendlyTankInDistance) {
            openDoor();
        } else {
            closeDoor();
        }
    }

    /*
    @Override
    public void draw() {
        super.draw();
        Drawing.drawing.drawRect(posX, posY, DOOR_DISTANCE, DOOR_DISTANCE);
    }
    */
    public void openDoor() {
        this.size = 0;
    }

    public void closeDoor() {
        this.size = Game.tile_size;
    }
}
