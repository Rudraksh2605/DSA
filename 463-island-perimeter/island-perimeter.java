class Solution {

    private static final int[][] dir = { 
            {-1, 0},  {1, 0},  {0, -1}, {0, 1}
        };

    public int islandPerimeter(int[][] grid) {
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    return bfs(grid, row, col);
                }
            }
        }
        return 0;
    }

    private int bfs(int[][] grid, int row, int col){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        int perimeter = 0;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(!isInside(grid, nr, nc)) {
                    perimeter++;
                    continue;
                }

                if(grid[nr][nc] == 0){
                    perimeter++;
                    continue;
                }

                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr,nc});
            }
        }
        return perimeter;
    }
    private boolean isInside( int[][] grid, int row, int col ) { 
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length; 
    }

}