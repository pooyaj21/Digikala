package model;

public abstract class Goods{
    private final String prefixID;
    protected final String id;
    protected int count;
    private static int COUNTER = 0;

    public Goods(String prefixID, int count) {
        COUNTER++;
        this.prefixID = prefixID;
        this.id = prefixID + COUNTER;
        this.count = count;
    }

    public String getPrefixID() {
        return prefixID;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return " Goods" +
                " id: " + id + '/' +
                " count: " + count
                ;
    }
}
