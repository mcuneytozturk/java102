package model;

import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private int health;
    private int money;
    private int damage;
    private String name;
    private String charName;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void selectChar() {
        Char s = new Samurai();
        Char k = new Knight();
        Char a = new Archer();
        Char[] charList = {s, a, k};
        System.out.println("----Karakter Seçimi----");
        for (Char charA : charList) {
            System.out.println(charA.getId() + ". Karakter: " + charA.getName() + ": Hasar: " + charA.getDamage() + ", Can: " + charA.getHealth() + ", Değer: " + charA.getMoney());
        }

        int selectChar = input.nextInt();

        switch (selectChar) {
            case 1 -> this.initPlayer(new Samurai());
            case 2 -> this.initPlayer(new Knight());
            case 3 -> this.initPlayer(new Archer());
            default -> this.initPlayer(new Samurai());
        }

        System.out.println("Karakter: " + this.toString());
    }

    public void initPlayer(Char aChar){
        this.charName = aChar.getName();
        this.health = aChar.getHealth();
        this.damage = aChar.getDamage();
        this.money = aChar.getMoney();
    }

    @Override
    public String toString() {
        return "Karakter : " + this.getCharName() +
                " Silah : " + this.inventory.getWeapon().getName() +
                " Hasar : " + this.getDamage() +
                " Can : " + this.getHealth() +
                " Para : " + this.getMoney();
    }
}
