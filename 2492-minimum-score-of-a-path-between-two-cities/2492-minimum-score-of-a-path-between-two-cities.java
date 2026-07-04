class Solution {
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, graph, vis);

        return ans;
    }

    private void dfs(int node, List<int[]>[] graph, boolean[] vis) {
        vis[node] = true;

        for (int[] next : graph[node]) {
            ans = Math.min(ans, next[1]);

            if (!vis[next[0]]) {
                dfs(next[0], graph, vis);
            }
        }
    }
}