package com.patikadev.helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {

                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static int screenCenterPoint(String eksen, Dimension size) {
        int point;
        switch (eksen) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }

        return point;
    }

    public static boolean isFldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }

    public static void showMsg(String s){
        optionPageTr();
        String msg;
        String ttl;
        switch (s){
            case "fill":
                msg= "Lütfen Tüm Alanları Doldurun";
                ttl="Hata";
                break;
            case "done":
                msg = "İşlem Başarılı";
                ttl= "Sonuç";
                break;
            case "error":
                msg="İşlem hata verdi!!";
                ttl="Hata";
                break;
            default:
                msg = s;
                ttl = "mesaj";
        }
        JOptionPane.showMessageDialog(null, msg, ttl, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void optionPageTr(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
    }
}
