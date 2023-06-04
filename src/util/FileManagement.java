package util;

import Manager.InventoryManager;
import model.Expirable;
import model.Food;
import model.Fruit;
import model.Goods;
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

    public void readFromFile(InventoryManager inventory){
        try {BufferedReader reader = new BufferedReader(new FileReader("InventorySource.txt"));
            String readLine;
            while ((readLine = reader.readLine()) != null){
                Goods good;
                //if (readLine.contains("FFR")good=new Fruit(reader.)//most read next line for count
                // and next line for add time
            }
        }catch (IOException e) {e.printStackTrace();}
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

}
