package house.game.rogue.Objects.Enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends Sprite {
    private Vector2 position;
    private float health;

//    Don't worry about these two right now
    private Vector2 velocity;
    private Vector2 acceleration;

    public Enemy(float x, float y, String txt) {
        super(new Texture(txt));
        setFlip(false,true);
        position = new Vector2(x,y);
        setPosition(x ,y);
    }

    public Vector2 getPosition(){
        return position;
    }
}
