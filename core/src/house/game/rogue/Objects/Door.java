package house.game.rogue.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import static house.game.rogue.Constants.*;

public class Door extends Sprite {
    private Vector2 position;
    private Vector2 direction;
    public Door(Vector2 _direction) {
        super(new Texture("door.png"));
        setSize(200, 200);
        setFlip(false, true);
        position = new Vector2();
        direction = _direction;
        if (compare(NORTH, direction)) {
            position.set(SCREEN_WIDTH / 2, 0);
        } else if (compare(SOUTH, direction)) {
            position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT - 100);
        } else if (compare(EAST, direction)) {
            position.set(SCREEN_WIDTH - 100, SCREEN_HEIGHT / 2);
        } else if (compare(WEST, direction)) {
            position.set(0, SCREEN_HEIGHT / 2);
        } else {
            System.out.println("invalid direction");
        }
        setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position.cpy();
    }

    public Vector2 getDirection(){
        return direction.cpy();
    }

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
