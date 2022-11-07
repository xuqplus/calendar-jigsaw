package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

public class Matrix {
    public int[][] array;
    // placement group
    public String elementKey;
    public String placementName; // element + direction
    public int possibility;
    public LinkedList<Matrix> possiblePlacements;
    // end placement group

    // solution path
    public Set<String> keys;
    public Set<Matrix> solutions;
    // end solution path

    public Matrix() {
    }

    public Matrix(String elementKey) {
        this.elementKey = elementKey;
        this.possiblePlacements = new LinkedList<>();
    }

    public Matrix(int[][] array) {
        this.array = array;
    }

    public int getRow() {
        return this.array.length;
    }

    public int getColumn() {
        return this.array[0].length;
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

    // array hash code override
    // collision detection
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
