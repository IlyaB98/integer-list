import org.example.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ListTests {
    private List list = new List(3);
    private Integer int1;
    private Integer int2;
    private Integer int3;

    @BeforeEach
    public void setUp() {
        int1 = 1;
        int2 = 2;
        int3 = 3;
    }

    @Test
    public void addInList() {
        list.add(int1);
        list.add(int2);
        list.add(3);
        list.add(4);
        Assertions.assertEquals(list.size(), 4);
    }

    @Test
    public void addInListByIndex() {
        list.add(0, int1);
        list.add(1, int2);
        list.add(1, int3);
        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    public void setInListByIndex() {
        list.set(1, int1);
        list.set(2, int2);
        list.set(2, int3);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void remove() {

        list.add(int1);
        list.add(int2);
        list.add(int3);
        list.remove(int1);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void removeByIndex() {
        list.add(int1);
        list.add(int2);
        list.add(int3);
        list.remove(1);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void contains() {
        list.add(int1);
        list.add(int2);
        list.add(int3);

        Assertions.assertEquals(list.contains(list.toArray(),int2), true);
        Assertions.assertEquals(list.contains(list.toArray(),4), false);
    }

    @Test
    public void indexOf() {
        list.add(int1);
        list.add(int2);
        list.add(int3);

        Assertions.assertEquals(list.indexOf(int1), 0);
        Assertions.assertEquals(list.indexOf(4), -1);
    }

    @Test
    public void lastIndexOf() {
        list.add(int1);
        list.add(int2);
        list.add(int3);

        Assertions.assertEquals(list.indexOf(int1), 0);
        Assertions.assertEquals(list.indexOf(4), -1);
    }

    @Test
    public void get() {
        list.add(int1);
        list.add(int2);
        list.add(int3);

        Assertions.assertEquals(list.get(1), 2);
    }

    @Test
    public void equals() {
        List list2 = new List(3);
        list2.add(int1);
        list2.add(int2);
        list2.add(int3);

        list.add(int1);
        list.add(int2);
        list.add(int3);

        Assertions.assertEquals(list.equals(list2), true);
    }

    @Test
    public void size() {
        list.add(int1);
        list.add(int2);
        list.add(int3);

        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    public void isEmpty() {
        list.add(int1);

        Assertions.assertEquals(list.isEmpty(), false);
    }

    @Test
    public void clear() {
        list.add(int2);
        list.clear();
        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    public void toArray() {
        Integer[] integers = {int1};
        list.add(int1);
        Assertions.assertEquals(Arrays.equals(integers, list.toArray()), true);
    }

    @Test
    public void sort() {
        list.add(int2);
        list.add(int3);
        list.add(int1);
        Assertions.assertArrayEquals(list.sort(), new Integer[]{1,2,3});
    }


}
