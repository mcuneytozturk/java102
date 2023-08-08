package model;

import java.util.ArrayList;
import java.util.List;

public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;


    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static List<Weapon> weapons() {
        List<Weapon> weaponList = new ArrayList<>();
        Weapon weapon1 = new Weapon("Kılıç", 1, 12, 3);
        weaponList.add(weapon1);
        Weapon weapon2 = new Weapon("Bıçak", 2, 12, 1);
        weaponList.add(weapon2);
        Weapon weapon3 = new Weapon("Satır",3, 12, 5);
        weaponList.add(weapon3);
        Weapon weapon4 = new Weapon("Yay",4, 12, 3);
        weaponList.add(weapon4);

        return weaponList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  id + " . " + name +
                " damage = " + damage +
                " price = " + price;
    }
}
