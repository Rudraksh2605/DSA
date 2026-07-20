class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= (m*n);

        while(k --> 0){
            int last = grid[m-1][n-1];

            for(int i = m-1; i >= 0; i--){
                for(int j = n-1; j >= 0; j--){

                    if(i == 0 && j == 0){
                        grid[0][0] = last;
                    } else if(j == 0){
                        grid[i][j] = grid[i-1][n-1];
                    } else {
                        grid[i][j] = grid[i][j-1];
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            List<Integer> r = new ArrayList<>();
            for(int j = 0; j < n; j++){
                r.add(grid[i][j]);
            }
            ans.add(r);
        }
        return ans;
    }
}