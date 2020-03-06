package it.raffo.codewars;

public class Kata
{

	public static String decimal2binary(long n)
	{
		String s = (n & 1) != 0 ? "1" : "0";
		if ((n >>= 1) != 0)
		{
			s = decimal2binary(n) + s;
		}
		return s;
	}

	public static int convertBinaryArrayToInt(String binary)
	{
		return Integer.parseInt(binary, 2);
	}

	public static String generaIP(String str)
	{
		if (str.isEmpty())
		{
			return "";
		}
		else
		{
			String dot = str.length() == 8 ? "" : ".";
			return convertBinaryArrayToInt(str.substring(0, 8)) + dot + generaIP(str.substring(8));
		}
	}

	public static String longToIP(long ip)
	{
		String unpadded = decimal2binary(ip);
		String padded = "00000000000000000000000000000000".substring(unpadded.length()) + unpadded;
		return generaIP(padded);
	}
}
