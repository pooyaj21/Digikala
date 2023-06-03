package Manager;

import model.Expirable;
import model.Goods;

public class SubmitManager {

    public void fromInventoryToCArt(InventoryManager inventory, CartManager cart, Goods good, int count) {
        for (Goods goods : inventory.addedGoods) {
            if (goods.equals(good)) {
                cart.addGoods(goods);
                goods.setContInProgress(count);
                good.setCountInventory(good.getCountInventory()- count);
            }
        }
    }

    public void submit(CartManager cart) {
        for (Goods goods : cart.getAll()) {
            if (goods instanceof Expirable) {
                if (((Expirable) goods).isExpired()) throw new IllegalStateException("Food is Expired: " + goods);
            }
        }
        System.out.println("Your Order submitted :");
        int counter=1;
        for (Goods goods : cart.getAll()) {
            System.out.println(counter+"."+goods.toStringForCart());
            counter++;
        }
        System.out.println();
        cart.clear();
    }


}
