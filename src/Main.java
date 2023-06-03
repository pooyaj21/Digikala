import Manager.CartManager;
import Manager.InventoryManager;
import Manager.SubmitManager;
import model.Drink;
import model.Fruit;
import model.NonFood;
import util.FileManagement;


public class Main {
    public static void main(String[] args) {
        InventoryManager inventory =InventoryManager.getInstance();
        SubmitManager submitManager = new SubmitManager();


        Fruit f1 = new Fruit(2);
        Drink d1 = new Drink(3);
        NonFood nf1 = new NonFood(4);

        inventory.addGoods(f1);
        inventory.addGoods(d1);
        inventory.addGoods(nf1);

        System.out.println(inventory);

        CartManager cart = new CartManager();


        submitManager.fromInventoryToCArt(inventory, cart,
                inventory.search("fdr2"), 1);
        submitManager.fromInventoryToCArt(inventory, cart,
                inventory.search("ffr1"), 1);


        FileManagement.writeCart(cart.getAll());

        submitManager.submit(cart);

        System.out.println(inventory);
        FileManagement.writeInventory(inventory.getAll());



    }
}