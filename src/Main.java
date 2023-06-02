import Manager.CartManager;
import Manager.InventoryManager;
import model.Drink;
import model.Fruit;
import model.NonFood;

public class Main {
    public static void main(String[] args) {
       InventoryManager.getInstance();



        Fruit f1 =new Fruit(2);
        Drink d1 = new Drink(3);
        NonFood nf1 = new NonFood(4);

        InventoryManager.getInstance().addGoods(f1);
        InventoryManager.getInstance().addGoods(d1);
        InventoryManager.getInstance().addGoods(nf1);

        System.out.println(InventoryManager.getInstance());
        CartManager cart = new CartManager();

        cart.addToCArt(f1,1);
        cart.addToCArt(d1,2);
        cart.addToCArt(nf1,3);

        System.out.println(InventoryManager.getInstance());

    }
}