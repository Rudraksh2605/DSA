class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        boolean[] visited = new boolean[isConnected.length];
        int province = 0;

        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected,visited, i);
                province++;
            }
        }
        return province;
    }

    private void dfs(int[][] conn, boolean[] visited, int city ){
        visited[city] = true;

        for(int i = 0; i < conn.length; i++){
            if(conn[city][i] == 1 && !visited[i]){
                dfs(conn, visited, i);
            }
        }
    }

}