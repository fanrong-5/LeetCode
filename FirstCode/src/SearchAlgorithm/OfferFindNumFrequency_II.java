package SearchAlgorithm;
import java.util.* ;

/**
 * @author fanrong
 * @create 2021/9/18 4:00 下午
 * @strParser 将字符串转化为整型数组
 *
 * 题目描述：在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *         请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 输入：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 输出：
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false
 */

public class OfferFindNumFrequency_II {

    public static int[] strParser(String str){

        // 通过split方法，将【字符】转化为【字符串数组】
        String[] strArr = str.split(",");

        // 将【字符串数组】转化为【整型数组】
        int[] numArr = new int[strArr.length];
        for(int i =0;i< strArr.length;i++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        return numArr;
    }

    public static boolean findNumFrequency(int[][] matrix,int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {  // 判断数组是否为空
            return false;
        }

        int rows = matrix.length,columns = matrix[0].length;
        int row = 0,column = columns-1 ;
        while (row<rows && column >0){
            if(matrix[row][column]==target){
                return true;
            }else if(matrix[row][column]>target){
                column --;
            }else{
                row ++;
            }
        }

        return false;

    }

    public static void main(String args[]){

        Scanner sc1 = new Scanner(System.in);
        int target = sc1.nextInt();

        // 输入多行数据：未知长度的二维数组
        ArrayList<int[]> input = new ArrayList<>();
        do{
            Scanner sc = new Scanner(System.in);
            String numStr = sc.nextLine();   // 接收 字符串
            if(numStr.equals("")){
                break;
            }
            input.add(strParser(numStr));  // 将字符串转化为数组 并存储到ArrayLis中
        }while(true);

        // 将输入的数组转化为二维数组
        int row = input.size();
        int column = input.get(0).length;

        int[][] nums = new int[row][column];
        for(int i =0;i<row;i++){
            for(int j=0;j<column;j++){
                nums[i][j] = input.get(i)[j];
            }
        }

        // 调用寻找数字函数
        System.out.println(findNumFrequency(nums,target));

    }
}
