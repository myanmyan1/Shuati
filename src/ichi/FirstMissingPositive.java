/**
 * 
 */
package ichi;

/**
 * @author kje511
 *
 */
public class FirstMissingPositive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 1};

        int result = firstMissingPositive(nums);
        System.out.println(result);

    }

    public static int firstMissingPositive(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (nums[i] == i + 1) {
                continue;
            }

            while (nums[i] != i + 1) {
                int temp = nums[i];
                if (temp <= 0 || temp > size) {
                    break;
                }

                // Switch numbers
                int indexTobeReplaced = temp - 1;
                if (nums[indexTobeReplaced] == temp) {
                    break;
                }
                nums[i] = nums[indexTobeReplaced];
                nums[indexTobeReplaced] = temp;
            }

        }

        for (int i = 0; i < size; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return size + 1;
    }

}
