import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        OrderMatic oMatic = new OrderMatic();

        List<Thread> istemler = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Thread t = new Thread(oMatic);
            istemler.add(t);
            t.start();
        }
    }
}