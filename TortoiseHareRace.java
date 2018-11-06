package Thread;
import static java.lang.System.out;
public class TortoiseHareRace {
    public static void main(String [] args){
        boolean[] flags  = {true,false};
        int totalStep = 10;
        int tortoiseStep = 0;
        int hareStep = 0;
        out.println("龟兔赛跑开始……");
        while(tortoiseStep < totalStep && hareStep < totalStep){
            tortoiseStep++;//乌龟先走
            out.printf("乌龟跑了 %d 步%n",tortoiseStep);

            boolean isHareSleep = flags[((int) (Math.random() * 10)) % 2];//随机睡觉 索引会在0、1之间随机
            if(isHareSleep){
                out.println("兔子睡着了zzzzz");
            }
            else{
                hareStep += 2;
                out.printf("兔子跑了 %d步%n",hareStep);
            }
        }
        if(tortoiseStep > hareStep){
            out.println("乌龟获胜");
        }
        else{
            out.println("兔子获胜");
        }
    }

}
