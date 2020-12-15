package house.game.rogue.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import house.game.rogue.Screens.ScrGame;
import house.game.rogue.Screens.ScrMenu;
import house.game.rogue.Constants;

public class MainMenu extends Game {


    private ScrMenu menu;
    private ScrGame game;
    private int screen;

    @Override
    public void create() {
        screen = Constants.MENU_SCREEN;
        System.out.println(screen);
        menu = new ScrMenu(this);
        game = new ScrGame(this);
        updateScreen(Constants.MENU_SCREEN);
    }

    public void updateScreen(int _screen){
        screen = _screen;
        if (screen == Constants.MENU_SCREEN){
            setScreen(menu);
        }
        if (screen == Constants.GAME_SCREEN){
            setScreen(game);
        }
    }

    @Override
    public void render() {
        super.render();
    }

}
