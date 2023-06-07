package Manager;

import model.Goods;

public final class InventoryManager extends Managing{
    private static InventoryManager inventory;
    private InventoryManager() {
    }

    public Boolean checkGoodsLeft(Goods selectedGood , int count){
        for (Goods good:addedGoods) {
            if(good.equals(selectedGood)) return good.getCountInventory()<=count;
        }
        if (count<0)return false;
        return false;
    }

    public static InventoryManager getInstance(){
        if(inventory == null) {
            inventory = new InventoryManager();
        }
        return inventory;
    }

    public Boolean checkGoodsLeftInInventory(Goods selectedGood , int count){
        for (Goods good:inventory.getAll()) {
            if(good.equals(selectedGood)) return good.getCountInventory()>=count;
        }
        return false;
    }

    @Override
    public String toString() {
        int counter=1;
        String inventory = "";
        for (Goods goods : super.addedGoods) {
            if(goods.getCountInventory()!=0) {
                inventory += counter + "." + goods.toStringForInventory() + "\n";
                counter++;
            }
        }
        return inventory;
    }
}
