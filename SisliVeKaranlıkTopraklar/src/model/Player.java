package model;

public class Player {
    private Inventory inventory;
    private int health;
    private int money;
    private int damage;
    private String name;

    public Player() {
    }

    public Player(Inventory inventory, int health, int money, int damage, String name) {
        this.inventory = inventory;
        this.health = health;
        this.money = money;
        this.damage = damage;
        this.name = name;
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

    public void selectChar() {
        Char s = new Samurai();
        Char k = new Knight();
        Char a = new Archer();
        Char[] charList = {s, k, a};

        for (Char charA : charList) {
            System.out.println("Karakter: " + charA.getName() + ": Hasar: " + charA.getDamage() + ", Can: " + charA.getHealth() + ", Değer: " + charA.getMoney());
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "inventory=" + inventory +
                ", healthy=" + health +
                ", money=" + money +
                ", damage=" + damage +
                ", name='" + name + '\'' +
                '}';
    }
}
