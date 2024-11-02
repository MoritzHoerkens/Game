package backend.units;

import java.util.HashSet;

import backend.map.Terrain;

/** basic melee unit with no bonus damage with decent damage to flankers */
public class Swordman extends Unit {

    public Swordman(int[] pos) {
        super(20, 10, 100, 2, null);
        this.pos = pos;
        this.facing = 0;
        tags = new HashSet<TagsOptions>();
        tags.add(TagsOptions.SMALL);

    }

    public void attack(Unit[][] units, Terrain[][] terrains) {
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
        this.dealDamage(primary,
                this.calcTerrainBasedDamage(terrains[primary.pos[0]][primary.pos[1]], attackDamage, false));
        this.dealDamage(secondary[0],
                this.calcTerrainBasedDamage(terrains[secondary[0].pos[0]][secondary[0].pos[1]], attackDamage, false));
        this.dealDamage(secondary[1],
                this.calcTerrainBasedDamage(terrains[secondary[1].pos[0]][secondary[1].pos[1]], attackDamage, false));
        this.dealDamage(secondary[2],
                this.calcTerrainBasedDamage(terrains[secondary[2].pos[0]][secondary[2].pos[1]], attackDamage, false));

    }
}
