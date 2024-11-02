package backend.units;

import java.util.ArrayList;

abstract class Unit {
    private double attackDamage;// damge done to the primary target
    private double flankingAttackDamage;// damge done to flanking targets
    private int range;
    private double health;
    private int movementPoints;
    public ArrayList<tags> tags = new ArrayList<tags>();
    public int[2] pos=new int[2];
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
    public void dealDamage(Unit unit, double damage) {
        unit.takeDamage(damage);
    }
    public void takeDamage(double damage){
        this.health-=damage;
        this.die();
    }
    public void die(){
        tags.append(tags.DEAD)
    }
    /*
     * calculates the damage dealt to all units around it and calls dealDamage
     * is to be implemented by the specific unit
     */
    public void attack(Unit[][] units) {

    }

}
/**
 * describes possible allowed tags for any unit
 */
enum tags {
    LARGE,
    SMALL,
    DEAD
}