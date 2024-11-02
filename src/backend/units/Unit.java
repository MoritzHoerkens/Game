package backend.units;

import java.util.HashSet;

public abstract class Unit {
    protected double attackDamage;// damge done to the primary target
    protected double flankingAttackDamage;// damge done to flanking targets
    protected double health;
    protected int movementPoints;
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

    /*
     * calculates the damage dealt to all units around it and calls dealDamage
     * is to be implemented by the specific unit
     */
    public abstract void attack(Unit[][] units);

}
