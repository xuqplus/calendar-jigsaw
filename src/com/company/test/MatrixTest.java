package com.company.test;

import com.company.Main;
import com.company.MatrixUtil;

import java.util.Arrays;

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

        // verify the solutions
        //Got NO.87 result > 98822L, 793600L, 2113920L, 235937792L, 817889280L, 7533101056L, 1949915152384L, 529964604588032L, 3386598892765184L, 67553994410557440L
        //Got NO.88 result > 390L, 793600L, 12648960L, 235937792L, 807452672L, 7533101056L, 1949915152384L, 529964604588032L, 3386598892765184L, 67553994410557440L
        //Got NO.89 result > 390L, 116224L, 1325056L, 283115520L, 3775004672L, 25971654656L, 1928473870336L, 529964604588032L, 3386598892765184L, 67553994410557440L
        //Got NO.90 result > 1542L, 229760L, 1325056L, 1881161728L, 2176843776L, 25971654656L, 1928473870336L, 529964604588032L, 3386598892765184L, 67553994410557440L
        //Got NO.91 result > 390L, 929792L, 8457728L, 270581760L, 3779067904L, 25972178944L, 1928473870336L, 529964604588032L, 3386598892765184L, 67553994410557440L
        //Got NO.92 result > 3590L, 798720L, 6308224L, 2164490240L, 25972178944L, 36247175168L, 1928473870336L, 529964604588032L, 3386564533026816L, 67553994410557440L
        //Got NO.93 result > 3590L, 798720L, 6308224L, 1887436800L, 2164490240L, 25972178944L, 1928473870336L, 529964604588032L, 3386598892765184L, 67553994410557440L
        //Got NO.94 result > 265732L, 2113922L, 68694016L, 1082359808L, 30232543232L, 35169239040L, 1926309609472L, 529964604588032L, 3386564533026816L, 67553994410557440L
        //Got NO.95 result > 390L, 1587200L, 25298432L, 270647296L, 3762290688L, 4530110464L, 1949915152384L, 529964604588032L, 3386598892765184L, 67553994410557440L
        //Got NO.96 result > 1542L, 1587200L, 6308224L, 2164490240L, 4530110464L, 36247175168L, 1949915152384L, 529964604588032L, 3386564533026816L, 67553994410557440L
        //Got NO.97 result > 1542L, 1587200L, 6308224L, 1887436800L, 2164490240L, 4530110464L, 1949915152384L, 529964604588032L, 3386598892765184L, 67553994410557440L
        long[] rr = new long[]{1542L, 1587200L, 6308224L, 1887436800L, 2164490240L, 4530110464L, 1949915152384L, 529964604588032L, 3386598892765184L, 67553994410557440L};
        int i = 0;
        for (long r : rr) {
            System.out.println(String.format("---- %s ----", i++));
            print(MatrixUtil.longToArray(r));
        }
    }

    public static void print(int[][] a) {
        if (MatrixUtil.isEmpty(a)) {
            return;
        }
        for (int[] a0 : a) {
            System.out.println(Arrays.toString(a0));
        }
    }
}
