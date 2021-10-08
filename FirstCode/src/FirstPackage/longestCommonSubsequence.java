package FirstPackage;
/*  最长公共子序列问题
*
* 思路：二维动态规划
* 注意点：
* 1-数学函数 Math.max() 函数的写法
* 2-注意二维数组和字符串的用法不要搞混*/

import java.util.Scanner;

public class longestCommonSubsequence {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        int m=str1.length();
        int n=str2.length();
        int[][] a =new int[m+1][n+1];  //创建m+1行  n+1列的二维数组
        for(int i=1;i<=m;i++){
            char c1 = str1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char c2 = str2.charAt(j-1);
                if(c1 == c2){
                    a[i][j]=a[i-1][j-1]+1;
                }
                else{
                    a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
                }
            }
        }
        System.out.println(a[m][n]);

    }
}
