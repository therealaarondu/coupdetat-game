package Inventory;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;

public class Sword extends Weapon{

    private double durability;



    public Sword(double damage, double durability, int quality, String name) {
        super(damage, quality, name, Color.LIGHTGREEN);

        this.durability = durability;


    }

    public Sword(Image sprite, String name, double damage, double durability, int quality) {
        super(sprite, name, damage, quality, Color.LIGHTGREEN);
        this.durability = durability;

    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "damage=" + getDamage() +
                ", durability=" + durability +
                ", quality=" + getQuality() +
                ", name='" + getName() + '\'' +
                '}';
    }

}
