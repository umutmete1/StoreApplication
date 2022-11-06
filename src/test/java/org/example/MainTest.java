package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fileExceptionTest(){
        String[] arr = new String[0];
        assertThrows(FileNotFoundException.class,()->{
            Main.main(arr);
        });
    }

}