/**
 * 寻找两个正序数组的中位数
 * // TODO 寻找分割线 死循环注意
 */
public class FindMedianOfTwoPositiveOrderedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {// 让nums1永远都是较短的一方
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = m + (n - m + 1) / 2;// 奇数偶数都适用 分割线左边的元素个数

        // 定义分割线为 下标位置 = 左边元素个数(分割线是右边第一个元素的下标)
        // 那么分割线满足 i+j = (m+n-1)/2
        // 开始在第一个数组中寻找分割线的位置
        int left = 0;
        int right = m;
        // nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        while (left < right) {//最终有 left == right 时,找到分割线
            int i = left + (right - left + 1) / 2;// 取中间位置作为第一个数组的分割线
            int j = totalLeft - i; // 第二个数组左边元素的个数(第二个数组的分割线索引)
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                // 分割线需要左移
                right = i - 1;// mid - 1
            }else {
                // 分割线需要右移/不移动
                left = i;// 两个元素会出现死循环 left不再变化 所以i那个地方要+1 向上取整
            }
        }
        int i = left;
        int j = totalLeft - i;
        // 注意在分割线位置特殊的时候 让参与比较的元素不被选中
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 1) {// 偶数
            return Math.max(nums1LeftMax, nums2LeftMax);
        }else{// 奇数
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }
}
