package backend;

import backend.map.*;
import backend.units.Unit;
import java.util.ArrayList;
import java.util.Set;

class TurnControl<T> {
    Unit[][] unitGrid;
    Grid grid = new Grid(10, 10);
    Set<Unit> units = new Set<Unit>();

    private void redoUnitGrid() {
        for (Unit i : units) {
            if (i.tags.contains(TagsOptions.DEAD)) {

            }
        }
    }
}