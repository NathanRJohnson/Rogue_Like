package house.game.rogue.Objects;

import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.math.MathUtils.floor;
import static com.badlogic.gdx.math.MathUtils.random;

/**
 * Steps around the grid
 * Used to build dungeon layout
 */
public class Walker {

    int current_row, current_column;
    int num_rows, num_columns;

    public Walker(int _start_column, int _start_row, int _num_columns, int _num_rows) {
        current_row = _start_row;
        current_column = _start_column;
        num_rows = _num_rows;
        num_columns = _num_columns;
    }

    /**
     * Computes a step for the walker to take
     * @param max_row total number of rows in the grid
     * @param max_column total number of columns in the grid
     * @return A random direction, either NORTH, SOUTH, EAST or WEST
     */
    public Vector2 computeDirection(int max_row, int max_column){
        int horizontal_step = 0;
        int vertical_step = 0;

        if (current_column == max_column - 1){ //at the far right edge
            horizontal_step = -1 * random(1);
        } else if(current_column == 0){ //at the far left edge
            horizontal_step = random(1);
        } else {
            int r =  (int) (random() * 100);
            if (r <= 25){
                horizontal_step = 1;
            } else if (r <= 50) {
                horizontal_step = -1;
            } else {
                horizontal_step = 0;
            }
        }
        if (horizontal_step == 0){ //bottom edge
            if (current_row == max_row -1){
                vertical_step = -1;
            } else if(current_row == 0){ //top edge
                vertical_step = 1;
            } else {
                int r = (int) (random() * 100);
                if (r <= 50){
                    vertical_step = 1;
                } else {
                    vertical_step = -1;
                }
            }
        }

        Vector2 direction = new Vector2(horizontal_step, vertical_step);
        return direction;
    }

    /**
     * Updates the walkers current grid position
     * @param _step a direction, either NORTH, SOUTH, EAST, WEST
     * @return new grid position
     */
    public Vector2 step(Vector2 _step){
        current_column += (int)_step.x;
        current_row += (int)_step.y;
        return new Vector2(current_column, current_row);
    }

    public Vector2 getGridPos(){
        Vector2 p = new Vector2(current_column, current_row);
        return  p;
    }
}
