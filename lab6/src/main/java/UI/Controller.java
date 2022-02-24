package UI;

import Model.BirthdayCake;
import Model.Order;
import Repository.CakeRepositoryFile;
import Repository.OrderRepositoryFile;
import Service.ServiceCakes;
import Service.ServiceOrders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class Controller {
    /** ADD BUTTONS **/
    @FXML
    private javafx.scene.control.Button addCake;
    @FXML
    private javafx.scene.control.Button addOrder;

    /** CAKE TEXT FIELDS (ADD) **/
    @FXML
    private javafx.scene.control.TextField NameCake;
    @FXML
    private javafx.scene.control.TextField FillingCake;
    @FXML
    private javafx.scene.control.TextField FrostingCake;
    @FXML
    private javafx.scene.control.TextField PriceCake;


    /** ORDER TEXT FIELDS (ADD) **/
    @FXML
    private javafx.scene.control.TextField Customer;
    @FXML
    private javafx.scene.control.TextField phone;
    @FXML
    private javafx.scene.control.TextField wish;
    @FXML
    private javafx.scene.control.TextField weigth;
    @FXML
    private javafx.scene.control.DatePicker date;
    @FXML
    private javafx.scene.control.TextField CakeID;


    /** CAKE TABLE (ALL) **/
    @FXML
    private javafx.scene.control.TableView<BirthdayCake> cakeTableView;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, Integer> id_cake;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, String> name_cake;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, String> filling_cake;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, String> frosting_cake;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, Integer> price_cake;

    /** ORDER TABLE (ALL) **/
    @FXML
    private javafx.scene.control.TableView<Order> orderTableView;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> id_order;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> name_order;
    @FXML
    private javafx.scene.control.TableColumn<Order, BirthdayCake> cake_order;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> delivery_order;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> weigth_order;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> wish_order;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> phone_order;

    /** ID REMOVE **/
    @FXML
    private javafx.scene.control.TextField id_removeCake;

    @FXML
    private javafx.scene.control.TextField id_removeOrder;


    /** CLEAR FIELDS BUTTONS **/
    @FXML
    private javafx.scene.control.Button clear1;

    @FXML
    private javafx.scene.control.Button clear2;


    /** REMOVE BUTTONS **/
    @FXML
    private javafx.scene.control.Button removeCakeButton;

    @FXML
    private javafx.scene.control.Button removeOrderButton;

    /** CAKE UPDATE **/
    @FXML
    private javafx.scene.control.TextField id_updateCake;

    @FXML
    private javafx.scene.control.TextField cake_update;

    @FXML
    private javafx.scene.control.TextField filling_update;

    @FXML
    private javafx.scene.control.TextField frosting_update;

    @FXML
    private javafx.scene.control.TextField price_update;

    @FXML
    private javafx.scene.control.Button cakeUpdateButton;


    /** ORDER UPDATE **/
    @FXML
    private javafx.scene.control.TextField id_updateOrder;

    @FXML
    private javafx.scene.control.TextField order_update;

    @FXML
    private javafx.scene.control.TextField phone_update;

    @FXML
    private javafx.scene.control.TextField wish_update;

    @FXML
    private javafx.scene.control.TextField weigth_update;

    @FXML
    private javafx.scene.control.TextField cakeID_update;

    @FXML
    private javafx.scene.control.DatePicker delivery_update;

    @FXML
    private javafx.scene.control.Button orderUpdateButton;

    /** CAKE CHEAPER THAN PRICE REPORT **/
    @FXML
    private javafx.scene.control.TextField cheaperThan;

    @FXML
    private javafx.scene.control.TableView<BirthdayCake> CakeReportTableView;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, Integer> CakeReportID;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, String> CakeReportName;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, String> CakeReportFilling;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, String> CakeReportFrosting;
    @FXML
    private javafx.scene.control.TableColumn<BirthdayCake, Integer> CakeReportPrice;

    /** ORDER OF CERTAIN CAKE REPORT **/

    @FXML
    private javafx.scene.control.TextField orderOfCake;

    @FXML
    private javafx.scene.control.TableView<Order> OrderOfCakeReportTableView;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> OrderRep1ID;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> OrderRep1Customer;
    @FXML
    private javafx.scene.control.TableColumn<Order, BirthdayCake> OrderRep1Cake;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> OrderRep1Deliver;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> OrderRep1Weigth;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> OrderRep1Wish;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> OrderRep1Phone;
    @FXML
    private javafx.scene.control.Button OrderRep1Button;

    /** ORDER OF CERTAIN DELIVERY DATE REPORT **/

    @FXML
    private javafx.scene.control.DatePicker dateDeliveredBy;

    @FXML
    private javafx.scene.control.TableView<Order> OrderOfDateReportTableView;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> OrderRep2ID;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> OrderRep2Customer;
    @FXML
    private javafx.scene.control.TableColumn<Order, BirthdayCake> OrderRep2Cake;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> OrderRep2Deliver;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> OrderRep2Weigth;
    @FXML
    private javafx.scene.control.TableColumn<Order, String> OrderRep2Wish;
    @FXML
    private javafx.scene.control.TableColumn<Order, Integer> OrderRep2Phone;
    @FXML
    private javafx.scene.control.Button OrderRep2Button;




    private CakeRepositoryFile cakesFile;
    private OrderRepositoryFile ordersFile;
    private final ServiceCakes CakesService;
    private final ServiceOrders OrdersService;
    private final ObservableList<BirthdayCake> Cakelist;
    private final ObservableList<Order> Orderlist;
    private final ObservableList<BirthdayCake> CakeReportList;
    private final ObservableList<Order> OrderReportList1;
    private final ObservableList<Order> OrderReportList2;

    public Controller(){
        this.CakesService = new ServiceCakes();
        this.OrdersService = new ServiceOrders();
        this.Cakelist = FXCollections.observableArrayList();
        this.Orderlist = FXCollections.observableArrayList();
        this.CakeReportList = FXCollections.observableArrayList();
        this.OrderReportList1 = FXCollections.observableArrayList();
        this.OrderReportList2 = FXCollections.observableArrayList();
        this.cakesFile = new CakeRepositoryFile("/Users/andradanelus/Downloads/lab6/src/main/java/cakes.txt");
        this.ordersFile = new OrderRepositoryFile("/Users/andradanelus/Downloads/lab6/src/main/java/orders.txt", cakesFile);
    }

    @SuppressWarnings("unchecked")
    @FXML
    private void initialize(){
        id_cake.setCellValueFactory(new PropertyValueFactory<>("ID"));
        name_cake.setCellValueFactory(new PropertyValueFactory<>("name"));
        filling_cake.setCellValueFactory(new PropertyValueFactory<>("filling"));
        frosting_cake.setCellValueFactory(new PropertyValueFactory<>("frosting"));
        price_cake.setCellValueFactory(new PropertyValueFactory<>("price"));

        for (BirthdayCake elem : cakesFile.findAll()){
            CakesService.add(elem);
        }

        for (BirthdayCake elem : CakesService.findAll()){
            Cakelist.add(elem);
        }

        cakeTableView.setItems(Cakelist);
        /*cakeTableView.getSelectionModel().selectedItemProperty().addListener((observable,oldItem,newItem)->showCake(newItem));*/
        cakeTableView.getColumns().setAll(id_cake, name_cake, filling_cake, frosting_cake, price_cake);

        id_order.setCellValueFactory(new PropertyValueFactory<>("ID"));
        name_order.setCellValueFactory(new PropertyValueFactory<>("name"));
        cake_order.setCellValueFactory(new PropertyValueFactory<>("cake"));
        delivery_order.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        weigth_order.setCellValueFactory(new PropertyValueFactory<>("weight"));
        wish_order.setCellValueFactory(new PropertyValueFactory<>("birthdayWish"));
        phone_order.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));


        for (Order elem : ordersFile.findAll()){
            OrdersService.add(elem);
        }

        for(Order elem : OrdersService.findAll()){
            Orderlist.add(elem);
        }

        orderTableView.setItems(Orderlist);
        /*orderTableView.getSelectionModel().selectedItemProperty().addListener((observable,oldItem,newItem)->showOrder(newItem));*/
        /*orderTableView.getColumns().setAll(id_order, name_order, cake_order, delivery_order, weigth_order, wish_order, phone_order);*/

        CakeReportID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        CakeReportName.setCellValueFactory(new PropertyValueFactory<>("name"));
        CakeReportFilling.setCellValueFactory(new PropertyValueFactory<>("filling"));
        CakeReportFrosting.setCellValueFactory(new PropertyValueFactory<>("frosting"));
        CakeReportPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        OrderRep1ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        OrderRep1Customer.setCellValueFactory(new PropertyValueFactory<>("name"));
        OrderRep1Cake.setCellValueFactory(new PropertyValueFactory<>("cake"));
        OrderRep1Deliver.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        OrderRep1Weigth.setCellValueFactory(new PropertyValueFactory<>("weight"));
        OrderRep1Wish.setCellValueFactory(new PropertyValueFactory<>("birthdayWish"));
        OrderRep1Phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        OrderRep2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        OrderRep2Customer.setCellValueFactory(new PropertyValueFactory<>("name"));
        OrderRep2Cake.setCellValueFactory(new PropertyValueFactory<>("cake"));
        OrderRep2Deliver.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        OrderRep2Weigth.setCellValueFactory(new PropertyValueFactory<>("weight"));
        OrderRep2Wish.setCellValueFactory(new PropertyValueFactory<>("birthdayWish"));
        OrderRep2Phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    }


    @FXML
    private void AddCakeButton() throws RuntimeException{
    try {
        Integer ID = 0;

        String nameCake = NameCake.getText();
        if (nameCake.isEmpty()) {
            NameCake.setStyle("-fx-border-color: red;");
            return;
        } else {
            NameCake.setStyle("-fx-border-color: none;");
        }

        String fillingCake = FillingCake.getText();
        if (fillingCake.isEmpty()) {
            FillingCake.setStyle("-fx-border-color: red;");
            return;
        } else {
            FillingCake.setStyle("-fx-border-color: none;");
        }

        String frostingCake = FrostingCake.getText();
        if (frostingCake.isEmpty()) {
            FrostingCake.setStyle("-fx-border-color: red;");
            return;
        } else {
            FrostingCake.setStyle("-fx-border-color: none;");
        }

        String priceCake = PriceCake.getText().toString();
        if (priceCake.isEmpty()) {
            PriceCake.setStyle("-fx-border-color: red;");
            return;
        } else {
            PriceCake.setStyle("-fx-border-color: none;");
        }

        for (BirthdayCake elem : CakesService.findAll()) {
            if (elem.getID() > ID) {
                ID = elem.getID();
            }
        }
        BirthdayCake b = new BirthdayCake(ID + 1, nameCake, fillingCake, frostingCake, Integer.parseInt(priceCake));
        this.CakesService.add(b);
        this.Cakelist.add(b);
        this.cakesFile.add(b);
    }
        catch (RuntimeException r){
            System.out.println(r);
        }

        /*System.out.println();
        System.out.println("Cake repository : ");
        System.out.println();
        System.out.println(this.CakesService.findAll().toString());
        System.out.println();*/
    }

    @FXML
    private void AddOrderButton() throws IOException {
            Integer ID = 0;

            String name = Customer.getText();
            if (name.isEmpty()) {
                Customer.setStyle("-fx-border-color: red;");
                return;
            } else {
                Customer.setStyle("-fx-border-color: none;");
            }

            int cake = Integer.parseInt(CakeID.getText());
            BirthdayCake b = CakesService.findById(cake);




            String deliveryDate = date.getValue().toString();
            if (deliveryDate.toString().isEmpty()) {
                date.setStyle("-fx-border-color: red;");
                return;
            } else {
                date.setStyle("-fx-border-color: none");
            }

            String weigthCake = weigth.getText();
            if (weigthCake.isEmpty()) {
                weigth.setStyle("-fx-border-color: red;");
                return;
            } else {
                weigth.setStyle("-fx-border-color: none");
            }

            String birthdayWish = wish.getText();
            if (birthdayWish.isEmpty()) {
                wish.setStyle("-fx-border-color: red;");
                return;
            } else {
                wish.setStyle("-fx-border-color: none");
            }

            String phoneNr = phone.getText();
            if (phoneNr.isEmpty()) {
                phone.setStyle("-fx-border-color: red;");
                return;
            } else {
                phone.setStyle("-fx-border-color: none");
            }

            for (Order elem : OrdersService.findAll()) {
                if (elem.getID() > ID) {
                    ID = elem.getID();
                }
            }

            Order o = new Order(ID + 1, name, b, deliveryDate, Integer.parseInt(weigthCake), birthdayWish, Integer.parseInt(phoneNr));
            this.OrdersService.add(o);
            this.Orderlist.add(o);
            this.ordersFile.add(o);

    }

    @FXML
    private void removeCake(){
        Integer id = Integer.parseInt(id_removeCake.getText());
        for(BirthdayCake elem: CakesService.findAll()){
            if(elem.getID()==id){
                this.CakesService.delete(elem);
                this.Cakelist.remove(elem);
                this.cakesFile.delete(elem);
            }
        }

    }

    @FXML
    private void removeOrder(){
        Integer id = Integer.parseInt(id_removeOrder.getText());
        for(Order elem: OrdersService.findAll()){
            if(elem.getID()==id){
                this.OrdersService.delete(elem);
                this.Orderlist.remove(elem);
                this.ordersFile.delete(elem);
            }
        }

    }

    @FXML
    private void cakeUpdate(){
        Integer id = Integer.parseInt(id_updateCake.getText());

        String nameCake = cake_update.getText();
        if (nameCake.isEmpty()) {
            cake_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            cake_update.setStyle("-fx-border-color: none;");
        }

        String fillingCake = filling_update.getText();
        if (fillingCake.isEmpty()) {
            filling_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            filling_update.setStyle("-fx-border-color: none;");
        }

        String frostingCake = frosting_update.getText();
        if (frostingCake.isEmpty()) {
            frosting_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            frosting_update.setStyle("-fx-border-color: none;");
        }

        String priceCake = price_update.getText().toString();
        if (priceCake.isEmpty()) {
            price_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            price_update.setStyle("-fx-border-color: none;");
        }


        for(BirthdayCake elem: CakesService.findAll()){
            if(elem.getID()==Integer.parseInt(id_updateCake.getText())){
                BirthdayCake b = new BirthdayCake(Integer.parseInt(id_updateCake.getText()), nameCake, fillingCake, frostingCake, Integer.parseInt(priceCake));
                this.CakesService.update(b,Integer.parseInt(id_updateCake.getText()));
                this.Cakelist.set(Integer.parseInt(id_updateCake.getText()),b);
                this.cakesFile.update(b, Integer.parseInt(id_updateCake.getText()));
            }
        }
    }

    @FXML
    private void orderUpdate(){
        Integer id = Integer.parseInt(id_updateOrder.getText());

        String name = order_update.getText();
        if (name.isEmpty()) {
            order_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            order_update.setStyle("-fx-border-color: none;");
        }

        /*String id_cakeUpdate = id_updateCake.getText();
        if (id_cakeUpdate.isEmpty()) {
            id_updateCake.setStyle("-fx-border-color: red;");
            return;
        } else {
            id_updateCake.setStyle("-fx-border-color: none;");
        }*/

        BirthdayCake cake = CakesService.findById(Integer.parseInt(cakeID_update.getText()));

        String deliveryDate = delivery_update.getValue().toString();
        if (deliveryDate.toString().isEmpty()) {
            delivery_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            delivery_update.setStyle("-fx-border-color: none");
        }

        String weigthCake = weigth_update.getText();
        if (weigthCake.isEmpty()) {
            weigth_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            weigth_update.setStyle("-fx-border-color: none");
        }

        String birthdayWish = wish_update.getText();
        if (birthdayWish.isEmpty()) {
            wish_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            wish_update.setStyle("-fx-border-color: none");
        }

        String phoneNr = phone_update.getText();
        if (phoneNr.isEmpty()) {
            phone_update.setStyle("-fx-border-color: red;");
            return;
        } else {
            phone_update.setStyle("-fx-border-color: none");
        }

        Order o = new Order(id, name, cake, deliveryDate, Integer.parseInt(weigthCake), birthdayWish, Integer.parseInt(phoneNr));
        for(Order elem: OrdersService.findAll()){
            if(elem.getID()==id){
                this.OrdersService.update(o,id);
                this.Orderlist.set(id,o);
                this.ordersFile.update(o, id);
            }
        }

    }

    @SuppressWarnings("unchecked")
    @FXML
    private void CakeReport(){
        String price = cheaperThan.getText();

        for (BirthdayCake elem : CakesService.findAll()){
            if (elem.getPrice() < Integer.parseInt(price)) {
                CakeReportList.add(elem);
            }
        }

        CakeReportTableView.setItems(CakeReportList);
        CakeReportTableView.getColumns().setAll(CakeReportID, CakeReportName, CakeReportFilling, CakeReportFrosting, CakeReportPrice);

    }

    @SuppressWarnings("unchecked")
    @FXML
    private void OrderReport1(){
        String cake = orderOfCake.getText();

        for (Order elem: OrdersService.findAll()){
            if(elem.getCake().getName().equals(orderOfCake.getText())){
                OrderReportList1.add(elem);
            }
        }
        OrderOfCakeReportTableView.setItems(OrderReportList1);
        OrderOfCakeReportTableView.getColumns().setAll(OrderRep1ID, OrderRep1Customer, OrderRep1Cake, OrderRep1Deliver, OrderRep1Weigth, OrderRep1Wish, OrderRep1Phone);
    }

    @SuppressWarnings("unchecked")
    @FXML
    private void OrderReport2(){
        String date = dateDeliveredBy.getValue().toString();

        for (Order elem: OrdersService.findAll()){
            if(elem.getDeliveryDate().equals(date)){
                OrderReportList2.add(elem);
            }
        }
        OrderOfDateReportTableView.setItems(OrderReportList2);
        OrderOfDateReportTableView.getColumns().setAll(OrderRep2ID, OrderRep2Customer, OrderRep2Cake, OrderRep2Deliver, OrderRep2Weigth, OrderRep2Wish, OrderRep2Phone);
    }


    @FXML
    private void clearFields1(){
        PriceCake.clear();
        NameCake.clear();
        FillingCake.clear();
        FrostingCake.clear();
        id_removeCake.clear();
    }

    @FXML
    private void clearFields2(){
        Customer.clear();
        phone.clear();
        wish.clear();
        weigth.clear();
        date.getEditor().clear();
        id_removeOrder.clear();
        CakeID.clear();
    }


}
