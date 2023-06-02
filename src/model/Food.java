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

    public boolean isExpired() {
        return (TimeUtility.currentTimeInSeconds() - addedTimeInSeconds) >= expireDurationInSeconds;
    }



    @Override
    public String toString() {
        return " Food" +
                " id: " + id + '/' +
                ", count: " + count
                ;
    }

}
