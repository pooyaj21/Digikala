package model;

public class Fruit extends Food {

    public Fruit(int count) {
        super("FR", count, 45);
    }

    @Override
    public String toString() {
        return " Fruit" +
                " id: " + id + '/' +
                " count: " + count
                ;
    }
}
