package OfferJZ;
import java.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author didi
 * @create 2021/7/29 10:17 下午
 */
public class OfferSolutions {
    public static void main(String args[]){

        // 输入数组长度与数组
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums =  new int[n];

        // 获取数组长度与数组
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        // 调用findRepeatNumber方法
        OfferSolutions solution = new OfferSolutions();
        int repeat = solution.findRepeatNumber(nums);
        System.out.println("重复数字是："+ repeat);

    }

    public int findRepeatNumber(int[] nums){

        // 创建一个集合：该集合不允许有重复值
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;

        // 遍历数组中的每一个元素 如果数组中的元素无法插入到集合中 则证明是重复元素
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;

    }
}
