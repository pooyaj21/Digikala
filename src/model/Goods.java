package model;

public abstract class Goods{
    private final String prefixID;
    protected final String id;
    protected int countInventory;
    protected int contInProgress;

    private static int COUNTER = 0;


    public Goods(String prefixID, int count) {
        COUNTER++;
        this.prefixID = prefixID;
        this.id = prefixID + COUNTER;
        this.countInventory = count;
    }

    public int getCountInventory() {
        return countInventory;
    }

    public void setCountInventory(int countInventory) {
        this.countInventory = countInventory;
    }

    public int getContInProgress() {
        return contInProgress;
    }

    public void setContInProgress(int contInProgress) {
        this.contInProgress = contInProgress;
    }

    public String getPrefixID() {
        return prefixID;
    }

    public String getId() {
        return id;
    }



    public String toStringForInventory() {
        return " Goods" +
                " id: " + id + '/' +
                " count: " + countInventory
                ;
    }

    public String toStringForCart() {
        return " Goods" +
                " id: " + id + '/' +
                " count: " + contInProgress
                ;
    }

    @Override
    public String toString() {
        return " Goods" +
                " id: " + id + '/' +
                " count: " + countInventory
                ;
    }

}
