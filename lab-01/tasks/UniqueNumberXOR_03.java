// Task 3
// INPUT: [1,3,1,2,2]
// OUTPUT: unique = 3
// using XOR
public class UniqueNumberXOR_03 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 2};
        int unique = findUniqueNumber(arr);
        System.out.println("unique = " + unique);
    }

    public static int findUniqueNumber(int[] arr) {
        int unique = 0;

        // Применяем XOR ко всем числам в массиве
        for (int num : arr) {
            unique ^= num;
        }

        return unique;
    }
}
