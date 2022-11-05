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
        for (int i = 1; i < b.length; i++) {
            System.arraycopy(a[i], 0, b[i - 1], 0, b[0].length);
        }
        return b;
    }

    public static int[][] down(int[][] a) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            return new int[0][0];
        }
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length - 1; i++) {
            System.arraycopy(a[i], 0, b[i + 1], 0, b[0].length);
        }
        return b;
    }

    // rotate 90 degrees
    public static int[][] rotate(int[][] a) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
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
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
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
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            throw new RuntimeException();
        }
        if ((a.length != a[0].length) || (a.length != 3 && a.length != 4)) {
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
    public static int[][] expand(int[][] a, int[][] b) {
        if (null == a || a.length <= 0 || null == a[0] || a[0].length <= 0) {
            throw new RuntimeException();
        }
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            for (int j = 0; j < Math.min(a[0].length, b[0].length); j++) {
                System.arraycopy(a[i], 0, b[i], 0, a[0].length);
            }
        }
        return b;
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


}
