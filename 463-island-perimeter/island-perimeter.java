class Solution {
    private static final int[][] dir = {
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
    };

    public int islandPerimeter(int[][] grid) {
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int row, int col){
        if(!isInside(grid, row, col)){
            return 1;
        }

        if(grid[row][col] == 0){
            return 1;
        }

        if(grid[row][col] == -1){
            return 0;
        }

        grid[row][col] = -1;
        int perimeter = 0;

        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];

            perimeter += dfs(grid, nr, nc);
        }
        return perimeter;
    }

    private boolean isInside(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}