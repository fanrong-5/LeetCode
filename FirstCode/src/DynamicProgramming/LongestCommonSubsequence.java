package DynamicProgramming;

/**
 * @author didi
 * @create 2021/9/18 6:53 下午
 * 最长公共子序列
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        /*思路：二维动态规划
        注意：数组 字符串*/
        int m=text1.length();
        int n=text2.length();
        int[][] a=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char c1=text1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char c2=text2.charAt(j-1);
                if(c1==c2){
                    a[i][j]=a[i-1][j-1]+1;
                }
                else{
                    a[i][j]=Math.max(a[i][j-1],a[i-1][j]);
                }
            }
        }

        return a[m][n];

    }

}
