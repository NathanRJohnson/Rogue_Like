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
        if (direction.equals(NORTH)) {
            position.set(SCREEN_WIDTH / 2, 100);
        } else if (direction.equals(SOUTH)) {
            position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT - 100);
        } else if (direction.equals(EAST)) {
            position.set(SCREEN_WIDTH - 100, SCREEN_HEIGHT / 2);
        } else if (direction.equals(WEST)) {
            position.set(100, SCREEN_HEIGHT / 2);
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
        if (Math.abs(x - position.x) < 50 && Math.abs(y - position.y) < 50) {
            System.out.println("Entered!!");
            return true;
        }
        return false;
    }
}
