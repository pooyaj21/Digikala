package util;

import Manager.CartManager;
import Manager.InventoryManager;
import Manager.SubmitManager;
import model.Goods;

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
                        System.out.println("Wrong entry!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    private static void inventoryMenu() {
        System.out.print("\n"+inventory);
        String[] MainOptions = {"\n1- Buy",
                "2- Return to Main menu",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 2) {
            printMenu(MainOptions);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        buyItems();
                        break;
                    case 2:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Wrong entry!");
                        System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    private static void cartMenu() {
        System.out.print("\n"+cart);
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
                        removeItems();
                        break;
                    case 3:
                        submitTheCart();
                        break;
                    case 4:
                        mainMenu();
                        break;
                    default:
                        System.out.println("Wrong entry!");
                        System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    public static void ExchangeToFile(){
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
                        System.out.println("Wrong entry!");
                        System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + MainOptions.length);
                scanner.next();
            }
        }
    }

    private static void buyItems() {
        System.out.print("Enter your Goods ID that you want to Add: ");
        String userInputID = new Scanner(System.in).nextLine();
        if (inventory.search(userInputID) == null) {
            System.err.println("Didn't found Goods you want!");
            inventoryMenu();
        }
        Goods selectedGood = inventory.search(userInputID);
        System.out.print("How manny of " + userInputID + " do you want to Add? ");
        int userInputCount = new Scanner(System.in).nextInt();
        if (!inventory.checkGoodsLeftInInventory(selectedGood, userInputCount)) {
            System.err.println("sorry we don't have " + userInputID
                    + " in " + userInputCount + " amount\n");
            inventoryMenu();
        }
        submitManager.fromInventoryToCArt(inventory, cart, selectedGood, userInputCount);
        System.out.print("\n"+inventory);
    }

    private static void removeItems(){
        System.out.print("Enter your Goods ID that you want to Remove: ");
        String userInputID = new Scanner(System.in).nextLine();
        if (cart.search(userInputID) == null) {
            System.err.println("Didn't found Goods you want!");
            cartMenu();
        }
        Goods selectedGood = inventory.search(userInputID);
        System.out.print("How manny of " + userInputID + " do you want to Remove? ");
        int userInputCount = new Scanner(System.in).nextInt();
        if (cart.checkGoodsLeftInCart(selectedGood, userInputCount)) {
            System.err.println("sorry you don't have " + userInputID
                    + " in " + userInputCount + " amount\n");
            cartMenu();
        }
        submitManager.fromCartToInventory(inventory, cart, selectedGood, userInputCount);
        System.out.print("\n"+cart);
    }

    private static void submitTheCart() {
        System.out.print("\n"+cart);
        submitManager.submit(cart,inventory);
    }

    

}
