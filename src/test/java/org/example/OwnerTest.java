package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    private final LinkedList linkedList = new LinkedList();
    private final Owner owner = new Owner(linkedList);
    private final LinkedList inv = new LinkedList();

    @BeforeEach
    void Start(){

        var Product = new Product("test",10.0,20.0,10,"01");
        var Product2 = new Product("test2",10.20,60.0,200,"02");
        var Product3 = new Product("test",10.0,15.0,200,"03");
        linkedList.add(Product);
        linkedList.add(Product2);
        linkedList.add(Product3);
    }

    @ParameterizedTest
    @DisplayName("Selling Product")
    @ValueSource(strings = {"A Product", "B Product", "C Product"})
    void sellProductShouldBeTrueIfItemExist(String a){
        inv.add(new Product("A Product", 10.0,20.0,10,"09"));
        inv.add(new Product("B Product", 10.0,20.0,10,"09"));
        inv.add(new Product("C Product", 10.0,20.0,10,"09"));
        owner.setInv(inv);
        assertTrue(owner.sellProduct(a));
    }

    @Test
    @DisplayName("Checking Stocks")
    void checkStocksShouldReturnFalseIfNull(){
        Product p = new Product("test",10.0,15.0,200,"03");
        assertFalse(owner.checkStocks(p));
    }

    @Test
    @DisplayName("Balance Test")
    void balanceShouldZero(){
        assertEquals(0,owner.getBalance());
    }

    @Test
    @DisplayName("Updating Price")
    void updatePriceTest(){
        Product firstProduct = new Product("Product A",10.0,15.0,200,"120");
        Product updatedProduct = new Product("Product A",10.0,18.0,200,"120");
        inv.add(firstProduct);
        owner.setInv(inv);
        owner.updatePrice(updatedProduct);
        assertEquals(owner.getInv().contains("Product A").getData().getSellingPrice(),18.0);
    }



}