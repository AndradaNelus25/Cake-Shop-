package Repository;

import Model.BirthdayCake;
import Model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderRepositoryFile extends AbstractRepository<Order, Integer> {

    private String filename;
    private CakeRepositoryFile cakeRepo;

    public OrderRepositoryFile(String filename, CakeRepositoryFile cakeRepo) {
        this.filename = filename;
        this.cakeRepo = new CakeRepositoryFile("/Users/andradanelus/Downloads/lab6/src/main/java/cakes.txt");
        readFromFile();
    }

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(",");
                if (el.length != 7) {
                    System.err.println("Not a valid number of atributes" + line);
                    continue;
                }
                try {
                    Integer Id = Integer.parseInt(el[0]);
                    int phoneNumber = Integer.parseInt(el[6]);
                    int weight = Integer.parseInt(el[4]);
                    BirthdayCake b = cakeRepo.findById(Integer.parseInt(el[2]));
                    Model.Order o = new Model.Order(Id, el[1], b, el[3], weight, el[5], phoneNumber);
                    super.add(o);
                } catch (NumberFormatException n) {
                    System.err.println("The ID is not a valid number" + el[0]);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading from file : " + ex);
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

    private void writeToFile() {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (Order el : findAll()) {
                String line = el.getID() + "," + el.getName() + "," + el.getCake().getID() + ","+ el.getDeliveryDate() + "," + el.getWeight() + "," + el.getBirthdayWish() + "," + el.getPhoneNumber();
                pw.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex);
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

