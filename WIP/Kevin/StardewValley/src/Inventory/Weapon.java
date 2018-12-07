package Inventory;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;

public class Weapon extends Item {


    private double damage;
    private int quality;


    public Weapon(double damage, int quality, String name, Color color) {
        super(name, color);
        this.damage = damage;
        this.quality = quality;

    }

    public Weapon(Image sprite, String name, double damage, int quality, Color color) {

        super(sprite, name, color);
        this.damage = damage;
        this.quality = quality;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }


}
