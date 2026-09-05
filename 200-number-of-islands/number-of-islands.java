class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int island = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                    island++;
                    bfs(grid, r, c);
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int startr, int startc){
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startr, startc});
        grid[startr][startc] = '0'; // visited

        int[][] dr = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : dr){
                int newr = r + d[0];
                int newc = c + d[1];

                if(isValid(grid, newr, newc)){
                    grid[newr][newc] = '0';
                    q.offer(new int[]{newr, newc});
                }
            }
        }
        
    }

    private boolean isValid(char[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1';
    }
}