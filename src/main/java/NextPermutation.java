/**
 * 下一个排列
 * // TODO: 方法记忆 从右边找第一个降序元素位置i 找到后再从右边找第一个比降序元素大的元素 交换位置后，从i+1翻转
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从右边开始找到第一个降序的元素 即右边的已经最大了，需要变小
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 找到降序的右边元素的第一个比nums[i]大的元素(一定存在)
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);// 交换位置
        }
        reverse(nums, i + 1);// 直接反转 得到下一个右边最小
    }


    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
