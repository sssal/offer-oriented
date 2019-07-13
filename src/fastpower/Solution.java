package fastpower;




public class Solution {
    public double PowerBit(double base, int exponent){
        int symbol = 1;
        if (exponent < 0) {
            if ((base - 0) < 0.000001 && (base - 0) > -0.000001) {
                return Double.POSITIVE_INFINITY;
            }else{
                symbol = -1;
                exponent = -exponent;
            }
        }
        if (exponent == 0) {
            return 1.0;
        }

        double result = 1.0;
        while(exponent != 0){
            if((exponent&1) == 1){
                result*=base;
            }
            exponent>>=1;
            base*=base;
        }

        if(symbol == -1) {
            return 1/result;
        }else{
            return result;
        }
    }

    public double Power(double base, int exponent) {
        int symbol = 1;
        if (exponent < 0) {
            if ((base - 0) < 0.000001 && (base - 0) > -0.000001) {
//                throw new RuntimeException("分母不为零");
                return Double.POSITIVE_INFINITY;
            }else{
                symbol = -1;
                exponent = -exponent;
            }
        }
        if (exponent == 0) {
            return 1.0;
        }

        if(exponent == 1){
            if(symbol == 1){
                return base;
            }else{
                return 1/base;
            }
        }

        if ((exponent & 1) == 1) {
            if(symbol == 1) {
                return Power(base * base, exponent >> 1) * base;
            }else{
                return 1/(Power(base * base, exponent >> 1) * base);
            }
        } else {
            if(symbol == 1){
                return Power(base * base, exponent >> 1);
            }else{
                return 1/Power(base * base, exponent >> 1);
            }

        }
    }
}

class Test{
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(Math.pow(0, -2));
        solution.Power(0, -2);
        System.out.println(solution.Power(0,-2)==Math.pow(0,-2));
    }
}
