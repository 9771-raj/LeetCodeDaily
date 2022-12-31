

public class uniquePath3 {
    static int count=0;
    public static void main(String[] args) {
        int[][] grid={{0,1},{2,0}};
        int[] src=new int[2];

        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int remain=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]>=0){
                    remain++;                      // total block we can visit
                    if (grid[i][j]==1){
                        src[0]=i;
                        src[1]=j;
                    }
                }
                else{
                    visited[i][j]=true;  // not for visit or obstacle
                }

            }
        }
        findUniquePath(grid,visited,src[0],src[1],remain);
        System.out.println(count);
    }
    private static void findUniquePath(int[][] grid,boolean[][] visited,int i,int j,int dest){
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j]) {
            return;
        }
        if (grid[i][j]==2 && dest==1){
            count++;
            return;
        }
        visited[i][j]=true;
        findUniquePath(grid,visited,i+1,j,dest-1);
        findUniquePath(grid,visited,i-1,j,dest-1);
        findUniquePath(grid,visited,i,j+1,dest-1);
        findUniquePath(grid,visited,i,j-1,dest-1);
        visited[i][j]=false;

    }
}
