package house.game.rogue.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import house.game.rogue.Constants;
import house.game.rogue.Menu.MainMenu;
import house.game.rogue.Objects.Button;


public  class ScrMenu extends ScrBase{

    private Button btnPlay;
    private Button btnZombie;
    private Button btnShoot;
    private Button btnGeneration;

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
        btnPlay = new Button(350,200, Gdx.graphics.getWidth()/2 - 175, Gdx.graphics.getHeight()/2, "play.png");
        btnZombie = new Button(150, 150, 75, 100, "zombie_button.png");
        btnShoot = new Button(250, 250, 300, 50, "shoot_button.png");
        btnGeneration = new Button(200, 200, 725, 75,"generation_button.png");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        batch.draw(background, 0, 0, 1000, 900);
        batch.draw(btnPlay, btnPlay.getX(), btnPlay.getY(), btnPlay.getWidth(), btnPlay.getHeight());
        batch.draw(btnZombie, btnZombie.getX(), btnZombie.getY(), btnZombie.getWidth(), btnZombie.getHeight());
        batch.draw(btnShoot, btnShoot.getX(), btnShoot.getY(), btnShoot.getWidth(), btnShoot.getHeight());
        batch.draw(btnGeneration, btnGeneration.getX(), btnGeneration.getY(), btnGeneration.getWidth(), btnGeneration.getHeight());
        batch.end();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button){
        if (button == Input.Buttons.LEFT) {
            if (btnPlay.isOver(screenX, screenY)){
                menu.updateScreen(Constants.GAME_SCREEN);
                System.out.println("Play");
            } else if (btnZombie.isOver(screenX, screenY)){
                menu.updateScreen(Constants.ZOMBIE_SCREEN);
                System.out.println("Zombie");
            } else if (btnShoot.isOver(screenX, screenY)){
                menu.updateScreen(Constants.SHOOT_SCREEN);
                System.out.println("Shoot");
            } else if (btnGeneration.isOver(screenX, screenY)){
                menu.updateScreen(Constants.GENERATION_SCREEN);
                System.out.println("Generation");
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
