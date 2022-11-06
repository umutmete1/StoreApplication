package org.example;

public class Transaction {
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    Product product;

    public Transaction(String date,String type,Product product){
        this.date = date;
        this.type = type;
        this.product = product;
    }

}
