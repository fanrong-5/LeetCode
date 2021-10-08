package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fanrong
 * @create 2021/9/21 11:30 上午
 */

public class OfferLengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String str){

        int res = 0,tmp = 0;

        // 创建hashmap 用于存储元素最后一次出现的频数
        HashMap<Character,Integer> hash = new HashMap<>();

        for(int j = 0; j < str.length(); j++) {
            int i = hash.getOrDefault(str.charAt(j), -1); // 获取索引 i
            hash.put(str.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }

        return res;
    }
}
