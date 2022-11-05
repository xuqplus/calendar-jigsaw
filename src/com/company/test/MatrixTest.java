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

        check(3 == Matrix.sum(a, b));
        check(0 == Matrix.multiply(a, b));
        check(8 == Matrix.sum(a1, a2));
        check(3 == Matrix.multiply(a1, a2));

        int[][] a3 = {
                {0, 0, 0}, {0, 1, 1}, {1, 1, 1}
        };
        check(8 == Matrix.sum(a3, a2));
        check(3 == Matrix.multiply(a3, a2));

        int[][] a4 = {
                {0, 0, 0, 1}, {0, 1, 1, 0}, {1, 1, 1, 0}
        };
        check(11 == Matrix.sum(a3, a4));
        check(5 == Matrix.multiply(a3, a4));
        Main.print(a4);

        System.out.println("--left/right--");
        int[][] left = Matrix.left(a4);
        Main.print(left);
        int[][] right = Matrix.right(a4);
        Main.print(right);

        System.out.println("--up/down--");
        int[][] up = Matrix.up(a4);
        Main.print(up);
        int[][] down = Matrix.down(a4);
        Main.print(down);

        int[][] r3 = {
                {0, 1, 0,},
                {0, 1, 1,},
                {0, 1, 1,},
        };
        int[][] r4 = {
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println("--rotate3--");
        Main.print(Matrix.rotate(r3));
        System.out.println("--double rotate3--");
        Main.print(Matrix.rotate(Matrix.rotate(r3)));
        System.out.println("--rotate4--");
        Main.print(Matrix.rotate(r4));
        System.out.println("--double rotate4--");
        Main.print(Matrix.rotate(Matrix.rotate(r4)));
        System.out.println("--move--");
        Main.print(Matrix.move2TopLeft(Matrix.rotate(Matrix.rotate(r4))));
        System.out.println("--move4 before--");
        Main.print(Matrix.rotate(Matrix.rotate(Matrix.rotate(r4))));
        System.out.println("--move4 after--");
        Main.print(Matrix.move2TopLeft(Matrix.rotate(Matrix.rotate(Matrix.rotate(r4)))));

        System.out.println("--expand3--");
        Main.print(Matrix.expand(Matrix.move2TopLeft(r3), new int[8][7]));
        System.out.println("--expand4--");
        Main.print(Matrix.expand(r4, new int[8][7]));

        int[][] m7 = {
                {0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0}
        };

        System.out.println("--merge7--");
        Main.print(Matrix.merge(r4, m7));
        System.out.println("--m7--");
        Main.print(m7);

    }
}
