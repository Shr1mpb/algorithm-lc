import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));// 按第一个元素排序
        int mergeCount = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            // 取出第一个元组 开始向后合并
            int[] cur = intervals[i];
            int[] next = intervals[i + 1];
            if (cur[1] >= next[0]) {// 可以合并
                intervals[i] = null;// 标记已被合并 合并就向后移动 以便下一次合并其他的元组
                mergeCount++;
                if (cur[1] < next[1]) {
                    intervals[i + 1] = new int[]{cur[0], next[1]};
                }else{
                    intervals[i + 1] = new int[]{cur[0], cur[1]};
                }
            }
            // 不能合并 正常循环向后
        }
        // 合并都已完成 取出intervals中不为null的元素即可
        int[][] ret = new int[intervals.length - mergeCount][];
        int index = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                ret[index++] = interval;
            }
        }
        return ret;
    }
}
