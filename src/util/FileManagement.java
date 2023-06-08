package util;

import Manager.InventoryManager;
import model.*;

import java.io.*;
import java.util.ArrayList;
public class FileManagement {
    static int cartCounter=1;
    public static void writeInventory(ArrayList<Goods> inventoryList){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Inventory.txt"));
            for (int i = 0; i < inventoryList.size(); i++) {
                writer.write((i+1)+". "+inventoryList.get(i).toStringForInventory());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e) {e.printStackTrace();}
    }

    public static void writeInventoryForSave(ArrayList<Goods> inventoryList){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("InventorySource.txt"));
            for (Goods good:inventoryList) {
                writer.write(good.getId());
                writer.newLine();
                writer.write(good.getCountInventoryToString());
                writer.newLine();
                if(good instanceof Expirable){
                    writer.write(((Food) good).getAddedTimeInSecondsToString());
                    writer.newLine();
                }
            }
            writer.close();
        }catch (IOException e) {e.printStackTrace();}
    }

    public static void readFromFile(InventoryManager inventory){
        ArrayList<String> a = new ArrayList<>();
        try {BufferedReader reader = new BufferedReader(new FileReader("InventorySource.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null){
                a.add(readLine);
            }
        }catch (IOException e) {e.printStackTrace();}
        for (int i = 0; i <a.size(); i++) {
            if(a.get(i).contains("FR")){
                inventory.addGoods(
                        new Fruit(Integer.parseInt(a.get(i+1)),Integer.parseInt(a.get(i+2))));
            } else if (a.get(i).contains("DR")) {
                inventory.addGoods(
                        new Drink(Integer.parseInt(a.get(i+1)),Integer.parseInt(a.get(i+2))));
            }else if(a.get(i).contains("NF")){
                inventory.addGoods(new NonFood(Integer.parseInt(a.get(i+1))));
            }
        }

    }

    public static void writeCart(ArrayList<Goods> cart){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Cart"+cartCounter+".txt"));
            for (int i = 0; i < cart.size(); i++) {
                writer.write((i+1)+". "+cart.get(i).toStringForCart());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e) {e.printStackTrace();}
        cartCounter++;
    }

    public static Boolean seeFileIsEmpty() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("InventorySource.txt"));
            if (reader.readLine() == null) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
