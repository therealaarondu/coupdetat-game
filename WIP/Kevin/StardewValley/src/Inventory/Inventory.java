package Inventory;

//still need to find out how to alight the stats properly



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.HashMap;

public class Inventory extends Application {

    double screenWidth = 1280, screenHeight = 720, menuWidth = screenWidth / 2;
    double menuHeight = screenHeight / 2, menuX = screenWidth / 4, menuY = screenHeight / 4;
    HashMap<Rectangle, Integer> boxID;
    HashMap<ImageView, Integer> imID;
    boolean dragging = false;
    int dragSlot = -1;
    Item[] inventory = new Item[30];
    static double inf = Double.POSITIVE_INFINITY;
    ImageView dragSprite;
    Rectangle[] smallBoxes = new Rectangle[30];
    ImageView[] sprites = new ImageView[30];
    Rectangle[] statsBoxes = new Rectangle[30];
    //images
    Image gods = new Image("file:godslayer.png", true);
    Image standard1 = new Image("file:standard.png", true);
    Image stormweaver = new Image("file:stormweaver.png", true);
    Image longsword = new Image("file:longsword.png", true);
    Image shadowstrike = new Image("file:shadowstrike.png", true);
    Image silversaber = new Image("file:silversaber.png", true);
    Image nightbane = new Image("file:nightbane.png", true);
    Image hellscream = new Image("file:hellscream.png", true);
    Image unholymight = new Image("file:unholymight.png", true);


    //bows
    Image tranquility1 = new Image("file:tranquility.png", true);
    Image basicbow = new Image("file:basic.png", true);


    Image empty = new Image("file:empty.png", true);
    Image hover = new Image("file:hover.png", true);
    Image inv = new Image("file:inv.png", true);
    Image invTop = new Image("file:inv top.png", true);
    Image hotbar = new Image("file:hotbar.png", true);

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();
        Scene scene = new Scene(group, screenWidth, screenHeight);

        dragSprite = new ImageView();
        boxID = new HashMap<>();
        imID = new HashMap<>();

        Text[] names = new Text[30];
        Text[] damages = new Text[30];
        Text[] qualities = new Text[30];
        Text[] durabilities = new Text[30];
        Text[] drawspeeds = new Text[30];
        Text[] allStats = new Text[30];


        Button sortType = new Button();
        Button sortAlpha = new Button();


        dragSprite.setVisible(false);
        dragSprite.setFitWidth(50);
        dragSprite.setFitHeight(50);
        dragSprite.setOpacity(0.7);

        Image trash = new Image("file:newtrash.png", true);
        ImageView trashImage = new ImageView();
        trashImage.setImage(trash);
        trashImage.setFitWidth(75);
        trashImage.setFitHeight(75);
        trashImage.setLayoutX(screenWidth / 2 + menuX * 1.23);
        trashImage.setLayoutY(screenHeight / 2 + menuY / 1.5);


        Image alpha = new Image("file:otheralpha.png", true);
        ImageView alphaIV = new ImageView();
        alphaIV.setImage(alpha);

        Image type = new Image("file:type.png", true);
        ImageView typeIV = new ImageView();
        typeIV.setImage(type);

        trashImage.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                if (dragging) {
                    inventory[dragSlot] = null;
                    refreshInv();
                    dragSlot = -1;
                    dragging = false;
                    dragSprite.setImage(null);
                }
            }
        });


        ImageView bg = new ImageView();
        ImageView iTop = new ImageView();

        sortType.setPrefSize(60, 60);
        sortType.setLayoutX(screenWidth / 2 + menuX * 1.25);
        sortType.setLayoutY(screenHeight / 2 - menuY / 2);
        sortType.setGraphic(typeIV);

        sortAlpha.setPrefSize(60, 60);
        sortAlpha.setLayoutX(screenWidth / 2 + menuX * 1.25);
        sortAlpha.setLayoutY(screenHeight / 2 - menuY / 8);
        sortAlpha.setGraphic(alphaIV);
        iTop.setImage(invTop);
        iTop.setFitWidth(screenWidth / 4);
        iTop.setFitHeight(screenHeight / 6);

        iTop.setLayoutX((screenWidth) - (menuX * 2.5));
        iTop.setLayoutY((screenHeight / 2) - (menuY * 1.86));

        bg.setImage(inv);
        bg.setFitWidth(menuWidth + (menuWidth / 8));
        bg.setFitHeight(menuHeight + menuHeight / 5);
        bg.setLayoutX(menuX - (menuWidth / 15.5));
        bg.setLayoutY(menuY - (menuHeight / 10));
        group.getChildren().addAll(bg, iTop, sortType, sortAlpha, trashImage, alphaIV);

        Sword standard = new Sword(standard1, "Standard Sword", 100, 3, 10);
        Sword stormWeaver = new Sword(stormweaver, "Storm Weaver", 200, inf, 20);
        Sword godSlayer = new Sword(gods, "God-Slayer", 1000, inf, 50);
        Sword longSword = new Sword(longsword, "Long Sword", 100, 500, 10);
        Sword shadowStrike = new Sword(shadowstrike, "Shadow Strike", 500, 2000, 25);
        Sword silverSaber = new Sword(silversaber, "Silver Saber", 250, 5000, 30);
        Sword nightBane = new Sword(nightbane, "Nightbane", 500, inf, 50);
        Sword hellScream = new Sword(hellscream, "Hellscream", 300, 5000, 30);
        Sword unholyMight = new Sword(unholymight, "Unholy-Might", 400, inf, 40);


        Bow tranquility = new Bow(tranquility1, "Tranquility", 200, 2, 40);
        Bow basic = new Bow(basicbow, "Basic Bow", 20, 3, 1);

        inventory[3] = standard;
        inventory[7] = stormWeaver;
        inventory[10] = godSlayer;
        inventory[28] = tranquility;
        inventory[1] = longSword;
        inventory[5] = shadowStrike;
        inventory[2] = silverSaber;
        inventory[4] = nightBane;
        inventory[12] = hellScream;
        inventory[13] = unholyMight;
        inventory[17] = basic;


        for (int i = 0; i < 30; i++) {

            ImageView im = new ImageView();
            if (inventory[i] != null && inventory[i].getSprite() != null) {
                im.setImage(inventory[i].getSprite());
            } else {
                im.setImage(empty);
            }
            im.setFitWidth(menuWidth / 6);
            im.setFitHeight(menuHeight / 5);
            im.setOpacity(0.8);
            im.setLayoutX(menuX + (menuWidth / 6) * (i % 6));
            im.setLayoutY(menuY + (menuHeight / 5) * ((i - (i % 6)) % 5));

            Rectangle box = new Rectangle();
            Rectangle stats = new Rectangle();
            stats.setVisible(false);
            stats.setFill(Color.rgb(240, 240, 240));
            stats.setStroke(Color.rgb(40, 40, 40));
            stats.setWidth(menuWidth / 2);
            stats.setHeight(menuHeight / 4);
            stats.setLayoutX(menuX * 1.5);
            stats.setLayoutY(menuY * 3.25);
            boxID.put(box, i);
            imID.put(im, i);
            box.setFill(Color.rgb(240, 240, 240));
            box.setStroke(Color.rgb(40, 40, 40));
            box.setHeight(menuHeight / 5);
            box.setWidth(menuWidth / 6);
            box.setLayoutX(menuX + (menuWidth / 6) * (i % 6));
            box.setLayoutY(menuY + (menuHeight / 5) * ((i - (i % 6)) % 5));

            Text name = new Text();
            name.setLayoutX(menuX * 1.92);
            name.setLayoutY(menuY * 3.32);
            name.setVisible(false);

            Text damage = new Text();
            damage.setLayoutX(menuX * 1.55);
            damage.setLayoutY(menuY * 3.5);
            damage.setVisible(false);

            Text quality = new Text();
            quality.setLayoutX(damage.getLayoutBounds().getWidth() + menuX * 1.8);
            quality.setLayoutY(menuY * 3.5);
            quality.setVisible(false);

            Text durability = new Text();

            Text allStatShown = new Text();
            //allStatShown.setLayoutX(menuX * 1.7);

            allStatShown.setLayoutX(screenWidth/2 - (box.getWidth()*0.875));
            allStatShown.setLayoutY(menuY * 3.5);
            allStatShown.setVisible(false);


            if (inventory[i] != null) {
                Item slotItem = inventory[i];
                box.setFill(slotItem.getInvColor());

                name.setText(slotItem.getName());
                if (slotItem instanceof Weapon) {
                    Weapon weapon = (Weapon) slotItem;
                    String tempStats;
                    tempStats = "Damage: " + weapon.getDamage() + "          " + "Quality: " + weapon.getQuality();
                    allStatShown.setText(tempStats);

                    damage.setText("Damage: " + (weapon.getDamage()));
                    quality.setText("Quality: " + (weapon.getQuality()));
                }

            }

            im.hoverProperty().addListener((obs) -> {
                if (im.isHover()) {
                    Color c = (Color) box.getFill();
                    int sc = 80;
                    double red = c.getRed() * 255, green = c.getGreen() * 255, blue = c.getBlue() * 255;
                    red = red - sc > 0 ? red - sc : 0;
                    green = green - sc > sc ? green - sc : 0;
                    blue = blue - sc > sc ? blue - sc : 0;
                    box.setFill(Color.rgb((int) red, (int) green, (int) blue));

                    //stats table
                    if (inventory[boxID.get(box)] != null) {
                        name.setText(inventory[boxID.get(box)].getName());
                        if (inventory[boxID.get(box)] instanceof Weapon) {
                            Weapon weapon = (Weapon) inventory[boxID.get(box)];
                            damage.setText("Damage: " + (weapon.getDamage()));
                            quality.setText("Quality: " + (weapon.getQuality()));
                            String tempStats;
                            tempStats = "Damage: " + weapon.getDamage() + "            " + "Quality: " + weapon.getQuality();
                            allStatShown.setText(tempStats);

                        }
                    } else {
                        im.setImage(hover);
                    }

                    if (inventory[imID.get(im)] != null) {
                        stats.setVisible(true);
                        name.setVisible(true);
                        damage.setVisible(true);
                        quality.setVisible(true);
                        allStatShown.setVisible(true);
                    }
                } else {
                    name.setText("");
                    damage.setText("");
                    quality.setText("");
                    allStatShown.setText("");
                    stats.setVisible(false);
                    name.setVisible(false);
                    damage.setVisible(false);
                    quality.setVisible(false);
                    allStatShown.setVisible(false);
                    box.setFill(Color.rgb(240, 240, 240));

                    int ID = boxID.get(box);
                    if (ID < 24)
                        im.setImage(empty);
                    else
                        im.setImage(hotbar);
                    if (inventory[ID] != null) {
                        Item slotItem = inventory[ID];
                        box.setFill(slotItem.getInvColor());
                        im.setImage(slotItem.getSprite());
                    }
                }
            });

            im.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
                @Override
                public void handle(MouseDragEvent mouseDragEvent) {
                    Color c = (Color) box.getFill();
                    int sc = 40;
                    double red = c.getRed() * 255, green = c.getGreen() * 255, blue = c.getBlue() * 255;
                    red = red - sc > 0 ? red - sc : 0;
                    green = green - sc > sc ? green - sc : 0;
                    blue = blue - sc > sc ? blue - sc : 0;
                    box.setFill(Color.rgb((int) red, (int) green, (int) blue));
                }
            });

            im.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
                @Override
                public void handle(MouseDragEvent mouseDragEvent) {
                    box.setFill(Color.rgb(240, 240, 240));
                    int ID = boxID.get(box);
                    if (inventory[ID] != null) {
                        Item slotItem = inventory[ID];
                        box.setFill(slotItem.getInvColor());
                    }
                }
            });

            im.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println("dragging");
                    dragging = true;
                    dragSprite.setVisible(true);
                    if (inventory[imID.get(im)] != null) {
                        dragSprite.setImage(inventory[imID.get(im)].getSprite());
                    }
                    dragSlot = boxID.get(box);
                    box.startFullDrag();
                }
            });

            im.setOnMouseDragReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println("released");
                    if (dragging) {
                        Item temp = inventory[boxID.get(box)];
                        inventory[boxID.get(box)] = inventory[dragSlot];
                        inventory[dragSlot] = temp;
                        refreshInv();
                        System.out.println(dragSlot + ", " + boxID.get(box));
                        dragging = false;
                        dragSprite.setVisible(false);
                        dragSlot = -1;
                        dragSprite.setImage(null);
                        System.out.println("stopped dragging");
                    }
                }
            });

            sortType.setOnAction(actionEvent -> {
                sortType(inventory);
                refreshInv();
                System.out.println("-----");
            });
            sortAlpha.setOnAction(actionEvent -> {
                sortAlpha(inventory);
                refreshInv();
                System.out.println("-----");
            });
            //add back in damage, quality, durabilit etc if want to keep them separate
            group.getChildren().addAll(box, im, stats, name, allStatShown);

            smallBoxes[i] = box;
            statsBoxes[i] = stats;
            sprites[i] = im;
            names[i] = name;
            damages[i] = damage;
            qualities[i] = quality;
            durabilities[i] =durability;
            allStats[i] = allStatShown;
        }
        refreshInv();
        group.getChildren().addAll(dragSprite);


        scene.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                if (dragging) {
                    dragSprite.setLayoutX(mouseDragEvent.getX() + 1);
                    dragSprite.setLayoutY(mouseDragEvent.getY() + 1);
                    System.out.println("moving sprite");
                }
            }
        });

        scene.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                dragSprite.setVisible(false);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double newMenuX = menuX * (newVal.doubleValue() / oldVal.doubleValue());
            menuX = newMenuX;
            bg.setFitWidth(newVal.doubleValue() / 2 + (menuX / 4.5));
            bg.setLayoutX(newMenuX - (newVal.doubleValue() / 34));
            iTop.setFitWidth(((newVal.doubleValue() / 2 + (menuX / 4.5)) / 2.25));
            iTop.setLayoutX((newMenuX - (newVal.doubleValue() / 34)) + menuX / 1.6);

            sortType.setPrefWidth(newVal.doubleValue() / 22);
            sortType.setLayoutX((newMenuX - (newVal.doubleValue() / 14)) + menuX * 2.53);
            sortAlpha.setPrefWidth(newVal.doubleValue() / 22);
            sortAlpha.setLayoutX((newMenuX - (newVal.doubleValue() / 14)) + menuX * 2.53);
            trashImage.setFitWidth(newVal.doubleValue() / 17);
            trashImage.setLayoutX((newMenuX - (newVal.doubleValue() / 14)) + menuX * 2.52);



            for (int i = 0; i < 30; i++) {
                ImageView im = sprites[i];
                Rectangle r = smallBoxes[i];
                Rectangle s = statsBoxes[i];
                Text n = names[i];
                Text d = damages[i];
                Text q = qualities[i];
                Text stats = allStats[i];
                im.setFitWidth(newVal.doubleValue() / 2 / 6);
                im.setLayoutX(newMenuX + (newVal.doubleValue() / 2 / 6) * (i % 6));
                r.setWidth(newVal.doubleValue() / 2 / 6);
                r.setLayoutX(newMenuX + (newVal.doubleValue() / 2 / 6) * (i % 6));
                s.setWidth(newVal.doubleValue() / 4);
                s.setLayoutX(newMenuX + (newVal.doubleValue() / 8));
                n.setLayoutX(newMenuX + (newVal.doubleValue() / 4.25));
                d.setLayoutX(newMenuX + (newVal.doubleValue() / 6.5));
                q.setLayoutX(newMenuX + (newVal.doubleValue() / 4.5));
                stats.setLayoutX(newMenuX + (newVal.doubleValue() / 5));

            }

        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double newMenuY = menuY * (newVal.doubleValue() / oldVal.doubleValue());
            menuY = newMenuY;
            iTop.setFitHeight((newVal.doubleValue() / 2 + (menuY / 2.75)) / 3.65);
            iTop.setLayoutY((newMenuY - (newVal.doubleValue() / 24)) / 5.5);
            bg.setFitHeight(newVal.doubleValue() / 2 + (menuY / 2.75));
            bg.setLayoutY(newMenuY - (newVal.doubleValue() / 24));
            sortType.setPrefHeight((newVal.doubleValue() / 13));
            sortType.setLayoutY(newMenuY / 2 + (newVal.doubleValue() / 4.2));
            sortAlpha.setPrefHeight((newVal.doubleValue() / 13));
            sortAlpha.setLayoutY(newMenuY / 2 + (newVal.doubleValue() / 3.05));
            trashImage.setFitHeight((newVal.doubleValue() / 10));
            trashImage.setLayoutY(newMenuY / 2 + (newVal.doubleValue() / 1.95));
            for (int i = 0; i < 30; i++) {
                ImageView im = sprites[i];
                Rectangle r = smallBoxes[i];
                Rectangle s = statsBoxes[i];
                Text n = names[i];
                Text d = damages[i];
                Text q = qualities[i];
                Text stats = allStats[i];
                im.setFitHeight(newVal.doubleValue() / 2 / 5);
                im.setLayoutY(newMenuY + (newVal.doubleValue() / 2 / 5) * ((i - (i % 6)) % 5));
                r.setHeight(newVal.doubleValue() / 2 / 5);
                r.setLayoutY(newMenuY + (newVal.doubleValue() / 2 / 5) * ((i - (i % 6)) % 5));
                s.setHeight(newVal.doubleValue() / 8);
                s.setLayoutY(newMenuY + (newVal.doubleValue() / 1.8));
                n.setLayoutY(newMenuY + (newVal.doubleValue() / 1.75));
                d.setLayoutY(newMenuY + (newVal.doubleValue() / 1.6));
                q.setLayoutY(newMenuY + (newVal.doubleValue() / 1.6));
                stats.setLayoutY(newMenuY + (newVal.doubleValue()/1.6));
                //stats.setFont(Font.font ("Verdana", newVal.doubleValue()/75));


            }
        });

        primaryStage.setTitle("Inventory");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void refreshInv() {

        for (int num = 0; num < 30; num++) {
            if (inventory[num] != null) {
                sprites[num].setImage(inventory[num].getSprite());
                smallBoxes[num].setFill(inventory[num].getInvColor());
            } else {
                smallBoxes[num].setFill(Color.rgb(240, 240, 240));
                if (num > 23)
                    sprites[num].setImage(hotbar);
                else
                    sprites[num].setImage(empty);
            }
        }
    }


    public void sortAlpha(Item[] inventory) {

        int length = 0;
        for (int i = 0; i < 24; i++) {
            if (inventory[i] != null) {
                length++;
            }
        }
        Item[] temp;
        temp = new Item[length];
        int num = 0;
        for (int i = 0; i < 24; i++) {
            if (inventory[i] != null) {
                temp[num] = inventory[i];
                num++;
            }
        }
        //before
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i].getName());
        }
        System.out.println("---");
        Item placeholder;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++)
                if ((temp[j + 1].getName()).compareToIgnoreCase(temp[j].getName()) < 0) {
                    placeholder = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = placeholder;
                }
        }
        //after
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i].getName());
        }

        for (int i = 0; i < temp.length; i++) {
            inventory[i] = temp[i];
        }
        for (int i = temp.length; i < 24; i++) {
            inventory[i] = null;
        }
    }

    public void sortType(Item[] inventory) {

        int length = 0;
        for (int i = 0; i < 24; i++) {
            if (inventory[i] != null) {
                length++;
            }
        }
        Item[] temp;
        temp = new Item[length];
        int num = 0;
        for (int i = 0; i < 24; i++) {
            if (inventory[i] != null) {
                temp[num] = inventory[i];
                num++;
            }
        }
        //before
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i].getName());
        }
        System.out.println("---");
        Item placeholder;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++)
                if ((temp[j + 1].getClass().getName()).compareToIgnoreCase(temp[j].getClass().getName()) < 0) {
                    placeholder = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = placeholder;
                }
        }
        //after
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i].getName());
        }

        for (int i = 0; i < temp.length; i++) {
            inventory[i] = temp[i];
        }
        for (int i = temp.length; i < 24; i++) {
            inventory[i] = null;
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
