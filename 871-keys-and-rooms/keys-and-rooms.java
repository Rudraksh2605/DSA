class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        int visitedroom = dfs(rooms, 0, visited);
        return visitedroom == rooms.size();
    }

    private int dfs(List<List<Integer>> rooms, int room, boolean[] visited){
        if(visited[room]) return 0;
        visited[room] = true;
        int count = 1;

        for(int k : rooms.get(room)){
            count += dfs(rooms, k, visited);
        }
        return count;
    }   
}