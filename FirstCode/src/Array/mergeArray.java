package Array;

import java.util.Scanner;
import java.util.*;

/**
 * 题目：合并两个有序数据
 * 输入：循环输入-输出，输入一次输出一次
 * 第一行：数组1的个数
 * 第二行：数组1（用空格分隔开）
 * 第三行：数组2的个数
 * 第四行：数组2（用空格分隔开）
 */
public class mergeArray {
    public static  void main(String args[]){
        int[] num1 = new int[100];
        int[] num2 = new int[100];

        Scanner sc =new Scanner(System.in);

       while(sc.hasNext()){
           int len1 = sc.nextInt();
           for(int i=0;i<len1;i++){
               num1[i]=sc.nextInt();
           }
           int len2 = sc.nextInt();
           for(int j=0;j<len2;j++){
               num2[j]=sc.nextInt();
           }

           mergeArray m = new mergeArray();
           m.merge(num1,len1,num2,len2);  // 调用 数组合并 函数
           for(int x=0;x<len1+len2;x++){
               System.out.print(num1[x]+" ");
           }
       }

    }

/*
* 整体思路：
* 依次遍历两个数组 建立新数组 从两个数组中选择合适的元素 放到新数组中
* 难点：
* 1-整体的循环条件：两个数组至少有一个没有遍历结束
* 2-元素的选择条件：临界条件（两个数组分别遍历到了最后一个） 普通条件：选择比较大的元素
* 3-指针的移动与新数组指针的选择 */


    public void merge(int[] num1,int m,int[] num2,int n){
        int index1 = 0;  // 设置指针 从头开始遍历数组
        int index2 = 0;
        int[] num = new int[m+n]; //新数组
        int temp; // 临时存放被选择下来的元素
        while(index1<m || index2<n){
            if(index1==m){                // 边界条件1：数组1 的最后一个元素
                temp=num2[index2];
                index2++;
            }
            else if (index2==n){
                temp = num1[index1];
                index1++;
            }
            else if(num1[index1]<num2[index2]){
                temp = num1[index1];
                index1++;
            }
            else{
                temp = num2[index2];
                index2++;
            }
            num[index1+index2-1] = temp;
        }
        for(int i=0;i != m+n;i++){
            num1[i]=num[i];
        }



    }

}
