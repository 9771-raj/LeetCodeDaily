
import java.util.*;

public class stocksCooldown {
     static int[][] memory;
    public static void main(String[] args) {
        int[] stocks={2,3,4,1,0,7,2};
        memory=new int[stocks.length][2];
        for (int i = 0; i < stocks.length; i++) {
            Arrays.fill(memory[i],-1);
        }
        int ans=stocks_cooldown(stocks,0,1);
        System.out.println("ans = " + ans);
    }

    private static int stocks_cooldown(int[] stocks, int i, int cond) {
        if (i>=stocks.length) return 0;

        if (memory[i][cond]!=-1){
            return memory[i][cond];
        }

        if (cond==1){             // buy
            int a=-stocks[i]+stocks_cooldown(stocks,i+1,0);
            int b=stocks_cooldown(stocks,i+1,1);
            return memory[i][cond]=Math.max(a,b);
        }
        int a=stocks[i]+stocks_cooldown(stocks,i+2,1);     // sell
        int b=stocks_cooldown(stocks,i+1,0);            // not sell
        return memory[i][cond]=Math.max(a,b);

    }

}
