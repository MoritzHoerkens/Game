package backend.units;

import java.util.HashSet;

import backend.map.Terrain;

public abstract class Unit {
    protected double attackDamage;// damge done to the primary target
    protected double flankingAttackDamage;// damge done to flanking targets
    protected double health;
    protected double movementPoints;
    protected double remainingMovementPoints;
    public int facing;// 0 to 3 with 0 being up and giong clockwise
    public HashSet<TagsOptions> tags = new HashSet<TagsOptions>();
    public int[] pos = new int[2];

    protected Unit(double attackDamage, double flankingAttackDamage, double health, int movementPoints,
            HashSet<TagsOptions> tags) {
        this.attackDamage = attackDamage;
        this.flankingAttackDamage = flankingAttackDamage;
        this.health = health;
        this.movementPoints = movementPoints;
        this.tags = tags;
    }

    /**
     * this method executes on the start on a new turn and resets changed variables
     */
    protected void newTurn() {
        this.remainingMovementPoints = this.movementPoints;
    }

    public void moveSquare(int direction, Unit[][] units, Terrain[][] terrain) {
        switch (direction) {
            case 0:
                if (this.pos[1] - 1 >= 0 && units[this.pos[0]][this.pos[1] - 1] == null) {
                    Terrain t = terrain[this.pos[0]][this.pos[1] - 1];
                    if (t.PASSABLE && t.MOVEMENT_COST >= this.remainingMovementPoints)
                        this.pos[1] -= 1;
                    this.remainingMovementPoints -= t.MOVEMENT_COST;
                }
                break;
            case 1:
                if (this.pos[0] + 1 < units.length && units[this.pos[0] + 1][this.pos[1] - 1] == null) {
                    Terrain t = terrain[this.pos[0] + 1][this.pos[1]];
                    this.pos[0] += 1;
                    this.remainingMovementPoints -= t.MOVEMENT_COST;
                }
                break;
            case 2:
                if (this.pos[1] + 1 < units[0].length && units[this.pos[0] + 1][this.pos[1]] == null) {
                    Terrain t = terrain[this.pos[0]][this.pos[1] + 1];
                    this.pos[1] += 1;
                    this.remainingMovementPoints -= t.MOVEMENT_COST;
                }
                break;
            case 3:
                if (this.pos[0] - 1 >= 0 && units[this.pos[0] - 1][this.pos[1]] == null) {
                    Terrain t = terrain[this.pos[0] - 1][this.pos[1]];
                    this.pos[0] -= 1;
                    this.remainingMovementPoints -= t.MOVEMENT_COST;
                }
                break;
            default:
                System.err.println("Movement occcured in an invalid direction. Movement was cancelled");
                break;
        }
    }

    /**
     * deals the given damage to another unit
     */
    public void dealDamage(Unit unit, double damage) {
        if (unit != null) {// null can be given without error. This removes the need to check every result
                           // of the getUnit methods
            unit.takeDamage(damage);
        }
    }

    public void takeDamage(double damage) {
        this.health -= damage;
        if (health <= 0) {
            this.die();
        }
    }

    protected void die() {
        tags.add(TagsOptions.DEAD);
    }

    /**
     * Get the unit that is on top of the cirrent unit in the given Grid
     * returns null if the square on top does not exits or if there is no unit
     */
    protected Unit getUnitTop(Unit[][] units) {
        if (this.pos[1] - 1 >= 0) {
            return units[this.pos[0]][this.pos[1] - 1];
        } else {
            return null;
        }
    }

    protected Unit getUnitRight(Unit[][] units) {
        if (this.pos[0] + 1 < units.length) {
            return units[this.pos[0] + 1][this.pos[1]];
        } else {
            return null;
        }
    }

    protected Unit getUnitBottom(Unit[][] units) {
        if (this.pos[1] + 1 < units[0].length) {
            return units[this.pos[0]][this.pos[1] - 1];
        } else {
            return null;
        }
    }

    protected Unit getUnitLeft(Unit[][] units) {
        if (this.pos[0] - 1 >= 0) {
            return units[this.pos[0] - 1][this.pos[1]];
        } else {
            return null;
        }
    }

    public double calcTerrainBasedDamage(Terrain attackedTerrain, double damage, boolean flanked) {
        if (this.tags.contains(TagsOptions.MELEE)) {
            return damage * attackedTerrain.DEFENSE_MODIFIER_MELEE * (flanked ? attackedTerrain.FLANKING_MODIFIER : 1);
        } else if (this.tags.contains(TagsOptions.MELEE)) {
            return damage * attackedTerrain.DEFENSE_MODIFIER_RANGED * (flanked ? attackedTerrain.FLANKING_MODIFIER : 1);
        } else {
            System.err.println("the unit type: " + this.getClass()
                    + " is missing a attacktype tag. The damage appied is the base damage");
            return damage;
        }
    }

    /*
     * calculates the damage dealt to all units around it and calls dealDamage
     * is to be implemented by the specific unit
     */
    public abstract void attack(Unit[][] units, Terrain[][] terrain);

}
