package xiaohongshu;

import java.util.Scanner;

public class Main {
    public static int step = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        boolean[][] blocked = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            blocked[x][y] = true;
        }
        dfs(blocked, 0, 0, 0, n, m);
        System.out.println(step);

    }

    public static void dfs(boolean[][] found, int x, int y, int len, int n, int m) {
        if (x < n && x >= 0 && y < m && y >= 0 && !found[x][y]) {
            boolean[][] tmpFound = new boolean[n][m];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    tmpFound[i][j] = found[i][j];
                }
            }

            tmpFound[x][y] = true;
//            System.arraycopy();
            if (x == n - 1 && y == m - 1) {
                if (step == 0) {
                    step = len;
                } else {
                    step = Math.min(step, len);
                }
            } else {
                len++;
                dfs(tmpFound, x + 1, y, len, n, m);
                dfs(tmpFound, x - 1, y, len, n, m);
                dfs(tmpFound, x, y + 1, len, n, m);
                dfs(tmpFound, x, y - 1, len, n, m);
            }
        }
    }
}
