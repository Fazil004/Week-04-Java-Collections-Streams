package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class ListManagerTest {
    ListManager lm = new ListManager();

    @Test
    void AddElement() {
        List<Integer> list = new ArrayList<>();
        lm.addElement(list, 5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
        lm.addElement(list, 3);
        assertEquals(2, list.size());
    }

    @Test
    void addElementNullList() {
        assertThrows(IllegalArgumentException.class, () -> lm.addElement(null, 5));

    }

    @Test
    void removeElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(2);
        boolean removed=lm.removeElement(list,3);
        assertTrue(removed);
        assertEquals(2, list.size());
        assertEquals(5, list.get(0));

    }

    @Test
    void removeElementNullList() {
        assertThrows(IllegalArgumentException.class, () -> lm.removeElement(null, 3));
    }

    @Test
    void GetSizeEmptyList() {
        List<Integer> list = new ArrayList<>();
        assertEquals(list.size(), 0);

    }

    @Test
    void GetSize(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(2);
        assertEquals(3,lm.getSize(list));
    }

    @Test
    void GetSizeNullList(){
        assertThrows(IllegalArgumentException.class, () -> lm.getSize(null));
    }


}