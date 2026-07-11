class Solution {
    List<Integer>[] graph;
    boolean[] vis;
    int nodes, edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                nodes = 0;
                edgeCount = 0;
                dfs(i);

                edgeCount /= 2;

                if (edgeCount == nodes * (nodes - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int u) {
        vis[u] = true;
        nodes++;
        edgeCount += graph[u].size();

        for (int v : graph[u]) {
            if (!vis[v])
                dfs(v);
        }
    }
}