package it.raffo.codewars;

public class DRoot
{
	public static int digital_root(int n)
	{
		int iRet = digital_rootS("" + n);
		while ((iRet / 10) > 0)
		{
			iRet = digital_rootS("" + iRet);
		}
		return iRet;
	}

	public static int digital_rootS(String num)
	{

		if (num.length() <= 1)
		{
			return Integer.valueOf(num).intValue();
		}
		else
		{
			int digit = Integer.valueOf("" + num.charAt(0)).intValue();
			return digit + digital_rootS(num.substring(1));
		}
	}

	public static int digital_rootV(int n)
	{
		String lunghezza = "" + n;
		int numero = 0;
		int[] numeri = new int[lunghezza.length()];
		if ((n >= 0) && (n < 10))
		{
			return n;
		}
		for (int l = 0; l < lunghezza.length(); l++)
		{
			numeri[l] = Integer.parseInt("" + lunghezza.charAt(l));
			numero += numeri[l];
		}
		return digital_rootV(numero);
	}

}
