package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline feline;

    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    void getSound() {
        Assertions.assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFood() throws Exception {
        List<String> food = List.of("food1", "food2");
        Mockito.doReturn(food).when(feline).eatMeat();
        Assertions.assertEquals(food, cat.getFood());
    }
}