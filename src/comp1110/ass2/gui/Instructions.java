package comp1110.ass2.gui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static java.awt.SystemColor.TEXT;
import static java.awt.SystemColor.info;
import static java.awt.SystemColor.text;

class Instructions extends Stage {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 530;

    private Stage primaryStage = new Stage();
    private Group root = new Group();
    private Group controls = new Group();

    private void addPanels() {
        Rectangle mainPanel = new Rectangle(primaryStage.getWidth(), primaryStage.getHeight());
        mainPanel.setFill(Color.web("#E9E9ED"));

        Rectangle leftPanel = new Rectangle(130, primaryStage.getHeight());
        leftPanel.setFill(Color.BLUEVIOLET);

        Rectangle rightTopPanel = new Rectangle(130, 0,primaryStage.getWidth()-130,90);
        rightTopPanel.setFill(Color.web("#3E50B5"));

        root.getChildren().addAll(mainPanel, leftPanel, rightTopPanel);
    }
    //add contains
    private void addcontains() {
        Label title = new Label("Instructions");
        title.setRotate(-90);
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font(70));
        title.setLayoutX(-120);
        title.setLayoutY(200);

        Label topicLeft = new Label("StratoGame");
        topicLeft.setFont(Font.font(37));
        topicLeft.setTextFill(Color.WHITE);
        topicLeft.setLayoutX(140);
        topicLeft.setLayoutY(40);

        Label topicformainbody = new Label("Basic Rules:");
        topicformainbody.setFont(Font.font(20));
        topicformainbody.setLayoutX(140);
        topicformainbody.setLayoutY(100);

        Text block = new Text("Player can choose either Green or Red. For each colour, "
                                + "there are 20 tiles. By using the mouse, you can `hover` the"
                                + " piece to the place you want.\n\n"
                                + "As for the placement, you have two options. The first one, "
                                + "your placement have to attach with other tile on grid (no "
                                + "matter green black or red). The second one, you can place "
                                + "tile at top of existing placements, but make sure the tile "
                                + "placed have the exactly same color with tiles on the grid "
                                + "and the under tiles must have same height on each square.\n\n"
                                + "Your score is calculated by finding the largest region of "
                                + "contiguous squares of your color,and then multiplying the "
                                + "number of squares forming the region by the maximum "
                                + "height of tiles in the region.");
        block.setFont(Font.font(16));
        block.setWrappingWidth(WIDTH - 140);
        block.setLayoutX(140);
        block.setLayoutY(150);

        root.getChildren().addAll(title,topicLeft,block,topicformainbody);
    }


    // Make a button for the users to quit the instruction
    private void makeControl(){
        Button menu = new Button("Close");
        menu.setId("control-btn");
        menu.setOnAction(event -> {
            primaryStage.close();
        });

        HBox hb = new HBox();
        hb.getChildren().addAll(menu);
        hb.setSpacing(10);
        hb.setPrefWidth(WIDTH-50);
        hb.setAlignment(Pos.CENTER);
        hb.setLayoutX(-150);
        hb.setLayoutY(HEIGHT - 60);
        controls.getChildren().add(hb);
        root.getChildren().addAll(hb);

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
        primaryStage.show();

        // Add CSS Stylesheet for buttons
        String style = getClass().getResource("assets/theme.css").toExternalForm();
        scene.getStylesheets().add(style);

        addPanels();
        addcontains();
        makeControl();
    }
}


