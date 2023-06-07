package util;

import Manager.CartManager;
import Manager.InventoryManager;
import Manager.SubmitManager;
import model.Drink;
import model.Fruit;
import model.Goods;
import model.NonFood;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static InventoryManager inventory;
    private static SubmitManager submitManager;
    private static CartManager cart;

    public Menu(InventoryManager inventory, SubmitManager submitManager, CartManager cart) {
        Menu.inventory = inventory;
        Menu.submitManager = submitManager;
        Menu.cart = cart;
    }

    private static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void mainMenu() {
        String[] MainOptions = {"\n1- Inventory",
                "2- Cart",
                "3- Exchange to File",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 3) {
            printMenu(MainOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        inventoryMenu();
                        break;
                    case 2:
                        cartMenu();
                        break;
                    case 3:
                        ExchangeToFile();
                        break;
                    default:
                        System.err.println("Wrong entry!");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    private static void inventoryMenu() {
        System.out.print("\n" + inventory);
        String[] MainOptions = {"\n1- Add Item in Inventory",
                "2- Remove Item in Inventory",
                "3- Buy",
                "4- Return to Main menu",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 2) {
            printMenu(MainOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addToInventory();
                        break;
                    case 2:
                        removeItemFromInventory();
                    case 3:
                        buyItems();
                        break;
                    case 4:
                        mainMenu();
                        break;
                    default:
                        System.err.println("Wrong entry!");
                        System.err.println("Please enter an integer value between 1 and " + MainOptions.length);
                }
            } catch (InputMismatchException ex) {
                System.err.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    private static void cartMenu() {
        System.out.print("\n" + cart);
        String[] MainOptions = {"\n1- Buy",
                "2- Remove from the Cart",
                "3- Submit The Cart",
                "4- Return to Main menu",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {
            printMenu(MainOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        buyItems();
                        break;
                    case 2:
                        removeItemsFromCart();
                        break;
                    case 3:
                        submitTheCart();
                        break;
                    case 4:
                        mainMenu();
                        break;
                    default:
                        System.err.println("Wrong entry!");
                        System.err.println("Please enter an integer value between 1 and " + MainOptions.length);
                }
            } catch (InputMismatchException ex) {
                System.err.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    public static void ExchangeToFile() {
        String[] MainOptions = {"\n1- Make a Inventory List",
                "2- Make a Cart List",
                "3- Return to Main menu",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 3) {
            printMenu(MainOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        FileManagement.writeInventory(inventory.getAll());
                        FileManagement.writeInventoryForSave(inventory.getAll());
                        System.out.print("File Created");
                        break;
                    case 2:
                        FileManagement.writeCart(cart.getAll());
                        System.out.print("File Created");
                        break;
                    case 3:
                        mainMenu();
                        break;
                    default:
                        System.err.println("Wrong entry!");
                        System.err.println("Please enter an integer value between 1 and " + MainOptions.length);
                }
            } catch (InputMismatchException ex) {
                System.err.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    private static void addToInventory() {
        System.out.println("Enter your new Goods category(Fruit,Drink,Non Food)");
        String userInput = new Scanner(System.in).nextLine();
        if (userInput.equalsIgnoreCase("Fruit")) {
            System.out.println("How much Goods?");
            int userInputCount = new Scanner(System.in).nextInt();
            inventory.addGoods(new Fruit(userInputCount));
        } else if (userInput.equalsIgnoreCase("Drink")) {
            System.out.println("How much Goods?");
            int userInputCount = new Scanner(System.in).nextInt();
            inventory.addGoods(new Drink(userInputCount));
        }else if (userInput.equalsIgnoreCase("Non Food")) {
            System.out.println("How much Goods?");
            int userInputCount = new Scanner(System.in).nextInt();
            inventory.addGoods(new NonFood(userInputCount));
        }else{
            System.err.println("Enter the right category!");
        }
        FileManagement.writeInventoryForSave(inventory.getAll());
        inventoryMenu();
    }

    private static void buyItems() {
        System.out.print("Enter your Goods ID that you want to Add: ");
        String userInputID = new Scanner(System.in).nextLine();
        if (inventory.search(userInputID) == null) {
            System.err.println("Didn't found Goods you want!");
            mainMenu();
        }
        Goods selectedGood = inventory.search(userInputID);
        System.out.print("How manny of " + userInputID + " do you want to Add? ");
        int userInputCount = new Scanner(System.in).nextInt();
        if (!inventory.checkGoodsLeftInInventory(selectedGood, userInputCount)) {
            System.err.println("sorry we don't have " + userInputID
                    + " in " + userInputCount + " amount\n");
            mainMenu();
        }
        submitManager.fromInventoryToCArt(inventory, cart, selectedGood, userInputCount);
        System.out.print("\n" + inventory);
        mainMenu();
    }

    private static void removeItemsFromCart() {
        System.out.print("Enter your Goods ID that you want to Remove: ");
        String userInputID = new Scanner(System.in).nextLine();
        if (cart.search(userInputID) == null) {
            System.err.println("Didn't found Goods you want!");
            mainMenu();
        }
        Goods selectedGood = cart.search(userInputID);
        System.out.print("How manny of " + userInputID + " do you want to Remove? ");
        int userInputCount = new Scanner(System.in).nextInt();
        if (cart.checkGoodsLeft(selectedGood, userInputCount)) {
            System.err.println("sorry you don't have " + userInputID
                    + " in " + userInputCount + " amount\n");
            mainMenu();
        }
        selectedGood.setCountInventory(selectedGood.getCountInventory()+userInputCount);
        selectedGood.setContInProgress(selectedGood.getContInProgress()-userInputCount);
        inventoryMenu();
    }

    private static void removeItemFromInventory(){
        System.out.print("Enter your Goods ID that you want to Remove: ");
        String userInputID = new Scanner(System.in).nextLine();
        if (inventory.search(userInputID) == null) {
            System.err.println("Didn't found Goods you want!");
            inventoryMenu();
        }
        Goods selectedGood = inventory.search(userInputID);
        System.out.print("How manny of " + userInputID + " do you want to Remove? ");
        int userInputCount = new Scanner(System.in).nextInt();
        if (inventory.checkGoodsLeft(selectedGood, userInputCount)) {
            System.err.println("sorry you don't have " + userInputID
                    + " in " + userInputCount + " amount\n");
            inventoryMenu();
        }
        selectedGood.setCountInventory(selectedGood.getCountInventory()-userInputCount);
        inventoryMenu();
    }

    private static void submitTheCart() {
        System.out.print("\n" + cart);
        submitManager.submit(cart, inventory);
    }


}
