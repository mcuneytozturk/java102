package model;

import java.util.Scanner;

public class Game {
    private Player player;

    private Location location;

    Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player();
        player.setName(playerName);
        System.out.println("Sayın" + player.getName() + "Sisli ve Karanlık Diyara hoş geldiniz");

        player.selectChar();

    }
}
