package backend;

import java.util.ArrayList;
import java.util.HashSet;
import backend.units.Unit;

public class Team {
    public final String name;
    private ArrayList<Object[]> moveOrders = new ArrayList<>();
    public HashSet<Unit> units = new HashSet<Unit>();// INdex 0 is the unit and the Rest are Integers
    private String colour;// in hexadecimal

    public Team(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public void executeMoveOrders() {
        for (Object[] i:moveOrders){
            Unit tmp=(Unit) i[0];
            tmp.moveSquare(i[1], null, null);
        }
    }
    public void addMoveOrder(Unit u, int direction){
        moveOrders.add(new Object[]{u,Integer.valueOf(direction)});
    }
}
