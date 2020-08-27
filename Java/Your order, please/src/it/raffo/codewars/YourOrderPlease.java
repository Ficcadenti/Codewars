package it.raffo.codewars;

public class YourOrderPlease
{
	public static String order(String words)
	{
		String[] strA = words.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= strA.length; i++)
		{
			for (String str : strA)
			{
				if (str.contains(Integer.toString(i)))
				{
					sb.append(str).append(" ");
				}
			}
		}
		return sb.toString().trim();
	}
}