package Repository;

import Model.Order;

import java.io.*;
import java.util.Map;

public class OrderRepoSerialization extends AbstractRepository<Order, Integer> {

    private String filename;
    @SuppressWarnings("unused")
    private CakeRepoSerialization cakeRepoS;

    public OrderRepoSerialization(String filename, CakeRepoSerialization cakeRepoS) {
        this.filename = filename;
        this.cakeRepoS = cakeRepoS;
        readFromFile();
    }

    @SuppressWarnings("unchecked")
    private void readFromFile() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            elem = (Map<Integer, Order>) in.readObject();
        }
        catch(IOException|ClassNotFoundException e) {
            System.out.println("Error reading from file : " + e);
        }
    }

    private void writeToFile(){
        try(ObjectOutputStream e=new ObjectOutputStream(new FileOutputStream(filename)))
        {
            e.writeObject(elem);
        }
        catch(IOException r){
            System.out.println(r);
        }
    }

    @Override
    public void add(Order order) {
        try {
            super.add(order);
            writeToFile();
        } catch (RuntimeException e) {
            System.out.println("Object wasn't added" + e);
        }
    }

    @Override
    public void delete(Order order) {
        try {
            super.delete(order);
            writeToFile();
        } catch (RuntimeException ex) {
            System.out.println("Object was not deleted" + ex);
        }
    }

    @Override
    public void update(Order order, Integer id) {
        try {
            super.update(order, id);
            writeToFile();
        } catch (RuntimeException ex) {
            System.out.println("Object was not updated" + ex);
        }
    }


}

