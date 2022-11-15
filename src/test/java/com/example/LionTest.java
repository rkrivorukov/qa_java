package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @Test
    void constructorTest() throws Exception {
        lion = new Lion("Самец", feline);
        assertTrue(lion.hasMane);
        lion = new Lion("Самка", feline);
        assertFalse(lion.hasMane);
        assertThrows(Exception.class, () -> lion = new Lion("abc", feline));
    }

    @Test
    void getKittens() throws Exception {
        lion = new Lion("Самец", feline);
        doReturn(3).when(feline).getKittens();
        assertEquals(3, lion.getKittens());
    }

    @Test
    void doesHaveMane() throws Exception {
        lion = new Lion("Самец", feline);
        lion.hasMane = true;
        assertTrue(lion.doesHaveMane());
        lion.hasMane = false;
        assertFalse(lion.doesHaveMane());
    }

    @ParameterizedTest
    @MethodSource("data")
    void getFood(List<String> food) throws Exception {
        lion = new Lion("Самец", feline);
        doReturn(food).when(feline).getFood("Хищник");
        assertEquals(food, lion.getFood());
    }

    public static Object[] data() {
        return new Object[] {List.of("Животные", "Птицы", "Рыба"), Collections.emptyList()};
    }
}