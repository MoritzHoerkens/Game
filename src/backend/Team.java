package backend;

import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Color;
import backend.map.Grid;
import backend.units.Unit;

public class Team {
    public final String name;
    private ArrayList<Object[]> moveOrders = new ArrayList<>();
    public HashSet<Unit> units = new HashSet<Unit>();// INdex 0 is the unit and the Rest are Integers
    private Color colour;// in hexadecimal

    public Team(String name, Color colour) {
        this.name = name;
        this.colour = colour;
    }

    public void executeMoveOrders(Grid grid) {
        for (Object[] i : moveOrders) {
            Unit tmp = (Unit) i[0];
            tmp.moveSquare((int) i[1], grid);
        }
    }

    public void addMoveOrder(Unit u, int direction) {
        moveOrders.add(new Object[] { u, Integer.valueOf(direction) });
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
