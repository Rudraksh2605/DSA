class Solution {

    public static final int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxarea = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(grid, i, j, visited);
                    maxarea = Math.max(maxarea, area);
                }
            }
        }

        return maxarea;
    }

    private int bfs(int[][] grid, int sr, int sc, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int area = 0;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int cr = cell[0];
            int cc = cell[1];
            area++;

            for(int[] d : dir){
                int nr = cr + d[0];
                int nc = cc + d[1];

                if(!isValid(grid, nr, nc)) continue;
                if(grid[nr][nc] == 0) continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;

                q.offer(new int[]{nr, nc});
            } 
        }

        return area;
    }

    private int dfs(int[][] grid, int nr, int nc, boolean[][] visited){
        if(!isValid(grid, nr, nc)) return 0;
        if(grid[nr][nc] == 0) return 0;
        if(visited[nr][nc]) return 0;
        visited[nr][nc] = true;
        int area = 1;
        for (int[] direction : dir) { 
            int newRow = nr + direction[0]; 
            int newCol = nc + direction[1]; 
            area += dfs(grid, newRow, newCol, visited);
        }
        return area;
    }

    private boolean isValid(int[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >=0 && c < grid[0].length;
    }
}