import java.util.*;
/*
You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks,
where tasks[i] = [enqueueTimei, processingTimei] means that the ith task will be
 available to process at enqueueTimei and will take processingTimei to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:

    If the CPU is idle and there are no available tasks to process, the CPU remains idle.
    If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time.
    If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
    Once a task is started, the CPU will process the entire task without stopping.
    The CPU can finish a task then start a new one instantly.

Return the order in which the CPU will process the tasks.*/
class triple{
    int start;
    int end;
    int index;
    triple(int x,int y,int z){
        this.start=x;
        this.end=y;
        this.index=z;
    }
}
public class singleThreadedCpu {
    public static void main(String[] args) {
        int[][] tasks={{1,2},{2,4},{3,2},{4,1}};
        int[] ans=solution(tasks);
        System.out.println(Arrays.toString(ans));
    }
    private static int[] solution(int[][] tasks){
        PriorityQueue<triple> pq=new PriorityQueue<>((a,b)->a.start-b.start);
        for (int i = 0; i < tasks.length; i++) {
            pq.add(new triple(tasks[i][0],tasks[i][1],i));
        }
        PriorityQueue<triple> pq2=new PriorityQueue<>(
                (a,b)->a.end==b.end?a.index-b.index:a.end-b.end
        );
        int curTime=0;
        int i=0;
        int[] res=new int[tasks.length];
        while (!pq.isEmpty()){
            while (!pq.isEmpty() && pq.peek().start<=curTime){
                pq2.add(pq.poll());
            }
            if (!pq2.isEmpty()){
                triple t=pq2.poll();
                res[i++]=t.index;
                curTime+=t.end;
            }
            else{
                if (!pq.isEmpty()){
                    curTime=pq.peek().start;
                }
                else{
                    break;
                }
            }
        }
        while (!pq2.isEmpty()){
            res[i++]=pq2.poll().index;
        }
        return res;
    }
}
