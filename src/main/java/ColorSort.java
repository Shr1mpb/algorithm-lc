/**
 * 颜色分类
 * // TODO: 手写快排、插入排序
 */
public class ColorSort {
    // 原地排序： 此处手写一个快排和插入排序
    public void sortColors(int[] nums) {
//        insertionSort(nums);
        quickSort(nums, 0, nums.length - 1);
    }

    private void insertionSort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0 && temp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = paration(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private int paration(int[] nums, int low, int high) {
        int pivot = nums[low];
        int left = low + 1;
        int right = high;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        swap(nums, low, right);
        return right;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
