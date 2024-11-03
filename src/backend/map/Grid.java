package backend.map;

public class Grid {
    private Terrain GlobalTerrain[][];

    /**
     * initializes a field with the given dimensions exclusivly using Terrain 0
     * Width i
     * 0/0___________________
     * |
     * | length j
     * |
     * |
     * |
     */
    public Grid(int width, int length) {
        GlobalTerrain = new Terrain[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; i < length; j++) {
                GlobalTerrain[i][j] = new Terrain(0);
            }
        }
    }

    /**
     * initializes a field with the dimension of the given 2DArray using the
     * contianing Terrains
     */
    public Grid(int[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; i < fields[i].length; j++) {
                GlobalTerrain[i][j] = new Terrain(fields[i][j]);
            }
        }
    }

    public Terrain getTerrain(int i, int j) {
        return GlobalTerrain[i][j];
    }
}