package model;

public class Telephone extends Product {
    private int camera;



    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return " | " + getId() +  " \t| " +
                 getName() +
                "\t \t \t \t|" + getPrice()+ " TL \t|" + getBrand() + "\t|" +
                getDiscCapacity() + " GB \t|" +
                getScreenSize() + " \t|" +
                 + camera + " MP " ;
    }
}
