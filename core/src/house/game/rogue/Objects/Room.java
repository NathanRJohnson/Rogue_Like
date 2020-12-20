package house.game.rogue.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import house.game.rogue.Constants;

public class Room extends Sprite {
    private float width;
    private float height;
    private float x;
    private float y;
    private int row_index;
    private int column_index;
    private boolean isPlayerInRoom = false;
    private int[] doors;

    public Room(int row, int col, String filename) {
        super(new Texture(Gdx.files.internal(filename)));
        x = 0;
        y = 0;
        row_index = row;
        column_index = col;
        setPosition(x,y);
        width = Constants.SCREEN_WIDTH;
        height = Constants.SCREEN_HEIGHT;
        setSize(width, height);
        setFlip(false, true);
        doors = new int[4];
        doors[Constants.NORTH] = 0;
        doors[Constants.SOUTH] = 0;
        doors[Constants.EAST] = 0;
        doors[Constants.WEST] = 0;
    }

    public void display() {
        //draw();
    }

    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public int getRow() {
        return row_index;
    }

    public void setRow(int row) {
        row_index = row;
    }

    public int getColumn() {
        return column_index;
    }

    public void setColumn(int col) {
        column_index = col;
    }

    public void setPlayerinRoom(boolean isPlayer) {
        isPlayerInRoom = isPlayer;
    }

    public boolean getPlayerinRoom() {
        return isPlayerInRoom;
    }
}
