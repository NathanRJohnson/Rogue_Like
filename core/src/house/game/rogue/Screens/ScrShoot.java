package house.game.rogue.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import house.game.rogue.Menu.MainMenu;
import house.game.rogue.Objects.Player;
import house.game.rogue.Objects.Rooms.Room;

import static house.game.rogue.Constants.SCREEN_HEIGHT;
import static house.game.rogue.Constants.SCREEN_WIDTH;

public class ScrShoot extends ScrBase{
    private Room room;
    private Player player;
    private Texture txt_icon;
    private Sprite spr_icon;

    public ScrShoot(MainMenu _mainMenu) {
        super();
        menu = _mainMenu;
    }

    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        room = new Room(0,0,"floor.jpg");
        player = new Player("Kirby.png");

        txt_icon = new Texture("shoot_button.png");
        spr_icon = new Sprite(txt_icon);
        spr_icon.setFlip(false,true);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
//     Please keep methods that are not related to drawing things to the screen
//     outside of the batch
        batch.begin();
        batch.draw(room, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        batch.draw(player, player.getVarX(), player.getVarY(), player.getWidth(),player.getHeight());
        batch.draw(spr_icon, SCREEN_WIDTH - 100,0, 100,100 );
        batch.end();

        player.move();
    }

    @Override
    public void dispose(){
        batch.dispose();
        txtBackground.dispose();
    }
}
