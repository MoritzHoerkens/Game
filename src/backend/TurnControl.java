package backend;

import backend.map.*;
import backend.units.TagsOptions;
import backend.units.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class TurnControl {
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

    private void executeMoveOrders() {
        ArrayList<Integer> orders = new ArrayList<Integer>();
        for (Unit i : units) {
            for (int j = 0; j < i.moveOrder.length(); j++) {
                orders.add(Integer.valueOf(i.moveOrder.charAt(j)));
            }
            for (Integer n : orders) {
                i.moveSquare(n, unitGrid, grid);
            }
        }
    }

    private void unitsAttack() {
        for (Unit i : units) {
            i.attack(unitGrid, grid);
        }
    }
}