package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @ParameterizedTest
    @ValueSource(ints = {0,Integer.MIN_VALUE,-10})
    void quantityShouldBeZero(int input){
        var Product = new Product("test",10.0,20.0,input,"01");
        assertEquals(0,Product.getQuantity());
    }

    @ParameterizedTest
    @ValueSource(ints = {10,Integer.MAX_VALUE,20,Integer.MAX_VALUE/2})
    void quantityShouldBeInput(int input){
        var Product = new Product("test",10.0,20.0,input,"01");
        assertEquals(input,Product.getQuantity());
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.0,Double.MAX_VALUE,Double.MIN_VALUE,Double.MAX_VALUE/2,3.141592653589793})
    void doubleShouldReturnInput(Double input){
        var Product = new Product("test4",input,input,10,"04");
        assertEquals(input,Product.getBuyingPrice());
    }
}