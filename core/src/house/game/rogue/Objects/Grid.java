package house.game.rogue.Objects;

import com.badlogic.gdx.math.Vector2;
import house.game.rogue.Objects.Rooms.BossRoom;
import house.game.rogue.Objects.Rooms.Room;
import house.game.rogue.Objects.Rooms.StartRoom;

import java.util.ArrayList;

import static com.badlogic.gdx.math.MathUtils.floor;
import static com.badlogic.gdx.math.MathUtils.random;

public class Grid {
    private Cell[][] grid;
    private int rows, columns;
//    private ArrayList<Door> doors;
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

    public void computePath() {
        Vector2 boss_coordinates = b.getGridPos();
        Vector2 walker_start_pos;
        Vector2 direction;
        System.out.println(s.getGridPos() + " " + boss_coordinates);
        while (!walker.getGridPos().equals(boss_coordinates)) {

            walker_start_pos = walker.getGridPos();
            direction = walker.computeDirection(columns, rows) ;

            Vector2 newpos = walker.step(direction);
            if (!newpos.equals(b.getGridPos())&& !newpos.equals(s.getGridPos()) && !(grid[floor(newpos.x)][floor(newpos.y)] instanceof Room)) {
                Room r = new Room((int)newpos.x, (int)newpos.y);
                grid[floor(newpos.x)][floor(newpos.y)] = r;
            }
            Door d = new Door(direction);
            //if (!exists(d)) {
            grid[floor(walker_start_pos.x)][floor(walker_start_pos.y)].addDoor(direction);
//            doors.add(d);
            //}
            Vector2 inverse = direction.cpy();
            inverse.scl(-1);
            inverse.nor();
//            //if (!exists(d)) {
            grid[floor(newpos.x)][floor(newpos.y)].addDoor(inverse);

//            //}
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
