package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanrong
 * @create 2021/10/10 11:17 上午
 */
public class MeiTuanTest2 {
    public static int solution(int[] nums,int len,int target){
        int res = 0;
        Arrays.sort(nums);
        for (int i=0;i<len;i++){

            if(nums[i]>target) break;
            for(int j=i+1;j<len;j++){
                if(nums[i]+nums[j]<=target) res++;
            }
        }

        return res;
    }
    public static  void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(solution(nums,n,m));
    }
}
