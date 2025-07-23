import java.util.Arrays;

/**
 * 轮转数组
 */
public class RotatingArray {
    public void rotate(int[] nums, int k) {
        int rotateNum = k % nums.length;
        if (k == 0) {
            return;
        }
        // 反转法：三次反转
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rotateNum - 1);
        reverse(nums, rotateNum, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
