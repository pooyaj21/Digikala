package Manager;

import model.Goods;

public final class InventoryManager extends Managing{
    private static InventoryManager inventory;
    private InventoryManager() {
    }

    public static InventoryManager getInstance(){
        if(inventory == null) {
            inventory = new InventoryManager();
        }
        return inventory;
    }

    @Override
    public String toString() {
        int counter=1;
        String inventory = "";
        for (Goods goods : super.addedGoods) {
            inventory += counter + "."+ goods+"\n";
            counter++;
        }
        return inventory;
    }
}
