package backend.map;

public class Terrain {
    public final double MOVEMENT_COST; // the amount of movemnt needed to trverse the square; -1 for impassable
    public final double DEFENSE_MODIFIER_MELEE; // the modifier on the amount of melee damage the unit occupying the
                                                // square takes
    public final double DEFENSE_MODIFIER_RANGED;// the modifier on the amount of ranged damage the unit occupying the
                                                // square tales
    public final double FLANKING_MODIFIER; // applies a multipier to the damage taken by the unit while
                                           // flanked
    public final boolean SHOOT_OVER_ALLOWED;

    // TODO probably better to outsorce to JSON
    public Terrain(int type) {
        switch (type) {
            case 0:// level
                /*
                 * nothing unusual
                 */
                SHOOT_OVER_ALLOWED = true;
                MOVEMENT_COST = 1;
                DEFENSE_MODIFIER_MELEE = 1;
                DEFENSE_MODIFIER_RANGED = 1;
                FLANKING_MODIFIER = 1;
                break;
            case 1:// forest
                /*
                 * slightly slowed down melee combat and reduced ranged combat on defense and
                 * offense
                 */
                SHOOT_OVER_ALLOWED = true;
                MOVEMENT_COST = 1.5;
                DEFENSE_MODIFIER_MELEE = 0.9;
                DEFENSE_MODIFIER_RANGED = 0.8;
                FLANKING_MODIFIER = 1;
                break;
            case 2:// mountain
                /*
                 * slowed down melee and ranged combat and flanking effectiveness is reduced,
                 * high movement cosrt
                 */
                SHOOT_OVER_ALLOWED = false;
                MOVEMENT_COST = 2.5;
                DEFENSE_MODIFIER_MELEE = 0.6;
                DEFENSE_MODIFIER_RANGED = 0.6;
                FLANKING_MODIFIER = 0.5;
                break;
            case 3:// river
                /*
                 * significatly benefits the defender in melee combat and has no effect on
                 * ranged combat, flanking increaded to counter the dadvantages
                 */
                SHOOT_OVER_ALLOWED = true;
                MOVEMENT_COST = 2;
                DEFENSE_MODIFIER_MELEE = 0.4;
                DEFENSE_MODIFIER_RANGED = 1;
                FLANKING_MODIFIER = 1 / DEFENSE_MODIFIER_MELEE;
                break;
            default:// should not happen
                SHOOT_OVER_ALLOWED = true;
                MOVEMENT_COST = 1;
                DEFENSE_MODIFIER_MELEE = 1;
                DEFENSE_MODIFIER_RANGED = 1;
                FLANKING_MODIFIER = 1;
                break;
        }
    }
}
