package DynamicProgramming;
import java.util.*;
/**
 * @author fanrong
 * @create 2021/9/18 6:51 下午
 * 连续子数组的最大和
 * 输入：以空空格分隔的数组
 * 输出：最大和
 */
public class OfferMaxSubArray {

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);   // 找出以当前元素结尾的子数组的最大和:是x和 pre+x 比较，不是pre 和pre+x 比较
            maxAns = Math.max(maxAns, pre);  // 比较当前子数组的最大和 和 当前最大值的 大小
        }
        return maxAns;
    }


    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();
        while(sc.hasNextInt()){
            inputList.add(sc.nextInt());
        }

        int[] nums = new int[inputList.size()];
        for(int i=0;i<inputList.size();i++){
            nums[i] = inputList.get(i);
        }

        System.out.println(maxSubArray(nums));
    }
}
