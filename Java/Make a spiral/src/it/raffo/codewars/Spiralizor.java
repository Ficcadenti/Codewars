package it.raffo.codewars;

public class Spiralizor
{

	public static int[][] spiralize(int size)
	{
		stampaMatrice(spirale(generaMatrice(size)));
		return null;
	}

	public static int[][] spirale(int[][] matrice)
	{
		int maxLarghezza = matrice[0].length - 1, minLarghezza = 0, maxAltezza = matrice.length - 1, minAltezza = 0, colonna = 0, riga = 0;
		System.out.println("Larghezza: " + minLarghezza + "," + maxLarghezza);
		System.out.println("Altezza: " + minAltezza + "," + maxAltezza);
		String direzione = "dx";
		while (true)
		{
			matrice[riga][colonna] = 1;
			if (direzione.equals("dx"))
			{
				if (colonna < maxLarghezza)
				{
					colonna += 1;
				}
				else if ((riga + 1) <= maxAltezza)
				{
					direzione = "down";
					minAltezza += 2;
				}
				else
				{
					direzione = "end";
				}
			}
			else if (direzione.equals("down"))
			{
				if (riga < maxAltezza)
				{
					riga += 1;
				}
				else if ((colonna - 1) > minLarghezza)
				{
					direzione = "sx";
					maxLarghezza -= 2;
				}
				else
				{
					direzione = "end";
				}
			}
			else if (direzione.equals("sx"))
			{
				if (colonna > minLarghezza)
				{
					colonna -= 1;
				}
				else if ((riga - 1) > minAltezza)
				{
					direzione = "up";
					maxAltezza -= 2;
				}
				else
				{
					direzione = "end";
				}
			}
			else if (direzione.equals("up"))
			{
				if (riga > minAltezza)
				{
					riga -= 1;
				}
				else if ((colonna + 1) < maxLarghezza)
				{
					direzione = "dx";
					minLarghezza += 2;
				}
				else
				{
					direzione = "end";
				}
			}
			else
			{
				break;
			}

			if (direzione.equals("end"))
			{
				if ((matrice[0].length % 2) == 0)
				{
					riga -= 1;
				}

				System.out.println("riga:" + riga);
				System.out.println("colonna:" + colonna);
				matrice[riga][colonna] = 1;
				break;
			}
		}
		return matrice;
	}

	public static int[][] generaMatrice(int n)
	{
		int[][] matrice = new int[n][n];
		int larghezza = n;
		int altezza = n;

		for (int r = 0; r < altezza; r++)
		{
			for (int c = 0; c < larghezza; c++)
			{

				matrice[r][c] = 0;
			}
		}

		return matrice;
	}

	public static void stampaMatrice(int[][] matrice)
	{
		for (int y = 0; y < matrice[0].length; y++)
		{
			for (int x = 0; x < matrice.length; x++)
			{

				System.out.print(String.format("% 2d ", matrice[x][y]));

			}
			System.out.println();
		}
	}

}