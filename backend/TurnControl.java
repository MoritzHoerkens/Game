package backend.units;

import backend.map.*;
import backend.units.Unit;
import java.util.ArrayList;

class TurnControl {
    Unit[][] unitGrid;
    Grid grid = new Grid(10, 10);
    Set<Unit> units = new Set<Unit>();

    private void redoUnitGrid() {
        for (Unit i : units) {
            if (i.tags.contains(tags.DEAD))
                ;
        }
    }
}