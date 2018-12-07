package Inventory;

import java.util.ArrayList;
import java.util.Collections;


public class main {
    static double inf = Double.POSITIVE_INFINITY;

    public static void main(String[] args) {

        ArrayList<Item> list = new ArrayList<>();

        Sword sickle = new Sword(20, 100, 3, "Sickle");
        Sword stormWeaver = new Sword(200, inf, 20, "Storm Weaver");
        Sword godSlayer = new Sword(1000, inf, 50, "God-Slayer");
        Sword volcanicLongSword = new Sword(200, 1000, 30, "Volcanic Long Sword");
        Sword barbarianBlade = new Sword(100, 500, 20, "Barabarian Blade");
        Sword broadSword = new Sword(50, 300, 10, "Broad Sword");
        Sword shadowStrike = new Sword(300, inf, 40, "Shadow Strike");
        Sword jawsOfDeception = new Sword(500, inf, 45, "Jaws of Deception");
        Sword unholyMight = new Sword(750, inf, 45, "Unholy Might");
        Sword saberOfTheStars = new Sword(900, inf, 50, "Saber of the Stars");
        Sword silverSaber = new Sword(400, 2000, 40, "Silver Saber");
        Sword hellsScream = new Sword(950, inf, 50, "Hell's Scream");
        Sword nightBane = new Sword(500, inf, 35, "Nightbane");
        Sword lament = new Sword(800, inf, 47, "Lament");
        Sword soulDefender = new Sword(650, 3000, 40, "Soul Defender");

        Bow tranquility = new Bow(200, 2, 1, "Tranquility");


        Collections.addAll(list, sickle, stormWeaver, godSlayer, volcanicLongSword, barbarianBlade, broadSword, shadowStrike, jawsOfDeception, unholyMight, saberOfTheStars);
        Collections.addAll(list, silverSaber, hellsScream, nightBane, lament, soulDefender);
        Collections.addAll(list, tranquility);

        for (Item item : list) {
            System.out.println(item.toString());
        }


    }
}
