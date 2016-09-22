package comp1110.ass2.gui;

import comp1110.ass2.bots.Player;
import comp1110.ass2.gui.scenes.Board;
import comp1110.ass2.gui.scenes.Viewer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;

/* Fancy yet ugly material design based main menu */
public class Menu extends Application {
    private static final int WIDTH = 518;
    private static final int HEIGHT = 352;

    // So we can return to menu
    private Stage primaryStage;
    private Group root = new Group();
    private Scene scene;

    private Player greenState = Player.Human;
    private Player redState = Player.Human;

    private void addPanels() {
        Rectangle mainPanel = new Rectangle(primaryStage.getWidth(), primaryStage.getHeight());
        mainPanel.setFill(Color.web("#E9E9ED"));

        Rectangle topPanel = new Rectangle(primaryStage.getWidth(), 120);
        topPanel.setFill(Color.web("#3E50B5"));

        Rectangle middlePanel = new Rectangle(primaryStage.getWidth() - 130, primaryStage.getHeight() - 100);
        middlePanel.setLayoutX(65);
        middlePanel.setLayoutY(75);
        middlePanel.setFill(Color.web("#FEFEFE"));

        root.getChildren().addAll(mainPanel, topPanel, middlePanel);
    }

    private void addLabels() {
        Label title = new Label ("StratoGame");
        title.setId("title-txt");
        title.setLayoutX(65);
        title.setLayoutY(20);

        Label green = new Label("Player Green");
        Label red = new Label("Player Red");
        green.setFont(Font.font(19));
        red.setFont(Font.font(19));

        Label info = new Label("By William Shen, Allen Huang and Marvin Yang");
        info.setFont(Font.font(16));
        info.setTextFill(Color.web("#3E50B5"));
        info.setPrefWidth(primaryStage.getWidth());
        info.setAlignment(Pos.CENTER);
        info.setLayoutY(HEIGHT - 25);

        HBox hb = new HBox();
        hb.setPrefWidth(primaryStage.getWidth());
        hb.getChildren().addAll(green, red);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(90);
        hb.setLayoutY(90);

        root.getChildren().addAll(title, hb, info);
    }

    private void viewerButton() {
        Button viewer = new Button("V");
        viewer.setId("round-btn");
        viewer.setTooltip(new Tooltip("Open Viewer"));
        viewer.setLayoutX(primaryStage.getWidth() - 100);
        viewer.setLayoutY(20);
        root.getChildren().add(viewer);

        viewer.setOnAction(event -> {
            Scene viewScene = new Viewer(new Group(), scene, primaryStage);
            this.primaryStage.setScene(viewScene);
        });
    }

    private void playerButtons() {
        Button playerGreen = new Button("Human");
        playerGreen.setId("player-btn-green");

        Button playerRed = new Button ("Human");
        playerRed.setId("player-btn-red");

        HBox hb = new HBox();
        hb.getChildren().addAll(playerGreen, playerRed);
        hb.setPrefWidth(primaryStage.getWidth());
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(90);
        hb.setLayoutY(125);
        root.getChildren().add(hb);

        playerGreen.setOnAction(event -> {
            greenState = greenState.getNext();
            playerGreen.setText(greenState.toString());
        });

        playerRed.setOnAction(event -> {
            redState = redState.getNext();
            playerRed.setText(redState.toString());
        });
    }

    private void controlButtons() {
        Button help = new Button("Help");
        help.setId("control-btn");
        help.setPrefWidth(80);

        Button startGame = new Button("Start Game");
        startGame.setId("control-btn");

        Button exit = new Button("Exit");
        exit.setId("control-btn");
        exit.setPrefWidth(80);

        HBox hb = new HBox();
        hb.setPrefWidth(primaryStage.getWidth() - 130);
        hb.setSpacing(25);
        hb.setAlignment(Pos.CENTER);
        hb.setLayoutX(65);
        hb.setLayoutY(HEIGHT - 90);
        hb.getChildren().addAll(startGame, help, exit);

        root.getChildren().add(hb);

        // Open game board and pass player states
        startGame.setOnAction(event -> {
            Scene board = new Board(new Group(), greenState, redState);
            this.primaryStage.setScene(board);
        });

        // Close program
        exit.setOnAction(event -> {
            // Make user confirm they want to exit
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Please confirm that you are exiting StratoGame.");

            // Check response and take action accordingly
            Optional<ButtonType> response = confirm.showAndWait();
            if (response.isPresent() && ButtonType.OK.equals(response.get()))
                Platform.exit();
        });

        // Show help message
        help.setOnAction(event -> {
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setTitle("StratoGame - Help");
            message.setHeaderText("Main Menu Help");
            message.setContentText("Please select which player you desire to be, and/or place against."
                + " There are 3 kinds of players - Human, Easy Bot, and Hard Bot. Once you have "
                + "selected the players, press 'Start Game'.\n To open the viewer, click on the 'V'"
                + "at the top right corner of the window.");
            message.showAndWait();
        });
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/R.png")));
        primaryStage.setTitle("StratoGame - Main Menu");
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setMinWidth(WIDTH);
        scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        String style = getClass().getResource("assets/theme.css").toExternalForm();
        scene.getStylesheets().add(style);

        addPanels();
        addLabels();
        viewerButton();
        playerButtons();
        controlButtons();

        System.out.println("width: " + primaryStage.getWidth() + ", height: " + primaryStage.getHeight());
        root.requestFocus();
    }

}
