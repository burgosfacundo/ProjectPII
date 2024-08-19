package model;

import java.util.HashSet;
import java.util.Set;

public class Client {
    private static int lastId = 0;
    private final int id;
    private String name;
    private String lastName;
    private String city;
    private String postalCode;
    private String address;
    private StatusClient statusClient;
    private Set<Order> orders = new HashSet<>();

    public Client(String name, String lastName, String city, String postalCode, String address) {
        this.id = lastId++;
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.statusClient = StatusClient.ACTIVE;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCity() {
        return city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getAddress() {
        return address;
    }
    public StatusClient getStatusClient(){ return statusClient; }
    public Set<Order> getOrders() {
        return orders;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void inactive(){ this.statusClient = StatusClient.INACTIVE; }
    public void active(){ this.statusClient = StatusClient.ACTIVE; }
    public void addOrder(Order order) {
        this.orders.add(order);
    }
    public void subtractOrder(Order order){
        this.orders.remove(order);
    }
}
