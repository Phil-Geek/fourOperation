import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
        int[] number = new int[5];
        int[] symbol = new int[4];
        int quesNumber;
        int count,count2,count3,count4;
        Map symbolMap = new HashMap();
        symbolMap.put("1","+");
        symbolMap.put("2","-");
        symbolMap.put("3","*");
        symbolMap.put("4","/");
        Map questionMap = new HashMap();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("请输入想要设置的题目数：");
        quesNumber=scanner.nextInt();
        String qusetion="";
        System.out.println("产生的四则运算题如下：");
        for(count=0;count<quesNumber;count++){
            qusetion="";
            for (count2=0;count2<5;count2++){
                number[count2]= (int) (1+Math.random()*100);
            }
            for (count3=0;count3<4;count3++){
                symbol[count3]= (int) (1+Math.random()*4);
            }
            for(count4=0;count4<4;count4++){
                qusetion+=String.valueOf(number[count4])+symbolMap.get(String.valueOf(symbol[count4]));
                if (count4==3){
                    qusetion+=String.valueOf(number[count4+1]);
                }
            }
            Object qusIsExist = questionMap.get(qusetion);
            if (qusIsExist==null){
                questionMap.put(qusetion,"0");
                System.out.println(count+1+". "+qusetion);

            }
        }
    }
}
