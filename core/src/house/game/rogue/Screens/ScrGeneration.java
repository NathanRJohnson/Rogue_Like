package house.game.rogue.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import house.game.rogue.Menu.MainMenu;
import house.game.rogue.Objects.Door;
import house.game.rogue.Objects.Grid;
import house.game.rogue.Objects.Player;
import house.game.rogue.Objects.Rooms.Room;

import java.util.ArrayList;

import static house.game.rogue.Constants.*;

public class ScrGeneration extends ScrBase{
    private Room room;
    private Player player;
    private Grid g;
    private Vector2 currentPos = new Vector2();
    private ArrayList<Door> doors;

    public ScrGeneration(MainMenu _mainMenu) {
        super();
        menu = _mainMenu;

    }

    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        player = new Player("Kirby.png");
        g = new Grid(4);
        g.setRooms();
        g.computePath();
        currentPos.set(g.getStartRoom());
        room = g.getRoom(currentPos);
        doors = room.getDoors();
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
//     Please keep methods that are not related to drawing things to the screen
//     outside of the batch
        batch.begin();
        batch.draw(room, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        for (Door d: doors){
            batch.draw(d, d.getPosition().x, d.getPosition().y, 100, 100);
        }
        batch.draw(player, player.getVarX(), player.getVarY(), 150,150);
        batch.end();

        for (Door d: doors){
            if (d.isEntered(player.getVarX(), player.getVarY())){
                currentPos.add(d.getDirection());
                System.out.println(currentPos);
                room = g.getRoom(currentPos);
                doors = room.getDoors();
                player.setPosition(d.getExitPosition().x, d.getExitPosition().y);
            }
        }
        player.move();

    }

    @Override
    public void dispose(){
        batch.dispose();
    }
}
