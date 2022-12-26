// LeetCode Problem 841
import java.util.*;
public class room_keys {
    public static void main(String[] args) {
//        Input: rooms = [[1],[2],[3],[]]
//        Output: true
//        Explanation:
//        We visit room 0 and pick up key 1.
//        We then visit room 1 and pick up key 2.
//        We then visit room 2 and pick up key 3.
//        We then visit room 3.
//        Since we were able to visit every room, we return true.

    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        Stack<Integer> stack=new Stack<>();
        // base case
        if(rooms.size()==1){
            return true;
        }
        if(rooms.get(0).isEmpty()){
            return false;
        }
        for(Integer i:rooms.get(0)){
            stack.push(i);
        }
        visited[0]=true;
        while(!stack.isEmpty()){
            int room=stack.pop();
            if (visited[room]){
                continue;
            }
            visited[room]=true;
            for(Integer i:rooms.get(room)){
                if (!stack.contains(i)){
                    stack.push(i);
                }
            }
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
