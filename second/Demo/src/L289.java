public class L289 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(a);
        show(a);
    }

    public static void gameOfLife(int[][] board) {
        int[] X = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
        int[] Y = new int[]{1, -1, -1, 0, 1, -1, 0, 1};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int i1 = 0; i1 < 8; i1++) {
                    int x = i + X[i1], y = j + Y[i1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    } else {
                        count += (board[x][y] & 1);
                    }
                }
                //System.out.println(count);
                if ((board[i][j] & 1) == 1) {
                    if (count == 2 || count == 3)
                        board[i][j] = 0b11;
                } else {
                    if (count == 3) {
                        board[i][j] = 0b10;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            board[i][j]=board[i][j]>>1;
            }
        }

    }

    public static void show(int[][] a) {
        int m = a.length, n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                System.out.print(a[i][i1] + " ");
            }
            System.out.println();
        }
    }

}
