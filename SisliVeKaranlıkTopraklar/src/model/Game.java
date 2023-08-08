package model;

import java.util.Scanner;

public class Game {
    private Player player;

    private Location location;

    Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = "geçici isim"; //input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Merhabalar " + player.getName() + ", bu Sisli ve Karanlık Diyara hoş geldiniz");

        player.selectChar();

        Location location = null;

        while(true){
            System.out.println(player.toString());
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
            System.out.println("1. Güvenli Ev");
            System.out.println("2. Mağaza");
            int selectedLoc = input.nextInt();
            location = switch (selectedLoc) {
                case 1 -> new SafeHouse(player);
                case 2 -> new ToolStore(player);
                default -> new SafeHouse(player);
            };

            if(!location.onLocation()){
                System.out.println("Game Over");
                break;
            }
        }
    }
}
