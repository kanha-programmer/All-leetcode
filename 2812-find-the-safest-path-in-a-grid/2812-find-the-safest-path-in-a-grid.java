class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = getDist(grid);

        int l = 0, r = 2 * n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(dist, mid)) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }

    int[][] getDist(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] x : dist) Arrays.fill(x, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k], y = cur[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return dist;
    }

    boolean check(int[][] dist, int val) {
        int n = dist.length;
        if (dist[0][0] < val) return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) return true;

            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k], y = cur[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < n &&
                    !vis[x][y] && dist[x][y] >= val) {

                    vis[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
}