package com.company;

public class Matrix {
    public static int sum(int[][] a) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
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

    public static int multiply(int[][] a, int[][] b) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return 0;
        }
        if (null == b || b.length <= 0 || null == b[0] || b[0].length <= 0) {
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

    public static int[][] left(int[][] a) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return new int[0][0];
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length; i++) {
            System.arraycopy(a[i], 1, b[i], 0, b[0].length - 1);
        }
        return b;
    }

    public static int[][] right(int[][] a) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return new int[0][0];
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length; i++) {
            System.arraycopy(a[i], 0, b[i], 1, b[0].length - 1);
        }
        return b;
    }

    public static int[][] up(int[][] a) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return new int[0][0];
        }
        int[][] b = new int[a.length][a[0].length];
        System.arraycopy(a, 1, b, 0, b.length - 1);
        return b;
    }

    public static int[][] down(int[][] a) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return new int[0][0];
        }
        int[][] b = new int[a.length][a[0].length];
        System.arraycopy(a, 0, b, 1, b.length - 1);
        return b;
    }

}
