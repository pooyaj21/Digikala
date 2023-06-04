package model;

import util.TimeUtility;

public abstract class Food extends Goods implements Expirable {

    protected final long addedTimeInSeconds;
    protected final int expireDurationInSeconds;

    public Food(String prefixID, int count, int expireDuration) {
        super("F" + prefixID, count);
        this.addedTimeInSeconds = TimeUtility.currentTimeInSeconds();
        this.expireDurationInSeconds = expireDuration;
    }

    public Food(String prefixID, int count, int expireDuration,int addedTimeInSeconds) {
        super("F" + prefixID, count);
        this.addedTimeInSeconds = addedTimeInSeconds;
        this.expireDurationInSeconds = expireDuration;
    }
    public long getAddedTimeInSeconds() {
        return addedTimeInSeconds;
    }

    public String getAddedTimeInSecondsToString() {
        return ""+addedTimeInSeconds;
    }


    public boolean isExpired() {
        return (TimeUtility.currentTimeInSeconds() - addedTimeInSeconds) >= expireDurationInSeconds;
    }


    public String toStringForInventory() {
        return " Food" +
                " id: " + id + '/' +
                " count: " + countInventory
                ;
    }

    public String toStringForCart() {
        return " Food" +
                " id: " + id + '/' +
                " count: " + contInProgress
                ;
    }

    @Override
    public String toString() {
        return " Food" +
                " id: " + id + '/' +
                ", count: " +countInventory
                ;
    }

}
