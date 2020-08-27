package it.raffo.codewar;

import java.util.Arrays;
import java.util.HashSet;

public class isogram
{
	public static boolean isIsogram(String str)
	{
		return str.length() == 0 ? true : str.length() == new HashSet<>(Arrays.asList(str.toLowerCase().split(""))).size();
	}
}
