package frompythontojava.onlineshop.part2;

import java.io.*;
import java.util.ArrayList;

public class OrderContainer {

    private ArrayList<Orderable> orders;

    public OrderContainer() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Orderable order) {
        this.orders.add(order);
        serializeOrders();
    }

    public ArrayList<Orderable> getOrders() {
        deserializeOrders();
        return orders;
    }

    private void serializeOrders() {

        try {
            // write object to file
            FileOutputStream fos = new FileOutputStream("src/frompythontojava/onlineshop/data/orders.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.orders);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void deserializeOrders() {

        try {
            // read object from file
            FileInputStream fis = new FileInputStream("src/frompythontojava/onlineshop/data/orders.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.orders = (ArrayList<Orderable>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
