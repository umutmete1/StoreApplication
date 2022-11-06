package org.example;

public class Owner {
    public LinkedList getProducts() {
        return products;
    }

    public void setProducts(LinkedList products) {
        this.products = products;
    }

    private LinkedList products;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private Double balance;

    public LinkedList getInv() {
        return inv;
    }

    public void setInv(LinkedList inv) {
        this.inv = inv;
    }

    private LinkedList inv = new LinkedList();

    public boolean buyProduct(String product){
        Node<Product> temp =products.contains(product);
        Node<Product> temp1 = inv.contains(product);
        if(temp != null){
            if(temp1 != null){
                temp1.getData().setQuantity(temp1.getData().getQuantity()+1);
                return true;
            }
            else{
                inv.add(temp);
                return true;
            }
        }
        else{
            System.out.println("the item you are trying to buy does not exist in the products");
            return false;
        }
    }

    public boolean sellProduct(String str) {
        if (inv.contains(str) == null){
            return false;
        }
        Product temp = inv.contains(str).getData();
        if(temp != null){
            temp.setQuantity(temp.getQuantity()-1);
            if(temp.getQuantity()==0){
                inv.delete(temp);
            }
            balance = balance + temp.getSellingPrice();
            return true;
        }
        else{
            System.out.println("the item you are trying to sell does not exist in our inventory");
            return false;
        }
    }
    public boolean checkStocks(Product p){
        return inv.contains(p) != null;
    }
    public void updatePrice(Product p){

    }
    public Owner(LinkedList products){
        this.products = products;
        balance = 0.0;
    }
    public void printInv(){
        Node<Product> walk = inv.getHead();
        int counter = 1;
        if(walk == null){
            System.out.println("the inv is empty");
            return;
        }
        while(walk!=null){
            System.out.println(counter + "-"+ walk.getData().getName());
            walk = walk.getNext();
            counter++;
        }
    }
    public void printProducts(){
        Node<Product> walk = products.getHead();
        if(walk == null){
            System.out.println("the products is empty");
            return;
        }
        while(walk!=null){
            System.out.println(walk.getData().getName());
            walk = walk.getNext();
        }
    }
    public void addProduct(Product product){
        Node<Product> headp = products.getHead();
        Node<Product> input = new Node<>(product);
        input.setNext(headp);
        headp = input;
    }
    public void addProductInv(Product product){
        Node<Product> head = inv.getHead();
        Node<Product> input = new Node<>(product);
        if(head != null){
            head.setNext(input);
        }
        head = input;
    }


}
