package model;

public class NonFood extends Goods {
    public NonFood(int count) {
        super("NF", count);
    }


    @Override
    public String toString() {
        return " Non Food" +
                " id: " + id + '/' +
                " count: " + count
                ;
    }
}