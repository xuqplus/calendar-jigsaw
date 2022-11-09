package com.company.test;

import com.company.Main;
import com.company.MatrixUtil;

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
        check(2 == MatrixUtil.sum(a));
        int[][] b = {
                {1}, {0}, {0}
        };
        check(1 == MatrixUtil.sum(b));

        int[][] a1 = {
                {0, 1}, {1, 1}, {1, 1}
        };
        check(5 == MatrixUtil.sum(a1));
        int[][] a2 = {
                {0, 0}, {0, 1}, {1, 1}
        };
        check(3 == MatrixUtil.sum(a2));

        check(3 == MatrixUtil.sum(a, b));
        check(0 == MatrixUtil.product(a, b));
        check(8 == MatrixUtil.sum(a1, a2));
        check(3 == MatrixUtil.product(a1, a2));

        int[][] a3 = {
                {0, 0, 0}, {0, 1, 1}, {1, 1, 1}
        };
        check(8 == MatrixUtil.sum(a3, a2));
        check(3 == MatrixUtil.product(a3, a2));

        int[][] a4 = {
                {0, 0, 0, 1}, {0, 1, 1, 0}, {1, 1, 1, 0}
        };
        check(11 == MatrixUtil.sum(a3, a4));
        check(5 == MatrixUtil.product(a3, a4));
        Main.print(a4);

        System.out.println("--left/right--");
        int[][] left = MatrixUtil.left(a4);
        Main.print(left);
        int[][] right = MatrixUtil.right(a4);
        Main.print(right);

        System.out.println("--up/down--");
        int[][] up = MatrixUtil.up(a4);
        Main.print(up);
        int[][] down = MatrixUtil.down(a4);
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
        Main.print(MatrixUtil.rotate(r3));
        System.out.println("--double rotate3--");
        Main.print(MatrixUtil.rotate(MatrixUtil.rotate(r3)));
        System.out.println("--rotate4--");
        Main.print(MatrixUtil.rotate(r4));
        System.out.println("--double rotate4--");
        Main.print(MatrixUtil.rotate(MatrixUtil.rotate(r4)));
        System.out.println("--move--");
        Main.print(MatrixUtil.move2TopLeft(MatrixUtil.rotate(MatrixUtil.rotate(r4))));
        System.out.println("--move4 before--");
        Main.print(MatrixUtil.rotate(MatrixUtil.rotate(MatrixUtil.rotate(r4))));
        System.out.println("--move4 after--");
        Main.print(MatrixUtil.move2TopLeft(MatrixUtil.rotate(MatrixUtil.rotate(MatrixUtil.rotate(r4)))));
        System.out.println("--mirror--");
        Main.print(MatrixUtil.mirror(r4));
        System.out.println("--mirror r4--");
        Main.print(MatrixUtil.move2TopLeft(MatrixUtil.rotate(MatrixUtil.mirror(r4))));
        Main.print(MatrixUtil.move2TopLeft(MatrixUtil.rotate(MatrixUtil.rotate(MatrixUtil.mirror(r4)))));

        System.out.println("--expand3--");
        Main.print(MatrixUtil.expand(MatrixUtil.move2TopLeft(r3), 8, 7));
        System.out.println("--expand4--");
        Main.print(MatrixUtil.expand(r4, 8, 7));

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
        Main.print(MatrixUtil.merge(r4, m7));
        System.out.println("--m7--");
        Main.print(m7);

        System.out.println("--m7--");
        Main.print(MatrixUtil.move(m7, -1, -1));

        long l159 = 0b1001_1111; // 159
        long l12541343 = 0b1011_1111_0101_1101_1001_1111; // 159
        check(1L == Long.parseLong("1", 2));
        check(2L == Long.parseLong("10", 2));
        check(3L == Long.parseLong("11", 2));
        int[][] array159 = MatrixUtil.longToArray(l159);
        int[][] array12541343 = MatrixUtil.longToArray(l12541343);
        check(l159 == MatrixUtil.arrayToLong(array159));
        check(l12541343 == MatrixUtil.arrayToLong(array12541343));
    }
}
