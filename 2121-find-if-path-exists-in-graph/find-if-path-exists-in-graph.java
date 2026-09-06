class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = build(n, edges);
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private List<List<Integer>> build(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    private boolean dfs(List<List<Integer>> graph, int curr, int dest, boolean[] visited){
        if(curr == dest) return true;
        visited[curr] = true;

        for(int n : graph.get(curr)){
            if(visited[n]) continue;

            if(dfs(graph, n, dest, visited)) return true;
        }
        return false;
    }
}