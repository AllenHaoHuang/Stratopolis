package comp1110.ass2.gui;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static java.awt.SystemColor.TEXT;
import static java.awt.SystemColor.info;
import static java.awt.SystemColor.text;

public class Instructions extends Stage {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private Stage primaryStage = new Stage();
    private Group root = new Group();


    /**
     * SUBFUNCTIONS. FIXME: Needs:
     * - Top panel, see topPanel in addPanels() in Menu
     * - and other panels to make it look better
     * - Title for top panel, see title in addMiddle() in Menu
     * - Huge chunk of text for instructions that is formatted properly
     */

    //edit the panel structure;
    private void addPanels() {
        Rectangle mainPanel = new Rectangle(primaryStage.getWidth(), primaryStage.getHeight());
        mainPanel.setFill(Color.web("#E9E9ED"));

        Rectangle leftPanel = new Rectangle(130, primaryStage.getHeight());
        leftPanel.setFill(Color.BLUEVIOLET);

        Rectangle rightTopPanel = new Rectangle(130, 0,primaryStage.getWidth()-130,90);
        rightTopPanel.setFill(Color.web("#3E50B5"));

        root.getChildren().addAll(mainPanel, leftPanel, rightTopPanel);
    }

    private void addcontains() {
        Label title = new Label("Instruction");
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
        topicformainbody.setFont(Font.font(15));
        topicformainbody.setTextFill(Color.WHITE);
        topicformainbody.setLayoutX(140);
        topicformainbody.setLayoutY(100);

        Text t = new Text("Player can choose either Green or Red. For each color, ");
        t.setFont(Font.font(13));
        t.setLayoutX(140);
        t.setLayoutY(135);

        Text t1 = new Text("there are 20 tiles. By using the mouse, you can drag the");
        t1.setFont(Font.font(13));
        t1.setLayoutX(140);
        t1.setLayoutY(160);

        Text t2 = new Text("piece to the place you want.");
        t2.setFont(Font.font(13));
        t2.setLayoutX(140);
        t2.setLayoutY(185);

        Text t3 = new Text("As for the placement, you have two options. The first one, ");
        t3.setFont(Font.font(13));
        t3.setLayoutX(140);
        t3.setLayoutY(210);

        Text t4 = new Text("your placement have to attach with other tile on grid(no ");
        t4.setFont(Font.font(13));
        t4.setLayoutX(140);
        t4.setLayoutY(235);

        Text t5 = new Text("matter green black or red). The second one, you can place ");
        t5.setFont(Font.font(13));
        t5.setLayoutX(140);
        t5.setLayoutY(260);

        Text t6 = new Text("tile at top of existing placements, but make sure the tile ");
        t6.setFont(Font.font(13));
        t6.setLayoutX(140);
        t6.setLayoutY(285);

        Text t7 = new Text("placed have the exactly same color with tiles on the grid");
        t7.setFont(Font.font(13));
        t7.setLayoutX(140);
        t7.setLayoutY(310);

        Text t8 = new Text("and the under tiles must have same height on each square.");
        t8.setFont(Font.font(13));
        t8.setLayoutX(140);
        t8.setLayoutY(335);

        Text t9 = new Text("Your score is calculated by finding the largest region of ");
        t9.setFont(Font.font(13));
        t9.setLayoutX(140);
        t9.setLayoutY(360);

        Text t10 = new Text("contiguous squares of your color,and then multiplying the  ");
        t10.setFont(Font.font(13));
        t10.setLayoutX(140);
        t10.setLayoutY(385);

        Text t11 = new Text("number of squares forming the region by the maximum  ");
        t11.setFont(Font.font(13));
        t11.setLayoutX(140);
        t11.setLayoutY(405);

        Text t12 = new Text("height of tiles in the region.");
        t12.setFont(Font.font(13));
        t12.setLayoutX(140);
        t12.setLayoutY(430);







        GridPane gridPane = new GridPane();
        gridPane.add(title,0,0);
        gridPane.add(topicLeft,1,0);
        gridPane.setHgap(60);
        gridPane.setVgap(10);
        gridPane.setPrefWidth(primaryStage.getWidth());
        gridPane.setTranslateY(110);
        gridPane.setAlignment(Pos.CENTER);

       root.getChildren().addAll(title,topicLeft,t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,topicformainbody,gridPane);
    }

    //

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

        addPanels();
        addcontains();

        System.out.println("width:" + primaryStage.getWidth() + ", height: " + primaryStage.getHeight());
    }




}


