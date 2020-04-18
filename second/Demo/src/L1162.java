import java.util.ArrayDeque;
import java.util.Queue;

public class L1162 {
    public static void main(String[] args) {
        int[][] grid={{1,0,1},{0,0,0},{1,0,1}};
        maxDistance(grid);
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static int maxDistance(int[][] grid) {
        int X[] = new int[]{0, 0, 1, -1};
        int Y[] = new int[]{1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        boolean flag1 = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    flag1 = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        boolean flag2 = false;
        int[] poll = null;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int i = 0; i < 4; i++) {
                int x1 = x + X[i], y1 = y + Y[i];
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] != 0) {
                    continue;
                }
                flag2 = true;
                queue.offer(new int[]{x1, y1});
                grid[x1][y1] = grid[x][y] + 1;
            }
        }
        if (!flag2 || !flag1) {
            return -1;
        } else {
            return grid[poll[0]][poll[1]] - 1;
        }
    }
}
