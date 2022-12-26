import java.util.Arrays;

public class longsubseq_sum {
    static int[][] dp;
    public static void main(String[] args) {
        int[] arr={2,3,4,5};
        int[] queries={1};
        for (int i = 0; i < queries.length; i++) {
            dp=new int[arr.length][queries[i]];
            for (int j = 0; j < dp.length; j++) {
                Arrays.fill(dp[j],-1);
            }
            int ans=LSWS(arr,queries[i],0,0);
            System.out.println("ans = " + ans);
        }
        optimised_sol(arr,queries);
    }

    // Recursion solved but it gets memory exceed error, So we can optimised by using prefix sum
    private static int LSWS(int[] arr,int target,int i,int sum){
        if (i>=arr.length){
            return 0;
        }
        if (sum>=target){
            return 0;
        }
        if (dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int a=0;
        if(arr[i]+sum<=target){
            a=1+LSWS(arr,target,i+1,arr[i]+sum);
        }

        int b=LSWS(arr,target,i+1,sum);
        return dp[i][sum]=Math.max(a,b);
    }
    private static void optimised_sol(int[] arr,int[] queries){
        Arrays.sort(arr);
        int[] ans=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum=0;
            for (int j = 0; j < arr.length; j++) {
                sum+=arr[j];
                if (sum>queries[i]){
                    ans[i]=j;
                    break;
                }
                if (j==arr.length-1 && sum<=queries[i]){
                    ans[i]=j+1;
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
