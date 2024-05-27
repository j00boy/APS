import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] paper;
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		paper = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				paper[r][c] = sc.nextInt();
			}
		}

		// 1
		for (int r = 0; r < N - 3; r++) {
			for (int c = 0; c < M; c++) {
				int len = 0;
				for (int i = r; i < r + 4; i++) {
					len += paper[i][c];
				}
				max = Math.max(max, len);
			}
		}

		// 2
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M - 3; c++) {
				int len = 0;
				for (int i = c; i < c + 4; i++) {
					len += paper[r][i];
				}
				max = Math.max(max, len);
			}
		}

		// 3
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < M - 1; c++) {
				int len = 0;
				for (int i = r; i < r + 2; i++) {
					for (int j = c; j < c + 2; j++) {
						len += paper[i][j];
					}
				}
				max = Math.max(max, len);
			}
		}

		// 4
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 1; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					len += paper[i][c];
				}
				len += paper[r + 2][c + 1];
				max = Math.max(max, len);
			}
		}

		// 5
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = c; i < c + 3; i++) {
					len += paper[r][i];
				}
				len += paper[r + 1][c];
				max = Math.max(max, len);
			}
		}

		// 6
		for (int r = 0; r < N - 2; r++) {
			for (int c = 1; c < M; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					len += paper[i][c];
				}
				len += paper[r][c - 1];
				max = Math.max(max, len);
			}
		}

		// 7
		for (int r = 1; r < N; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = c; i < c + 3; i++) {
					len += paper[r][i];
				}
				len += paper[r - 1][c + 2];
				max = Math.max(max, len);
			}
		}

		// 8
		for (int r = 0; r < N - 2; r++) {
			for (int c = 1; c < M; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					len += paper[i][c];
				}
				len += paper[r + 2][c - 1];
				max = Math.max(max, len);
			}
		}

		// 9
		for (int r = 1; r < N; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = c; i < c + 3; i++) {
					len += paper[r][i];
				}
				len += paper[r - 1][c];
				max = Math.max(max, len);
			}
		}

		// 10
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 1; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					len += paper[i][c];
				}
				len += paper[r][c + 1];
				max = Math.max(max, len);
			}
		}

		// 11
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = c; i < c + 3; i++) {
					len += paper[r][i];
				}
				len += paper[r + 1][c + 2];
				max = Math.max(max, len);
			}
		}

		// 12
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 1; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					for (int j = c; j < c + 2; j++) {
						len += paper[i][j];
					}
				}
				len -= paper[r + 2][c];
				len -= paper[r][c + 1];

				max = Math.max(max, len);
			}
		}

		// 13
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = r; i < r + 2; i++) {
					for (int j = c; j < c + 3; j++) {
						len += paper[i][j];
					}
				}

				len -= paper[r][c];
				len -= paper[r + 1][c + 2];

				max = Math.max(max, len);
			}
		}

		// 14
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 1; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					for (int j = c; j < c + 2; j++) {
						len += paper[i][j];
					}
				}

				len -= paper[r][c];
				len -= paper[r + 2][c + 1];

				max = Math.max(max, len);
			}
		}

		// 15
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = r; i < r + 2; i++) {
					for (int j = c; j < c + 3; j++) {
						len += paper[i][j];
					}
				}

				len -= paper[r + 1][c];
				len -= paper[r][c + 2];

				max = Math.max(max, len);
			}
		}

		// 16
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = r; i < r + 2; i++) {
					for (int j = c; j < c + 3; j++) {
						len += paper[i][j];
					}
				}

				len -= paper[r + 1][c];
				len -= paper[r + 1][c + 2];

				max = Math.max(max, len);
			}
		}

		// 17
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 1; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					for (int j = c; j < c + 2; j++) {
						len += paper[i][j];
					}
				}

				len -= paper[r][c];
				len -= paper[r + 2][c];

				max = Math.max(max, len);
			}
		}

		// 18
		for (int r = 0; r < N - 1; r++) {
			for (int c = 0; c < M - 2; c++) {
				int len = 0;
				for (int i = r; i < r + 2; i++) {
					for (int j = c; j < c + 3; j++) {
						len += paper[i][j];
					}
				}

				len -= paper[r][c];
				len -= paper[r][c + 2];

				max = Math.max(max, len);
			}
		}
		
		// 19
		for (int r = 0; r < N - 2; r++) {
			for (int c = 0; c < M - 1; c++) {
				int len = 0;
				for (int i = r; i < r + 3; i++) {
					for (int j = c; j < c + 2; j++) {
						len += paper[i][j];
					}
				}

				len -= paper[r][c + 1];
				len -= paper[r + 2][c + 1];

				max = Math.max(max, len);
			}
		}

		System.out.println(max);
	}
}
