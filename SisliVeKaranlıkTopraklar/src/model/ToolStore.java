package model;

public class ToolStore extends Location{
    @Override
    public boolean onLocation() {
        return false;
    }

    public ToolStore(Player player) {
        super(player);
        this.setName("Mağaza");

    }
}
