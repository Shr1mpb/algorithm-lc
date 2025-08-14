package review1;

import java.util.*;

/**
 * 字母异位词分组
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            }else{
                map.put(sortedStr, new ArrayList<>());
                map.get(sortedStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
