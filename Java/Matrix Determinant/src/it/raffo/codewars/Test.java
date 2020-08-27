package it.raffo.codewars;

public class Test
{

	public static void main(String[] args)
	{
		int mat[][] = { { 2, 5, 3 }, { 1, -2, -1 }, { 1, 3, 4 } };
		System.out.print("Determinant of the matrix is : " + Matrix.determinant(mat));
	}

}
