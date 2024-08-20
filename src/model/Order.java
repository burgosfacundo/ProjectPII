package model;

public class Order {
    private static int lastId = 1;
    private final int id;
    private Float total;
    private StatusOrder statusOrder;
    private Client client;
    private Product product;

    public Order(Float total, Product product,Client client) {
        this.id = lastId++;
        this.total = total;
        this.statusOrder = StatusOrder.PENDING;
        this.product = product;
        this.client = client;
        client.addOrder(this);
    }

    public int getId() {
        return id;
    }
    public Float getTotal() {
        return total;
    }
    public StatusOrder getStatusOrder() {
        return statusOrder;
    }
    public Client getClient() {
        return client;
    }
    public Product getProduct() {
        return product;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void paid(){
        this.statusOrder = StatusOrder.PAID;
    }
}
