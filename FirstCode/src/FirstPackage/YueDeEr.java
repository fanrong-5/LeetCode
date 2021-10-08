package FirstPackage;
import java.util.* ;

// 约德尔测试
public class YueDeEr {
    public static void main(String args[]){
        // 1- 读取屏幕数据
        Scanner sc = new Scanner(System.in);
        String history = sc.nextLine();
        String star = sc.nextLine();

        String trans ="";
        // 2- 将字符串转化为二进制数字
        for(int i=0;i<history.length();i++){
            char c = history.charAt(i);
            if(c>='A'&&c<='Z'||c>='a'&&c<='z'||c>='0'&&c<='9'){  // 不管是数字还是字母，要用单引号
                trans = trans+"1";   // 自定义字符串
            }
            else{
                trans = trans+"0";
            }
        }
        // 3- 对比两个二进制字符串
        int same =0;
        for(int j=0;j<star.length();j++){
            if(star.charAt(j)==trans.charAt(j)){
                same++;
            }
        }
        // 4- 计算相似率并输出
       /* float rate =  same / star.length();*/
        float rate = (float) same * 100 / (float) trans.length();
        System.out.printf("%.2f%%",rate ); //  输出百分率，保留最后两个小数
    }
}
