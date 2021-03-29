package BusinessLayer;

import DataLayer.RestaurantSerializer;

import java.io.BufferedWriter;
import java.io.IOException;

public class Stop extends Thread {
    private BufferedWriter buffWriter;

    public Stop(BufferedWriter bufferedWriter) {
        this.buffWriter = bufferedWriter;
    }

    public void run() {
        RestaurantSerializer.exportMenu();

        try {
            buffWriter.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

