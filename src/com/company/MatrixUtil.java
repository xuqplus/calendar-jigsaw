package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MatrixUtil {

    public static boolean isEmpty(int[][] a) {
        // todo, define what is empty to the matrix
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Matrix a) {
        return null != a && isEmpty(a.array);
    }

    public static int sum(int[][] a) {
        if (isEmpty(a)) {
            return 0;
        }
        int sum = 0;
        for (int[] a0 : a) {
            for (int a1 : a0) {
                sum += a1;
            }
        }
        return sum;
    }

    public static int sum(int[][] a, int[][] b) {
        return sum(a) + sum(b);
    }

    public static int product(int[][] a, int[][] b) {
        if (isEmpty(a) || isEmpty(b)) {
            return 0;
        }
        int product = 0;
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            for (int j = 0; j < Math.min(a[0].length, b[0].length); j++) {
                product += (a[i][j] * b[i][j]);
            }
        }
        return product;
    }

    // down = 1 > move down 1 step, right = 1 > move to right 1 step
    public static int[][] move(int[][] a, int down, int right) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length - down; i++) {
            try {
                System.arraycopy(a[i], 0, b[i + down], Math.max(right, 0), Math.min(b[0].length - right, b[0].length));
            } catch (Exception e) {
                // pass
            }
        }
        return b;
    }

    public static int[][] left(int[][] a) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length; i++) {
            System.arraycopy(a[i], 1, b[i], 0, b[0].length - 1);
        }
        return b;
    }

    public static int[][] right(int[][] a) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length; i++) {
            System.arraycopy(a[i], 0, b[i], 1, b[0].length - 1);
        }
        return b;
    }

    public static int[][] up(int[][] a) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 1; i < b.length; i++) {
            System.arraycopy(a[i], 0, b[i - 1], 0, b[0].length);
        }
        return b;
    }

    public static int[][] down(int[][] a) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length - 1; i++) {
            System.arraycopy(a[i], 0, b[i + 1], 0, b[0].length);
        }
        return b;
    }

    // rotate 90 degrees, only support 3*3, 4*4 matrix
    public static int[][] rotate(int[][] a) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        if ((a.length != a[0].length) || (a.length != 3 && a.length != 4)) {
            throw new RuntimeException();
        }
        int[][] b = new int[a.length][a[0].length];
        if (a.length == 3) {
            b[0][0] = a[2][0];
            b[0][1] = a[1][0];
            b[0][2] = a[0][0];
            b[1][0] = a[2][1];
            b[1][1] = a[1][1];
            b[1][2] = a[0][1];
            b[2][0] = a[2][2];
            b[2][1] = a[1][2];
            b[2][2] = a[0][2];
        }
        if (a.length == 4) {
            b[0][0] = a[3][0];
            b[0][1] = a[2][0];
            b[0][2] = a[1][0];
            b[0][3] = a[0][0];
            b[1][0] = a[3][1];
            b[1][1] = a[2][1];
            b[1][2] = a[1][1];
            b[1][3] = a[0][1];
            b[2][0] = a[3][2];
            b[2][1] = a[2][2];
            b[2][2] = a[1][2];
            b[2][3] = a[0][2];
            b[3][0] = a[3][3];
            b[3][1] = a[2][3];
            b[3][2] = a[1][3];
            b[3][3] = a[0][3];
        }
        return b;
    }

    public static int[][] mirror(int[][] a) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        if ((a.length != a[0].length) || (a.length != 3 && a.length != 4)) {
            throw new RuntimeException();
        }
        int[][] b = new int[a.length][a[0].length];
        if (a.length == 3) {
            System.arraycopy(a[0], 0, b[2], 0, 3);
            System.arraycopy(a[1], 0, b[1], 0, 3);
            System.arraycopy(a[2], 0, b[0], 0, 3);
        }
        if (a.length == 4) {
            System.arraycopy(a[3], 0, b[0], 0, 4);
            System.arraycopy(a[2], 0, b[1], 0, 4);
            System.arraycopy(a[1], 0, b[2], 0, 4);
            System.arraycopy(a[0], 0, b[3], 0, 4);
        }
        return b;
    }

    public static int[][] move2TopLeft(int[][] a) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        int[][] b = a;
        int sum = sum(a);
        while (true) {
            int[][] t = left(b);
            int s = sum(t);
            if (s == sum) {
                b = t;
            } else {
                break;
            }
        }
        while (true) {
            int[][] t = up(b);
            int s = sum(t);
            if (s == sum) {
                b = t;
            } else {
                break;
            }
        }
        return b;
    }

    // a <= b
    public static int[][] expand(int[][] a, int row, int column) {
        if (isEmpty(a)) {
            throw new RuntimeException();
        }
        int[][] b = new int[row][column];
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            for (int j = 0; j < Math.min(a[0].length, b[0].length); j++) {
                System.arraycopy(a[i], 0, b[i], 0, a[0].length);
            }
        }
        return b;
    }

    public static Matrix expand(Matrix a, Matrix b) {
        if (isEmpty(b)) {
            throw new RuntimeException();
        }
        final int row = b.array.length;
        final int column = b.array[0].length;
        return new Matrix(expand(a.array, row, column));
    }

    // a <= b
    public static int[][] merge(int[][] a, int[][] b) {
        int[][] c = new int[b.length][b[0].length];
        for (int i = 0; i < b.length; i++) {
            System.arraycopy(b[i], 0, c[i], 0, b[i].length);
        }
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            for (int j = 0; j < Math.min(a[0].length, b[0].length); j++) {
                c[i][j] += a[i][j];
            }
        }
        return c;
    }

    // up to 8 different directions
    public static Set<Matrix> getPossibleDirections(int[][] a) {
        Set<Matrix> r = new HashSet<>();
        int[][] a0 = move2TopLeft(a);
        int[][] a1 = move2TopLeft(rotate(a0));
        int[][] a2 = move2TopLeft(rotate(a1));
        int[][] a3 = move2TopLeft(rotate(a2));

        int[][] a4 = move2TopLeft(mirror(a));
        int[][] a5 = move2TopLeft(rotate(a4));
        int[][] a6 = move2TopLeft(rotate(a5));
        int[][] a7 = move2TopLeft(rotate(a6));
        r.add(new Matrix(a0));
        r.add(new Matrix(a1));
        r.add(new Matrix(a2));
        r.add(new Matrix(a3));
        r.add(new Matrix(a4));
        r.add(new Matrix(a5));
        r.add(new Matrix(a6));
        r.add(new Matrix(a7));
        return r;
    }

    // merge matrix into target without collision
    public static LinkedList<Matrix> getPossiblePlacements(Matrix matrix, Matrix target) {
        if (isEmpty(matrix) || isEmpty(target)) {
            throw new RuntimeException();
        }
        if (matrix.getRow() != target.getRow() || matrix.getColumn() != target.getColumn()) {
            throw new RuntimeException();
        }
        final int row = target.array.length;
        final int column = target.array[0].length;
        LinkedList<Matrix> r = new LinkedList<>();
        matrix.possiblePlacements = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int[][] moved = move(matrix.array, i, j);
                if (0 == (product(moved, target.array))) {
                    Matrix merged = new Matrix(merge(moved, target.array));
                    r.add(merged);
                    merged.keys = new HashSet<>();
                    merged.keys.add(matrix.elementKey);
                    merged.solutions = new HashSet<>();
                    merged.solutions.add(new Matrix(moved));
                }
            }
        }
        return r;
    }

    public static Matrix cartesianProduct(Matrix a, Matrix b) {
        if (null == a.possiblePlacements || null == b.possiblePlacements || a.possiblePlacements.size() <= 0 || b.possiblePlacements.size() <= 0) {
            throw new RuntimeException();
        }
        Matrix r = new Matrix();
        r.keys = new HashSet<>();
        r.keys.addAll(a.keys);
        r.keys.addAll(b.keys);
        for (Matrix aa : a.possiblePlacements) {
            for (Matrix bb : b.possiblePlacements) {
                if (9 == product(aa.array, bb.array)) { // fixed dots
                    Matrix merged = new Matrix(merge(aa.array, bb.array));
                    if (null == r.possiblePlacements) {
                        r.possiblePlacements = new LinkedList();
                    }
                    r.possiblePlacements.add(merged);
                    r.possibility++;
                    merged.keys = r.keys;
                    merged.solutions = new HashSet<>();
                    merged.solutions.addAll(aa.solutions);
                    merged.solutions.addAll(bb.solutions);
                }
            }
        }
        return r;
    }
}
