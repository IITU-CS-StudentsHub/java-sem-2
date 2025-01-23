package tasks;

// Task 4
// INPUT: [1,3,5,1,2,2]
// OUTPUT: 3, 5
// 1 ^ 3 ^ 5 ^ 1 ^ 2 ^ 2 = 3 ^ 5
// using XOR operation to find unique numbers
public class TwoUniqueNumbersXOR_04 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 1, 2, 2};
        int[] result = findTwoUniqueNumbers(arr);
        System.out.println("Unique numbers: " + result[0] + ", " + result[1]);
    }

    public static int[] findTwoUniqueNumbers(int[] arr) {
        int xorResult = 0;

        // Применяем XOR ко всем числам в массиве
        for (int num : arr) {
            xorResult ^= num;
        }

        // Найдем бит, который отличается между двумя уникальными числами
        int rightmostSetBit = xorResult & -xorResult;

        // Разделяем элементы на две группы и применяем XOR для каждой
        int num1 = 0, num2 = 0;
        for (int num : arr) {
            if ((num & rightmostSetBit) != 0) {
                num1 ^= num;  // Группа с установленным битом
            } else {
                num2 ^= num;  // Группа с неустановленным битом
            }
        }

        return new int[] {num1, num2};
    }
}
