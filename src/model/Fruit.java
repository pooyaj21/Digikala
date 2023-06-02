package model;

public class Fruit extends Food {

    public Fruit(int count) {
        super("FR", count, 45);
    }

    public String toStringForInventory() {
        return " Fruit" +
                " id: " + id + '/' +
                " count: " + countInventory
                ;
    }

    public String toStringForCart() {
        return " Fruit" +
                " id: " + id + '/' +
                " count: " + contInProgress
                ;
    }

    @Override
    public String toString() {
        return " Fruit" +
                " id: " + id + '/' +
                ", count: " + countInventory
                ;
    }
}
