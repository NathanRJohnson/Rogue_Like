package house.game.rogue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Sprite  implements InputProcessor {
    Texture img;
    private int varX;
    private int varY;

    public Player(String texture) {
        img = new Texture(texture);
        varY = 0;
        varX = 0;
    }

    public int getVarX() {
        return varX;
    }

    public int getVarY() {
        return varY;
    }

    public Texture getImg() {
        return img;
    }

    public void move() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
