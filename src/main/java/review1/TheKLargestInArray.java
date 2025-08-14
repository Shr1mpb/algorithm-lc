package review1;

/**
 * 数组中的第K个最大元素
 */
public class TheKLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        int[] lar = new int[20001];
        // 数字在的位 +1 (因为数字有负数 所以数字所对应的位在数组中+10000)
        for (int num : nums) {
            lar[num + 10000]++;
        }
        for (int i = lar.length - 1; i >= 0; i--) {
            k -= lar[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return nums[0];
    }
}
