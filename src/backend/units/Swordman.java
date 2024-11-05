package backend.units;

import java.util.HashSet;

import backend.Team;
import backend.map.Grid;

/** basic melee unit with no bonus damage with decent damage to flankers */
public class Swordman extends Unit {

    public Swordman(int[] pos, Team team) {
        super(20, 10, 100, 2, null, team);
        this.pos = pos;
        this.facing = 0;
        tags = new HashSet<TagsOptions>();
        tags.add(TagsOptions.SMALL);

    }

    public void attack(Grid terrains) {
        Unit primary;
        Unit[] secondary = new Unit[3];
        switch (this.facing) {
            case (0):
                primary = this.getUnitTop();
                secondary[0] = this.getUnitRight();
                secondary[1] = this.getUnitBottom();
                secondary[2] = this.getUnitLeft();
                break;
            case (1):
                primary = this.getUnitRight();
                secondary[0] = this.getUnitTop();
                secondary[1] = this.getUnitBottom();
                secondary[2] = this.getUnitLeft();
                break;
            case (2):
                primary = this.getUnitBottom();
                secondary[0] = this.getUnitRight();
                secondary[1] = this.getUnitTop();
                secondary[2] = this.getUnitLeft();
                break;
            case (3):
                primary = this.getUnitLeft();
                secondary[0] = this.getUnitRight();
                secondary[1] = this.getUnitBottom();
                secondary[2] = this.getUnitTop();
                break;
            default:
                primary = null;
                secondary[0] = null;
                secondary[1] = null;
                secondary[2] = null;
                break;
        }
        this.dealDamage(primary,
                this.calcTerrainBasedDamage(terrains.getTerrain(primary.pos[0], primary.pos[1]), attackDamage, false));
        this.dealDamage(secondary[0],
                this.calcTerrainBasedDamage(terrains.getTerrain(secondary[0].pos[0], secondary[0].pos[1]), attackDamage,
                        false));
        this.dealDamage(secondary[1],
                this.calcTerrainBasedDamage(terrains.getTerrain(secondary[1].pos[0], secondary[1].pos[1]), attackDamage,
                        false));
        this.dealDamage(secondary[2],
                this.calcTerrainBasedDamage(terrains.getTerrain(secondary[2].pos[0], secondary[2].pos[1]), attackDamage,
                        false));

    }
}
