package FirstPackage;

import java.util.Scanner;

/* 翻转字符串
* 1-输入：字符串 转换到数组中
* 2-循环 交换*/
public class reverseString {
    public static void main(String args[]){
        // 输入一个字符串 定义字符类型的数组
        char[] c = new char[100];
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i=0;i<str.length();i++){
            c[i] = str.charAt(i);
        }
        // 翻转
        int left=0,right=str.length()-1;
        while(left<right){
            char temp = c[left];
            c[left]=c[right];
            c[right]=temp;
            left++;
            right--;
        }
        // 输出结果
        for(int j=0;j<str.length();j++){
            System.out.print(c[j]);
        }
    }
}
