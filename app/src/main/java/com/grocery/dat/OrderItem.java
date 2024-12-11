package app.src.main.java.com.grocery.dat;


public class OrderItem {
    private int productId;
    private String productName;
    private int quantity;
    private double productPrice;
    private double totalProductPrice;

    public int getProductId(){
        return productId;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getProductPrice(){
        return productPrice;
    }

    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }

    public double getTotalProductPrice(){
        return totalProductPrice;
    }

    public void setTotalProductPrice(double productPrice, int quantity){
        this.totalProductPrice = productPrice * quantity;
    }
    
}
