package Test;
import java.util.*;

/**
 * @author fanrong
 * @create 2021/9/18 10:30 上午
 *
 */
public class ScannerTest {
    public static void main(String args[]){

        /*
        // 输入一行数据，以空格分隔，结束输入条件：回车
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList() ;
        while(sc.hasNext()){
            String inputStr = sc.nextLine();
            arr.add(inputStr);
        }

        for(int i = 0;i< arr.size();i++){
            System.out.println(arr.get(i));
        }
        */

        // 输入一行数据（整型），结束条件：输入回车来完成这一行
        ArrayList<Integer> input = new ArrayList() ;
        Scanner sc1 = new Scanner(System.in);
        String line = sc1.nextLine();
        Scanner sc2 = new Scanner(line);

        while(sc2.hasNextInt()){
            input.add(sc2.nextInt());
        }


        // 循环输入多行数据（字符串），结束输入条件：两下回车
        ArrayList<String> inputList = new ArrayList<>();
        do{
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(str.equals("")){
                break;
            }
            inputList.add(str);
        }while (true);

        for(int i =0;i< inputList.size();i++){
            System.out.println(inputList.get(i));
        }

    }
}
