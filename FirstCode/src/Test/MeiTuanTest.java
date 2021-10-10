package Test;

import java.util.*;

/**
 * @author fanrong
 * @create 2021/10/10 9:59 上午
 */
public class MeiTuanTest {
    public static int solution(int[] num1,int[] num2,int value){
        int res = 0;
        int len = num1.length;
        int i =0;
        while(i<len){
            if(num1[i]==num2[i]) i++;
            int diff = 0;
            while(i<len&&num1[i]!=num2[i]){
                diff++;
                i++;
            }
            if(diff>0) res++;
        }
        if(res>value) return res;
        else return 0;



    }
    public static void main(String args[]){
        // 输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();

        // 新建两个列表
        /*ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();*/

        int index1 = 0,index2=0;   // 数组末尾索引

        int[] num1 = new int[1000000];
        int[] num2 = new int[1000000];
        for(int i=0;i<1000000;i++){
            num1[i] = -1;
            num2[i] = -1;
        }

        // 第一个
        for(int i=0;i<m;i++){
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int v1 = sc.nextInt();
            for(int j=l1;j<r1+1;j++){
                num1[j] = v1;
            }
            if(i==m-1)  index1 = r1;

        }

        // 第二个
        for(int i=0;i<n;i++){
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int v1 = sc.nextInt();
            for(int j=l1;j<r1+1;j++){
                num2[j] = v1;
            }
            if(i==m-1)  index2 = r1;

        }

        int size = Math.max(index1,index2) +1;

        // 调用函数
        System.out.println(solution(Arrays.copyOfRange(num1,0,size),Arrays.copyOfRange(num2,0,size),t));

    }


}

