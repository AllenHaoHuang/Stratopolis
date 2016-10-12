package comp1110.ass2.gui;

import comp1110.ass2.logic.Player;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.util.Optional;

/**
 * `Menu` is the main window from which everything is launched from.
 * The UI is easy to use, with colours and layouts based on material
 * design
 *
 * @author William Shen - u6096655
 *
 * The implementation for music was based off COMP1110 Assignment 1 by Steve Blackburn
 */
public class Menu extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 455;

    // JavaFX Variables
    private Stage primaryStage;
    private Group root = new Group();
    private Group middleComponents = new Group();

    private Button greenBtn = new Button("Human");
    private Button redBtn = new Button ("Human");

    private Player greenPlayer = Player.Human;
    private Player redPlayer = Player.Human;

    // Default option values
    private double redDifficulty = 2;
    private double greenDifficulty = 2;
    private int hintCount = 0;
    private boolean musicOn = false;

    // Specify location of music file
    private static final String URI_BASE = "assets/";
    private static final String LOOP_URI = Menu.class.getResource(URI_BASE + "drums.wav").toString();
    private AudioClip loop;

    // Add main panels to create skeleton
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

    // Add top control buttons for Instructions, Help, and Viewer
    private void addTop() {
        // Main title label near the top
        Label title = new Label ("StratoGame");
        title.setId("title-txt");
        title.setLayoutX(65);
        title.setLayoutY(20);

        Button howToPlay = new Button("H");
        howToPlay.setId("round-btn-blue");
        howToPlay.setTooltip(new Tooltip("How to Play StratoGame"));
        howToPlay.setLayoutX(primaryStage.getWidth() - 200);
        howToPlay.setOnAction(event -> {
            // Only allow one instance, block out Menu controls
            root.setDisable(true);
            new Instructions(primaryStage);
            root.setDisable(false);
        });

        Button help = new Button("?");
        help.setId("round-btn-teal");
        help.setTooltip(new Tooltip("Help"));
        help.setLayoutX(primaryStage.getWidth() - 150);
        help.setOnAction(event -> {
            // Show help message for 'Menu'
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setTitle("StratoGame - Help");
            message.setHeaderText("Main Menu Help");
            message.setContentText("Please select which player you desire to be, and/or place against "
                    + "by clicking the red and green buttons."
                    + " There are 3 kinds of players - Human, Easy Bot, and Hard Bot. Once you have "
                    + "selected the players, press 'Start Game'.\n\nTo read how to play StratoGame,"
                    + " click on the 'H' near the top of the window. To open the viewer, click on the 'V'");
            message.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            message.showAndWait();
        });

        Button viewBtn = new Button("V");
        viewBtn.setId("round-btn-magenta");
        viewBtn.setTooltip(new Tooltip("Open Viewer"));
        viewBtn.setLayoutX(primaryStage.getWidth() - 100);
        viewBtn.setOnAction(event -> {
            // Only allow one instance of Viewer, grey out Menu controls
            root.setDisable(true);
            new Viewer(primaryStage);
            root.setDisable(false);
        });

        root.getChildren().addAll(title, howToPlay, help, viewBtn);
    }

    // Add main control panel - i.e. white central block
    private void addMiddle() {
        // Labels to identify players
        Label greenLabel = new Label("Player Green");
        greenLabel.setFont(Font.font("Open Sans", 20));
        greenLabel.setTextFill(Color.GREEN);
        GridPane.setHalignment(greenLabel, HPos.CENTER);

        Label redLabel = new Label("Player Red");
        redLabel.setFont(Font.font("Open Sans", 20));
        redLabel.setTextFill(Color.RED);
        GridPane.setHalignment(redLabel, HPos.CENTER);

        Label info = new Label("By William Shen, Allen Huang and Marvin Yang");
        info.setFont(Font.font("Open Sans", 16));
        info.setTextFill(Color.web("#3E50B5"));
        info.setPrefWidth(primaryStage.getWidth());
        info.setAlignment(Pos.CENTER);
        info.setLayoutY(HEIGHT - 80);

        // Buttons to allow players to select who to play against, changes text based on player state
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

        // Add player labels and controls to GridPane for layout
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
        root.getChildren().add(middleComponents);
    }

    // Creates the 'Start Game', 'Options' and 'Exit' buttons
    private void controlButtons() {
        // Create control buttons, add CSS and group into HBox
        Button startGame = new Button("Start Game");
        startGame.setId("control-btn");
        startGame.setOnAction(event -> {
            // Open game board and pass player states
            root.setDisable(true);
            System.out.println("Board opened! " + greenPlayer + " vs. " + redPlayer);
            new Board(primaryStage, greenPlayer, redPlayer, greenDifficulty, redDifficulty, hintCount);
            root.setDisable(false);
        });

        Button options = new Button("Options");
        options.setId("control-btn");

        Button exit = new Button("Exit");
        exit.setId("control-btn");
        exit.setPrefWidth(80);
        exit.setOnAction(event -> {
            // Make user confirm they want to exit
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                    "Do you really want to exit StratoGame?", ButtonType.NO, ButtonType.YES);
            // Check response and take action accordingly
            Optional<ButtonType> response = confirm.showAndWait();
            if (response.isPresent() && ButtonType.YES.equals(response.get())) System.exit(0);
        });

        // Create new HBox to center and align buttons
        HBox hb = new HBox();
        hb.setPrefWidth(primaryStage.getWidth() - 130);
        hb.setSpacing(25);
        hb.setAlignment(Pos.CENTER);
        hb.setLayoutX(65);
        hb.setLayoutY(HEIGHT - 145);
        hb.getChildren().addAll(startGame, options, exit);
        root.getChildren().add(hb);

        // Handle options button click
        options.setOnAction(event -> {
            // Hide the current middle components and controls
            hb.setVisible(false);
            middleComponents.setVisible(false);

            // Create and set labels and sliders
            Label greenLabel = new Label("Hard Bot Difficulty (for Player Green)");
            greenLabel.setFont(Font.font("Open Sans", 18));
            greenLabel.setTextFill(Color.GREEN);

            Label redLabel = new Label("Hard Bot Difficulty (for Player Red)");
            redLabel.setFont(Font.font("Open Sans", 18));
            redLabel.setTextFill(Color.RED);

            // Set default difficulties to class variable. The difficulty represent hard bot depth
            Slider greenSlider = new Slider(1, 3, greenDifficulty);
            greenSlider.setId("slider");
            greenSlider.setShowTickLabels(true);
            greenSlider.setShowTickMarks(true);
            greenSlider.setSnapToTicks(true);
            greenSlider.setPrefWidth(primaryStage.getWidth() - 160);

            Slider redSlider = new Slider(1, 3, redDifficulty);
            redSlider.setId("slider");
            redSlider.setShowTickLabels(true);
            redSlider.setShowTickMarks(true);
            redSlider.setSnapToTicks(true);
            redSlider.setPrefWidth(primaryStage.getWidth() - 160);

            // For selecting number of hints using a ComboBox
            Label hintLabel = new Label("Number of Hints: ");
            hintLabel.setFont(Font.font("Open Sans", 18));
            ComboBox hintCombo = new ComboBox();
            hintCombo.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
            hintCombo.setValue(hintCount);

            // CheckBox to turn music on and off
            Label musicLabel = new Label("   Music: ");
            musicLabel.setFont(Font.font("Open Sans", 18));
            CheckBox musicCheck = new CheckBox();
            musicCheck.setSelected(musicOn);

            // Add all to HBox for alignment
            HBox prev = new HBox();
            prev.setAlignment(Pos.CENTER);
            prev.setSpacing(10);
            prev.getChildren().addAll(hintLabel, hintCombo, musicLabel, musicCheck);

            // Set bottom controls and label and add to HBox
            Label instructions = new Label("1 = Easiest\n3 = Hardest");
            instructions.setTranslateX(-10);
            instructions.setFont(Font.font("Open Sans", 16));
            instructions.setTextFill(Color.web("#3E50B5"));

            // Exit controls, add to HBox for alignment
            Button close = new Button("Close");
            close.setId("control-btn");

            Button save = new Button("Save and Exit");
            save.setId("control-btn");

            HBox controls = new HBox();
            controls.setSpacing(20);
            controls.setAlignment(Pos.CENTER);
            controls.getChildren().addAll(instructions, close, save);

            // Create new VBox to store all the options
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(18);
            vBox.setTranslateX(80);
            vBox.setTranslateY(95);
            vBox.getChildren().addAll(greenLabel, greenSlider, redLabel, redSlider, prev, controls);

            root.getChildren().addAll(vBox);
            root.requestFocus();

            // Save and exit button clicked, we save the value
            save.setOnAction(saveEvent -> {
                // If no values have changed we simply close the options
                if (greenDifficulty == greenSlider.getValue() && redDifficulty == redSlider.getValue()
                        && hintCount == (int) hintCombo.getValue() && musicOn == musicCheck.isSelected()) {
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                } else {
                    // Update the values and show success message
                    redDifficulty = redSlider.getValue();
                    greenDifficulty = greenSlider.getValue();
                    hintCount = (int) hintCombo.getValue();
                    if (musicOn != musicCheck.isSelected()) {
                        musicOn = !musicCheck.isSelected();
                        toggleSoundLoop();
                    }
                    Alert success = new Alert(Alert.AlertType.INFORMATION, "Difficulties saved successfully.");
                    success.showAndWait();
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                }
            });

            // Close options menu, check if user has saved first and ask accordingly
            close.setOnAction(exitEvent -> {
                // If no values have been changed we simply close the options
                if (greenDifficulty == greenSlider.getValue() && redDifficulty == redSlider.getValue()
                        && hintCount == (int) hintCombo.getValue()) {
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                } else {
                    // Warn user they do not have saved values, and save and close accordingly
                    Alert alert = new Alert(Alert.AlertType.WARNING, "You have unsaved changes. Do you" +
                            " want to save the new difficulties?", ButtonType.NO, ButtonType.YES);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.YES) {
                        redDifficulty = redSlider.getValue();
                        greenDifficulty = greenSlider.getValue();
                        hintCount = (int) hintCombo.getValue();
                        if (musicOn != musicCheck.isSelected()) {
                            musicOn = !musicCheck.isSelected();
                            toggleSoundLoop();
                        }                    }
                    root.getChildren().removeAll(vBox, controls);
                    hb.setVisible(true);
                    middleComponents.setVisible(true);
                }
            });
        });
    }

    private void imagePanel() {
        // Set up fancy strip of tiles at bottom
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

    // Set up the sound loop (plays when checkbox is checked and saved)
    private void setUpSoundLoop() {
        try {
            loop = new AudioClip(LOOP_URI);
            loop.setCycleCount(AudioClip.INDEFINITE);
        } catch (Exception e) {
            System.err.println(":-( something bad happened ("+LOOP_URI+"): "+e);
        }
    }

    // Turn the sound loop on or off
    private void toggleSoundLoop() {
        if (musicOn)
            loop.stop();
        else
            loop.play();
        musicOn = !musicOn;
    }

    @Override
    public void start(Stage primaryStage) {
        // Set properties for stage
        this.primaryStage = primaryStage;
        System.out.println("StratoGame initiated.");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/R.png")));
        primaryStage.setTitle("StratoGame - Main Menu");
        primaryStage.setResizable(false);

        // Initialise scene and add to stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Add CSS stylesheet
        String style = getClass().getResource("assets/theme.css").toExternalForm();
        scene.getStylesheets().add(style);

        // Add Open Sans Font
        Font.loadFont(getClass().getResourceAsStream("assets/OpenSans-Regular.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("assets/OpenSans-Bold.ttf"), 16);

        // Ensure game closes properly
        primaryStage.setOnCloseRequest(event -> {
            System.exit(0);
        });

        // Add components to root
        addPanels();
        addTop();
        addMiddle();
        controlButtons();
        imagePanel();
        setUpSoundLoop();

        // Set focus on none of the controls
        root.requestFocus();
    }

}