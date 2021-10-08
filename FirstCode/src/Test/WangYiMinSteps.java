package Test;

/**
 * @author fanrong
 * @create 2021/9/17 7:53 下午
 * 题目：最少步数
 * 输入：
 * 第一行：2,3,1,1,4
 * 第n行：1,7,6,5,9
 * 输出：
 * 2
 * 2
 */

import java.util.*;

public class WangYiMinSteps {

    public static int minSteps(String input){

        // 并将每个字符存储到一个数组中:运用split()函数根据匹配给定的正则表达式来拆分此字符串
        String[] string = input.split(",");

        // 定义一个数组，用来存储取出来的string.length个元素
        int len = string.length;
        int[] nums = new int[len];
        for (int i = 0; i < string.length; i++) {
            //将字符串参数作为有符号的十进制整数进行解
            nums[i] = Integer.parseInt(string[i]);
        }

        int index = 0, result = 0;

        while (index < len - 1) {
            int step = nums[index];  // step是当前的步数
            int max = 0, maxIndex = 0;   // max就是下一个最大步数
            for (int j = 1; j <= step; j++) {
                if (index + j < len) {
                    int temp = nums[index + j];
                    if (temp > max) {
                        max = temp;
                        maxIndex = index + j;
                    }
                } else {
                    maxIndex = len;
                    break;
                }
            }
            result++;
            index = maxIndex;
        }
        return result;
    }

    public static void main(String[] args) {

        // 循环输入
        ArrayList<String> inputList = new ArrayList<>();
        do{
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(str.equals("")){
                break;
            }
            inputList.add(str);
        }while (true);

        // 定义一个可变长度的数组，用于存放结果
        ArrayList<Integer> results = new ArrayList<>();

        // 循环计算每一个数组
        for(int x=0;x<inputList.size();x++){

            // 定义一个字符串: 表示当前的数组
            String input = inputList.get(x);
            // 得到结果
            results.add(minSteps(input));
        }

        // 输出结果
        for(int i =0;i<results.size();i++){
            System.out.println(results.get(i));
        }
    }
}
