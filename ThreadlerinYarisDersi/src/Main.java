import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        int chunkSize = numbers.size() / 4;

        EvenLadies evenThread1 = new EvenLadies(new ArrayList<>(numbers.subList(0, chunkSize)), evenNumbers);
        EvenLadies evenThread2 = new EvenLadies(new ArrayList<>(numbers.subList(chunkSize, 2 * chunkSize)), evenNumbers);
        SingleLadies oddThread1 = new SingleLadies(new ArrayList<>(numbers.subList(2 * chunkSize, 3 * chunkSize)), oddNumbers);
        SingleLadies oddThread2 = new SingleLadies(new ArrayList<>(numbers.subList(3 * chunkSize, 4 * chunkSize)), oddNumbers);

        evenThread1.start();
        evenThread2.start();
        oddThread1.start();
        oddThread2.start();

        try {
            evenThread1.join();
            evenThread2.join();
            oddThread1.join();
            oddThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
