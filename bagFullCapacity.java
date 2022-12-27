import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
/*             Maximum Bags with Full Capacity Rocks
You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks.
The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks.
You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.
Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags
*/
class tuple{
    int start;
    int end;
    tuple(int x,int y){
        this.start=x;
        this.end=y;
    }
}
public class bagFullCapacity {
    public static void main(String[] args) {
        int[] cap={2,3,4,5};
        int[] rocks={1,2,4,4};
        int add=2;
        System.out.println(solution(cap,rocks,add));
    }
    private static int solution(int[] cap,int[] rocks,int add){
        ArrayList<tuple> arr=new ArrayList<>();
        for (int i = 0; i < cap.length; i++) {
            arr.add(new tuple(cap[i],cap[i]-rocks[i]));
        }
        Collections.sort(arr,(a,b)->a.end-b.end);

        int count=0;
        int i=0;
        while (add!=0 && i<arr.size()){
            if (add-arr.get(i).end>=0){
                count++;
                add=add-arr.get(i).end;
            }
            i++;
        }
        return count;
    }
}
