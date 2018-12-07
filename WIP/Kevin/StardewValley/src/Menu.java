import java.awt.*;
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
import javafx.scene.paint.Color;
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

public class Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button play = new Button();
    Button multiplayer = new Button();
    Button options = new Button();
    Button exit = new Button();
    Button info = new Button();
    double screenWidth = 1280, screenHeight = 768;

    Group mainMenuGroup;
    Scene mainMenuScene;

    Group playGroup;
    Scene playScene;

    Group multiplayerGroup;
    Scene multiplayerScene;

    Group optionsGroup;
    Scene optionsScene;

    Group videoSettingsGroup;
    Scene videoSettingsScene;

    Group soundSettingsGroup;
    Scene soundSettingsScene;

    Group controlsGroup;
    Scene controlsScene;

    Group gameSettingsGroup;
    Scene gameSettingsScene;

    Group keyboardShortcutsGroup;
    Scene keyboardShortcutsScene;

    Group infoGroup;
    Scene infoScene;


    public BufferedImage scale(BufferedImage img, double scale) {
        BufferedImage out = new BufferedImage((int) scale * img.getWidth(), (int) scale * img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) out.getGraphics();
        g.scale(scale, scale);
        g.drawImage(img, 0, 0, null);
        return out;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        mainMenuGroup = new Group();
        mainMenuScene = new Scene(mainMenuGroup, screenWidth, screenHeight);

        BufferedImage img1 = (ImageIO.read(new File("main.png")));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        BufferedImage infoPic = ImageIO.read(new File("question.png"));
        WritableImage infoIcon = SwingFXUtils.toFXImage(infoPic, null);
        BufferedImage exitIcon = ImageIO.read(new File("exit.png"));
        WritableImage exitPic = SwingFXUtils.toFXImage(exitIcon, null);

        // BufferedImage optionsPic = scale(ImageIO.read(new File("options.png")), 3);
        //  WritableImage optionsIcon = SwingFXUtils.toFXImage(optionsPic, null);

        Image playImage = new Image("file:play.png", true);
        ImageView playImageView = new ImageView();
        playImageView.setImage(playImage);

        Image multiplayerImage = new Image("file:multiplayer.png");
        ImageView multiplayerImageView = new ImageView();
        multiplayerImageView.setImage(multiplayerImage);

        Image optionsImage = new Image("file:options.png", true);
        ImageView optionsImageView = new ImageView();
        optionsImageView.setImage(optionsImage);

    /*    Image titleImage = new Image("file:title.png", true);
        ImageView titleIV = new ImageView();
        titleIV.setImage(titleImage);
        titleIV.setFitWidth(200);
        titleIV.setFitHeight(200); */


        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);

        Text title = new Text("Coup d'état");
        title.setFont(new Font("BlackChancery", 200));
        title.setFill(Color.rgb(139, 79, 40));
        title.setTextAlignment(TextAlignment.CENTER);


        info.setPrefSize(50, 50);
        info.setGraphic(new ImageView(infoIcon));
        info.setStyle("-fx-background-color: transparent;"); //makes transparent
        play.setPrefSize(300, 100);
        multiplayer.setPrefSize(300, 100);
        options.setPrefSize(300, 100);
        exit.setPrefSize(100, 50);
        exit.setGraphic(new ImageView(exitPic));
        exit.setStyle("-fx-background-color: transparent;"); //makes transparent

        primaryStage.setTitle("Coup d'état");
        //play.setText("Play");
        play.setTextAlignment(TextAlignment.CENTER);
        play.setGraphic(playImageView);
        //play.setStyle("-fx-background-color: transparent;"); //makes transparent
        // multiplayer.setText("Multiplayer");
        multiplayer.setGraphic(multiplayerImageView);
        //multiplayer.setStyle("-fx-background-color: transparent;"); //makes transparent
        //options.setText("Options");
        options.setGraphic(optionsImageView);
        //options.setStyle("-fx-background-color: transparent;"); //makes transparent


        mainMenuGroup.getChildren().addAll(canvas);
        mainMenuGroup.getChildren().addAll(playImageView, multiplayerImageView, optionsImageView);
        mainMenuGroup.getChildren().addAll(play, multiplayer, options, title, exit, info);

        runPlay(primaryStage);
        runMultiplayer(primaryStage);
        runOptions(primaryStage);

        runVideoSettings(primaryStage);
        runSoundSettings(primaryStage);
        runControls(primaryStage);
        runKeyboardShortcuts(primaryStage);
        runGameSettings(primaryStage);
        runInfo(primaryStage);

        play.setOnAction(actionEvent -> {
            System.out.println("play");
            primaryStage.setScene(playScene);
            primaryStage.show();
        });

        multiplayer.setOnAction(actionEvent -> {
            System.out.println(multiplayer);
            primaryStage.setScene(multiplayerScene);
            primaryStage.show();
        });

        options.setOnAction(actionEvent -> {
            System.out.println("options");
            primaryStage.setScene(optionsScene);
            primaryStage.show();
        });

        info.setOnAction(actionEvent -> {
            System.out.println("info");
            primaryStage.setScene(infoScene);
            primaryStage.show();
        });

        exit.setOnAction(actionEvent -> {
            alertBox.display("Coup d'état", "Thanks for playing!");
            primaryStage.close();
        });
       /* primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(primaryStage);
        }); */


        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

        play.setLayoutX((mainMenuScene.widthProperty().intValue() / 2) - (play.getWidth() / 2));
        play.setLayoutY((mainMenuScene.heightProperty().intValue() / 2) - (play.getHeight() / 2));
        multiplayer.setLayoutX((mainMenuScene.widthProperty().intValue() / 2) - (multiplayer.getWidth() / 2));
        multiplayer.setLayoutY((mainMenuScene.heightProperty().intValue() / 2) - (multiplayer.getHeight() / 2.25) + (play.getHeight()));
        options.setLayoutX((mainMenuScene.widthProperty().intValue() / 2) - (options.getWidth() / 2));
        options.setLayoutY((mainMenuScene.heightProperty().intValue() / 2) - (options.getHeight() / 2.5) + (play.getHeight() * 2)); //change from constant
        exit.setAlignment(Pos.CENTER);
        exit.setLayoutX(mainMenuScene.widthProperty().doubleValue() - exit.getWidth());
        exit.setLayoutY(mainMenuScene.heightProperty().doubleValue() - exit.getHeight() * 1.5);
        info.setLayoutX(0);
        info.setLayoutY(mainMenuScene.heightProperty().doubleValue() - info.getHeight() * 1.5);
        title.setLayoutX((mainMenuScene.widthProperty().intValue() / 2) - (title.getLayoutBounds().getWidth() / 2));
        title.setLayoutY((mainMenuScene.heightProperty().intValue() / 2) - (play.getHeight() / 2) * 4);

        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

    }

    public void runPlay(Stage primaryStage) throws IOException {
        playGroup = new Group();
        playScene = new Scene(playGroup, screenWidth, screenHeight);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.drawImage(image, 0, 0);
        Button back = new Button();
        backButton(back, primaryStage, mainMenuScene);
        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setPrefSize(300, 100);
        playGroup.getChildren().add(canvas);
        playGroup.getChildren().addAll(back, newGame);

        primaryStage.setScene(playScene);
        primaryStage.show();
        newGame.setLayoutX((playScene.widthProperty().intValue() / 2) - (newGame.getWidth() / 2));
        newGame.setLayoutY((playScene.heightProperty().intValue() / 2) - (newGame.getHeight() / 2));

        primaryStage.setScene(playScene);
        primaryStage.show();


    }

    public void runMultiplayer(Stage primaryStage) throws IOException {
        multiplayerGroup = new Group();
        multiplayerScene = new Scene(multiplayerGroup, screenWidth, screenHeight);

        Button back = new Button();
        backButton(back, primaryStage, mainMenuScene);
        multiplayerGroup.getChildren().addAll(back);
        primaryStage.setScene(multiplayerScene);
        primaryStage.show();


    }

    public void runOptions(Stage primaryStage) throws IOException {
        optionsGroup = new Group();
        optionsScene = new Scene(optionsGroup, screenWidth, screenHeight);

        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        BufferedImage backIcon = ImageIO.read(new File("back.png"));
        WritableImage back2 = SwingFXUtils.toFXImage(backIcon, null);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.drawImage(image, 0, 0);


        Button back = new Button();
        backButton(back, primaryStage, mainMenuScene);
        Button videoSettings = new Button();
        Button soundSettings = new Button();
        Button controls = new Button();
        Button gameSettings = new Button();

        videoSettings.setText("Video Settings");
        videoSettings.setPrefSize(300, 100);
        videoSettings.setOnAction(actionEvent -> {
            System.out.println("video settings");
            primaryStage.setScene(videoSettingsScene);
            primaryStage.show();
        });

        soundSettings.setText("Sound Settings");
        soundSettings.setPrefSize(300, 100);
        soundSettings.setOnAction(actionEvent -> {
            System.out.println("sound settings");
            primaryStage.setScene(soundSettingsScene);
            primaryStage.show();

        });

        controls.setText("Controls");
        controls.setPrefSize(300, 100);
        controls.setOnAction(actionEvent -> {
            System.out.println("controls");
            primaryStage.setScene(controlsScene);
            primaryStage.show();
        });

        gameSettings.setText("Game Settings");
        gameSettings.setPrefSize(300, 100);
        gameSettings.setOnAction(actionEvent -> {
            System.out.println("game settings");
            primaryStage.setScene(gameSettingsScene);
            primaryStage.show();
        });

        optionsGroup.getChildren().add(canvas);
        optionsGroup.getChildren().addAll(back, videoSettings, soundSettings, controls, gameSettings);
        primaryStage.setScene(optionsScene);
        primaryStage.show();

        videoSettings.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (videoSettings.getWidth() / 2));
        videoSettings.setLayoutY(optionsScene.heightProperty().intValue() / 2 - ((videoSettings.getHeight() / 2)));
        soundSettings.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (soundSettings.getWidth() / 2));
        soundSettings.setLayoutY(optionsScene.heightProperty().intValue() / 2 + (soundSettings.getHeight() / 2));
        controls.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (controls.getWidth() / 2));
        controls.setLayoutY(optionsScene.heightProperty().intValue() / 2 + ((controls.getHeight() / 2) * 3));
        gameSettings.setLayoutX(optionsScene.widthProperty().intValue() / 2 - (gameSettings.getWidth() / 2));
        gameSettings.setLayoutY(optionsScene.heightProperty().intValue() / 2 + ((gameSettings.getHeight() / 2) * 5));


        primaryStage.setScene(optionsScene);
        primaryStage.show();


    }

    public void runVideoSettings(Stage primaryStage) throws IOException {
        videoSettingsGroup = new Group();
        videoSettingsScene = new Scene(videoSettingsGroup, screenWidth, screenHeight);
        Button back = new Button();
        backButton(back, primaryStage, optionsScene);

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


        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        videoSettingsGroup.getChildren().add(canvas);
        ((Group) videoSettingsScene.getRoot()).getChildren().add(hbox);//very important

        videoSettingsGroup.getChildren().addAll(back, cb, vsync, aa);

        primaryStage.setScene(videoSettingsScene);
        primaryStage.show();


    }

    public void runSoundSettings(Stage primaryStage) throws IOException {
        soundSettingsGroup = new Group();
        soundSettingsScene = new Scene(soundSettingsGroup, screenWidth, screenHeight);
        Button back = new Button();
        //back button
        backButton(back, primaryStage, optionsScene);
        ScrollBar bar = new ScrollBar();
        bar.setMin(0);
        bar.setMax(100);
        bar.setLayoutX(200);
        bar.setLayoutY(200);
        bar.setPrefSize(300, 25);
        bar.setUnitIncrement(5);
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        soundSettingsGroup.getChildren().add(canvas);
        soundSettingsGroup.getChildren().addAll(back, bar);
        primaryStage.setScene(soundSettingsScene);
        primaryStage.show();

    }

    public void runControls(Stage primaryStage) throws IOException {
        controlsGroup = new Group();
        controlsScene = new Scene(controlsGroup, screenWidth, screenHeight);
        Button back = new Button();
        //back button
        backButton(back, primaryStage, optionsScene);

        Button keyboard = new Button("Keyboard Shortcuts");
        keyboard.setPrefSize(300, 100);

        keyboard.setOnAction((event) -> {
            System.out.println("keyboard shortcuts");
            primaryStage.setScene(keyboardShortcutsScene);
            primaryStage.show();
        });
        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);

        controlsGroup.getChildren().add(canvas);
        controlsGroup.getChildren().addAll(back, keyboard);

        primaryStage.setScene(controlsScene);
        primaryStage.show();
        keyboard.setLayoutX((controlsScene.widthProperty().intValue() / 2) - (keyboard.getWidth() / 2));
        keyboard.setLayoutY((controlsScene.heightProperty().intValue() / 2) - (keyboard.getHeight() / 2));

        primaryStage.setScene(controlsScene);
        primaryStage.show();


    }

    public void runKeyboardShortcuts(Stage primaryStage) throws IOException {
        keyboardShortcutsGroup = new Group();
        keyboardShortcutsScene = new Scene(keyboardShortcutsGroup, screenWidth, screenHeight);
        Button back = new Button();
        //back button
        backButton(back, primaryStage, controlsScene);

        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        keyboardShortcutsGroup.getChildren().add(canvas);
        keyboardShortcutsGroup.getChildren().addAll(back);
        primaryStage.setScene(keyboardShortcutsScene);
        primaryStage.show();


    }

    public void runGameSettings(Stage primaryStage) throws IOException {
        gameSettingsGroup = new Group();
        gameSettingsScene = new Scene(gameSettingsGroup, screenWidth, screenHeight);
        Button back = new Button();
        //back button
        backButton(back, primaryStage, optionsScene);
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


        BufferedImage img1 = ImageIO.read(new File("main.png"));
        WritableImage image = SwingFXUtils.toFXImage(img1, null);
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, 0, 0);
        gameSettingsGroup.getChildren().add(canvas);
        gameSettingsGroup.getChildren().addAll(back, difficulty);
        HBox hbox = new HBox();
        hbox.setLayoutX(200);
        hbox.setLayoutY(200);
        hbox.getChildren().addAll(easy, medium, hard);

        ((Group) gameSettingsScene.getRoot()).getChildren().add(hbox);//very important

        primaryStage.setScene(gameSettingsScene);
        primaryStage.show();


    }

    public void runInfo(Stage primaryStage) throws IOException {
        infoGroup = new Group();
        infoScene = new Scene(infoGroup, screenWidth, screenHeight);
        Button back = new Button();
        backButton(back, primaryStage, mainMenuScene);

        Text info = new Text();
        info.setText("CPT made by: Aaron Du, Kevin Ma, David Jiang, Daniel Abdi");
        info.setFont(new Font("Calibri", 20));
        info.setTextAlignment(TextAlignment.CENTER);
        infoGroup.getChildren().addAll(back, info);
        info.setLayoutX(170);
        info.setLayoutY(300);
        primaryStage.setScene(infoScene);
        primaryStage.show();

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

    public void closeProgram(Stage primaryStage) {
        boolean answer = confirmBox.display("Stardew Valley", "Are you sure you want to exit?");
        if (answer) {
            primaryStage.close();
        }
    }


}
