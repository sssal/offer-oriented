package 机器人移动范围;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        boolean[][] symbol = new boolean[m][n];
        int sum = 0;

        isSuit(0, 0, m, n, k, symbol);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (symbol[i][j]) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    public static void isSuit(int x, int y, int m, int n, int k, boolean[][] symbol) {
        if (x >= 0 && x < m && y >= 0 && y < n && !symbol[x][y]) {
            int xsum = bitsum(x);
            int ysum = bitsum(y);
            if (xsum + ysum <= k) {
                symbol[x][y] = true;
                isSuit(x + 1, y, m, n, k, symbol);
                isSuit(x - 1, y, m, n, k, symbol);
                isSuit(x, y + 1, m, n, k, symbol);
                isSuit(x, y - 1, m, n, k, symbol);
            }
        }
    }

    public static int bitsum(int num) {
        if (num < 10) {
            return num;
        } else {
            return num / 10 + num % 10;
        }
    }
}