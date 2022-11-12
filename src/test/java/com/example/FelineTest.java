package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FelineTest {

    private Feline feline = new Feline();

    @Test
    void eatMeat() throws Exception {
        Assertions.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void getFamily() {
        Assertions.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittens() {
        Assertions.assertEquals(1, feline.getKittens());
    }

    @Test
    void testGetKittens() {
        Assertions.assertEquals(5, feline.getKittens(5));
    }
}