package Repository;

import Model.BirthdayCake;

import java.io.*;
import java.util.Map;

public class CakeRepoSerialization extends AbstractRepository<BirthdayCake, Integer> {

    private String filename;

    public CakeRepoSerialization(String filename) {
        this.filename = filename;
        readFromFile();
    }


    @SuppressWarnings("unchecked")
    private void readFromFile() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            elem = (Map<Integer, BirthdayCake>) in.readObject();
        } catch (IOException | ClassNotFoundException err) {
            System.out.println("Error reading from file : " + err);
        }

    }

    @Override
    public void add(BirthdayCake cake) throws RuntimeException{
        try {
            super.add(cake);
            writeToFile();
        } catch (RuntimeException | IOException e) {
            System.out.println("Object wasn't added : " + e);
        }
    }

    public void writeToFile() throws IOException{
        try (ObjectOutputStream e = new ObjectOutputStream(new FileOutputStream(filename))) {
            e.writeObject(elem);
        } catch (IOException r) {
            System.out.println(r);
        }
    }


    @Override
    public void delete(BirthdayCake cake) throws RuntimeException{
        try {
            super.delete(cake);
            writeToFile();
        } catch (RuntimeException | IOException ex) {
            System.out.println("Object was not deleted : " + ex);
        }
    }

    @Override
    public void update(BirthdayCake cake, Integer id) throws RuntimeException {
        try {
            super.update(cake, id);
            writeToFile();
        } catch (RuntimeException | IOException ex) {
            System.out.println("Object was not updated : " + ex);
        }
    }
}