package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author fanrong
 * @create 2021/10/10 11:47 上午
 */
public class MeiTuanTest3 {
    public static  int solution(int[] nums,int n){
        int res =0;
        return res;

    }
    public static  void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        // 哈希表
        Map<Integer,Integer> fre = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
            }
        }
        System.out.println(solution(nums,n));
    }
}
