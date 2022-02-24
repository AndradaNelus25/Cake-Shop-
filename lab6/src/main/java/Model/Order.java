package Model;

import java.io.Serializable;

public class Order implements Identifiable<Integer>, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer ID;
    private String name;
    private BirthdayCake cake;
    private String deliveryDate;
    private int weight;
    private String birthdayWish;
    private int phoneNumber;

    public Order() {
        this.ID = 0;
        this.cake = null;
        this.deliveryDate = null;
        this.phoneNumber = 0;
        this.birthdayWish = "";
        this.weight = 0;
        this.name = "";
    }

    public Order(Integer orderID, String name, BirthdayCake cake, String deliveryDate, int weight, String birthdayWish, int phoneNumber) {
        this.ID = orderID;
        this.name = name;
        this.cake = cake;
        this.deliveryDate = deliveryDate;
        this.weight = weight;
        this.birthdayWish = birthdayWish;
        this.phoneNumber = phoneNumber;
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

    public BirthdayCake getCake() {
        return cake;
    }

    public void setCake(BirthdayCake cake) {
        this.cake = cake;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBirthdayWish() {
        return birthdayWish;
    }

    public void setBirthdayWish(String birthdayWish) {
        this.birthdayWish = birthdayWish;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Model.Order " + this.ID + " : Cake ID : " + this.cake.getID() + ", from : " + this.name + ", phone number : " + this.phoneNumber +  ", has weight : "+ this.weight + " and birthday wish : " + this.birthdayWish + ", to be delivered on : " + this.deliveryDate;
    }



}
