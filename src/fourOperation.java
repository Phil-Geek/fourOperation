import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:
 *         Xuzhiqiang   Lipengfei
 * Creatime:
 *          2019/4/1
 * Function:
 *          Generating Four Non-repetitive Operational Questions
 **/
public class fourOperation {
    public static void main(String[] args){
        int digitNumber=0;
        int quesNumber=0;
        int count,count2,count3,count4;
        Boolean flag = true;
        Map symbolMap = new HashMap();
        symbolMap.put("1","+");
        symbolMap.put("2","-");
        symbolMap.put("3","*");
        symbolMap.put("4","/");
        Map questionMap = new HashMap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用自动出题系统!");
        while (flag){
            String qusetion="";
            while (flag){
                System.out.println("请输入想要设置的题目数：");
                quesNumber=scanner.nextInt();
                if (quesNumber>=1){
                    break;
                }
                System.out.println("请输入有效数字!");
            }
            while (flag){
                System.out.println("请输入要操作的数目：");
                digitNumber=scanner.nextInt();
                if (digitNumber>=2){
                    break;
                }
                System.out.println("请输入有效数字!");
            }
            int[] number = new int[digitNumber];
            int[] symbol = new int[digitNumber-1];
            System.out.println("产生的四则运算题如下：");
            for(count=0;count<quesNumber;count++){
                qusetion="";
                for (count2=0;count2<digitNumber;count2++){
                    number[count2]= (int) (1+Math.random()*100);
                }
                for (count3=0;count3<digitNumber-1;count3++){
                    symbol[count3]= (int) (1+Math.random()*4);
                }
                for(count4=0;count4<digitNumber-1;count4++){
                    qusetion+=String.valueOf(number[count4])+symbolMap.get(String.valueOf(symbol[count4]));
                    if (count4==digitNumber-2){
                        qusetion+=String.valueOf(number[count4+1]);
                    }
                }
                Object qusIsExist = questionMap.get(qusetion);
                if (qusIsExist==null){
                    questionMap.put(qusetion,"0");
                    System.out.println(count+1+". "+qusetion);

                }
            }
            System.out.println("是否继续出题？ 是 --> 请输入\"1\"    否 --> 请输入\"0\"");
            int result = scanner.nextInt();
            if (result==0){
                flag=false;
            }
        }
        System.out.println("感谢使用");
    }
}
