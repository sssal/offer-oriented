package xiaohongshu;

import java.util.Scanner;

public class Main2 {
    public static int step = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        String[] input = new String[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            input[i] = in.nextLine();
        }
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (input[j].charAt(i) == '.') {
                    arr[j][i] = 0;
                } else if (input[j].charAt(i) == '#') {
                    arr[j][i] = 1;
                } else if (input[j].charAt(i) == 'S') {
                    arr[j][i] = 2;
                    startX = j;
                    startY = i;
                } else {
                    arr[j][i] = 3;
                    endX = j;
                    endY = i;
                }
            }
        }
        dfs(arr, startX, startY, 0, n);
        System.out.println(step);

    }

    public static void dfs(int[][] found, int x, int y, int len, int n) {
        if(x==n){
            x=0;
        }
        if(x == -1){
            x = n-1;
        }
        if(y == n){
            y=0;
        }
        if(y == -1){
            y = n-1;
        }

        if (found[x][y] != 1 ) {
            if (found[x][y] == 3) {
                if (step == -1) {
                    step = len;
                } else {
                    step = Math.min(step, len);
                }
            } else {
                int[][] tmpFound = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        tmpFound[i][j] = found[i][j];
                    }
                }
                tmpFound[x][y] = 1;


                len++;
                dfs(tmpFound, x + 1, y, len, n);
                dfs(tmpFound, x - 1, y, len, n);
                dfs(tmpFound, x, y + 1, len, n);
                dfs(tmpFound, x, y - 1, len, n);
            }
        }

    }
}
