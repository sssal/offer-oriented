package arrayfind;

import static java.lang.Math.round;

public class Solution {
    public boolean Find(int target,int[][] array){
        int endX = array[0].length,
            endY = array.length;
        int startX = 0,
                startY = 0;

        int xIndex = array.length-1,
                yIndex = 0;
        while(yIndex<=array[0].length-1 && xIndex>=0){
            if(target>array[xIndex][yIndex]){
                yIndex++;
            }else if(target<array[xIndex][yIndex]){
                xIndex--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(new Solution().Find(1,a));
    }
}
