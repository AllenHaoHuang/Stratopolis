package comp1110.ass2.gui;

import comp1110.ass2.bots.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;

/* Fancy yet ugly material design based main menu */
public class Menu extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 455;

    // So we can return to menu
    private Stage primaryStage;
    private Group root = new Group();
    private Group middleComponents = new Group();

    private Button greenBtn = new Button("Human");
    private Button redBtn = new Button ("Human");

    private Player greenPlayer = Player.Human;
    private Player redPlayer = Player.Human;

    private double redDifficulty = 2;
    private double greenDifficulty = 2;

    private void addPanels() {
        // Create panels and add to root
        Rectangle mainPanel = new Rectangle(primaryStage.getWidth(), primaryStage.getHeight());
        mainPanel.setFill(Color.web("#E9E9ED"));

        Rectangle topPanel = new Rectangle(primaryStage.getWidth(), 130);
        topPanel.setFill(Color.web("#3E50B5"));

        Rectangle middlePanel = new Rectangle(primaryStage.getWidth() - 130, HEIGHT - 125);
        middlePanel.setLayoutX(65);
        middlePanel.setLayoutY(85);
        middlePanel.setFill(Color.web("#FFFFFF"));

        root.getChildren().addAll(mainPanel, topPanel, middlePanel);
    }

    private void topButtons() {
        Button howToPlay = new Button("H");
        howToPlay.setId("round-btn-blue");
        howToPlay.setTooltip(new Tooltip("How to Play StratoGame"));
        howToPlay.setLayoutX(primaryStage.getWidth() - 200);
        howToPlay.setOnAction(event -> {
            new Alert(Alert.AlertType.ERROR, "Under Construction.").showAndWait();
            /* Open form with instructions on how to play
            new Instructions(primaryStage); */
        });

        Button help = new Button("?");
        help.setId("round-btn-teal");
        help.setTooltip(new Tooltip("Help"));
        help.setLayoutX(primaryStage.getWidth() - 150);
        help.setOnAction(event -> {
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setTitle("StratoGame - Help");
            message.setHeaderText("Main Menu Help");
            message.setContentText("Please select which player you desire to be, and/or place against "
                    + "by clicking the red and green buttons."
                    + " There are 3 kinds of players - Human, Easy Bot, and Hard Bot. Once you have "
                    + "selected the players, press 'Start Game'.\n\nTo read how to play StratoGame,"
                    + " click on the 'H' near the top of the window. To open the viewer, click on the 'V'");
            message.showAndWait();
        });

        Button viewBtn = new Button("V");
        viewBtn.setId("round-btn-magenta");
        viewBtn.setTooltip(new Tooltip("Open Viewer"));
        viewBtn.setLayoutX(primaryStage.getWidth() - 100);
        viewBtn.setOnAction(event -> {
            // Only allow one instance of Viewer
            new Viewer(primaryStage);
        });

        root.getChildren().addAll(howToPlay, help, viewBtn);
    }

    private void addMiddle() {
        // Set up labels and add css properties and add to root
        Label title = new Label ("StratoGame");
        title.setId("title-txt");
        title.setLayoutX(65);
        title.setLayoutY(20);

        Label greenLabel = new Label("Player Green");
        greenLabel.setFont(Font.font(22));
        greenLabel.setTextFill(Color.GREEN);
        GridPane.setHalignment(greenLabel, HPos.CENTER);

        Label redLabel = new Label("Player Red");
        redLabel.setFont(Font.font(22));
        redLabel.setTextFill(Color.RED);
        GridPane.setHalignment(redLabel, HPos.CENTER);

        Label info = new Label("By William Shen, Allen Huang and Marvin Yang");
        info.setFont(Font.font(16));
        info.setTextFill(Color.web("#3E50B5"));
        info.setPrefWidth(primaryStage.getWidth());
        info.setAlignment(Pos.CENTER);
        info.setLayoutY(HEIGHT - 80);

        greenBtn.setId("player-btn-green");
        greenBtn.setOnAction(event -> {
            greenPlayer = greenPlayer.getNext();
            greenBtn.setText(greenPlayer.toString());
        });

        redBtn.setId("player-btn-red");
        redBtn.setOnAction(event -> {
            redPlayer = redPlayer.getNext();
            redBtn.setText(redPlayer.toString());
        });

        // Add player labels and controls to GridPane
        GridPane gridpane = new GridPane();
        gridpane.add(greenLabel, 0, 0);
        gridpane.add(redLabel, 1, 0);
        gridpane.add(greenBtn, 0, 1);
        gridpane.add(redBtn, 1, 1);
        gridpane.setHgap(60);
        gridpane.setVgap(10);
        gridpane.setPrefWidth(primaryStage.getWidth());
        gridpane.setTranslateY(110);
        gridpane.setAlignment(Pos.CENTER);

        middleComponents.getChildren().addAll(gridpane, info);
        root.getChildren().addAll(title, middleComponents);
    }

    private void controlButtons() {
        // Create buttons, add CSS and group into HBox
        Button options = new Button("Options");
        options.setId("control-btn");

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
        hb.setLayoutY(HEIGHT - 145);
        hb.getChildren().addAll(startGame, options, exit);

        root.getChildren().add(hb);

        // Open game board and pass player states
        startGame.setOnAction(event -> {
            new Board(primaryStage, greenPlayer, redPlayer, greenDifficulty, redDifficulty);
            System.out.println("Board opened! " + greenPlayer + " vs. " + redPlayer);
        });

        // Close program
        exit.setOnAction(event -> {
            // Make user confirm they want to exit
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Do you really want to exit StratoGame?", ButtonType.NO, ButtonType.YES);
            // Check response and take action accordingly
            Optional<ButtonType> response = confirm.showAndWait();
            if (response.isPresent() && ButtonType.YES.equals(response.get())) Platform.exit();
        });
        // Show help message
        options.setOnAction(event -> {
            hb.setVisible(false);
            middleComponents.setVisible(false);

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(15);
            vBox.setTranslateX(80);
            vBox.setTranslateY(115);

            Label greenLabel = new Label("Hard Bot Difficulty (for Player Green)");
            greenLabel.setFont(Font.font(20));
            greenLabel.setTextFill(Color.GREEN);

            Label redLabel = new Label("Hard Bot Difficulty (for Player Red)");
            redLabel.setFont(Font.font(20));
            redLabel.setTextFill(Color.RED);

            Rectangle white = new Rectangle(1, 1);
            white.setFill(Color.web("#FFFFFF"));

            Slider greenSlider = new Slider(1, 5, greenDifficulty);
            greenSlider.setId("slider");
            greenSlider.setShowTickLabels(true);
            greenSlider.setShowTickMarks(true);
            greenSlider.setSnapToTicks(true);
            greenSlider.setPrefWidth(primaryStage.getWidth() - 160);

            Slider redSlider = new Slider(1, 5, redDifficulty);
            redSlider.setId("slider");
            redSlider.setShowTickLabels(true);
            redSlider.setShowTickMarks(true);
            redSlider.setSnapToTicks(true);
            redSlider.setPrefWidth(primaryStage.getWidth() - 160);

            vBox.getChildren().addAll(greenLabel, greenSlider, white, redLabel, redSlider);
            vBox.requestFocus();

            Label instructions = new Label("1 = Easiest\n5 = Hardest");
            instructions.setTranslateX(-10);
            instructions.setFont(Font.font(16));
            instructions.setTextFill(Color.web("#3E50B5"));

            Button close = new Button("Close");
            close.setId("control-btn");

            Button save = new Button("Save and Exit");
            save.setId("control-btn");

            HBox controls = new HBox();
            controls.setSpacing(20);
            controls.setPrefWidth(primaryStage.getWidth());
            controls.setAlignment(Pos.CENTER);
            controls.getChildren().addAll(instructions, close, save);
            controls.setTranslateY(350);

            root.getChildren().addAll(vBox, controls);

            // Save value
            save.setOnAction(saveEvent -> {
                if (greenDifficulty == greenSlider.getValue() && redDifficulty == redSlider.getValue()) {
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                } else {
                    redDifficulty = redSlider.getValue();
                    greenDifficulty = greenSlider.getValue();
                    Alert success = new Alert(Alert.AlertType.INFORMATION, "Difficulties saved successfully.");
                    success.showAndWait();
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                }
            });

            // Close options menu, check if user has saved first
            close.setOnAction(exitEvent -> {
                if (greenDifficulty == greenSlider.getValue() && redDifficulty == redSlider.getValue()) {
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "You have unsaved changes. Do you" +
                            " want to save the new difficulties?", ButtonType.NO, ButtonType.YES);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.YES) {
                        redDifficulty = redSlider.getValue();
                        greenDifficulty = greenSlider.getValue();
                    }
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                }
            });
        });
    }

    private void imagePanel() {
        // Set up fancy strip of tiles
        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(primaryStage.getWidth());
        gridPane.setHgap(3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setTranslateY(HEIGHT - 25);
        gridPane.setOpacity(0.4);
        // Loop through asset tiles
        for (char i = 'A'; i <= 'T'; i++) {
            ImageView imageView = new ImageView();
            Image tile = new Image(getClass().getResourceAsStream("assets/" + i + ".png"), 22, 22, false, false);
            imageView.setImage(tile);
            gridPane.add(imageView, i - 'A', 0);
        }
        // Add GridPane to root
        root.getChildren().add(gridPane);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("StratoGame initiated.");
        this.primaryStage = primaryStage;
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/R.png")));
        primaryStage.setTitle("StratoGame - Main Menu");
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
        });

        String style = getClass().getResource("assets/theme.css").toExternalForm();
        scene.getStylesheets().add(style);

        addPanels();
        topButtons();
        addMiddle();
        controlButtons();
        imagePanel();

        root.requestFocus();
    }

}
