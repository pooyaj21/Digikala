package Manager;

import model.Expirable;
import model.Goods;

public class SubmitManager {

    public void submit(CartManager cart) {
        for (Goods goods : cart.getAll()) {
            if (goods instanceof Expirable) {
                if (((Expirable) goods).isExpired()) throw new IllegalStateException("Food is Expired: " + goods);
            }
        }
        System.out.println("Your Order submitted :");
        for (Goods goods : cart.getAll()) {
            System.out.println(goods);
        }
        cart.clear();
    }

}
