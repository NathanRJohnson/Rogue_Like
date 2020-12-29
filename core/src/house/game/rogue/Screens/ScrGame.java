package house.game.rogue.Screens;
import com.badlogic.gdx.Gdx;
import house.game.rogue.Objects.Rooms.Room;

import house.game.rogue.Menu.MainMenu;
import house.game.rogue.Objects.Player;

import static house.game.rogue.Constants.*;

public class ScrGame extends ScrBase {
    private Room room;
    private Player player;

    public ScrGame(MainMenu _mainMenu) {
        super();
        menu = _mainMenu;
    }

    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        room = new Room(0,0,"floor.jpg");
        player = new Player("Kirby.png");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
//     Please keep methods that are not related to drawing things to the screen
//     outside of the batch
        batch.begin();
        batch.draw(room, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        batch.draw(player, player.getVarX(), player.getVarY(), player.getWidth(),player.getHeight());
        batch.end();

        player.move();
    }

    @Override
    public void dispose(){
        batch.dispose();
        txtBackground.dispose();
    }
}
