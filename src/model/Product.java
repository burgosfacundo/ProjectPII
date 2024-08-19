package model;

public class Product {
    private static int lastId = 0;
    private final int id;
    private String title;
    private Float price;
    private String description;

    public Product(String title, Float price, String description) {
        this.id = lastId++;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public int getId(){return id;}
    public String getTitle() {
        return title;
    }
    public Float getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

