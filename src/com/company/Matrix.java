package com.company;

import java.util.Set;

public class Matrix {
    public long array2d;
    public Set<String> keys;
    public Set<Long> placements;

    public Matrix() {
    }

    public Matrix(int[][] array) {
        this.array2d = MatrixUtil.arrayToLong(array);
    }
}
