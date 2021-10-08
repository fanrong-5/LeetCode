package FirstPackage;

import java.util.*;
/* 输入：一个一个的数字 转化到数组中
* 第一行：数组的个数
* 第二行：数组（每个元素之间用空格分隔开）
* */
public class QuickSort {

    public static void main(String args[]){


        Scanner sc= new Scanner(System.in);
            int len=sc.nextInt();
            int[] arr=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=sc.nextInt();
            }
        QuickSort sort = new QuickSort();
            sort.quickSort(arr,0,len-1);// 调用非静态函数

        System.out.println(Arrays.toString(arr));  // 输出数组的方法1（更规范）

        // 输出数组的方法2
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");   // 不换行输出
            // System.out.println(arr[i]);   // 换行输出
        }
    }

    // 递归
    public void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);
            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point-1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }
    }

    /**
     * 分割数组，找到分割点
     */
    public int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }
            swap(list, left, right); // 交换

            while (left < right && list[left] <= first) {
                left++;
            }
            swap(list, left, right);  // 交换
        }
        // 返回分割点所在的位置,left就是一趟之后，基数所在的位置
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
