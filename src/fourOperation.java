import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
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
    static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static void main(String[] args){
        int digitNumber=0;
        int quesNumber=0;
        int MAX_VALUE=0;
        int MIN_VALUE=0;
        int count2,count3,count4,countQN;
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
            String qusetion;
            countQN=0;
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
            while (flag){
                System.out.println("请输入四则运算题的上限值：");
                MAX_VALUE=scanner.nextInt();
                System.out.println("请输入四则运算题的下限值：");
                MIN_VALUE=scanner.nextInt();
                if (MAX_VALUE!=MIN_VALUE && MAX_VALUE>MIN_VALUE){
                    break;
                }
                System.out.println("最大值和最小值不合理!");
            }
            int[] number = new int[digitNumber];
            int[] symbol = new int[digitNumber-1];
            System.out.println("产生的四则运算题如下：");
            while(countQN!=quesNumber){
                qusetion="";
                for (count2=0;count2<digitNumber;count2++){
                    number[count2]= (int) (1+Math.random()*100);
                }
                for (count3=0;count3<digitNumber-1;count3++){
                    symbol[count3]= (int) (1+Math.random()*4);
                }
                for(count4=0;count4<digitNumber-1;count4++) {
                    qusetion += String.valueOf(number[count4]) + symbolMap.get(String.valueOf(symbol[count4]));
                    if (count4 == digitNumber - 2) {
                        qusetion += String.valueOf(number[count4 + 1]);
                    }
                }
                try {
                    String  result = jse.eval(qusetion).toString();
                    int resultInt = Integer.parseInt(result);
                    if (resultInt<=MAX_VALUE && resultInt>=MIN_VALUE){
                        Object qusIsExist = questionMap.get(qusetion);
                        if (qusIsExist==null){
                            questionMap.put(qusetion,"0");
                            System.out.println(countQN+1+". "+qusetion);
                            countQN++;
                        }
                    }
                } catch (Exception e) {

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
