package backend;

import backend.map.*;
import backend.units.TagsOptions;
import backend.units.Unit;
import java.util.HashSet;
import java.util.Set;

class TurnControl<T> {
    Unit[][] unitGrid;
    Grid grid = new Grid(10, 10);
    Set<Unit> units = new HashSet<Unit>();

    private void redoUnitGrid() {
        unitGrid = new Unit[unitGrid.length][unitGrid[0].length];// empty grid
        for (Unit i : units) {
            if (i.tags.contains(TagsOptions.DEAD)) {
                units.remove(i);
                continue;
            }
            unitGrid[i.pos[0]][i.pos[1]] = i;
        }
    }

}