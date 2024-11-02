package backend.units;

import java.util.HashSet;

/** basic melee unit with no bonus damage */
public class Swordman extends Unit {

    public Swordman(int[] pos) {
        super(20, 10, 100, 2, null);
        this.pos = pos;
        this.facing = 0;
        tags = new HashSet<TagsOptions>();
        tags.add(TagsOptions.SMALL);

    }

    public void attack(Unit[][] units) {
        Unit primary;
        Unit[] secondary = new Unit[3];
        switch (this.facing) {
            case (0):
                primary = this.getUnitTop(units);
                secondary[0] = this.getUnitRight(units);
                secondary[1] = this.getUnitBottom(units);
                secondary[2] = this.getUnitLeft(units);
                break;
            case (1):
                primary = this.getUnitRight(units);
                secondary[0] = this.getUnitTop(units);
                secondary[1] = this.getUnitBottom(units);
                secondary[2] = this.getUnitLeft(units);
                break;
            case (2):
                primary = this.getUnitBottom(units);
                secondary[0] = this.getUnitRight(units);
                secondary[1] = this.getUnitTop(units);
                secondary[2] = this.getUnitLeft(units);
                break;
            case (3):
                primary = this.getUnitLeft(units);
                secondary[0] = this.getUnitRight(units);
                secondary[1] = this.getUnitBottom(units);
                secondary[2] = this.getUnitTop(units);
                break;
            default:
                primary = null;
                secondary[0] = null;
                secondary[1] = null;
                secondary[2] = null;
                break;
        }
        this.dealDamage(primary, attackDamage);
        this.dealDamage(secondary[0], attackDamage);
        this.dealDamage(secondary[1], attackDamage);
        this.dealDamage(secondary[2], attackDamage);

    }
}
