package house.game.rogue.Objects;

import com.badlogic.gdx.math.Vector2;
import house.game.rogue.Objects.Rooms.BossRoom;
import house.game.rogue.Objects.Rooms.Room;
import house.game.rogue.Objects.Rooms.StartRoom;

import java.util.ArrayList;

import static com.badlogic.gdx.math.MathUtils.floor;
import static com.badlogic.gdx.math.MathUtils.random;

/**
 * Manages the generation of the dungeon
 */
public class Grid {
    private Cell[][] grid;
    private int rows, columns;
    private BossRoom b;
    private StartRoom s;
    private Walker walker;

    public Grid(int size){
        if (size< 0) {
            throw new IllegalArgumentException();
        }
        columns = rows = size;
        grid = new Cell[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(columns, rows);
            }
        }
    }

    public Grid(int _columns, int _rows){
        if (rows < 0 || columns < 0) {
            throw new IllegalArgumentException();
        }
        columns = _columns;
        rows = _rows;
    }

    /**
     * Sets the start and end rooms
     *
     * Randomly selects two different cell spaces, and marks them as the boss and start rooms respectively
     * Sets the position of the walker
     */
    public void setRooms() {
        int randomCol = random(columns - 1);
        int randomRow = random(rows - 1);
        b = new BossRoom(randomCol, randomRow);
        grid[randomCol][randomRow] = b;

        int randomRow2;
        int randomCol2;
        do {
            randomRow2 = random(rows - 1);
            randomCol2 = random( columns - 1);
        } while (randomRow == randomRow2 && randomCol == randomCol2);

        s = new StartRoom(randomCol2, randomRow2);
        grid[randomCol2][randomRow2] = s;
        walker = new Walker(randomCol2, randomRow2, columns, rows);
    }

    /**
     * Generates the dungeon layout
     *
     * The walker steps around the grid of cells, starting at the start cell, and ending
     * when it arrives in the boss cell. When the walker steps into a grid space, it generates a new room,
     * and places a door on the wall it passed through in the previous room, and a door on the opposite wall
     * in the new room.
     */
    public void computePath() {
        //End position of the walker
        Vector2 boss_coordinates = b.getGridPos();
        //Starting Position of the walker
        Vector2 walker_start_pos;
        Vector2 direction;
        System.out.println(s.getGridPos() + " " + boss_coordinates);

        // Until we reach the boss room
        while (!walker.getGridPos().equals(boss_coordinates)) {
            //Find the curent grid position of the walker
            walker_start_pos = walker.getGridPos();
            //Create a random direction for it to step (within bounds)
            direction = walker.computeDirection(columns, rows);
            //calculate the grid position of the walker after it has taken the step
            Vector2 newpos = walker.step(direction);

            //Create a new room, if it is not already a room
            if (!newpos.equals(b.getGridPos())&& !newpos.equals(s.getGridPos()) && !(grid[floor(newpos.x)][floor(newpos.y)] instanceof Room)) {
                Room r = new Room((int)newpos.x, (int)newpos.y);
                grid[floor(newpos.x)][floor(newpos.y)] = r;
            }
            //Create a new door in the previous room on the wall we stepped through
            grid[floor(walker_start_pos.x)][floor(walker_start_pos.y)].addDoor(direction);

            //Create a new door on the opposite wall in the new room
            Vector2 inverse = direction.cpy();
            inverse.scl(-1);
            inverse.nor();
            grid[floor(newpos.x)][floor(newpos.y)].addDoor(inverse);
        }
    }

    private boolean valid_move(Vector2 player_position, Vector2 direction) {
        if (!(grid[floor(player_position.x)][floor(player_position.y)].hasDoor(direction))) {
            return false;
        }
        return true;
    }

    public Vector2 getStartRoom(){
        return s.getGridPos().cpy();
    }

    public Room getRoom(Vector2 gridPos){
        if (grid[(int)gridPos.x][(int)gridPos.y] instanceof Room){
            return (Room)grid[(int)gridPos.x][(int)gridPos.y];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
