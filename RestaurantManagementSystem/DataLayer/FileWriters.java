package DataLayer;


import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;
import BusinessLayer.Stop;

import java.io.*;
import java.util.List;

public class FileWriters {
    private static BufferedWriter buffWriter;

    public static void initializareBuffer() {
        try {
            buffWriter = new BufferedWriter(new FileWriter("bills.txt"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Stop(buffWriter));
    }
    
    public static String generateBill(Order order) {
        try {
            String afis = "\nORDER " + order.getOrderID() + ":\nTable: " + order.getTable() + "   -   " + order.getDate() + "\n";
            List<MenuItem> menuItems = order.getListOfItems();
            int total = 0;
            for (int i = 0; i < menuItems.size(); i++) {
                int quantity = 1;
                while (i != menuItems.size() - 1 && menuItems.get(i).getName().compareTo(menuItems.get(i + 1).getName()) == 0) {
                    quantity++;
                    i++;
                }
                MenuItem menuItem = Restaurant.getItem(menuItems.get(i).getName());
                afis = afis.concat(
                        menuItem.getName() + " - " + menuItem.computePrice() + " RON x" + quantity + "\n");
                total += menuItem.computePrice() * quantity;
            }
            afis = afis.concat("\nTOTAL: " + total + " RON\nVa multumim!\n");
            buffWriter.append(afis);
            return afis;
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }


    static void importMenu() {
        try {
            File file = new File("restaurant.ser");
            if (!file.createNewFile() && file.length() != 0) { 
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                while (true) {
                    try {
                        MenuItem menuItem = (MenuItem) objectInputStream.readObject();
                        Restaurant.createItem(menuItem);
                    } catch (StreamCorruptedException | EOFException e) {
                        break;
                    } catch (ClassNotFoundException e) {
                        System.out.println(e.toString());
                    }
                }
                fileInputStream.close();
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void exportMenu() {
        File file = new File("restaurant.ser");

        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            List<MenuItem> menuItems = Restaurant.getMenuItems();
            for (MenuItem menuItem : menuItems) {
                objectOutputStream.writeObject(menuItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}