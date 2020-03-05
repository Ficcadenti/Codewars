package it.raffo.codewars;

public class Vowels
{

	public static int getCount(String str)
	{
		int vowelsCount = 0;
		String vocali = "aeiou";
		for (int i = 0; i < str.length(); i++)
		{
			if (vocali.indexOf("" + str.charAt(i)) >= 0)
			{
				vowelsCount++;
			}
		}
		return vowelsCount;
	}

}