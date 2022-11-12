package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    @Test
    void getFood() throws Exception {
        lion = new Lion("Самец", feline);
        doReturn(List.of("Животные", "Птицы", "Рыба")).when(feline).getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}