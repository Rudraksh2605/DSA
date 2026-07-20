class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length; 
        int n = grid[0].length;
        k %= (m*n);

        int[][] ans = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = i*n+j;
                int newidx = (idx+k) % (m*n);

                int newr = newidx / n;
                int newc = newidx % n;
                ans[newr][newc] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            List<Integer> r = new ArrayList<>();
                for(int g = 0; g < n; g++){
                    r.add(ans[i][g]);
                }
                res.add(r);
            
        }
        return res;
    }
}