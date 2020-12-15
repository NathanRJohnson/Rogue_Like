package house.game.rogue.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import house.game.rogue.Menu.MainMenu;

public class ScrGame extends ScrBase{

    public ScrGame(MainMenu _mainMenu) {
        super();
        menu = _mainMenu;
        txtBackground = new Texture("floor.jpg");
    }

    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        background = new Sprite(txtBackground);
        background.setFlip(false,true);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        batch.draw(background, 0, 0, 1000, 900);
        batch.end();
    }

    @Override
    public void dispose(){
        batch.dispose();
        txtBackground.dispose();
    }
}
