/**
 * 除自身以外数组的乘积
 */
public class ProductOfArraysOtherThanItself {
    // 前缀积
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        pre[0] = nums[0];
        suf[nums.length - 1] = nums[nums.length - 1];
        int left = 1;
        int right = nums.length - 2;
        while (left != nums.length - 1) {
            pre[left] = pre[left - 1] * nums[left];
            suf[right] = suf[right + 1] * nums[right];
            left++;
            right--;
        }

        result[0] = suf[1];
        result[nums.length - 1] = pre[nums.length - 2];
        for (int i = 1; i < nums.length-1; i++) {
            result[i] = pre[i - 1] * suf[i + 1];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        // 左数组，left[i]代表i左边数乘积
        int[] left = new int[nums.length];
        left[0] = 1;
        // 右数组，right[i]代表i右边数乘积
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;

        int leftTemp = 1;
        int rightTemp = 1;

        for (int i = 1; i < nums.length; i++) {
            leftTemp *= nums[i - 1];
            left[i] = leftTemp;

            rightTemp *= nums[nums.length - i];
            right[nums.length - 1 - i] = rightTemp;
        }

        // 两数相乘即可
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

}
