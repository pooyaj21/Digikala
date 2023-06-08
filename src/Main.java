import Manager.CartManager;
import Manager.InventoryManager;
import Manager.SubmitManager;
import model.Drink;
import model.Fruit;
import model.NonFood;
import util.FileManagement;
import util.Menu;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = InventoryManager.getInstance();
        SubmitManager submitManager = new SubmitManager();
        if (FileManagement.seeFileIsEmpty()) {
            inventory.addGoods(new Fruit(84));
            inventory.addGoods(new Fruit(34));
            inventory.addGoods(new Drink(12));
            inventory.addGoods(new Drink(66));
            inventory.addGoods(new NonFood(18));
            inventory.addGoods(new NonFood(81));
            FileManagement.writeInventoryForSave(inventory.getAll());
        } else {
            FileManagement.readFromFile(inventory);
        }
        CartManager cart = new CartManager();
        Menu menu = new Menu(inventory, submitManager, cart);

        menu.mainMenu();

    }
}