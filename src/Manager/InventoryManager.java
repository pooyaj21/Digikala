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

    public Goods search(String userInput){
        for (Goods good:inventory.getAll()) {
            if(good.getId().equals(userInput.toUpperCase()))return good;
        }
        return null;
    }



    @Override
    public String toString() {
        int counter=1;
        String inventory = "";
        for (Goods goods : super.addedGoods) {
            inventory += counter + "."+ goods.toStringForInventory()+"\n";
            counter++;
        }
        return inventory;
    }
}
