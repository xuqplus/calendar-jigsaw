package com.company;

import java.util.Arrays;
import java.util.Date;

public class Main {


    public static void main(String[] args) {
        String input = "11/21/2021"; // MM/DD/YYYY
        print(getTargetMatrix(input));
    }

    static int[][] M = {
            {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
            {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5},
    };
    static int[][] D = {
            {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6},
            {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6},
            {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5}, {4, 6},
            {5, 0}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 5}, {5, 6},
            {6, 0}, {6, 1}, {6, 2},
    };
    static int[][] W = {
            {6, 3}, {6, 4}, {6, 5}, {6, 6}, {7, 4}, {7, 5}, {7, 6},
    };

    static int[][] getTargetMatrix(String date) {
        int[][] a = generateInitialMatrix();
        Date dt = new Date(date);
        int m = dt.getMonth();
        int d = dt.getDate() - 1;
        int w = dt.getDay();
        a[M[m][0]][M[m][1]] = 2;
        a[D[d][0]][D[d][1]] = 2;
        a[W[w][0]][W[w][1]] = 2;
        return a;
    }

    static int[][] generateInitialMatrix() {
        int[][] a = new int[8][7];
        a[0][6] = 1;
        a[1][6] = 1;
        a[7][0] = 1;
        a[7][1] = 1;
        a[7][2] = 1;
        a[7][3] = 1;
        return a;
    }

    static void print(int[][] a) {
        if (null == a) {
            return;
        }
        if (a.length != 8) {
            return;
        }
        if (a[0].length != 7) {
            return;
        }
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
        System.out.println(Arrays.toString(a[3]));
        System.out.println(Arrays.toString(a[4]));
        System.out.println(Arrays.toString(a[5]));
        System.out.println(Arrays.toString(a[6]));
        System.out.println(Arrays.toString(a[7]));
    }
}
