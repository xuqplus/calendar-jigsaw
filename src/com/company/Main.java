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
        String input = "11/11/2022"; // MM/DD/YYYY
        int[][] target = getTargetMatrix(input);
        System.out.println("--target--");
        print(target);

        Map<String, Set<Long>> placementMap = new LinkedHashMap<>();
        for (Map.Entry<String, int[][]> entry : ELEMENTS.entrySet()) {
            String key = entry.getKey();
            int[][] element = entry.getValue();
            Set<int[][]> directions = MatrixUtil.getPossibleDirections(element);
            for (int[][] direction : directions) {
                int[][] expanded = MatrixUtil.expand(direction, target.length, target[0].length);
                List<Long> placements = MatrixUtil.getPossiblePlacements(expanded, target);
                if (!placementMap.containsKey(key)) {
                    placementMap.put(key, new HashSet<>());
                }
                placementMap.get(key).addAll(placements);
            }
        }
        Set<Long> aa = placementMap.get("AA");
        Set<Long> bb = placementMap.get("BB");
        Set<Long> cc = placementMap.get("CC");
        Set<Long> dd = placementMap.get("DD");
        Set<Long> ee = placementMap.get("EE");
        Set<Long> ff = placementMap.get("FF");
        Set<Long> gg = placementMap.get("GG");
        Set<Long> hh = placementMap.get("HH");
        Set<Long> ii = placementMap.get("II");
        Set<Long> jj = placementMap.get("JJ");
        Set rr = new HashSet();
        int qq = 0;
        for (Long a : aa) {
            if (qq++ % 5 == 0) System.out.println(String.format("---%s/%s", qq, aa.size()));
            for (Long b : bb) {
                if ((a & b) != 0) continue;
                long b0 = a | b;
                for (Long c : cc) {
                    if ((b0 & c) != 0) continue;
                    long c0 = b0 | c;
                    for (Long d : dd) {
                        if ((c0 & d) != 0) continue;
                        long d0 = c0 | d;
                        for (Long e : ee) {
                            if ((d0 & e) != 0) continue;
                            long e0 = d0 | e;
                            for (Long f : ff) {
                                if ((e0 & f) != 0) continue;
                                long f0 = e0 | f;
                                for (Long g : gg) {
                                    if ((f0 & g) != 0) continue;
                                    long g0 = f0 | g;
                                    for (Long h : hh) {
                                        if ((g0 & h) != 0) continue;
                                        long h0 = g0 | h;
                                        for (Long i : ii) {
                                            if ((h0 & i) != 0) continue;
                                            long i0 = h0 | i;
                                            for (Long j : jj) {
                                                if ((i0 & j) == 0) {
                                                    Object[] r = Arrays.asList(a, b, c, d, e, f, g, h, i, j).stream().sorted().toArray();
                                                    rr.add(r);
                                                    System.out.println(String.format("Got NO.%s result >", rr.size()));
                                                    printSolution(target, r);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
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

    public static void printSolution(int[][] target, Object... r) {
        if (MatrixUtil.isEmpty(target)) {
            return;
        }
        char[][] pp = new char[target.length][target[0].length];
        List<int[][]> rr = new LinkedList<>();
        rr.add(target);
        for (Object o : r) {
            rr.add(MatrixUtil.longToArray((Long) o));
        }
        int p1 = 0;
        for (int[][] p : rr) {
            for (int i = 0; i < target.length; i++) {
                for (int j = 0; j < target[0].length; j++) {
                    if (0 != p[i][j]) {
                        pp[i][j] = (char) ('`' + p1);
                    }
                }
            }
            p1++;
        }
        for (char[] p : pp) {
            System.out.println(Arrays.toString(p));
        }
    }
}
