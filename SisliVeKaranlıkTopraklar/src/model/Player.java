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

    public Player() {
    }

    public Player(Inventory inventory, int health, int money, int damage, String name, String charName) {
        this.inventory = inventory;
        this.health = health;
        this.money = money;
        this.damage = damage;
        this.name = name;
        this.charName = charName;
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

        switch (selectChar){
            case 1:
                this.initPlayer(new Samurai());
                break;
            case 2:
                this.initPlayer(new Knight());
                break;
            case 3:
                this.initPlayer(new Archer());
                break;
            default:
                this.initPlayer(new Samurai());
        }

        System.out.println("Karakter: " + this.toString());
    }

    public void initPlayer(Char aChar){
        this.charName = aChar.getName();
        this.health = aChar.getHealth();
        this.damage = aChar.getDamage();
        this.money = aChar.getMoney();
    }

    public void selectLocation(){
        Location location = null;
        System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
        System.out.println("1. Güvenli Ev");
        System.out.println("2. Mağaza");
        int selectedLoc = input.nextInt();
        switch (selectedLoc){
            case 1:
                location = new SafeHouse(this);
                break;
            case 2:
                location= new ToolStore(this);
                break;
            default:
                location = new SafeHouse(this);
        }

        location.onLocation();
    }
    @Override
    public String toString() {
        return "Karakter: " + this.getCharName() +
                "  hasar: " + this.getDamage() +
                " can: " + this.getHealth() +
                " para: " + this.getMoney();
    }
}
