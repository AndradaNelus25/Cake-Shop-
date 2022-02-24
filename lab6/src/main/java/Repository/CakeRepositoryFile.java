package Repository;

import Model.BirthdayCake;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class CakeRepositoryFile extends AbstractRepository<BirthdayCake, Integer> {

    private String filename;

    public CakeRepositoryFile(String filename) {
        this.filename = filename;
        readFromFile();
    }

    private void readFromFile(){
        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                String[] el=line.split(",");
                if(el.length!=5){
                    System.err.println("Not a valid number of atributes "+line);
                    continue;
                }
                try{
                    Integer Id=Integer.parseInt(el[0]);
                    int price = Integer.parseInt(el[4]);
                    BirthdayCake b = new BirthdayCake(Id,el[1],el[2],el[3],price);
                    super.add(b);
                }
                catch(NumberFormatException n){
                    System.err.println("The ID is not a valid number "+el[0]);
                }
            }
        }
        catch(IOException ex){
            System.out.println("Error reading from file : " + ex);
        }
    }

    @Override
    public void add(BirthdayCake cake) {
        try{
            super.add(cake);
            writeToFile();
        }
        catch(RuntimeException e){
            System.out.println("Object wasn't added" + e);
        }
    }

    private void writeToFile() {
        try(PrintWriter pw = new PrintWriter(filename)) {
            for(BirthdayCake el : findAll()) {
                String line = el.getID() + "," + el.getName() + "," + el.getFilling() + "," + el.getFrosting() + "," + el.getPrice();
                pw.println(line);
            }
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(BirthdayCake cake){
        try{
            super.delete(cake);
            writeToFile();
        }
        catch(RuntimeException ex){
            System.out.println("Object was not deleted" + ex);
        }
    }

    @Override
    public void update(BirthdayCake cake, Integer id){
        try{
            super.update(cake, id);
            writeToFile();
        }
        catch(RuntimeException ex){
            System.out.println("Object was not updated" + ex);
        }
    }


}

