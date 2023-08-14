public class Rats extends Animal {

    public Rats(String name, int weight, int age) {
        super(name, weight, age);
    }

    @Override
    public void getDosage() {
        int age = getAge();
        int weight = getWeight();
        if(weight < 100 || age < 5){
            System.out.println("İlaçlama dikkatle ve az miktarda yapılmalıdır");
        } else if (weight < 200 || age < 15){
            System.out.println("İlaçlama normal dozda uygulanabilir");
        } else if (weight < 300 || age < 25){
            System.out.println("İlaçlama yapılmamalıdır");
        }
    }

    @Override
    public void getFeedTime() {
        int age = getAge();
        int weight = getWeight();
        if(weight < 100 || age < 5){
            System.out.println("bebek maması ile devam");
        } else if (weight < 200 || age < 15){
            System.out.println("normal öğün verilmeli");
        } else if (weight < 300 || age < 25){
            System.out.println("diyet mama verilmeli");
        }
    }
}
