package DynamicProgramming;
import java.util.*;

/**
 * @author fanrong
 * @create 2021/9/18 6:52 下午
 * 题目描述：礼物的最大价值
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 */
public class OfferMaxValue {
    public static int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;   // 特殊情况1
                if(i == 0) grid[i][j] += grid[i][j - 1] ;  // 特殊情况2
                else if(j == 0) grid[i][j] += grid[i - 1][j];  // 特殊情况3
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        // 已知二维数组的大小
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][]  grip = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                grip[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxValue(grip));
    }

}
