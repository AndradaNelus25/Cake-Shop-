package Model;

import java.io.Serializable;

public class BirthdayCake implements Identifiable<Integer>, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer ID;
    private String name;
    private String filling;
    private String frosting;
    private int price;

    public BirthdayCake() {
        this.setID(0);
        this.setName("");
        this.setFilling("");
        this.setFrosting("");
        this.setPrice(0);
    }

    public BirthdayCake(Integer ID, String name, String filling, String frosting, int price) {
        this.setID(ID);
        this.setFilling(filling);
        this.setFrosting(frosting);
        this.setName(name);
        this.setPrice(price);
    }

    public String getFrosting() {
        return frosting;
    }

    public void setFrosting(String frosting) {
        this.frosting = frosting;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void setID(Integer id) {
        ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String toString() {
        return "Cake " + this.ID + " : " + this.name + ", has frosting : " + this.frosting + ", filling : " + this.filling + " and price : " + this.price;
    }



}
