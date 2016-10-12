package comp1110.ass2.gui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * `Instructions` allows users to view the instructions for the game
 *
 * @author Marvin Yang - u5894100
 */
class Instructions extends Stage {
    private static final int WIDTH = 550;
    private static final int HEIGHT = 625;

    private Stage primaryStage = new Stage();
    private Group root = new Group();

    private void addPanels() {
        // Add the panels for UI
        Rectangle mainPanel = new Rectangle(568, 672);
        mainPanel.setFill(Color.web("#E9E9ED"));

        Rectangle leftPanel = new Rectangle(130, 672);
        leftPanel.setFill(Color.BLUEVIOLET);
        leftPanel.setOpacity(0.8);

        Rectangle rightTopPanel = new Rectangle(130, 0, 438, 90);
        rightTopPanel.setFill(Color.web("#3E50B5"));
        rightTopPanel.setOpacity(0.9);

        root.getChildren().addAll(mainPanel, leftPanel, rightTopPanel);
    }

    // Add labels and text
    private void addContains() {
        Label title = new Label("Instructions");
        title.setRotate(-90);
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("Open Sans", 70));
        title.setLayoutX(-120);
        title.setLayoutY(200);

        Label topicLeft = new Label("StratoGame");
        topicLeft.setFont(Font.font("Open Sans", 37));
        topicLeft.setTextFill(Color.WHITE);
        topicLeft.setLayoutX(140);
        topicLeft.setLayoutY(40);

        Label topicMain = new Label("Basic Rules:");
        topicMain.setFont(Font.font("Open Sans", 20));
        topicMain.setLayoutX(140);
        topicMain.setLayoutY(100);

        Text block = new Text("Players can choose either Green or Red. Each player, "
                + "starts with twenty randomly shuffled tiles. By using the mouse, you can hover over to the "
                + "position you want to place your tile on. Player Green can also use WASD to position, QE to rotate and Spacebar to place the tile. "
                + "Player Red can use IJKL to position, UO to rotate and Enter to place the tile.\n\n"
                + "There are two rules for a tile placement"
                + "\n1. The tile must be next to or above another tile."
                + "\n2. In order to place a tile above other tiles, each colour on the tile may only be stacked on top of itself or black. "
                + "There must also be no overhangs, and each stacked tile must be over at least two different tiles.\n\n"
                + "Score is calculated by multiplying the number of squares in your largest region of "
                + "connected tiles of your colour with the "
                + "maximum height of tiles in that region. The player with the higher score wins. If the scores are equal, "
                + "ties will be broken according to the value of the next largest region; cascading to smaller regions if ties persist;"
                + " and ultimately to a random choice in the unlikely event that it remains unbroken.");
        block.setFont(Font.font("Open Sans", 15.5));
        block.setWrappingWidth(WIDTH - 140);
        block.setLayoutX(140);
        block.setLayoutY(150);

        root.getChildren().addAll(title, topicLeft, block, topicMain);
    }

    // Make a button for the users to close the form
    private void makeControl(){
        Button menu = new Button("Close");
        menu.setAlignment(Pos.CENTER);
        menu.setTranslateX(30);
        menu.setTranslateY(HEIGHT - 50);
        menu.setId("control-btn");
        menu.setOnAction(event -> {
            primaryStage.close();
        });
        root.getChildren().addAll(menu);
    }

    Instructions(Stage parentStage) {
        primaryStage.setTitle("How to Play StratoGame - Instructions");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/E.png")));
        primaryStage.setResizable(false);

        // Open as blocking dialog, so only one instance
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.initOwner(parentStage);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);

        // Add CSS Stylesheet for buttons and load font
        String style = getClass().getResource("assets/theme.css").toExternalForm();
        scene.getStylesheets().add(style);
        Font.loadFont(getClass().getResourceAsStream("assets/OpenSans-Regular.ttf"), 16);

        addPanels();
        addContains();
        makeControl();

        primaryStage.showAndWait();
    }
}


