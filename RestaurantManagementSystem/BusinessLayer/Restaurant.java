package BusinessLayer;

import DataLayer.FileWriters;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Restaurant implements RestaurantProcessing {
	
    private static Map<Order, Collection<MenuItem>> orders = new HashMap<>();
    private static List<MenuItem> produse = new ArrayList<>();

    public static void createItem(MenuItem menuItem) {
        assert menuItem != null;
        assert produse != null;
        produse.add(menuItem);

        assert produse.size() > 0;
    }

    public static void deleteItem(MenuItem menuItem) {
        assert menuItem != null;
        assert produse != null;
        produse.remove(getItem(menuItem.getName()));
    }

    public static Order getOrder(int orderID) {
        List<Order> orderList = createOrderList();
        for (Order order : orderList) {
            if (order.getOrderID() == orderID)
                return order;
        }

        return null;
    }
    
    public static void createOrder(Order order) {
        assert order != null;
        orders.put(order, order.getMenuItems());
        assert orders.size() > 0;
    }

    
    public static JTable createOrdersTable() {
        List<Order> orderList = createOrderList();
        JTable table;
        String[] columnNames = {"Id", "Table", "Date"};
        Object[][] comenzi = new Object[orderList.size()][3];

        for (int i = 0; i < orderList.size(); i++) {
            comenzi[i][0] = orderList.get(i).getOrderID();
            comenzi[i][1] = orderList.get(i).getTable();
            comenzi[i][2] = orderList.get(i).getDate();
        }

        table = new JTable(comenzi, columnNames);
        table.setDefaultEditor(Object.class, null);
        return table;
    }

    public static void deleteOrder(Order order) {
        orders.remove(getOrder(order.getOrderID()));
    }

    public static JTable createTable() {
        JTable table;

        String[] columnNames = {"Name", "Price", "Type"};
        Object[][] prod = new Object[produse.size()][3];

        for (int i = 0; i < produse.size(); i++) {
            prod[i][0] = produse.get(i).getName();
            prod[i][1] = produse.get(i).computePrice();
            prod[i][2] = produse.get(i).getClass().getSimpleName();
        }

        table = new JTable(prod, columnNames);
        table.setDefaultEditor(Object.class, null);

        return table;
    }

    public static MenuItem getItem(String name) {
        for (MenuItem menuItem : produse) {
            if (menuItem.getName().compareTo(name) == 0)
                return menuItem;
        }

        return null;
    }

    public static List<MenuItem> getMenuItems() {
        return produse;
    }

    public static List<MenuItem> getBaseMenuItems() {
        List<MenuItem> toReturn = new ArrayList<>();

        for (MenuItem menuItem : produse) {
            if (menuItem.getClass().getSimpleName().compareTo("BaseProduct") == 0)
                toReturn.add(menuItem);
        }
        return toReturn;
    }


    public static void editItem(MenuItem menuItem, String newName, int newPrice) {
        assert menuItem != null;
        assert newPrice >= 0;
        int oldSize = produse.size();

        for (MenuItem menuItem1 : produse) {
            if (menuItem1.getName().compareTo(menuItem.getName()) == 0) {
                menuItem1.setName(newName);
                menuItem1.setPrice(newPrice);
                break;
            }
        }

        assert oldSize == produse.size();
    }

    public static List<Order> createOrderList() {
        Set<Order> orderSet = orders.keySet();
        List<Order> orderList = new ArrayList<>(orderSet);
        Collections.sort(orderList);

        return orderList;
    }
    
    public static void updatePrices() {
        for (MenuItem menuItem : produse) {
            menuItem.computePrice();
        }
    }

    public static boolean canBeDeleted(String name) {
        if (getItem(name).getClass().getSimpleName().compareTo("CompositeProduct") == 0)
            return true;

        for (MenuItem menuItem : produse) {
            if (menuItem.getClass().getSimpleName().compareTo("CompositeProduct") == 0) {
                CompositeProduct compositeProduct = (CompositeProduct) menuItem;

                List<MenuItem> ingredients = compositeProduct.getIngredients();
                for (MenuItem menuItem1 : ingredients) {
                    if (name.compareTo(menuItem1.getName()) == 0)
                        return false;
                }
            }
        }

        List<Order> orderList = createOrderList();
        for(Order order : orderList) {
            for(MenuItem menuItem : order.getListOfItems()) {
                if(menuItem.getName().compareTo(name) == 0)
                    return false;
            }
        }
        return true;
    }
    public static String generateBill(Order order) {
        assert order != null;
        return FileWriters.generateBill(order);
    }
}