import Manager.CartManager;
import Manager.InventoryManager;
import Manager.SubmitManager;
import model.Drink;
import model.Fruit;
import model.NonFood;
import util.Menu;

public class Main {
    public static void main(String[] args) {
         InventoryManager inventory = InventoryManager.getInstance();
         SubmitManager submitManager = new SubmitManager();

        inventory.addGoods(new Fruit(10));
        inventory.addGoods(new Fruit(10));
        inventory.addGoods(new Drink(10));
        inventory.addGoods(new Drink(10));
        inventory.addGoods(new NonFood(10));
        inventory.addGoods(new NonFood(10));

        CartManager cart = new CartManager();
        Menu menu =new Menu(inventory,submitManager,cart);

        menu.mainMenu();
    }
}