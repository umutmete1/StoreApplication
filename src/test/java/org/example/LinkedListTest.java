package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinkedListTest {
    @Test
    void testShouldReturnOne(){
        var linkedList = new LinkedList();
        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
        assertEquals("01",linkedList.contains("test").getData().getID());
    }


    @Test
    void testShouldReturnTwo(){
        var linkedList = new LinkedList();
        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
        assertEquals("02",linkedList.contains("test2").getData().getID());
    }

    @Test
    void testShouldReturnThree(){
        var linkedList = new LinkedList();
        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
        assertEquals("03",linkedList.contains("test").getData().getID());
    }

    @Test
    void testShouldReturnNull(){
        var linkedList = new LinkedList();
        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
        assertNull(linkedList.contains("test3"));
    }

    @Test
    void addTestShouldReturnProduct3(){
        var linkedList = new LinkedList();
        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
        assertEquals(Product3,linkedList.getHead().getData());
    }

    @Test
    void deleteProductTest(){
        var linkedList = new LinkedList();
        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test3",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
        linkedList.deleteProduct("test");
        assertEquals(9,linkedList.contains("test").getData().getQuantity());
    }

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void deleteShouldPrint(){
        var linkedList = new LinkedList();
        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test3",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
        linkedList.deleteProduct("test4");
        assertEquals("We dont have that item in our inventory", outputStreamCaptor.toString()
                .trim());

    }
}