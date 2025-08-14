package review1;

/**
 * 缺失的第一个正数
 * 1 ~ N+1 原地负号标记法
 * // TODO
 */
public class MissingFirstPositiveNumber {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 置所有的非正数为n+1 因为不在讨论范围内 还可能影响标记
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 给原本是正数的地方 在数组中打标记 标记点为：nums[数字 - 1] 标记为负数
        for (int i = 0; i < n; ++i) {
            int abs = Math.abs(nums[i]);
            if (abs > 0 && abs <= n) {// 原本是正数的有标记意义的数 (包含了没遍历到但是被打了标记的数 原本非正数的数应该都会被设置为abs=n+1 大于n的数标记也没有意义)
                nums[abs - 1] = -Math.abs(nums[abs - 1]);
            }
        }
        // 遍历 如果全是负数 说明1~N全都有 直接返回n+1
        // 如果发现正数 说明没有被标记 标记位置i对应的数 i+1 是缺失正数
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        MissingFirstPositiveNumber mf = new MissingFirstPositiveNumber();
        System.out.println(mf.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
