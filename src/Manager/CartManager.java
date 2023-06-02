package Manager;

import model.Goods;

public class CartManager extends Managing {


    @Override
    public String toString() {
        int counter=1;
        String cart = "";
        for (Goods goods : this.addedGoods) {
            cart += counter + "."+ goods.toStringForCart()+"\n";
            counter++;
        }
        return cart;
    }
}