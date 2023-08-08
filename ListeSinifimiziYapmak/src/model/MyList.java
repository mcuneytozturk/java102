package model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<T> {
    private T[] genericArray;

    private int capacity;

    private int index = 0;

    @SuppressWarnings("unchecked")
    public MyList() {
        this.capacity = 10;
        this.genericArray = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.capacity = capacity;
        this.genericArray = (T[]) new Object[capacity];
    }

    public int size() {
        int sizeCount = 0;
        for (T t : this.genericArray) {
            sizeCount++;
        }
        return sizeCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        if (index < capacity) {
            this.genericArray[index] = data;
            index++;
        } else {
            this.capacity *= 2;
            add(data);
        }
    }

    public T get(int i) {
        if (i < this.index) {
            return this.genericArray[i];
        } else {
            return null;
        }
    }

    public T[] remove(int i) {
        if (i < this.index) {
            for (int y = 0; y < index; y++) {
                if(i == y){
                   for(int z = i; z < index; z++){
                       this.genericArray[z] = this.genericArray[z+1];
                   }
                }
            }
            return this.genericArray;
        } else {
            return null;
        }
    }

    public T[] set(int i, T data){
        if(i < index){
            for(int y = 0; y < index; y++){
                if (i == y) {
                    this.genericArray[i] = data;
                    break;
                }
            }
            return getGenericArray();
        } else {
            return null;
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(this.genericArray);
    }

    public int indexOf(T data){
        int counter = -1;
        for (T t: this.genericArray){
            counter++;
            if(data.equals(t)){
                return counter;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int counter = index;
        for(int i = index; i > 0; i--){
            if (data.equals(this.genericArray[i])){
                counter = i;
                break;
            } else {
                counter = -1;
            }
        }
        return counter;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public T[] toArray(){
        return Arrays.copyOf(this.genericArray, index);
    }

    @SuppressWarnings("unchecked")
    public void clear(){
        this.genericArray = (T[]) new Object[0];
    }

    public T[] getGenericArray() {
        return genericArray;
    }

    public MyList<T> subList(int start, int finish){
        MyList<T> subArray = new MyList<>(finish+1);
        for(int i = start; i <= finish; i++){
            subArray.add(this.genericArray[i]);
        }
        return subArray;
    }

    public boolean contains(T data){
        boolean isEquals = false;
        for( T t: this.genericArray){
            if (data.equals(t)){
                isEquals = true;
                break;
            }
        }
        return isEquals;
    }

    public void setGenericArray(T[] genericArray) {
        this.genericArray = genericArray;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
