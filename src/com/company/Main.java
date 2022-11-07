package com.company;

import java.util.*;

public class Main {

    static int[][] AA = {
            {1, 1, 0, 0,},
            {0, 1, 0, 0,},
            {0, 1, 0, 0,},
            {0, 1, 0, 0,},
    }, BB = {
            {1, 0, 0,},
            {1, 1, 0,},
            {1, 1, 0,},
    }, CC = {
            {1, 1, 1,},
            {1, 0, 1,},
            {0, 0, 0,},
    }, DD = {
            {1, 1, 1,},
            {1, 0, 0,},
            {1, 0, 0,},
    }, EE = {
            {1, 1, 0,},
            {0, 1, 0,},
            {0, 1, 1,},
    }, FF = {
            {1, 1, 1,},
            {0, 1, 0,},
            {0, 1, 0,},
    }, GG = {
            {1, 0, 0, 0,},
            {1, 0, 0, 0,},
            {1, 0, 0, 0,},
            {1, 0, 0, 0,},
    }, HH = {
            {1, 1, 0,},
            {0, 1, 0,},
            {0, 1, 0,},
    }, II = {
            {1, 1, 0, 0,},
            {0, 1, 1, 1,},
            {0, 0, 0, 0,},
            {0, 0, 0, 0,},
    }, JJ = {
            {1, 1, 0,},
            {0, 1, 1,},
            {0, 0, 0,},
    };

    static Map<String, int[][]> ELEMENTS = new HashMap<String, int[][]>() {{
        put("AA", AA);
        put("BB", BB);
        put("CC", CC);
        put("DD", DD);
        put("EE", EE);
        put("FF", FF);
        put("GG", GG);
        put("HH", HH);
        put("II", II);
        put("JJ", JJ);
    }};

    public static void main(String[] args) {
        String input = "11/05/2022"; // MM/DD/YYYY
        Matrix target = new Matrix(getTargetMatrix(input));
        System.out.println("--target--");
        print(target);

        LinkedList<Matrix> matrices = new LinkedList<>();
        for (Map.Entry<String, int[][]> entry : ELEMENTS.entrySet()) {
            String name = entry.getKey();
            int[][] element = entry.getValue();
            Set<Matrix> directions = MatrixUtil.getPossibleDirections(element);
            int directionOrder = 0;
            for (Matrix direction : directions) {
                Matrix expanded = MatrixUtil.expand(direction, target);
                LinkedList<Matrix> placements = MatrixUtil.getPossiblePlacements(expanded, target);
                expanded.elementKey = name;
                expanded.placementName = name + directionOrder++;
                expanded.possibility = placements.size();
                expanded.possiblePlacements = placements;
                matrices.add(expanded);
            }
        }
        Collections.sort(matrices, Comparator.comparingInt(o -> o.possibility));
        Map<String, Matrix> matricesMapGroupedByKey = new LinkedHashMap<>();
        for (Matrix matrix : matrices) {
            String elementKey = matrix.elementKey;
            if (!matricesMapGroupedByKey.containsKey(elementKey)) {
                matricesMapGroupedByKey.put(elementKey, new Matrix(elementKey));
            }
            Matrix matrixGrouped = matricesMapGroupedByKey.get(elementKey);
            matrixGrouped.possiblePlacements.addAll(matrix.possiblePlacements);
            matrixGrouped.possibility += matrix.possibility;
            matrixGrouped.keys = new HashSet<>();
            matrixGrouped.keys.add(elementKey);
        }
        LinkedList<Matrix> matricesGroupedByKey = new LinkedList<>(matricesMapGroupedByKey.values());
        while (matricesGroupedByKey.size() > 1) {
            System.out.println("----");
            Collections.sort(matricesGroupedByKey, Comparator.comparingInt(o -> o.possibility));
            Matrix first = matricesGroupedByKey.removeFirst();
            Matrix second = matricesGroupedByKey.removeFirst();
            Matrix product = MatrixUtil.cartesianProduct(first, second);
            matricesGroupedByKey.add(product);
        }
        System.out.println("----");
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
        a[M[m][0]][M[m][1]] = 1;
        a[D[d][0]][D[d][1]] = 1;
        a[W[w][0]][W[w][1]] = 1;
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

    public static void print(int[][] a) {
        if (MatrixUtil.isEmpty(a)) {
            return;
        }
        for (int[] a0 : a) {
            System.out.println(Arrays.toString(a0));
        }
    }

    public static void print(Matrix a) {
        print(a.array);
    }
}
