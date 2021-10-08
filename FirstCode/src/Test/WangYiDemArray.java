package Test;

/**
 * @author fanrong
 * @create 2021/9/17 8:56 下午
 * 输入：
 * 2 2 3  表示：是一个2*2*3的数组
 * 2      表示：接下来输入两行
 * 2 0    表示：第3维度 下表为0的位置 进行+1操作
 * 1 1    表示：第2维度 下表为1的位置 进行+1操作
 */

import java.util.*;
public class WangYiDemArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int n = in.nextInt();
        int[][][] nums = new int[x][y][z]; //定义新的数组
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                for(int p = 0;p<z;p++){
                    nums[i][j][p] = 0;
                }
            }
        }
        for(int i = 0;i<n;i++){
            int dem = in.nextInt();
            int index = in.nextInt();
            if(dem == 0){
                for(int p =0;p<y;p++){
                    for(int j=0;j<z;j++){
                        nums[index][p][j] = nums[index][p][j]+1;
                    }
                }
            }else if(dem == 1){
                for(int p =0;p<x;p++){
                    for(int j=0;j<z;j++){
                        nums[p][index][j]+=1;
                    }
                }
            }else{
                for(int p =0;p<x;p++){
                    for(int j=0;j<y;j++){
                        nums[p][j][index]+=1;
                    }
                }
            }
        }

        // 输出结果
        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                for(int p = 0;p<z;p++){
                    System.out.print(nums[i][j][p]) ;
                    System.out.print(" ") ;
                }
            }
        }
    }
}
