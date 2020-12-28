package house.game.rogue.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

//Player is an object, so it belongs in the Objects package
public class Player extends Sprite implements InputProcessor {
    // changed ints to floats
    private float varX;
    private float varY;
    //added variables to control width and height
    private float width, height;

    public Player(String texture) {
//      When creating a derived class (a class which extends something, you should to call super in the constructor
        super(new Texture(texture));
        varY = 0;
        varX = 0;
        setFlip(false,true);
        setPosition(varX, varY);
        width = height = 300;
    }

    public float getVarX() {
        return varX;
    }

    public float getVarY() {
        return varY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() { return height;}

    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            varX--;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            varX++;
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            varY--;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            varY++;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
