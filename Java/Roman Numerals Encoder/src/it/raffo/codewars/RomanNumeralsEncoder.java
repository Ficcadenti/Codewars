package it.raffo.codewars;

import java.util.TreeMap;

public class RomanNumeralsEncoder
{

	private static final TreeMap<Integer, String> map = new TreeMap<>();

	static
	{
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	public static String solution(int n)
	{
		return aRomano(n);
	}

	private static String aRomano(int number)
	{
		int k = map.floorKey(number);
		if (number == k)
		{
			return map.get(number);
		}
		return map.get(k) + aRomano(number - k);
	}
}