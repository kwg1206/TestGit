
import java.util.Scanner;

public class Scissors_Stone_Cloth {

    public static void main(String[] args) {
            //判断是否继续的标志
            int k = 1;
            do {
                System.out.println("猜拳游戏现在开始"+"\n"+"输入 0 :石头   1 :剪刀    2 :布");
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                //判断你出剪刀石头还是布
                if (n==0) {
                    System.out.print("你出石头");
                }else if(n==1){
                    System.out.print("你出剪刀");
                }else {
                    System.out.print("你出布");
                }
                //电脑随机数
                int x=0+(int)(Math.random()*2);
                //判断电脑出的是剪刀石头还是布
                if (x==0) {
                    System.out.println("VS电脑出石头");
                }else if(x==1){
                    System.out.println("VS电脑出剪刀");
                }else {
                    System.out.println("VS电脑出布");
                }
                //判断谁赢
                if ((n==0&&x==1) || (n==1&&x==2) || (n==2&&x==0)) {
                    System.out.println("你赢了");
                }else if(n == x){
                    System.out.println("打平");
                }else {
                    System.out.println("电脑赢了");
                    
                }
                System.out.println("是否继续游戏?        1 : 继续        2 : 关闭");
                Scanner ab = new Scanner(System.in);
                k = ab.nextInt();
            } while (k==1);
            
    }

}


