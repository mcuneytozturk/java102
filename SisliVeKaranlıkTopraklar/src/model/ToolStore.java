package model;

public class ToolStore extends NormalLoc{
    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoş Geldin!");
        System.out.println("1 - Silahlar \n 2 - Zırhlar \n 3 - Çıkış yap");
        System.out.println("Seçiminiz: ");
        int selection = scanner.nextInt();
        while(selection < 1 ||selection > 3){
            System.out.println("Geçersiz seçim, tekrar seçiniz");
            selection = scanner.nextInt();
        }
        switch (selection) {
            case 1 -> {printWeapon(); buyWeapon();}
            case 2 -> printArmor();
            case 3 -> {
                System.out.println("BB");
                return true;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("=====Silahlar=====");
        for (Weapon w: Weapon.weapons()){
            System.out.println(w.toString());
        }
    }

    public void buyWeapon(){
        int weaponSelection = scanner.nextInt();

        while (weaponSelection < 1 ||weaponSelection > Weapon.weapons().size()){
            System.out.println("Geçersiz bir değer girdiniz");
            weaponSelection = scanner.nextInt();
        }

        Weapon weapon = Weapon.weapons().get(weaponSelection - 1);
        Player player = this.getPlayer();
        int balance = player.getMoney();
        Inventory inventory = player.getInventory();

        if(weapon.getPrice() > this.getPlayer().getMoney()){
            System.out.println("Bu silahı karşılayamıyorsunuz");
        } else {
            player.setMoney(balance - weapon.getPrice());
            System.out.println("Silahı satın aldınız kalan paranız : " + balance);
            System.out.println("Önceki silahınız : " + inventory.getWeapon());
            inventory.setWeapon(weapon);
            System.out.println("Yeni silahınız : " + inventory.getWeapon());

        }
    }


    public void printArmor() {
        System.out.println("=====Zırhlar=====");
    }

    public ToolStore(Player player) {
        super(player, "Mağaza");

    }
}
