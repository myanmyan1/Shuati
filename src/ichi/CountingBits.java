/**
 * 
 */
package ichi;

/**
 * @author kje511
 *
 */
public class CountingBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = countBits(0);
		
		int i=0;

	}

	public static int[] countBits(int num) {
		int[] result = new int[num+1];

		result[0] = 0;
		
		for (int i=1; i<=num; i++) {
			int sub = i /2;
			int remain = i%2;
			
			int subtotal = remain + result[sub];
			
			result[i] = subtotal;
		}
		return result;
	}
}
