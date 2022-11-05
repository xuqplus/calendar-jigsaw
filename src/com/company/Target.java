package com.company;

import java.util.Arrays;

public class Target {
    public final int[][] target;
    public int possibility;

    public Target(int[][] target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Target target = (Target) o;
        boolean r = true;
        try {
            for (int i = 0; i < this.target.length; i++) {
                for (int j = 0; j < this.target[0].length; j++) {
                    if (this.target[i][j] != target.target[i][j]) {
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
            int[] a = new int[this.target.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Arrays.hashCode(target[i]);
            }
            return Arrays.hashCode(a);
        } catch (Exception e) {
            return Arrays.hashCode(target);
        }
    }
}
