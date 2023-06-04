package Manager;

import model.Expirable;
import model.Goods;
import util.FileManagement;

import javax.sound.midi.Soundbank;

public class SubmitManager {

    public void fromInventoryToCArt(InventoryManager inventory, CartManager cart, Goods good, int count) {
        for (Goods goods : inventory.addedGoods) {
                if (goods instanceof Expirable) {
                    if (((Expirable) goods).isExpired()) {
                        goods.setCountInventory(0);
                        throw new IllegalStateException("Good is Expired: " + goods.getId());
                        //break; // if Exception got change and remove you need it
                    }
                }
            if (goods.equals(good)) {
                cart.addGoods(goods);
                goods.setContInProgress(goods.getContInProgress()+count);
                good.setCountInventory(good.getCountInventory()- count);
                System.out.println("Order Added to your Cart");
            }
        }
    }

    public void fromCartToInventory(InventoryManager inventory, CartManager cart, Goods good, int count) {
        for (Goods goods : inventory.addedGoods) {
            if (goods.equals(good)) {
                cart.removeGoods(goods);
                goods.setContInProgress(goods.getContInProgress()-count);
                good.setCountInventory(good.getCountInventory()+ count);
                System.out.println("Order Removed to your Cart");
            }
        }
    }

    public void submit(CartManager cart) {
        for (Goods goods : cart.getAll()) {
            if (goods instanceof Expirable) {
                if (((Expirable) goods).isExpired()){
                    goods.setCountInventory(0);
                    throw new IllegalStateException("Good is Expired: " + goods.getId());
                    //break; // if Exception got change and remove you need it
                }
            }
        }
        System.out.println("Your Order submitted :");
        FileManagement.writeCart(cart.getAll());
        int counter=1;
        for (Goods goods : cart.getAll()) {
            System.out.println(counter+"."+goods.toStringForCart());
            goods.setContInProgress(0);
            counter++;
        }
        System.out.println();

        cart.clear();
    }


}
