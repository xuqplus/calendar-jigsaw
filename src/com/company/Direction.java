package com.company;

import java.util.Arrays;

public class Direction {
    public final int[][] element;

    public Direction(int[][] element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        boolean r = true;
        try {
            for (int i = 0; i < element.length; i++) {
                for (int j = 0; j < element[0].length; j++) {
                    if (this.element[i][j] != direction.element[i][j]) {
                        r = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            r = false;
        }
        return r;
    }

    @Override
    public int hashCode() {
        try {
            int[] a = new int[this.element.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Arrays.hashCode(element[i]);
            }
            return Arrays.hashCode(a);
        } catch (Exception e) {
            return Arrays.hashCode(element);
        }
    }
}
