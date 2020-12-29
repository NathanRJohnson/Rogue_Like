package house.game.rogue.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import static house.game.rogue.Constants.*;

/**
 * Acts as a place holder for actual rooms in the grid
 */
public class Cell extends Sprite {
    protected int rowx, colx;
    protected ArrayList<Door> doors;
    protected int[] door_index;

    public Cell(int _col, int _row, String filename) {
        super(new Texture(filename));
        colx = _col;
        rowx = _row;
        doors = new ArrayList<Door>();
        door_index = new int[4];
        for (int i = 0; i < 4; i++){
            door_index[i] = INACTIVE;
        }
    }

    public Cell(int _col, int _row) {
        colx = _col;
        rowx = _row;
        doors = new ArrayList<Door>();
    }

    /**
     * Adds a door to the room if there isn't one already
     * @param wall NORTH, SOUTH, WEST, or EAST
     */
    public void addDoor(Vector2 wall) {
        if (!hasDoor(wall)){
            doors.add(new Door(wall));
            if (wall.equals(NORTH)) {
                door_index[0] = ACTIVE;
            } else if (wall.equals(SOUTH)) {
                door_index[1] = ACTIVE;
            } else if (wall.equals(EAST)) {
                door_index[2] = ACTIVE;
            } else { //WEST
                door_index[3] = ACTIVE;
            }
        }
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    /**
     *
     * @param wall that you want to check (NORTH, SOUTH, EAST, WEST)
     * @return trye if a door exists on that wall, false otherwise
     */
    public boolean hasDoor(Vector2 wall) {
        if (wall.equals(NORTH)) {
            return door_index[0] == ACTIVE;
        } else if (wall.equals(SOUTH)) {
            return door_index[1] == ACTIVE;
        } else if (wall.equals(EAST)) {
            return door_index[2] == ACTIVE;
        } else { //WEST
            return door_index[3] == ACTIVE;
        }
    }

    public Vector2 getGridPos(){
        return new Vector2(colx,rowx);
    }

}
