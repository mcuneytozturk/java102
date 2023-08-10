package service;

import model.Brand;
import model.Computer;
import model.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatikaStoreService {
    public void initializeStore(){
        Scanner sc = new Scanner(System.in);
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - NoteBook işlemleri \n 2 - Cep Telefonu İşlemleri \n 3 - Marka Listele \n 0 - Çıkış Yap");
        System.out.println("İşlem Tercihiniz : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getComputerList();
                break;
            case 2:
                getTelephoneList();
                break;
            case 3:
                System.out.println("--------------------------------");
                for (Brand b: getBrands()){
                    System.out.println(" - " + b.getName());
                }
                break;
            case 0:
                break;
        }
    }

    public List<Brand> getBrands(){
        List<Brand> brandList =new ArrayList<>();
        Brand apple = new Brand("Apple");
        brandList.add(apple);
        Brand asus = new Brand("Asus");
        brandList.add(asus);
        Brand casper = new Brand("Casper");
        brandList.add(casper);
        Brand huawei = new Brand("Huawei");
        brandList.add(huawei);
        Brand lenovo = new Brand("Lenovo");
        brandList.add(lenovo);
        Brand monster = new Brand("Monster");
        brandList.add(monster);
        Brand hp = new Brand("HP");
        brandList.add(hp);
        Brand samsung = new Brand("Samsung");
        brandList.add(samsung);
        Brand xiaomi = new Brand("Xiaomi");
        brandList.add(xiaomi);

        return brandList;
    }

    public Brand getBrand(String brand) {
        List<Brand> brandList = getBrands();
        for (Brand b : brandList) {
            if (b.getName().equals(brand)) {
                return b;
            }
        }
        return null;
    }

    public void getTelephoneList(){
        List<Telephone> telephoneList = new ArrayList<>();
        Telephone iPhone11 = new Telephone();
        iPhone11.setName("iPhone 11 64 GB");
        iPhone11.setPrice(7379);
        iPhone11.setCamera(5);
        iPhone11.setDiscCapacity(64);
        iPhone11.setBrand(getBrand("Apple"));
        iPhone11.setScreenSize(6.1);
        telephoneList.add(iPhone11);
        Telephone samsungGalaxyA51 = new Telephone();
        samsungGalaxyA51.setName("SAMSUNG GALAXY A51");
        samsungGalaxyA51.setPrice(3199);
        samsungGalaxyA51.setCamera(32);
        samsungGalaxyA51.setDiscCapacity(128);
        samsungGalaxyA51.setBrand(getBrand("Samsung"));
        samsungGalaxyA51.setScreenSize(6.5);
        telephoneList.add(samsungGalaxyA51);
        Telephone redmiNote10Pro = new Telephone();
        redmiNote10Pro.setName("Redmi Note 10 Pro 8GB");
        redmiNote10Pro.setPrice(4012);
        redmiNote10Pro.setCamera(35);
        redmiNote10Pro.setDiscCapacity(128);
        redmiNote10Pro.setBrand(getBrand("Xiaomi"));
        redmiNote10Pro.setScreenSize(6.5);
        telephoneList.add(redmiNote10Pro);

        System.out.println(" | " + "ID" +  "\t | " +
                " " + "Ürün Adı" +
                "\t \t \t \t | " + "Fiyat" + " | " + "Marka" + "| " +
                "Depolama" + "    | " +
                "Ekran" + " | " +
                "Kamera      ");
        for (Telephone t: telephoneList){
            System.out.println(t.toString());
        }
    }

    public void getComputerList(){
        List<Computer> computerList = new ArrayList<>();
        Computer huaweiMateBook = new Computer();
        huaweiMateBook.setName("HUAWEI Matebook 14");
        huaweiMateBook.setPrice(7000);
        huaweiMateBook.setScreenSize(14.0);
        huaweiMateBook.setDiscCapacity(512);
        huaweiMateBook.setBrand(getBrand("Huawei"));
        huaweiMateBook.setRam(16);
        computerList.add(huaweiMateBook);
        Computer lenovoV14 = new Computer();
        lenovoV14.setName("LENOVO V14 IGL");
        lenovoV14.setPrice(3699);
        lenovoV14.setScreenSize(14.0);
        lenovoV14.setDiscCapacity(1024);
        lenovoV14.setBrand(getBrand("Lenovo"));
        lenovoV14.setRam(8);
        computerList.add(lenovoV14);
        Computer aSUSTuf = new Computer();
        aSUSTuf.setName("ASUS Tuf Gaming");
        aSUSTuf.setPrice(8199);
        aSUSTuf.setScreenSize(15.6);
        aSUSTuf.setDiscCapacity(2048);
        aSUSTuf.setBrand(getBrand("Asus"));
        aSUSTuf.setRam(32);
        computerList.add(aSUSTuf);

        System.out.println(" | " + "ID" +  "\t|\t" +
                " " + "Ürün Adı" +
                "\t \t \t \t|\t" + "Fiyat" + "\t|\t" + "Marka" + "\t|\t" +
                "Depolama" + "\t|\t" +
                "Ekran" + " \t|\t"
                + "RAM");
        for (Computer c: computerList){
            System.out.println(c.toString());
        }
    }
}
