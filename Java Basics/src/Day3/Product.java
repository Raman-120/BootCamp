package Day3;

public class Product {

    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;

    Product(int productId, String name, String category, double price, int quantity){
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId(){
        return this.productId;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setProductId(int Id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String toString(){
        return productId + " " + name + " " + category + " " + price + " " + quantity;
    }

}
