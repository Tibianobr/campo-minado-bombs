package sample.model;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;

import static sample.Main.X_TILES;
import static sample.Main.Y_TILES;

public class Grid {

    private static Tile[][] grid = new Tile[X_TILES][Y_TILES];

    public List<Tile> create()
    {
        List<Tile> tileList = new ArrayList<>();
        for (int y = 0; y < Y_TILES; y++) {
            for (int x = 0; x < X_TILES; x++) {
                Tile tile = new Tile(x, y);
                grid[x][y] = tile;
                tileList.add(tile);
            }
        }
        return tileList;
    }


    public static List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();

        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                if (!(x == 0 && y == 0)) {
                    int newX = tile.getX() + x;
                    int newY = tile.getY() + y;

                    // Check bounds
                    if (newX > 0 && newX < X_TILES && newY > 0 && newY < Y_TILES) {
                        neighbors.add(grid[newX][newY]);
                    }
                }
            }
        }
        return neighbors;
    }
}
