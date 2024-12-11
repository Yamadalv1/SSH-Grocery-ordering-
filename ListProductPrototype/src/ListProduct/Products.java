package ListProductPrototype.src.ListProduct;

public class Products {
    private int id;
    private String name;
    private double price;
    private double previousPrice;
    private boolean available;
    private String category;
    private double discount;
    private String description;
    private String source;
    private String imagePath;

    public Products(int id, String name, double price, double previousPrice, boolean available,
                   String category, double discount, String description, String source, String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.previousPrice = previousPrice;
        this.available = available;
        this.category = category;
        this.discount = discount;
        this.description = description;
        this.source = source;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public double getPreviousPrice() {
        return previousPrice;
    }

    public String getImagePath() {
        return imagePath;
    }
}
