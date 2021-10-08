package FirstPackage;
import java.util.Scanner;



public class HelloWorld {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in); // 固定格式 定义sc
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();              // 读取输入行  字符串类型：nextLine()
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();                   // 读取输入行  整型类型：nextInt()
        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);

        String myname =sc.nextLine();
        char c =myname.charAt(0);
        System.out.println(c);
    }


}
