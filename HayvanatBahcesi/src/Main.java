
public class Main {
    public static void main(String[] args) {
        Horses horses = new Horses("At", 400, 4);
        Cats cat = new Cats("Soma", 10, 14);

        System.out.print(cat.getName() + ":  ");
        cat.getDosage();
        System.out.print(horses.getName()+ ":  ");
        horses.getFeedTime();

    }
}