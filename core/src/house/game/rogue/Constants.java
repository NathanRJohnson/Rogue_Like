package house.game.rogue;

import com.badlogic.gdx.math.Vector2;

public class Constants {
    public final static int MENU_SCREEN = 0;
    public final static int GAME_SCREEN = 1;
    public final static int ZOMBIE_SCREEN = 2;
    public static final int SHOOT_SCREEN = 3;
    public static final int GENERATION_SCREEN  = 4;
//    public final static int NORTH = 0;
//    public final static int SOUTH = 1;
//    public final static int EAST = 2;
//    public final static int WEST = 3;

    public static final Vector2 NORTH = new Vector2(0, -1);
    public static final Vector2 SOUTH = new Vector2(0, 1);
    public static final Vector2 EAST = new Vector2(1, 0);
    public static final Vector2 WEST = new Vector2(-1, 0);
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    public final static float SCREEN_WIDTH = 1000;
    public final static float SCREEN_HEIGHT = 900;
}
