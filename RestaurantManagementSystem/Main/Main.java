package Main;

import DataLayer.FileWriters;
import DataLayer.RestaurantSerializer;
import PresentationLayer.AdministratorGUI;
import PresentationLayer.ChefGUI;
import PresentationLayer.WaiterGUI;

public class Main {
    private static ChefGUI chefGUI;
    private static WaiterGUI waiterGUI;

    public static void main(String[] args) {
        FileWriters.initializareBuffer();
        RestaurantSerializer.importMenu();
        new AdministratorGUI();
        chefGUI = new ChefGUI();
        waiterGUI = new WaiterGUI();
        waiterGUI.addObserver(chefGUI);
    }
    public static void setWaiterGUI(WaiterGUI waiterG) {
        Main.waiterGUI = waiterG;
    }

    public static WaiterGUI getWaiterGUI() {
        return waiterGUI;
    }

    public static ChefGUI getChefGUI() {
        return chefGUI;
    }

    public static void setChefGUI(ChefGUI chefG) {
        Main.chefGUI = chefG;
    }

    
}