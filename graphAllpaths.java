import java.util.ArrayList;

public class graphAllpaths {
    public static void main(String[] args) {
        int[][] graph={{1,2},{3},{3},{}};
        ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        findAllPath(graph,0,paths,arr);
        System.out.println(paths);
    }

    private static void findAllPath(int[][] graph, int src, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> arr) {
        if(src==graph.length-1){
            paths.add(new ArrayList<>(arr));
            return;
        }
        for(int i:graph[src]){
            arr.add(i);
            findAllPath(graph,i, paths, arr);
            arr.remove(arr.size()-1);
        }
    }
    
}
