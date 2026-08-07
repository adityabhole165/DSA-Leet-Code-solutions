import java.util.*;

class Solution {
    public String smallestNumber(String num, long t) {
        long tt = t;
        int a = 0, b = 0, c = 0, d = 0;
        while (tt % 2 == 0) { tt /= 2; a++; }
        while (tt % 3 == 0) { tt /= 3; b++; }
        while (tt % 5 == 0) { tt /= 5; c++; }
        while (tt % 7 == 0) { tt /= 7; d++; }
        if (tt != 1) return "-1"; // t has a prime factor no digit can ever supply

        // f[i][j] = min digits (from 2,3,4,6,8,9) to reach >= i twos and >= j threes
        long[][] f = new long[a + 1][b + 1];
        int[][] digitEx = { {1,0}, {0,1}, {2,0}, {1,1}, {3,0}, {0,2} }; // 2,3,4,6,8,9
        final long INF = Long.MAX_VALUE / 2;
        for (long[] row : f) Arrays.fill(row, INF);
        f[0][0] = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i == 0 && j == 0) continue;
                long best = INF;
                for (int[] ex : digitEx) {
                    int pi = Math.max(0, i - ex[0]);
                    int pj = Math.max(0, j - ex[1]);
                    if (pi == i && pj == j) continue;
                    best = Math.min(best, f[pi][pj] + 1);
                }
                f[i][j] = best;
            }
        }

        int n = num.length();
        int[] e2 = new int[n + 1], e3 = new int[n + 1], e5 = new int[n + 1], e7 = new int[n + 1];
        int firstZero = -1;
        for (int i = 0; i < n; i++) {
            int dg = num.charAt(i) - '0';
            if (dg == 0 && firstZero == -1) firstZero = i;
            int[] ex = exponents(dg);
            e2[i+1] = e2[i] + ex[0];
            e3[i+1] = e3[i] + ex[1];
            e5[i+1] = e5[i] + ex[2];
            e7[i+1] = e7[i] + ex[3];
        }

        if (firstZero == -1) {
            int la = Math.max(0, a - e2[n]), lb = Math.max(0, b - e3[n]);
            int lc = Math.max(0, c - e5[n]), ld = Math.max(0, d - e7[n]);
            if (la == 0 && lb == 0 && lc == 0 && ld == 0) return num;
        }

        int maxI = (firstZero == -1) ? n - 1 : firstZero;
        String sameLen = null;
        for (int i = maxI; i >= 0 && sameLen == null; i--) {
            int origD = num.charAt(i) - '0';
            int startD = (origD == 0) ? 1 : origD + 1;
            for (int dgt = startD; dgt <= 9; dgt++) {
                int[] ex = exponents(dgt);
                int ta2 = e2[i] + ex[0], ta3 = e3[i] + ex[1], ta5 = e5[i] + ex[2], ta7 = e7[i] + ex[3];
                int la = Math.max(0, a - ta2), lb = Math.max(0, b - ta3);
                int lc = Math.max(0, c - ta5), ld = Math.max(0, d - ta7);
                int remLen = n - 1 - i;
                long need = f[la][lb] + lc + ld;
                if (need <= remLen) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i).append((char) ('0' + dgt));
                    sb.append(greedyFill(f, la, lb, lc, ld, remLen));
                    sameLen = sb.toString();
                    break;
                }
            }
        }
        if (sameLen != null) return sameLen;

        long M = f[a][b] + c + d;
        int L = (int) Math.max(n + 1, M);
        return greedyFill(f, a, b, c, d, L);
    }

    private int[] exponents(int dg) {
        switch (dg) {
            case 1: return new int[]{0,0,0,0};
            case 2: return new int[]{1,0,0,0};
            case 3: return new int[]{0,1,0,0};
            case 4: return new int[]{2,0,0,0};
            case 5: return new int[]{0,0,1,0};
            case 6: return new int[]{1,1,0,0};
            case 7: return new int[]{0,0,0,1};
            case 8: return new int[]{3,0,0,0};
            case 9: return new int[]{0,2,0,0};
            default: return new int[]{0,0,0,0};
        }
    }

    private String greedyFill(long[][] f, int a, int b, int c, int d, int len) {
        StringBuilder sb = new StringBuilder();
        int curA = a, curB = b, curC = c, curD = d;
        for (int pos = 0; pos < len; pos++) {
            int remLenAfter = len - pos - 1;
            for (int dgt = 1; dgt <= 9; dgt++) {
                int[] ex = exponents(dgt);
                int na = Math.max(0, curA - ex[0]), nb = Math.max(0, curB - ex[1]);
                int nc = Math.max(0, curC - ex[2]), nd = Math.max(0, curD - ex[3]);
                long need = f[na][nb] + nc + nd;
                if (need <= remLenAfter) {
                    sb.append((char) ('0' + dgt));
                    curA = na; curB = nb; curC = nc; curD = nd;
                    break;
                }
            }
        }
        return sb.toString();
    }
}