package model;

public class SafeHouse extends Location{
    public SafeHouse(Player player) {
        super(player);
        this.setName("Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz \nCanınız yenilendi");
        return false;
    }
}
