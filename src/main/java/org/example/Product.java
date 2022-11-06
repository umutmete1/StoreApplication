package org.example;

public class Product {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if(quantity < 0){
            this.quantity = 0;
        }
        else {
            this.quantity = quantity;
        }
    }

    private int quantity;

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private Double sellingPrice;

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    private Double buyingPrice;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID;

    public Product(String name,Double buyingPrice,Double sellingPrice,int quantity,String ID){
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = Math.max(quantity, 0);
        this.ID = ID;
    }
}
