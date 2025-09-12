package interview;

import java.util.HashMap;

public class SumK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put (0,1);
        int preSum = 0;
        int ans = 0;
        for(int num : nums){
            preSum += num;
            if(map.containsKey(preSum - k)){
                ans += map.get(preSum - k);
            }
            map.put(preSum,map.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }
}
