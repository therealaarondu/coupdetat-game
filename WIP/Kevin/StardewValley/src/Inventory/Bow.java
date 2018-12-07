package Inventory;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;

public class Bow extends Weapon {

    private double drawspeed;


    public Bow(double damage, double drawspeed, int quality, String name) {
        super(damage, quality, name, Color.LIGHTPINK);
        this.drawspeed = drawspeed;
    }

    public Bow(Image sprite, String name, double damage, double drawspeed, int quality) {
        super(sprite, name, damage, quality, Color.LIGHTPINK);
        this.drawspeed = drawspeed;

    }

    public double getDrawspeed() {
        return drawspeed;
    }

    public void setDrawspeed(double drawspeed) {
        this.drawspeed = drawspeed;
    }


    @Override
    public String toString() {
        return "Bow{" +
                "damage=" + getDamage() +
                ", drawspeed=" + drawspeed +
                ", quality=" + getQuality() +
                ", name='" + getName() + '\'' +
                '}';
    }
}




