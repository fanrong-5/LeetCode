package Test;
import java.util.* ;
/**
 * @author fanrong
 * @create 2021/9/17 3:12 下午
 */
public class QuickSortTest {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] num = new int[len] ;
        for(int i =0;i<len;i++){
            num[i] = sc.nextInt();
        }

        QuickSortTest  sort = new QuickSortTest();
        sort.quickSort(num,0,len-1);

        System.out.println(Arrays.toString(num));
    }

    // 递归计算
    public int[] quickSort(int[] arr,int left,int right){
       if(left<right){
           int partition = sortPartition(arr,left,right);
           quickSort(arr,0,partition-1);
           quickSort(arr,partition+1,right);
       }

        return arr;
    }
    // 确定基准点 同时也是对每个子数组排序
    public int sortPartition(int[] arr,int left,int right){
        int first = arr[left];
        while(left<right){
            while(arr[right]<=first) right --;
            swap(arr,left,right);

            while(arr[left]>=first) left ++;
            swap(arr,left,right);
        }

        return left;
    }
    // 交换元素
    public void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
