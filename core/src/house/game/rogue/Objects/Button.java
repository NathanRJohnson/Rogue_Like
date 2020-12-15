package house.game.rogue.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Button extends Sprite {
    private float width, height, x, y;

    public Button(float _width, float _height, float _x, float _y, String filename) throws IllegalArgumentException{
        super(new Texture(Gdx.files.internal(filename)));
        x = _x;
        y = _y;
        setPosition(x,y);
        if (_width < 0 || _height < 0){
            throw new IllegalArgumentException("Invalid size argument");
        }
        width = _width;
        height = _height;
        setSize(width, height);
        setFlip(false, true);
    }

    public boolean isOver(int screenX, int screenY) {
        if (screenX > x && screenX < x + width && screenY > y && screenY < y + height) {
            return true;
        } else {
            return false;
        }
    }

    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }

    public float getX() {
        return x;
    }
    public float getY(){
        return y;
    }

}
