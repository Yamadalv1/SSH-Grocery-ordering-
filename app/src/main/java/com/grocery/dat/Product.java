package app.src.main.java.com.grocery.dat;


public class Product {
    private int id;
    private String name;
    private double price;
    private Double previousPrice;
    private boolean available;
    private String category;
    private double discount;
    private String description;
    private String source;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Double getPreviousPrice(){
        return previousPrice;
    }

    public void setPreviousPrice(Double previousPrice){
        this.previousPrice = previousPrice;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public double getDiscount(){
        return discount;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

}