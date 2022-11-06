package org.example;
import java.util.Objects;

public class LinkedList {
    public Node<Product> getHead() {
        return head;
    }

    public void setHead(Node<Product> head) {
        this.head = head;
    }

    private Node<Product> head;

    public void add(Product input){
        Node<Product> p = new Node<>(input);
        p.setNext(head);
        head = p;
    }
    public void add(Node<Product> p){
        p.setNext(head);
        head = p;
    }
    public Node<Product> contains(Product p){
        Node<Product> walker = head ;
        while(walker != null){
            if(Objects.equals(walker.getData().getName(), p.getName())){
                return walker;
            }
            walker = walker.getNext();
        }
        return null;
    }
    public Node<Product> contains(String str){
        Node<Product> walker = head;
        while(walker != null){
            if(Objects.equals(walker.getData().getName(), str)){
                return walker;
            }
            walker = walker.getNext();
        }
        return null;
    }
    public void delete(Product p){
        Node<Product> walker = head;
        Node<Product> prev = null;
        while(walker != null){
            if(walker.getData() == p){
                break;
            }
            prev = walker;
            walker = walker.getNext();
        }
        if(walker != null){
            prev.setNext(walker.getNext());
        }
        else{
            System.out.println("the item does not exist");
        }
    }
    public void deleteProduct(String str){
        Node<Product> temp = contains(str);
        if(temp != null){
            temp.getData().setQuantity(temp.getData().getQuantity()-1);
            if(temp.getData().getQuantity()==1){
                delete(temp.getData());
            }
        }
        else{
            System.out.println("We dont have that item in our inventory");
        }
    }
    public LinkedList(){
        head = null;
    }
}
