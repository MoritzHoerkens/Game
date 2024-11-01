package backend.units;

import java.util.ArrayList;

abstract class Units {
    public double attackDamage;// damge done to the primary target
    public double flankingAttackDamage;// damge done to flanking targets
    public int range;
    public int health;
    public int movementPoints;
    public ArrayList<tags> tags = new ArrayList<tags>();

    /**
     * the direction should only be 0-up,1-right,2-below,3-left
     * 
     * @param direction
     * @param damage
     */
    // TODO implement dealDamage
    /**
     * deals the given damage to another unit
     */
    public void dealDamage(int direction, int damage) {

    }

    /*
     * calculates the damage dealt to all units around it and calls dealDamage
     * is to be implemented by the specific unit
     */
    public void attack() {

    }

}
/**
 * describes possible allowed tags for any unit
 */
enum tags {
    LARGE,
    SMALL,
    FLEEING,
}