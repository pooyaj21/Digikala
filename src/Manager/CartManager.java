package Manager;

import model.Goods;

public class CartManager extends Managing {

    public Boolean checkGoodsLeftInCart(Goods selectedGood , int count){
        for (Goods good:addedGoods) {
            if(good.equals(selectedGood)) return good.getContInProgress()>count;
        }
        return false;
    }
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