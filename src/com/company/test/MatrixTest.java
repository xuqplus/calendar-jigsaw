package com.company.test;

import com.company.Main;
import com.company.Matrix;

public class MatrixTest {
    static void check(boolean b) {
        if (!b) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {0}, {1}, {1}
        };
        check(2 == Matrix.sum(a));
        int[][] b = {
                {1}, {0}, {0}
        };
        check(1 == Matrix.sum(b));

        int[][] a1 = {
                {0, 1}, {1, 1}, {1, 1}
        };
        check(5 == Matrix.sum(a1));
        int[][] a2 = {
                {0, 0}, {0, 1}, {1, 1}
        };
        check(3 == Matrix.sum(a2));

        check(0 == Matrix.sum(a, b));
        check(3 == Matrix.sum(a1, a2));

        int[][] a3 = {
                {0, 0, 0}, {0, 1, 1}, {1, 1, 1}
        };
        check(3 == Matrix.sum(a3, a2));

        int[][] a4 = {
                {0, 0, 0, 1}, {0, 1, 1, 0}, {1, 1, 1, 0}
        };
        check(5 == Matrix.sum(a3, a4));
        Main.print(a4);
    }
}
