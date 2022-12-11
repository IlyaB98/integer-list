package org.example;

import org.example.exception.ArgumentNullException;
import org.example.exception.ElementNotFoundException;
import org.example.exception.InvalidArrayLengthException;

import java.util.Arrays;

public class List implements IntegerList {
    private int lengthArray;
    private Integer[] integers;

    public List(int lengthArray) {
        setLengthArray(lengthArray);
        integers = new Integer[lengthArray];
    }

    private void grow() {
        setIntegers(Arrays.copyOf(integers, integers.length + (int) (integers.length * 1.5)));
    }
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    @Override
    public Integer add(Integer item) {
        if (integers.length == this.size()) {
            grow();
        }
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] == null) {
                integers[i] = item;
                return integers[i];
            }
        }

        return null;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < integers.length && integers[index] == null) {
            integers[index] = item;
            return integers[index];
        } else if (index < integers.length && integers[index] != null) {
            for (int i = integers.length - 1; i >= index; i++) {
                Integer oldString = integers[index];
                integers[index] = item;
                for (int j = 0; j < integers.length; j++) {
                    if (integers[j] == null) {
                        integers[j] = oldString;
                    }
                }
            }
            integers[index] = item;
            return integers[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы фактического количества элементов");
        }
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < integers.length) {
            integers[index] = item;
            return integers[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы фактического количества элементов");
        }
    }

    @Override
    public Integer remove(String item) {
        Integer integer = Integer.parseInt(item);
        for (int i = 0; i < integers.length; i++) {
            if (integers[i].equals(integer)) {
                Integer oldString = integers[i];
                integers[i] = null;
                return oldString;
            }
        }
        throw new ElementNotFoundException("Элемент отсутствует в списке");
    }

    @Override
    public Integer remove(int index) {
        if (index < integers.length) {
            Integer oldString = integers[index];
            integers[index] = null;
            return oldString;
        } else {
            throw new ElementNotFoundException("Элемент отсутствует в списке");
        }
    }

    @Override
    public boolean contains(Integer[] arr, int element) {
        if (Arrays.binarySearch(arr, element) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integers.length - 1; i >= 0; i--) {
            if (integers[i] == null) {
                continue;
            }
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < integers.length) {
            return integers[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за рамки фактического количества элементов");
        }
    }

    @Override
    public boolean equals(Integer[] otherList) {
        if (otherList == null) {
            throw new ArgumentNullException();
        }
        return Arrays.equals(integers, otherList);
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (Integer integer : integers) {
            if (integer != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    @Override
    public void clear() {
        Arrays.fill(integers, null);
    }

    @Override
    public Integer[] toArray() {
        Integer[] newIntegers = new Integer[this.size()];

        int counter = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] != null) {
                newIntegers[counter] = integers[i];
                counter++;
            }
        }
        return newIntegers;
    }

    @Override
    public Integer[] sort() {
       quickSort(integers, 0, integers.length - 1);
        return integers;
    }

    public void setLengthArray(int lengthArray) {
        if (lengthArray > 0) {
            this.lengthArray = lengthArray;
        } else {
            throw new InvalidArrayLengthException("Длинна массива не может быть меньше или равна 0");
        }
    }

    public int getLengthArray() {
        return lengthArray;
    }

    public Integer[] getIntegers() {
        return integers;
    }

    public void setIntegers(Integer[] integers) {
        this.integers = integers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return Arrays.equals(integers, list.integers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integers);
    }
}
