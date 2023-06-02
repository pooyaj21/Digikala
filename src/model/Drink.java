package model;

public class Drink extends Food {

    public Drink(int count) {
        super("DR", count, 60);
    }

    @Override
    public String toString() {
        return " Drink" +
                " id: " + id + '/' +
                " count: " + count
                ;
    }

}