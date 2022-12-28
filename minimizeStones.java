import java.util.PriorityQueue;
                         // Remove Stones to minimize the total
public class minimizeStones {
    public static void main(String[] args) {
        int[] piles={4,3,6,7};
        int ans=minStoneSum(piles,3);
        System.out.println(ans);

    }
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for(int i:piles){
            pq.add(i);
        }
        while(k>0){
            int a=pq.poll();
            a=Math.ceilDiv(a,2);
            pq.add(a);
            k--;
        }
        int s=0;
        while(!pq.isEmpty()){
            int a=pq.poll();
            System.out.println(a);
            s+=a;
        }
        return s;
    }
}
