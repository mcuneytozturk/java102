package model;

public class Computer extends Product{

    private int ram;

    public Computer() {
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return " | " + getId() +  "\t|\t" +
                getName() + "\t \t \t \t|\t" +
                getPrice() + " TL \t|\t" +
                getBrand() + "\t|\t" +
                getDiscCapacity() + "\t|\t" +
                getScreenSize() + "\t|\t" +
                + ram + "\n";
    }
}
