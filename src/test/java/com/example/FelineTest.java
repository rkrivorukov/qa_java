package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testGetKittens(int n) {
        Assertions.assertEquals(n, feline.getKittens(n));
    }
}