package org.example;

public class Node<T> {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data ;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    private Node<T> next;
    public Node(T data){
        this.data = data;
        next = null;
    }
}
