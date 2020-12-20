package house.game.rogue.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import house.game.rogue.Objects.Room;

import house.game.rogue.Menu.MainMenu;

public class ScrGame extends ScrBase{
    private Room room;
    public ScrGame(MainMenu _mainMenu) {
        super();
        menu = _mainMenu;
        txtBackground = new Texture("floor.jpg");
    }

    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        background = new Sprite(txtBackground);
        room = new Room(0,0,"floor.jpg");
        background.setFlip(false,true);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        batch.draw(background, 0, 0, 1000, 900);
        room.draw(batch);
        batch.end();
    }

    @Override
    public void dispose(){
        batch.dispose();
        txtBackground.dispose();
    }
}
