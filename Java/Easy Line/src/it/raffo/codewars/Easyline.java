package it.raffo.codewars;

import java.math.BigInteger;

public class Easyline
{

	public static BigInteger easyLine(int n)
	{
		System.out.println(n);
		BigInteger sumCoefBinomiali = BigInteger.valueOf(0);
		BigInteger[][] tartaglia = creaTartaglia(n + 1);
		// stampaTartaglia(tartaglia);
		for (int i = 0; i < tartaglia[n].length; i++)
		{
			// BigInteger binomio = BigInteger.valueOf(tartaglia[n][i].longValue());
			BigInteger binomio = tartaglia[n][i];
			binomio = binomio.multiply(tartaglia[n][i]);
			sumCoefBinomiali = sumCoefBinomiali.add(binomio);
		}
		return sumCoefBinomiali;
	}

	public static BigInteger[][] creaTartaglia(int n)
	{

		BigInteger[][] tartaglia; // o triangolo di Pascal
		int i, j;
		tartaglia = new BigInteger[n][];

		for (i = 0; i < tartaglia.length; i++)
		{
			tartaglia[i] = new BigInteger[i + 1];
		}

		for (i = 0; i < tartaglia.length; i++)

		{

			tartaglia[i][0] = BigInteger.valueOf(1);
			tartaglia[i][i] = BigInteger.valueOf(1);
			for (j = 1; j < i; j++)
			{
				tartaglia[i][j] = tartaglia[i - 1][j - 1].add(tartaglia[i - 1][j]);

				// BigInteger.valueOf(tartaglia[i - 1][j -
				// 1].longValue()).add(BigInteger.valueOf(tartaglia[i - 1][j].longValue()));
			}

		}
		return tartaglia;
	}

	public static void stampaTartaglia(BigInteger[][] tartaglia)
	{
		for (int i = 0; i < tartaglia.length; i++)

		{

			for (int j = 0; j < tartaglia[i].length; j++)
			{
				System.out.print(tartaglia[i][j] + " ");
			}

			System.out.println("");

		}
	}
}
