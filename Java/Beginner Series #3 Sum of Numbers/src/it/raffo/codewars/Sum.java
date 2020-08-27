package it.raffo.codewars;

public class Sum
{
	public static int GetSum(int a, int b)
	{
		int iRet = 0;
		for (int i = Math.min(a, b); i <= Math.max(a, b); i++)
		{
			iRet += i;
		}
		return iRet;
	}
}