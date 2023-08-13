package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	static boolean[][] visited;
	static int N;
	static char[][] space;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		space = new char[N][N];
		visited = new boolean[N][N];
		int normalResult = 0;
		int unnormalResult = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				space[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					normalResult++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (space[i][j] == 'G') {
					space[i][j] = 'R';
				}
			}
		}

		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					unnormalResult++;
				}
			}
		}

		System.out.println(normalResult + " " + unnormalResult);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		char color = space[x][y];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (space[nx][ny] == color && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}
