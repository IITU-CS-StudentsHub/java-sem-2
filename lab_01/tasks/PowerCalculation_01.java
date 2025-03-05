package lab_01.tasks;

// Task: 1
// INPUT: 5 5
// OUTPUT: 3125
// Note: Don't use lib
public class PowerCalculation_01 {
    public static void main(String[] args) {
        int base = 5;
        int exponent = 5;
        int result = 1;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }

        System.out.println("5^5 = " + result);
    }
}