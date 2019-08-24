package numberof1;

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String temp = "" + i;
            while (temp.length() != 0) {
                if (temp.contains("1")) {
                    sum++;
                    temp = temp.substring(temp.indexOf("1") + 1);
                } else {
                    break;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 20;
        System.out.println(solution.NumberOf1Between1AndN_Solution(n));
    }
}
