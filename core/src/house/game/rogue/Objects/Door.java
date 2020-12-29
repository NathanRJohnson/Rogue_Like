package house.game.rogue.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import static house.game.rogue.Constants.*;

/**
 * Controls movement from room to room
 */
public class Door extends Sprite {
    private Vector2 position;
    private Vector2 direction;
    private Vector2 exitPosition;
    public Door(Vector2 _direction) {
        super(new Texture("door.png"));
        setSize(200, 200);
        setFlip(false, true);
        position = new Vector2();
        exitPosition = new Vector2();
        direction = _direction;
        if (compare(NORTH, direction)) {
            position.set(SCREEN_WIDTH / 2, 0);
            exitPosition.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT - 250);
        } else if (compare(SOUTH, direction)) {
            position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT - 100);
            exitPosition.set(SCREEN_WIDTH / 2, 150);
        } else if (compare(EAST, direction)) {
            position.set(SCREEN_WIDTH - 100, SCREEN_HEIGHT / 2);
            exitPosition.set(250, SCREEN_HEIGHT/2);
        } else if (compare(WEST, direction)) {
            position.set(0, SCREEN_HEIGHT / 2);
            exitPosition.set(SCREEN_WIDTH - 250, SCREEN_HEIGHT/2);
        }
        setPosition(position.x, position.y);
    }

    /**
     * The position the player is set to once going through the door
     * @return new position for the player
     */

    public Vector2 getExitPosition(){
        return exitPosition.cpy();
    }

    public Vector2 getPosition() {
        return position.cpy();
    }

    public Vector2 getDirection(){
        return direction.cpy();
    }

    /**
     * Checks to see if the player is close enough to the door
     * @param x player x position
     * @param y player y position
     * @return true if the player is close enough to the door, false otherwise
     */
    public boolean isEntered(float x, float y) {
        if (Math.abs(x - position.x) < 100 && Math.abs(y - position.y) < 100) {
            System.out.println("Entered!!");
            return true;
        }
        return false;
    }

    private boolean compare(Vector2 a, Vector2 b){
        return (Math.abs(a.x - b.x) < 0.00001 && Math.abs(a.y - b.y) < 0.00001);
    }
}
