package com.company;

import java.util.Arrays;

public class Element {
    public final int[][] array;

    public Element(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (this.array[i][j] != matrix.array[i][j]) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public int hashCode() {
        try {
            int[] a = new int[this.array.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Arrays.hashCode(array[i]);
            }
            return Arrays.hashCode(a);
        } catch (Exception e) {
            return Arrays.hashCode(array);
        }
    }
}
