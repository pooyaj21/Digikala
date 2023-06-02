package Manager;

import model.Goods;

public class CartManager extends Managing {
    public void addToCArt(Goods goods ,int count) {
        addedGoods.add(goods);
        goods.setCount(count);
    }

    @Override
    public String toString() {
        int counter=1;
        String cart = "";
        for (Goods goods : super.addedGoods) {
            cart += counter + "."+ goods+"\n";
            counter++;
        }
        return cart;
    }
}