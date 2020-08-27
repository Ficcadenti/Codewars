package it.raffo.codewar;

public class Test
{

	public static String pak(final String s)
	{

		String str = s.trim();
		return str.replace(" ", " pak ");
	}

	public static void main(String[] args)
	{
		System.out.println(isogram.isIsogram("Dermatoglyphics"));
		System.out.println(pak("   "));
	}

}
