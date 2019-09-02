package 分硬币;

public class Solution {

    int count = 0;
    int[] arr;

    public int calculateWays(int n) {
        arr = new int[n + 1];
        return calculateWays1(n);
    }

    //记忆化搜索递归
    private int calculateWays1(int n) {
        if (n < 0)
            throw new IllegalArgumentException("input wrong");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2 || n == 3)
            return 2;
        if (n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9)
            return n - 1;
        if (n == 10)
            return 11;
        if (arr[n] != 0)
            return arr[n];
        int res = 0;
        res = Math.max(Math.max(calculateWays1(n - 1) + 1, calculateWays1(n - 2) + 2), Math.max(calculateWays1(n - 5) + 4, calculateWays1(n - 10) + 11));
        arr[n] = res;
        return res;
    }

    //动态规划
    public static int countWays(int[] coins, int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= n; ++j) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int n = 20;
        System.out.println(countWays(coins, n));

    }
}
