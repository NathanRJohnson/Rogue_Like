package house.game.rogue.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import house.game.rogue.Constants;
import house.game.rogue.Menu.MainMenu;
import house.game.rogue.Objects.Button;


public  class ScrMenu extends ScrBase{

    private Button btnPlay;
    public ScrMenu(MainMenu _mainMenu) {
        super();
        menu = _mainMenu;
        txtBackground = new Texture("Background.jpg");

    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        background = new Sprite(txtBackground);
        background.setFlip(false,true);
        btnPlay = new Button(350,175, Gdx.graphics.getWidth()/2 - 175, Gdx.graphics.getHeight()/2, "play.png");
        System.out.println("bruh");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        batch.draw(background, 0, 0, 1000, 900);
        batch.draw(btnPlay, btnPlay.getX(), btnPlay.getY(), btnPlay.getWidth(), btnPlay.getHeight());
        batch.end();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button){
        if (button == Input.Buttons.LEFT) {
            if (btnPlay.isOver(screenX, screenY)){
                menu.updateScreen(Constants.GAME_SCREEN);
                System.out.println("Button Pressed");
            }
        }
        return false;
    }

    @Override
    public void dispose(){
        batch.dispose();
        txtBackground.dispose();
        background.getTexture().dispose();
        btnPlay.getTexture().dispose();
    }
}
