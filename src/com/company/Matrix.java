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
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return 0;
        }
        if (null == b || b.length <= 0 || null == b[0] || b[0].length <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            for (int j = 0; j < Math.min(a[0].length, b[0].length); j++) {
                sum += (a[i][j] * b[i][j]);
            }
        }
        return sum;
    }
}
