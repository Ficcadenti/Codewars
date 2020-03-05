package it.raffo.codewars;

public class Matrix
{

	public static int determinant(int[][] matrix)
	{
		return determinateMatriceN(matrix, matrix.length);
	}

	public static void getCoefficente(int mat[][], int temp[][], int p, int q, int n)
	{
		int i = 0, j = 0;

		for (int row = 0; row < n; row++)
		{
			for (int col = 0; col < n; col++)
			{

				if ((row != p) && (col != q))
				{
					temp[i][j++] = mat[row][col];
					if (j == (n - 1))
					{
						j = 0;
						i++;
					}
				}
			}
		}
	}

	static int determinateMatriceN(int mat[][], int n)
	{
		int D = 0;

		if (n == 1)
		{
			return mat[0][0];
		}
		int temp[][] = new int[n][n];
		int segno = 1;

		for (int f = 0; f < n; f++)
		{
			getCoefficente(mat, temp, 0, f, n);
			D += segno * mat[0][f] * determinateMatriceN(temp, n - 1);
			segno = -segno;
		}
		return D;
	}
}