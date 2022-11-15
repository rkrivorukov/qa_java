package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
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

    @ParameterizedTest
    @MethodSource("data")
    void getFood(List<String> food) throws Exception {
        Mockito.doReturn(food).when(feline).eatMeat();
        Assertions.assertEquals(food, cat.getFood());
    }

    public static Object[] data() {
        return new Object[] {
                List.of("food1", "food2"),
                Collections.emptyList()
        };
    }
}