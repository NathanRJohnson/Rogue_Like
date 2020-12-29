package house.game.rogue.Menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import house.game.rogue.Screens.*;
import house.game.rogue.Constants;

public class MainMenu extends Game {


    private ScrMenu menu;
    private ScrGame game;
    private ScrZombie zombie;
    private ScrShoot shoot;
    private ScrGeneration generation;
    private int screen;

    @Override
    public void create() {
        screen = Constants.MENU_SCREEN;
        System.out.println(screen);
        menu = new ScrMenu(this);
        game = new ScrGame(this);
        zombie = new ScrZombie(this);
        shoot = new ScrShoot(this);
        generation = new ScrGeneration(this);

        updateScreen(Constants.MENU_SCREEN);
    }

    public void updateScreen(int _screen){
        screen = _screen;
        if (screen == Constants.MENU_SCREEN){
            setScreen(menu);
        }
        else if (screen == Constants.GAME_SCREEN){
            setScreen(game);
        }
        else if (screen == Constants.ZOMBIE_SCREEN){
            setScreen(zombie);
        }
        else if (screen == Constants.SHOOT_SCREEN){
            setScreen(shoot);
        }
        else if (screen == Constants.GENERATION_SCREEN){
            setScreen(generation);
        }
    }

    @Override
    public void render() {
        super.render();
    }

}
