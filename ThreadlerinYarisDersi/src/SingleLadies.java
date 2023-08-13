import java.util.ArrayList;

class SingleLadies extends Thread {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> oddNumbers;

    public SingleLadies(ArrayList<Integer> numbers, ArrayList<Integer> oddNumbers) {
        this.numbers = numbers;
        this.oddNumbers = oddNumbers;
    }

    public void run() {
        try
        {

        for (int num : numbers) {
            if (num % 2 != 0) {
                synchronized (oddNumbers) {
                    oddNumbers.add(num);
                }
            }
        }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
