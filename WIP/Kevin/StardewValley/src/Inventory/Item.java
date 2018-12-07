package Inventory;



import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.awt.image.BufferedImage;

public abstract class Item {


    private Image sprite;
    private String name;
    private Color invColor;

    public Item(String name) {
    }

    public Item(String name, Color invColor) {
        this.name = name;
        this.invColor = invColor;
    }

    public Item(Image sprite, String name, Color invColor) {
        this.sprite = sprite;
        this.name = name;
        this.invColor = invColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getInvColor() {
        return invColor;
    }


    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", sprite=" + sprite + '}';
    }



}
