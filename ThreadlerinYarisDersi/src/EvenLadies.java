import java.util.ArrayList;

class EvenLadies extends Thread {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> evenNumbers;

    public EvenLadies(ArrayList<Integer> numbers, ArrayList<Integer> evenNumbers) {
        this.numbers = numbers;
        this.evenNumbers = evenNumbers;
    }

    public void run() {
        try{

            for (int num : numbers) {
            if (num % 2 == 0) {
                synchronized (evenNumbers) {
                    evenNumbers.add(num);
                }
            }
         }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
