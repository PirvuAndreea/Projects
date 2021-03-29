package BusinessLayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Order implements Comparable<Order> {
    private static int id = 0;
    private int orderID;
    private int table;
    private boolean done;
    private LocalDate data;
    private Collection<MenuItem> menuItems;


    public Order(int table, List<MenuItem> menuItems) {
        orderID = id;
        id++;
        data = LocalDate.now();
        this.table = table;
        this.menuItems = menuItems;
        done = false;
    }

   
    public int getOrderID() {
        return orderID;
    }

    public int getTable() {
        return table;
    }
    
    public int hashCode() {
        return orderID;
    }

    public LocalDate getDate() {
        return data;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
   
    public List<MenuItem> getListOfItems() {
        return new ArrayList<>(menuItems);
    }
    
    Collection<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public int compareTo(Order o) {
        Integer id1 = this.getOrderID();
        Integer id2 = o.getOrderID();
        return id1.compareTo(id2);
    }
}