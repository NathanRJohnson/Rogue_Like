package house.game.rogue.Objects.Rooms;

import com.badlogic.gdx.math.Vector2;
import house.game.rogue.Constants;
import house.game.rogue.Objects.Cell;
import house.game.rogue.Objects.Door;

import java.util.ArrayList;

public class Room extends Cell {
    private boolean isPlayerInRoom = false;
    protected ArrayList<Door> doors;

    public Room(int row, int col, String filename) {
        super(row, col, filename);
        setPosition(0,0);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setFlip(false, true);
        doors = new ArrayList<Door>();
    }

    public Room(int row, int col) {
        super(row, col, "floor.jpg");
        setPosition(0,0);
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setFlip(false, true);
        doors = new ArrayList<Door>();
    }




    public void setPlayerinRoom(boolean isPlayer) {
        isPlayerInRoom = isPlayer;
    }

    public boolean getPlayerinRoom() {
        return isPlayerInRoom;
    }
}
