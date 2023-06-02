package model;

public class Drink extends Food {

    public Drink(int count) {
        super("DR", count, 60);
    }

    public String toStringForInventory() {
        return " Drink" +
                " id: " + id + '/' +
                " count: " + countInventory
                ;
    }

    public String toStringForCart() {
        return " Drink" +
                " id: " + id + '/' +
                " count: " + contInProgress
                ;
    }

    @Override
    public String toString() {
        return " Drink" +
                " id: " + id + '/' +
                ", count: " + countInventory
                ;
    }

}