
//fix the scenes from drawing new ones

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javax.imageio.ImageIO;

public class MainMenu extends Application {

    Button play = new Button();
    Button multiplayer = new Button();
    Button options = new Button();
    Button exit = new Button();
    Button info = new Button();

    Group mainMenuGroup;
    Scene mainMenuScene;


   Group optionsGroup;
   Scene optionsScene;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainMenuGroup = new Group();
        mainMenuScene = new Scene(mainMenuGroup, 1024, 760);

        runOptions(primaryStage, optionsScene);
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        BufferedImage infoPic = ImageIO.read(new File("question.png"));
        WritableImage infoIcon = SwingFXUtils.toFXImage(infoPic, null);
        BufferedImage exitIcon = ImageIO.read(new File("exit.png"));
        WritableImage exitPic = SwingFXUtils.toFXImage(exitIcon, null);

        BufferedImage optionsPic = ImageIO.read(new File("options.png"));
        WritableImage optionsIcon = SwingFXUtils.toFXImage(optionsPic, null);

        BufferedImage playPic = ImageIO.read(new File("play.png"));
        WritableImage playIcon = SwingFXUtils.toFXImage(playPic, null);

        BufferedImage multiPic = ImageIO.read(new File("multiplayer.png"));
        WritableImage multiIcon = SwingFXUtils.toFXImage(multiPic, null);



        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);




        Text title = new Text("PlaceHolder");

        title.setFont(new Font("Calibri", 120));

        primaryStage.setTitle("Coup d'état");
       // play.setText("Play");
        play.setGraphic(new ImageView(playIcon));
        play.setStyle("-fx-background-color: transparent;"); //makes transparent
       // multiplayer.setText("Multiplayer");
        multiplayer.setGraphic(new ImageView(multiIcon));
        multiplayer.setStyle("-fx-background-color: transparent;"); //makes transparent
        //options.setText("Options");
        options.setGraphic(new ImageView(optionsIcon));
        options.setStyle("-fx-background-color: transparent;"); //makes transparent
        //exit.setText("Exit");

        info.setPrefSize(50, 50);
        info.setGraphic(new ImageView(infoIcon));
        info.setStyle("-fx-background-color: transparent;"); //makes transparent
        play.setPrefSize(300, 100);
        multiplayer.setPrefSize(300, 100);
        options.setPrefSize(300, 100);
        exit.setPrefSize(100, 50);
        exit.setGraphic(new ImageView(exitPic));
        exit.setStyle("-fx-background-color: transparent;"); //makes transparent

        title.setX(490);
        title.setY(300);
        //title.setLayoutX((scene.widthProperty().intValue() / 3));
        //title.setLayoutY((scene.heightProperty().intValue() / 6));
        mainMenuGroup.getChildren().addAll(canvas);
        mainMenuGroup.getChildren().addAll(play, multiplayer, options, title, exit, info);
        play.setOnAction(event -> {
            try {
                play(primaryStage, mainMenuScene);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        multiplayer.setOnAction(event -> System.out.println("multiplayer"));
        options.setOnAction(event -> {
            System.out.println("options");
                primaryStage.setScene(optionsScene);
                primaryStage.show();

        });
        /*primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(primaryStage);
        }); */
        exit.setOnAction(event -> {
            alertBox.display("Stardew Valley", "Thanks for Playing!");
            primaryStage.close();
        });
        info.setOnAction(event -> {
            System.out.println("info");
            try {
                runInfo(primaryStage, mainMenuScene);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

        play.setLayoutX((mainMenuScene.widthProperty().intValue() / 2) - (play.getWidth() / 2));
        play.setLayoutY((mainMenuScene.heightProperty().intValue() / 2) - (play.getHeight() / 2));
        multiplayer.setLayoutX((mainMenuScene.widthProperty().intValue() / 2) - (multiplayer.getWidth() / 2));
        multiplayer.setLayoutY((mainMenuScene.heightProperty().intValue() / 2) - (multiplayer.getHeight() / 2) + (play.getHeight()));
        options.setLayoutX((mainMenuScene.widthProperty().intValue() / 2) - (options.getWidth() / 2));
        options.setLayoutY((mainMenuScene.heightProperty().intValue() / 2) - (options.getHeight() / 2) + (play.getHeight() * 2)); //change from constant
        exit.setAlignment(Pos.CENTER);
        exit.setLayoutX(1800);
        exit.setLayoutY(920);
        info.setLayoutX(0);
        info.setLayoutY(920);
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

    }

    public void runOptions(Stage primaryStage, Scene scene) throws IOException {
        //Buttons
        Button autoRun = new Button();
        Button back = new Button();
        Button videoSettings = new Button();
        Button soundSettings = new Button();
        Button controls = new Button();
        Button gameSettings = new Button();



        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        BufferedImage backIcon = ImageIO.read(new File("back.png"));
        WritableImage back2 = SwingFXUtils.toFXImage(backIcon, null);
        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);

        //autorun button
        autoRun.setText("Autorun");
        autoRun.setPrefSize(300, 100);
        autoRun.setOnAction((event) -> {

        });
        //back button
        backButton(back, primaryStage, scene);
        //video settings
        videoSettings.setText("Video Settings");
        videoSettings.setPrefSize(300, 100);
        videoSettings.setOnAction((event) -> {
            try {
                videoSettings(primaryStage, optionsScene);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        //sound settings
        soundSettings.setText("Sound Settings");
        soundSettings.setPrefSize(300, 100);
        soundSettings.setOnAction((event) -> {
            try {
                soundSettings(primaryStage, optionsScene);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        //controls
        controls.setText("Controls");
        controls.setPrefSize(300, 100);
        controls.setOnAction((event) -> {
            try {
                controls(primaryStage, optionsScene);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //game settings
        gameSettings.setText("Game Settings");
        gameSettings.setPrefSize(300, 100);
        gameSettings.setOnAction((event) -> {
            try {
                gameSettings(primaryStage, optionsScene);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        mainMenuGroup.getChildren().add(canvas);
        mainMenuGroup.getChildren().addAll(back, videoSettings, soundSettings, controls, gameSettings);

        // autoRun.setLayoutX(test.widthProperty().intValue() / 2 - (autoRun.getWidth() / 2));
        // autoRun.setLayoutY(test.heightProperty().intValue() / 2 - (autoRun.getHeight() / 2));

        //button layout

        videoSettings.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (videoSettings.getWidth() / 2));
        videoSettings.setLayoutY(optionsScene.heightProperty().intValue() / 2 - ((videoSettings.getHeight()/2)));
        soundSettings.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (soundSettings.getWidth() / 2));
        soundSettings.setLayoutY(optionsScene.heightProperty().intValue() / 2 + (soundSettings.getHeight() / 2));
        controls.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (controls.getWidth() / 2));
        controls.setLayoutY(optionsScene.heightProperty().intValue() / 2 + ((controls.getHeight() / 2)*3));
        gameSettings.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (gameSettings.getWidth() / 2));
        gameSettings.setLayoutY(optionsScene.heightProperty().intValue() / 2 + ((gameSettings.getHeight() / 2)*5) );

        primaryStage.setScene(optionsScene);
        primaryStage.show();
    }

    public void runInfo(Stage primaryStage, Scene scene) throws IOException {
        Group test2 = new Group();
        Scene test = new Scene(test2, 1920, 1080);
        Button back = new Button();
        backButton(back, primaryStage, scene);

        Text info = new Text();
        info.setText("CPT made by: Aaron Du, Kevin Ma, David Jiang, Daniel Abdi");
        info.setFont(new Font("Calibri", 20));
        info.setTextAlignment(TextAlignment.CENTER);
        test2.getChildren().addAll(back, info);
        info.setLayoutX(170);
        info.setLayoutY(300);
        primaryStage.setScene(test);
        primaryStage.show();
    }

    public void play(Stage primaryStage, Scene scene) throws IOException {
        Group group = new Group();
        Scene scene2 = new Scene(group, 1920, 1080);
        Button back = new Button();
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        backButton(back, primaryStage, scene);
        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setPrefSize(300, 100);
        group.getChildren().add(canvas);
        group.getChildren().addAll(back, newGame);

        primaryStage.setScene(scene2);
        primaryStage.show();
        newGame.setLayoutX((scene2.widthProperty().intValue() / 2) - (newGame.getWidth() / 2));
        newGame.setLayoutY((scene2.heightProperty().intValue() / 2) - (newGame.getHeight() / 2));
        //newGame.setLayoutX(700);
       // newGame.setLayoutY(400);
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    public void videoSettings(Stage primaryStage, Scene scene) throws IOException {
        Button back = new Button();
        //back button
        backButton(back, primaryStage, scene);

//fullscreen or windowed
        final ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton fullscreen = new ToggleButton("Fullscreen");
        ToggleButton windowed = new ToggleButton("Windowed");
        fullscreen.setToggleGroup(toggleGroup);
        windowed.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> { //never allows there to be an unselected toggle
            if (newVal == null) {
                oldVal.setSelected(true);
            }
        });
        fullscreen.setOnAction((event) -> {
            primaryStage.setMaximized(true);
        });
        windowed.setOnAction((event) -> {
            primaryStage.setMaximized(false);
        });
        HBox hbox = new HBox();
        hbox.setLayoutX(200);
        hbox.setLayoutY(300);
        hbox.getChildren().addAll(fullscreen, windowed);
        //resolution
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
                "640 x 480", "800 x 600", "1024 x 768", "1280 x 960", "1440 x 900", "1920 x 1080")
        );
        cb.setLayoutX(200);
        cb.setLayoutY(200);
        //vsync
        ToggleButton vsync = new ToggleButton("Vsync");
        vsync.setLayoutX(200);
        vsync.setLayoutY(400);
        //anti-aliasing
        ChoiceBox aa = new ChoiceBox(FXCollections.observableArrayList(
                "Off", "Low - FXAA", "Medium - SMAA Low", "High - SMAA Medium", "Ultra - SMAA High")
        );
        aa.setLayoutX(200);
        aa.setLayoutY(500);

        Group newGroup = new Group();
        Scene newScene = new Scene(newGroup, 1920, 1080);

        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        newGroup.getChildren().add(canvas);
        ((Group) newScene.getRoot()).getChildren().add(hbox);//very important
        newGroup.getChildren().addAll(back, cb, vsync, aa);

        primaryStage.setScene(newScene);
        primaryStage.show();

    }

    public void soundSettings(Stage primaryStage, Scene scene) throws IOException {
        Button back = new Button();
        //back button
        backButton(back, primaryStage, scene);
        ScrollBar bar = new ScrollBar();
        bar.setMin(0);
        bar.setMax(100);
        bar.setLayoutX(200);
        bar.setLayoutY(200);
        bar.setPrefSize(300, 25);

        bar.setUnitIncrement(5);

        Group newGroup = new Group();
        Scene newScene = new Scene(newGroup, 1920, 1080);
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        newGroup.getChildren().add(canvas);
        newGroup.getChildren().addAll(back, bar);
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    public void controls(Stage primaryStage, Scene scene) throws IOException {
        Button back = new Button();
        //back button
        backButton(back, primaryStage, scene);

        Group newGroup = new Group();
        Scene newScene = new Scene(newGroup, 1920, 1080);
        //Keyboard shortcuts
        Button keyboard = new Button("Keyboard Shortcuts");
        keyboard.setPrefSize(300, 100);
        //keyboard.setLayoutX(688);
        //keyboard.setLayoutY(300);
        keyboard.setOnAction((event) -> {
            try {
                keyBoardShortcuts(primaryStage, newScene);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        newGroup.getChildren().add(canvas);
        newGroup.getChildren().addAll(back, keyboard);

        primaryStage.setScene(newScene);
        primaryStage.show();
        keyboard.setLayoutX((newScene.widthProperty().intValue() / 2) - (keyboard.getWidth() / 2));
        keyboard.setLayoutY((newScene.heightProperty().intValue() / 2) - (keyboard.getHeight() / 2));

        primaryStage.setScene(newScene);
        primaryStage.show();

    }

    public void gameSettings(Stage primaryStage, Scene scene) throws IOException {
        Button back = new Button();
        //back button
        backButton(back, primaryStage, scene);
        //Difficulty label
        Text difficulty = new Text("Difficulty");
        difficulty.setFont(new Font("Calibri", 20));
        difficulty.setLayoutX(200);
        difficulty.setLayoutY(180);
        //toggle difficulty
        final ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton easy = new ToggleButton("Easy");
        ToggleButton medium = new ToggleButton("Medium");
        ToggleButton hard = new ToggleButton("Hard");
        easy.setToggleGroup(toggleGroup);
        medium.setToggleGroup(toggleGroup);
        hard.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> { //never allows there to be an unselected toggle
            if (newVal == null) {

                oldVal.setSelected(true);
            }
            System.out.println(newVal);
        });
        easy.setOnAction((event) -> {
            System.out.println("Pussy mode enabled");
        });
        medium.setOnAction((event) -> {
            System.out.println("...");
        });
        hard.setOnAction((event) -> {
            System.out.println("big dik energy");
        });

        Group newGroup = new Group();
        Scene newScene = new Scene(newGroup, 1920, 1080);
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        newGroup.getChildren().add(canvas);
        newGroup.getChildren().addAll(back, difficulty);
        HBox hbox = new HBox();
        hbox.setLayoutX(200);
        hbox.setLayoutY(200);
        hbox.getChildren().addAll(easy, medium, hard);

        ((Group) newScene.getRoot()).getChildren().add(hbox);//very important

        primaryStage.setScene(newScene);
        primaryStage.show();

    }

    public void keyBoardShortcuts(Stage primaryStage, Scene scene) throws IOException {
        Button back = new Button();
        //back button
        backButton(back, primaryStage, scene);
        Group group = new Group();
        Scene newScene = new Scene(group, 1920, 1080);
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(1920, 1080);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        group.getChildren().add(canvas);
        group.getChildren().addAll(back);
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    public void closeProgram(Stage primaryStage) {
        boolean answer = confirmBox.display("Stardew Valley", "Are you sure you want to exit?");
        if (answer) {
            primaryStage.close();
        }
    }

    public void backButton(Button back, Stage primaryStage, Scene scene) throws IOException {
        BufferedImage backIcon = ImageIO.read(new File("back.png"));
        WritableImage back2 = SwingFXUtils.toFXImage(backIcon, null);
        //back.setText("Back");

        back.setPrefSize(100, 50);
        back.setGraphic(new ImageView(back2));
        back.setStyle("-fx-background-color: transparent;"); //makes transparent
        back.setOnAction(event -> {
            System.out.println("back");
            primaryStage.setScene(scene);
        });
    }

}
