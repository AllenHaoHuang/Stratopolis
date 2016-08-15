package comp1110.ass2.gui;

/**
 * Created by allen on 15/08/2016.
 */

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.*;

public class PlayGame {

    // represents grid
    public class Grid extends ImageView {};

    // represents pieces
    public class FXPiece extends ImageView {};

    // to allow piece to be dragged or dropped
    public class DraggablePiece extends FXPiece {
        int position;
        int homeX, homeY;
        double mouseX, mouseY;

        // snap to nearest grid position
        private void snapToGrid(){};

        // snap to home if piece not hovering over grid
        private void snapToHome(){};

        // for rotation
        private void rotate(){};
    };


    // set handlers for game
    private void setUpHandlers(Scene scene) {};
    private void setUpSound () {};

    private void makePieces() {};
    private void makeGrid() {};
    private void resetPieces() {};
    private void makeControls() {};
    private void endGame() {};
    private void newGame() {};
}
