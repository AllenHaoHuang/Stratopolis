package comp1110.ass2.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

class Instructions extends Stage {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private Stage primaryStage = new Stage();
    private Group root = new Group();

    /** SUBFUNCTIONS. FIXME: Needs:
     *      - Top panel, see topPanel in addPanels() in Menu
     *          - and other panels to make it look better
     *      - Title for top panel, see title in addMiddle() in Menu
     *      - Huge chunk of text for instructions that is formatted properly
     */

    Instructions(Stage parentStage) {
        primaryStage.setTitle("How to Play StratoGame - Instructions");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/E.png")));
        primaryStage.setResizable(false);

        // Open as blocking dialog, so only one instance
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.initOwner(parentStage);

        /* FIXME: Run any subfunctions here to generate UI and nodes
            Take a look at viewer or menu for an example */

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("width:" + primaryStage.getWidth() + ", height: " + primaryStage.getHeight());
    }
}
