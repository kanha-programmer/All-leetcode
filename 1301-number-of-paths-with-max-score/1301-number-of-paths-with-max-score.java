class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1000000007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X' || (i == n - 1 && j == n - 1))
                    continue;

                // Check Down
                update(i + 1, j, n, score, ways, i, j, MOD);

                // Check Right
                update(i, j + 1, n, score, ways, i, j, MOD);

                // Check Diagonal
                update(i + 1, j + 1, n, score, ways, i, j, MOD);

                if (score[i][j] != -1 && ch != 'E')
                    score[i][j] += ch - '0';
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }

    private void update(int x, int y, int n, int[][] score, int[][] ways,
                        int i, int j, int MOD) {

        if (x >= n || y >= n || score[x][y] == -1)
            return;

        if (score[x][y] > score[i][j]) {
            score[i][j] = score[x][y];
            ways[i][j] = ways[x][y];
        } else if (score[x][y] == score[i][j]) {
            ways[i][j] = (ways[i][j] + ways[x][y]) % MOD;
        }
    }
}