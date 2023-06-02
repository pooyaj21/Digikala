package model;

public class NonFood extends Goods {
    public NonFood(int count) {
        super("NF", count);
    }

    public String toStringForInventory() {
        return " NonFood" +
                " id: " + id + '/' +
                " count: " + countInventory
                ;
    }

    public String toStringForCart() {
        return " NonFood" +
                " id: " + id + '/' +
                " count: " + contInProgress
                ;
    }

    @Override
    public String toString() {
        return " NonFood" +
                " id: " + id + '/' +
                ", count: " + countInventory
                ;
    }
}