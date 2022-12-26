public class canJump {
    public static void main(String[] args) {
        int[] jumps={2,3,0,4,1};
        boolean ans=Can_Jump(jumps);
        System.out.println(ans);
    }

    private static boolean Can_Jump(int[] jumps) {
        int i=0;
        int max_reach=0;
        while (i<jumps.length && i<=max_reach){
            max_reach=Math.max(max_reach,jumps[i]+i);
            i++;
        }
        if (i==jumps.length){
            return true;
        }
        return false;
    }
}
