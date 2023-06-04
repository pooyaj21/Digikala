package util;

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
