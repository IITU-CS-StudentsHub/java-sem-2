package lecture_1;

// Bitwise Operators: &, |, ^, ~, <<, >>, >>>, &=, |=, ^=, <<=, >>=, >>>=
// & - Bitwise AND
// | - Bitwise OR
// ^ - Bitwise XOR
// ~ - Bitwise Complement
// << - Left Shift
// >> - Right Shift
// >>> - Unsigned Right Shift
// &= - Bitwise AND Assignment
// |= - Bitwise OR Assignment
// ^= - Bitwise XOR Assignment
// <<= - Left Shift Assignment
// >>= - Right Shift Assignment
// >>>= - Unsigned Right Shift Assignment
// n >> k = n / 2^k
// n << k = n * 2^k
public class Main {
		public static void main(String[] args) {
			int a = 5; // 101
			int b = 7; // 111
			int c = a & b; // 101 & 111 = 101
			System.out.println(c); // 5
			c = a | b; // 101 | 111 = 111
			System.out.println(c); // 7
			c = a ^ b; // 101 ^ 111 = 010
			System.out.println(c); // 2
			c = ~a; // ~101 = 010
			System.out.println(c); // -6
			c = a << 1; // 101 << 1 = 1010
			System.out.println(c); // 10
			c = a >> 1; // 101 >> 1 = 10
			System.out.println(c); // 2
			c = a >>> 1; // 101 >>> 1 = 10
			System.out.println(c); // 2
			c = 5;
			c &= 3; // 101 & 011 = 001
			System.out.println(c); // 1
			c = 5;
			c |= 3; // 101 | 011 = 111
			System.out.println(c); // 7
			c = 5;
			c ^= 3; // 101 ^ 011 = 110
			System.out.println(c); // 6
			c = 5;
			c <<= 1; // 101 << 1 = 1010
			System.out.println(c); // 10
			c = 5;
			c >>= 1; // 101 >> 1 = 10
			System.out.println(c); // 2
			c = 5;
			c >>>= 1; // 101 >>> 1 = 10
			System.out.println(c); // 2
		}
}